import Foundation
import ComposeApp
import SwiftUI
import UIKit

class SwiftLibDependencyFactoryImpl: SwiftLibDependencyFactory {
    static let shared = SwiftLibDependencyFactoryImpl()

    private let mediaScanner: MediaScanner = MediaScannerImpl()
    private let deviceStorageSource: DeviceStorageSource = DeviceStorageSourceImpl()

    func provideFirebaseAnalyticsImpl() -> Analytics {
        return FirebaseAnalyticsImpl()
    }

    func providePlatformImpl() -> Platform {
        return IosPlatform()
    }

    func provideMediaScannerImpl() -> MediaScanner {
        return mediaScanner
    }

    func provideDeviceStorageSourceImpl() -> DeviceStorageSource {
        return deviceStorageSource
    }

    func provideContactsScannerImpl() -> ContactsScanner {
        return mediaScanner as! ContactsScanner
    }
}
