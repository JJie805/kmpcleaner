import Foundation
import ComposeApp
import SwiftUI
import UIKit

class SwiftLibDependencyFactoryImpl: SwiftLibDependencyFactory {
    static var shared = SwiftLibDependencyFactoryImpl()

    func provideFirebaseAnalyticsImpl() -> any Analytics {
        return FirebaseAnalyticsImpl()
    }

    func providePlatformImpl() -> any Platform {
        return IosPlatform()
    }

    func provideMediaScannerImpl()-> any MediaScanner {
        return MediaScannerImpl()
    }
    
    func provideDeviceStorageSourceImpl() -> any DeviceStorageSource {
        return DeviceStorageSourceImpl()
    }
}
