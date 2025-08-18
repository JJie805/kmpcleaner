import Foundation
import Photos
import ComposeApp
import UIKit

class MediaScannerImpl: ComposeApp.MediaScanner {
    // 1. 实现异步的 getAllPhotos
    func getAllPhotos(completion: @escaping ([ComposeApp.PhotoEntity]) -> Void) {
        runWithAuthorization {
            let fetchOptions = PHFetchOptions()
            fetchOptions.sortDescriptors = [NSSortDescriptor(key: "creationDate", ascending: false)]
            let assets = PHAsset.fetchAssets(with: .image, options: fetchOptions)
            self.processPhotoAssets(assets, completion: completion)
        } notAuthorized: {
            completion([])
        }
    }

    // 2. 实现异步的 getScreenshotPhotos
    func getScreenshotPhotos(completion: @escaping ([ComposeApp.PhotoEntity]) -> Void) {
        runWithAuthorization {
            let collections = PHAssetCollection.fetchAssetCollections(with: .smartAlbum, subtype: .smartAlbumScreenshots, options: nil)
            guard let collection = collections.firstObject else {
                completion([])
                return
            }
            let assets = PHAsset.fetchAssets(in: collection, options: nil)
            self.processPhotoAssets(assets, completion: completion)
        } notAuthorized: {
            completion([])
        }
    }

    // 3. 实现异步的 getNonScreenshotPhotos
    func getNonScreenshotPhotos(completion: @escaping ([ComposeApp.PhotoEntity]) -> Void) {
        runWithAuthorization {
            // 获取所有截图的 ID 集合，用于后续过滤
            let screenshotIDs = self.getScreenshotAssetIDs()
            
            let fetchOptions = PHFetchOptions()
            fetchOptions.sortDescriptors = [NSSortDescriptor(key: "creationDate", ascending: false)]
            let allAssets = PHAsset.fetchAssets(with: .image, options: fetchOptions)
            
            var nonScreenshotAssets: [PHAsset] = []
            allAssets.enumerateObjects { asset, _, _ in
                if !screenshotIDs.contains(asset.localIdentifier) {
                    nonScreenshotAssets.append(asset)
                }
            }
            
            self.processPhotoAssets(assetArray: nonScreenshotAssets, completion: completion)
            
        } notAuthorized: {
            completion([])
        }
    }

    // 4. 【新增】实现获取所有视频的方法
    func getAllVideos(completion: @escaping ([ComposeApp.VideoEntity]) -> Void) {
        runWithAuthorization {
            let fetchOptions = PHFetchOptions()
            fetchOptions.sortDescriptors = [NSSortDescriptor(key: "creationDate", ascending: false)]
            let assets = PHAsset.fetchAssets(with: .video, options: fetchOptions)
            self.processVideoAssets(fetchResult: assets, completion: completion)
        } notAuthorized: {
            completion([])
        }
    }



    /// 统一处理权限请求的辅助函数
    private func runWithAuthorization(
        authorized: @escaping () -> Void,
        notAuthorized: @escaping () -> Void
    ) {
        // 在后台线程执行，避免阻塞 UI
        DispatchQueue.global(qos: .userInitiated).async {
            PHPhotoLibrary.requestAuthorization(for: .readWrite) { status in
                if status == .authorized || status == .limited {
                    authorized()
                } else {
                    notAuthorized()
                }
            }
        }
    }
    
    private func processPhotoAssets(assetArray: [PHAsset], completion: @escaping ([ComposeApp.PhotoEntity]) -> Void) {
        var result: [ComposeApp.PhotoEntity] = []
        let imageManager = PHImageManager.default()
        let options = PHImageRequestOptions()
        options.deliveryMode = .highQualityFormat
        options.isNetworkAccessAllowed = true
        
        let dispatchGroup = DispatchGroup()
        
        // 迭代的是一个普通的 Array
        for asset in assetArray {
            dispatchGroup.enter()
            // 调用我们提取出的、处理单个 Asset 的公共逻辑
            processSinglePhotoAsset(asset: asset, imageManager: imageManager, options: options) { photoEntity in
                if let photoEntity = photoEntity {
                    // 使用主队列来安全地追加到数组，避免并发问题
                    DispatchQueue.main.async {
                        result.append(photoEntity)
                    }
                }
                dispatchGroup.leave()
            }
        }
        
        dispatchGroup.notify(queue: .main) {
            completion(result)
        }
    }
    
