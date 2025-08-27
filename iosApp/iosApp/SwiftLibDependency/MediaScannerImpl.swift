import Foundation
import Photos
import Contacts
import ComposeApp // Ensure this is the correct name for your KMP module
import UIKit

class MediaScannerImpl: ComposeApp.MediaScanner {

    // MARK: - Public API Implementation

    func getAllPhotos(completion: @escaping ([ComposeApp.PhotoEntity]) -> Void) {
        runWithAuthorization {
            let assets = self.fetchAssets(with: .image)
            completion(self.assetsToPhotos(assets))
        } notAuthorized: { completion([]) }
    }

    func getScreenshotPhotos(completion: @escaping ([ComposeApp.PhotoEntity]) -> Void) {
        runWithAuthorization {
            let collections = PHAssetCollection.fetchAssetCollections(with: .smartAlbum, subtype: .smartAlbumScreenshots, options: nil)
            guard let collection = collections.firstObject else {
                completion([])
                return
            }
            let assets = self.fetchAssets(in: collection)
            completion(self.assetsToPhotos(assets))
        } notAuthorized: { completion([]) }
    }

    func getNonScreenshotPhotos(completion: @escaping ([ComposeApp.PhotoEntity]) -> Void) {
        runWithAuthorization {
            let allPhotoAssets = self.fetchAssets(with: .image)
            let screenshotAssets = self.fetchAssets(in: PHAssetCollection.fetchAssetCollections(with: .smartAlbum, subtype: .smartAlbumScreenshots, options: nil).firstObject)
            
            let screenshotIDs = Set(screenshotAssets.map { $0.localIdentifier })
            let nonScreenshotAssets = allPhotoAssets.filter { !screenshotIDs.contains($0.localIdentifier) }
            
            completion(self.assetsToPhotos(nonScreenshotAssets))
        } notAuthorized: { completion([]) }
    }

