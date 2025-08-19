import Foundation
import Photos
import ComposeApp // 确保这是您 KMP 模块的正确名称
import UIKit


class MediaScannerImpl: ComposeApp.MediaScanner {
    func getAllPhotos(completion: @escaping ([ComposeApp.PhotoEntity]) -> Void) {
        runWithAuthorization {
            let fetchOptions = PHFetchOptions()
            fetchOptions.sortDescriptors = [NSSortDescriptor(key: "creationDate", ascending: false)]
            let assets = PHAsset.fetchAssets(with: .image, options: fetchOptions)
            var photoArray: [PHAsset] = []
            assets.enumerateObjects { asset, _, _ in
                photoArray.append(asset)
            }
            completion(self.assetsToPhotos(photoArray))
        } notAuthorized: { completion([]) }
    }
    
    func getScreenshotPhotos(completion: @escaping ([ComposeApp.PhotoEntity]) -> Void) {
        runWithAuthorization {
            let collections = PHAssetCollection.fetchAssetCollections(with: .smartAlbum, subtype: .smartAlbumScreenshots, options: nil)
            guard let collection = collections.firstObject else {
                completion([])
                return
            }
            let assets = PHAsset.fetchAssets(in: collection, options: nil)
            var photoArray: [PHAsset] = []
            assets.enumerateObjects { asset, _, _ in
                photoArray.append(asset)
            }
            completion(self.assetsToPhotos(photoArray))
        } notAuthorized: { completion([]) }
    }

    func getNonScreenshotPhotos(completion: @escaping ([ComposeApp.PhotoEntity]) -> Void) {
        runWithAuthorization {
            let screenshotIDs = self.getScreenshotAssetIDs()
            let allAssets = PHAsset.fetchAssets(with: .image, options: nil)
            var nonScreenshotAssets: [PHAsset] = []
            allAssets.enumerateObjects { asset, _, _ in
                if !screenshotIDs.contains(asset.localIdentifier) {
                    nonScreenshotAssets.append(asset)
                }
            }
            completion(self.assetsToPhotos(nonScreenshotAssets))
        } notAuthorized: { completion([]) }
    }
    
    func getAllVideos(completion: @escaping ([ComposeApp.VideoEntity]) -> Void) {
        // 您可以仿照 assetsToPhotos 实现一个 assetsToVideos
        // 为简洁起见，此处暂未实现
        completion([])
    }

    func getThumbnailBitmap(forId id: String, isVideo: Bool, completion: @escaping (Ui_graphicsImageBitmap?) -> Void) {
        fetchBitmap(forId: id, targetSize: CGSize(width: 400, height: 400), completion: completion)
    }

    func getHashBitmap(forId id: String, completion: @escaping (Ui_graphicsImageBitmap?) -> Void) {
        fetchBitmap(forId: id, targetSize: CGSize(width: 8, height: 8), completion: completion)
    }

    // MARK: - Private Helpers
    
    /// 核心的、按需获取单个位图的函数
    private func fetchBitmap(forId id: String, targetSize: CGSize, completion: @escaping (Ui_graphicsImageBitmap?) -> Void) {
        // 将任务派发到后台队列，避免阻塞调用者
        DispatchQueue.global(qos: .userInitiated).async {
            let assets = PHAsset.fetchAssets(withLocalIdentifiers: [id], options: nil)
            guard let asset = assets.firstObject else {
                // 即使找不到也要在主线程回调，确保线程安全
                DispatchQueue.main.async { completion(nil) }
                return
            }
            
            let imageManager = PHImageManager.default()
            let options = PHImageRequestOptions()
            options.deliveryMode = .highQualityFormat
            options.resizeMode = .exact // 精确缩放以获得正确的哈希值
            options.isNetworkAccessAllowed = true
            // 在我们自己的后台队列中使用同步是安全的，可以简化逻辑
            options.isSynchronous = true

            imageManager.requestImage(for: asset, targetSize: targetSize, contentMode: .aspectFill, options: options) { image, _ in
                let bitmap = image != nil ? self.uiImageToImageBitmap(image!) : nil
                // 将结果切回主线程进行回调，这是 Swift 与 UIKit/Photos 交互的安全做法
                DispatchQueue.main.async { completion(bitmap) }
            }
        }
    }
    
    /// 将 [PHAsset] 数组转换为只包含元数据的 [Photo] 数组
    private func assetsToPhotos(_ assets: [PHAsset]) -> [ComposeApp.PhotoEntity] {
        return assets.map { asset in
            // 直接创建 Kotlin 的 Photo 对象，不包含任何位图数据
            ComposeApp.PhotoEntity(
                id: asset.localIdentifier,
                creationDate: Int64(asset.creationDate?.timeIntervalSince1970 ?? 0),
                sizeInBytes: self.getFileSizeForAsset(asset: asset),
                width: Int32(asset.pixelWidth),
                height: Int32(asset.pixelHeight)
            )
        }
    }
    
    /// 统一处理权限请求的辅助函数
    private func runWithAuthorization(
        authorized: @escaping () -> Void,
        notAuthorized: @escaping () -> Void
    ) {
        // 在后台线程执行权限请求和初始扫描，避免阻塞 UI
        DispatchQueue.global(qos: .userInitiated).async {
            let status = PHPhotoLibrary.authorizationStatus(for: .readWrite)
            switch status {
            case .authorized, .limited:
                authorized()
            case .notDetermined:
                PHPhotoLibrary.requestAuthorization(for: .readWrite) { newStatus in
                    if newStatus == .authorized || newStatus == .limited {
                        authorized()
                    } else {
                        notAuthorized()
                    }
                }
            default:
                notAuthorized()
            }
        }
    }

    /// 获取截图文件夹中所有 asset 的 ID
    private func getScreenshotAssetIDs() -> Set<String> {
        var screenshotIDs = Set<String>()
        let collections = PHAssetCollection.fetchAssetCollections(with: .smartAlbum, subtype: .smartAlbumScreenshots, options: nil)
        guard let collection = collections.firstObject else { return screenshotIDs }
        
        let screenshotAssets = PHAsset.fetchAssets(in: collection, options: nil)
        screenshotAssets.enumerateObjects { asset, _, _ in
            screenshotIDs.insert(asset.localIdentifier)
        }
        return screenshotIDs
    }
    
    /// 获取 PHAsset 的文件大小
    private func getFileSizeForAsset(asset: PHAsset) -> Int64 {
        guard let resource = PHAssetResource.assetResources(for: asset).first,
              let unsignedInt64 = resource.value(forKey: "fileSize") as? CLong else {
            return 0
        }
        return Int64(unsignedInt64)
    }

    /// UIImage -> Kotlin ImageBitmap (您的原始实现)
    func uiImageToImageBitmap(_ image: UIImage) -> Ui_graphicsImageBitmap? {
        guard let data = image.pngData() else { return nil }

        let kotlinBytes = KotlinByteArray(size: Int32(data.count))
        for (index, byte) in data.enumerated() {
            kotlinBytes.set(index: Int32(index), value: Int8(bitPattern: byte))
        }

        return BridgeKt.byteArraytoImageBitmap(byteArray: kotlinBytes)
    }
    
    /// UIImage 缩放 (您的原始实现)
    private func resizeUIImage(_ image: UIImage, targetSize: CGSize) -> UIImage {
        UIGraphicsBeginImageContextWithOptions(targetSize, false, 1.0)
        image.draw(in: CGRect(origin: .zero, size: targetSize))
        let scaledImage = UIGraphicsGetImageFromCurrentImageContext()
        UIGraphicsEndImageContext()
        return scaledImage ?? image
    }
}
