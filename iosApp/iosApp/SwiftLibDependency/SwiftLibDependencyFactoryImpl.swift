import Foundation
import ComposeApp

class SwiftLibDependencyFactoryImpl: SwiftLibDependencyFactory {
    static let shared = SwiftLibDependencyFactoryImpl()

    private let mediaScanner: MediaScanner = MediaScannerImpl()
    private let deviceStorageSource: DeviceStorageSource = DeviceStorageSourceImpl()
    private let contactsScanner: ContactsScanner = ContactsScannerImpl()
    private let calendarScanner: CalendarScanner = CalendarScannerImpl()

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
        return contactsScanner
    }

    func provideCalendarScannerImpl() -> CalendarScanner {
        return calendarScanner
    }
}