    func getAllVideos(completion: @escaping ([ComposeApp.VideoEntity]) -> Void) {
        runWithAuthorization {
            let assets = self.fetchAssets(with: .video)
            completion(self.assetsToVideos(assets))
        } notAuthorized: { completion([]) }
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

    func deletePhotos(ids: [String], completion: @escaping (KotlinBoolean) -> Void) {
        runWithAuthorization {
            let assets = PHAsset.fetchAssets(withLocalIdentifiers: ids, options: nil)
            PHPhotoLibrary.shared().performChanges({
                PHAssetChangeRequest.deleteAssets(assets)
            }) { success, error in
                DispatchQueue.main.async {
                    completion(KotlinBoolean(value: success))
                }
            }
        } notAuthorized: {
            DispatchQueue.main.async {
                completion(KotlinBoolean(value: false))
            }
        }
    }

    func deleteVideos(ids: [String], completion: @escaping (KotlinBoolean) -> Void) {
        runWithAuthorization {
            let assets = PHAsset.fetchAssets(withLocalIdentifiers: ids, options: nil)
            PHPhotoLibrary.shared().performChanges({
                PHAssetChangeRequest.deleteAssets(assets)
            }) { success, error in
                DispatchQueue.main.async {
                    completion(KotlinBoolean(value: success))
                }
            }
        } notAuthorized: {
            DispatchQueue.main.async {
                completion(KotlinBoolean(value: false))
            }
        }
    }

    // KMP-compatible completion handler version
    func getKeyFrames(forVideoId: String, completion: @escaping ([Any]) -> Void) {
        Task {
            let result = await getKeyFrames(forVideoId: forVideoId)
            completion(result)
        }
    }

    // Modern async version for internal logic
    private func getKeyFrames(forVideoId: String) async -> [Ui_graphicsImageBitmap] {
        let assets = PHAsset.fetchAssets(withLocalIdentifiers: [forVideoId], options: nil)
        guard let asset = assets.firstObject else { return [] }

        // Correctly wrap the callback in a continuation, handling the optional AVAsset?
        let avAsset: AVAsset? = await withCheckedContinuation { continuation in
            let imageManager = PHImageManager.default()
            let options = PHVideoRequestOptions()
            options.version = .original
            options.isNetworkAccessAllowed = true
            imageManager.requestAVAsset(forVideo: asset, options: options) { asset, _, _ in
                continuation.resume(returning: asset)
            }
        }

        guard let unwrappedAvAsset = avAsset else {
            return []
        }

        var keyFrames: [Ui_graphicsImageBitmap] = []
        do {
            let imageGenerator = AVAssetImageGenerator(asset: unwrappedAvAsset)
            imageGenerator.appliesPreferredTrackTransform = true
            let duration = try await unwrappedAvAsset.load(.duration)
            let durationInSeconds = CMTimeGetSeconds(duration)
            
            guard durationInSeconds > 0 else { return [] }
            
            let times = (0..<5).map {
                CMTime(seconds: durationInSeconds * Double($0) / 4.0, preferredTimescale: 600)
            }
            
            for try await result in imageGenerator.images(for: times) {
                do {
                    let cgImage = try result.image
                    let uiImage = UIImage(cgImage: cgImage)
                    let resizedImage = self.resizeUIImage(uiImage, targetSize: CGSize(width: 9, height: 8))
                    if let bitmap = self.uiImageToImageBitmap(resizedImage) {
                        keyFrames.append(bitmap)
                    }
                } catch {
                    print("Could not generate image for a specific time: \(error)")
                }
            }
        } catch {
            print("Error generating key frames: \(error)")
        }
        
        return keyFrames
    }

    // MARK: - Private Helpers

    private func fetchBitmap(forId id: String, targetSize: CGSize, completion: @escaping (Ui_graphicsImageBitmap?) -> Void) {
        DispatchQueue.global(qos: .userInitiated).async {
            let assets = PHAsset.fetchAssets(withLocalIdentifiers: [id], options: nil)
            guard let asset = assets.firstObject else {
                DispatchQueue.main.async { completion(nil) }
                return
            }

            let imageManager = PHImageManager.default()
            let options = PHImageRequestOptions()
            options.deliveryMode = .fastFormat
            options.isNetworkAccessAllowed = true
            // REMOVED: options.isSynchronous = true - This is critical for performance

            imageManager.requestImage(for: asset, targetSize: targetSize, contentMode: .aspectFill, options: options) { image, _ in
                guard let fetchedImage = image else {
                    DispatchQueue.main.async { completion(nil) }
                    return
                }
                
                let correctlySizedImage = self.resizeUIImage(fetchedImage, targetSize: targetSize)
                let bitmap = self.uiImageToImageBitmap(correctlySizedImage)
                
                DispatchQueue.main.async { completion(bitmap) }
            }
        }
    }
    
    private func fetchAssets(with mediaType: PHAssetMediaType) -> [PHAsset] {
        let fetchOptions = PHFetchOptions()
        fetchOptions.sortDescriptors = [NSSortDescriptor(key: "creationDate", ascending: false)]
        let result = PHAsset.fetchAssets(with: mediaType, options: fetchOptions)
        var assets: [PHAsset] = []
        result.enumerateObjects { asset, _, _ in
            assets.append(asset)
        }
        return assets
    }

    private func fetchAssets(in collection: PHAssetCollection?) -> [PHAsset] {
        guard let collection = collection else { return [] }
        let result = PHAsset.fetchAssets(in: collection, options: nil)
        var assets: [PHAsset] = []
        result.enumerateObjects { asset, _, _ in
            assets.append(asset)
        }
        return assets
    }

    private func assetsToPhotos(_ assets: [PHAsset]) -> [ComposeApp.PhotoEntity] {
        return assets.map { asset in
            ComposeApp.PhotoEntity(
                id: asset.localIdentifier,
                creationDate: Int64(asset.creationDate?.timeIntervalSince1970 ?? 0),
                sizeInBytes: self.getFileSizeForAsset(asset: asset),
                width: Int32(asset.pixelWidth),
                height: Int32(asset.pixelHeight)
            )
        }
    }
    
    private func assetsToVideos(_ assets: [PHAsset]) -> [ComposeApp.VideoEntity] {
        return assets.map { asset in
            ComposeApp.VideoEntity(
                id: asset.localIdentifier,
                creationDate: Int64(asset.creationDate?.timeIntervalSince1970 ?? 0),
                sizeInBytes: self.getFileSizeForAsset(asset: asset),
                duration: Int64(asset.duration)
            )
        }
    }

    private func runWithAuthorization(authorized: @escaping () -> Void, notAuthorized: @escaping () -> Void) {
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

    private func getFileSizeForAsset(asset: PHAsset) -> Int64 {
        guard let resource = PHAssetResource.assetResources(for: asset).first,
              let unsignedInt64 = resource.value(forKey: "fileSize") as? CLong else {
            return 0
        }
        return Int64(unsignedInt64)
    }

    func uiImageToImageBitmap(_ image: UIImage) -> Ui_graphicsImageBitmap? {
        guard let data = image.pngData() else { return nil }
        let kotlinBytes = KotlinByteArray(size: Int32(data.count))
        for (index, byte) in data.enumerated() {
            kotlinBytes.set(index: Int32(index), value: Int8(bitPattern: byte))
        }
        return BridgeKt.byteArraytoImageBitmap(byteArray: kotlinBytes)
    }

    private func resizeUIImage(_ image: UIImage, targetSize: CGSize) -> UIImage {
        UIGraphicsBeginImageContextWithOptions(targetSize, false, 1.0)
        image.draw(in: CGRect(origin: .zero, size: targetSize))
        let scaledImage = UIGraphicsGetImageFromCurrentImageContext()
        UIGraphicsEndImageContext()
        return scaledImage ?? image
    }
}
