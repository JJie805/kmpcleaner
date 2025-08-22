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
    
    func getAhashBitmap(forId id: String, completion: @escaping (Ui_graphicsImageBitmap?) -> Void) {
        fetchBitmap(forId: id, targetSize: CGSize(width: 8, height: 8), completion: completion)
    }
    
    func getDhashBitmap(forId id: String, completion: @escaping (Ui_graphicsImageBitmap?) -> Void) {
        fetchBitmap(forId: id, targetSize: CGSize(width: 9, height: 8), completion: completion)
    }

    // MARK: - Private Helpers
    
    /// 核心的、按需获取单个位图的函数
    private func fetchBitmap(forId id: String, targetSize: CGSize, completion: @escaping (Ui_graphicsImageBitmap?) -> Void) {
        // 1. 切换到后台线程，这部分逻辑保持不变，非常正确。
        DispatchQueue.global(qos: .userInitiated).async {
            let assets = PHAsset.fetchAssets(withLocalIdentifiers: [id], options: nil)
            guard let asset = assets.firstObject else {
                DispatchQueue.main.async { completion(nil) }
                return
            }
            
            let imageManager = PHImageManager.default()
            let options = PHImageRequestOptions()
            // 这些选项依然是最佳实践，我们告诉系统需要一个高质量的小图
            options.deliveryMode = .highQualityFormat
            options.resizeMode = .exact
            options.isNetworkAccessAllowed = true
            options.isSynchronous = true

            // 2. 调用 requestImage，但我们只把它当作获取“原材料”的步骤
            imageManager.requestImage(for: asset, targetSize: targetSize, contentMode: .aspectFill, options: options) { image, _ in
                
                // 3. 安全地解包从系统获取的图片
                guard let fetchedImage = image else {
                    // 如果系统因为任何原因（如iCloud下载失败）未能返回图片，则安全退出
                    DispatchQueue.main.async { completion(nil) }
                    return
                }
                
                // ==================== 核心修改：强制尺寸校正 ====================
                //
                // 无论 `fetchedImage` 的实际尺寸是多少 (90x120, 56x120, etc.),
                // `correctlySizedImage` 的尺寸将永远是我们传入的 `targetSize` (例如 9x8)。
                // 这是解决问题的关键一步。
                //
                let correctlySizedImage = self.resizeUIImage(fetchedImage, targetSize: targetSize)
                //
                // ==========================================================
                
                // 4. 使用我们刚刚校正过尺寸的图片，进行后续的转换操作
                let bitmap = self.uiImageToImageBitmap(correctlySizedImage)
                
                // 5. 将最终结果安全地返回到主线程，供 Kotlin 使用
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
