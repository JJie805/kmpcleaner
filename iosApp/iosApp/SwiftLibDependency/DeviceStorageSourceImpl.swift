import Foundation
import Photos
import ComposeApp
import UIKit

class DeviceStorageSourceImpl: ComposeApp.DeviceStorageSource {
    
    func getStorageDetails()-> ComposeApp.StorageDetails {
        return ComposeApp.StorageDetails(totalBytes:0, freeBytes:0)
    }
}