    /// 统一处理图片 PHAsset 集合，将其转换为 [PhotoEntity]
    private func processPhotoAssets(_ assets: PHFetchResult<PHAsset>, completion: @escaping ([ComposeApp.PhotoEntity]) -> Void) {
        var result: [ComposeApp.PhotoEntity] = []
        let imageManager = PHImageManager.default()
        let options = PHImageRequestOptions()
        options.deliveryMode = .highQualityFormat // 使用异步获取高质量图片
        options.isNetworkAccessAllowed = true // 允许从 iCloud 下载
        
        let dispatchGroup = DispatchGroup() // 使用 DispatchGroup 等待所有异步任务完成

        assets.enumerateObjects { asset, _, _ in
            dispatchGroup.enter() // 标记一个新任务开始
            
            imageManager.requestImage(for: asset, targetSize: CGSize(width: 800, height: 800), contentMode: .aspectFill, options: options) { image, _ in
                guard let image = image else {
                    dispatchGroup.leave() // 任务失败，也要标记完成
                    return
                }
                
                let hashUIImage = self.resizeUIImage(image, targetSize: CGSize(width: 8, height: 8))
                
                // 确保Bitmap转换成功
                if let thumbBitmap = self.uiImageToImageBitmap(image), let hashBitmap = self.uiImageToImageBitmap(hashUIImage) {
                    let photo = ComposeApp.PhotoEntity(
                        id: asset.localIdentifier,
                        thumbnail: thumbBitmap,
                        creationDate: Int64(asset.creationDate?.timeIntervalSince1970 ?? 0),
                        sizeInBytes: self.getFileSizeForAsset(asset: asset),
                        hashThumbnail: hashBitmap,
                        width: Int32(asset.pixelWidth),
                        height: Int32(asset.pixelHeight)
                    )
                    // 在并发环境中安全地添加结果
                    DispatchQueue.main.async {
                         result.append(photo)
                    }
                }
                dispatchGroup.leave() // 标记任务完成
            }
        }
        
        dispatchGroup.notify(queue: .main) { // 所有任务都完成后，执行回调
            completion(result)
        }
    }
    
    private func processSinglePhotoAsset(asset: PHAsset, imageManager: PHImageManager, options: PHImageRequestOptions, completion: @escaping (ComposeApp.PhotoEntity?) -> Void) {
          imageManager.requestImage(for: asset, targetSize: CGSize(width: 800, height: 800), contentMode: .aspectFill, options: options) { image, _ in
              guard let image = image else {
                  completion(nil)
                  return
              }
              
              let hashUIImage = self.resizeUIImage(image, targetSize: CGSize(width: 8, height: 8))
              
              if let thumbBitmap = self.uiImageToImageBitmap(image), let hashBitmap = self.uiImageToImageBitmap(hashUIImage) {
                  // 【修复错误 #2】严格按照 Kotlin data class 的顺序排列参数
                  let photo = ComposeApp.PhotoEntity(
                    id: asset.localIdentifier,
                    thumbnail: thumbBitmap,
                    creationDate: Int64(asset.creationDate?.timeIntervalSince1970 ?? 0),
                    sizeInBytes: self.getFileSizeForAsset(asset: asset),
                    hashThumbnail: hashBitmap,
                    width: Int32(asset.pixelWidth),
                    height: Int32(asset.pixelHeight)
                  )
                  completion(photo)
              } else {
                  completion(nil)
              }
          }
      }
    
    /// 【新增】统一处理视频 PHAsset 集合，将其转换为 [VideoEntity]
    private func processVideoAssets(fetchResult: PHFetchResult<PHAsset>, completion: @escaping ([ComposeApp.VideoEntity]) -> Void) {
        var result: [ComposeApp.VideoEntity] = []
        let imageManager = PHImageManager.default()
        let options = PHImageRequestOptions()
        options.deliveryMode = .fastFormat
        options.isNetworkAccessAllowed = true

        let dispatchGroup = DispatchGroup()

        fetchResult.enumerateObjects { asset, _, _ in
            dispatchGroup.enter()
            
            imageManager.requestImage(for: asset, targetSize: CGSize(width: 400, height: 400), contentMode: .aspectFill, options: options) { image, _ in
                // 【修复错误 #4】使用 if let 安全地处理可选值
                if let image = image, let thumbBitmap = self.uiImageToImageBitmap(image) {
                    // 【修复错误 #3】移除了 width 和 height 参数
                    let video = ComposeApp.VideoEntity(
                        id: asset.localIdentifier,
                        thumbnail: thumbBitmap,
                        creationDate: Int64(asset.creationDate?.timeIntervalSince1970 ?? 0),
                        sizeInBytes: self.getFileSizeForAsset(asset: asset),
                        duration: Int64(asset.duration * 1000)
                    )
                    DispatchQueue.main.async {
                        result.append(video)
                    }
                }
                dispatchGroup.leave()
            }
        }
        
        dispatchGroup.notify(queue: .main) {
            completion(result)
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
    
    private func getFileSizeForAsset(asset: PHAsset) -> Int64 {
        guard let resource = PHAssetResource.assetResources(for: asset).first,
              let unsignedInt64 = resource.value(forKey: "fileSize") as? CLong else {
            return 0
        }
        return Int64(unsignedInt64)
    }
    
    /// UIImage 缩放
    private func resizeUIImage(_ image: UIImage, targetSize: CGSize) -> UIImage {
        UIGraphicsBeginImageContextWithOptions(targetSize, false, 1.0)
        image.draw(in: CGRect(origin: .zero, size: targetSize))
        let scaledImage = UIGraphicsGetImageFromCurrentImageContext()
        UIGraphicsEndImageContext()
        return scaledImage ?? image
    }

    /// UIImage -> Kotlin ImageBitmap
    func uiImageToImageBitmap(_ image: UIImage) -> Ui_graphicsImageBitmap? {
        guard let data = image.pngData() else { return nil }

        let kotlinBytes = KotlinByteArray(size: Int32(data.count))
        for (index, byte) in data.enumerated() {
            kotlinBytes.set(index: Int32(index), value: Int8(bitPattern: byte))
        }

        return BridgeKt.byteArraytoImageBitmap(byteArray: kotlinBytes)
    }
}
