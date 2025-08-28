import Foundation
import ComposeApp
import FirebaseAnalytics
import FirebaseCore

import Foundation
import UIKit
import ComposeApp

class IosPlatform: NSObject, Platform {
    var name: String = UIDevice.current.systemName
    var systemVersion: String = UIDevice.current.systemVersion
    var appVersionName: String = Bundle.main.infoDictionary?["CFBundleShortVersionString"] as? String ?? ""
    var appVersionCode: String = Bundle.main.infoDictionary?["CFBundleVersion"] as? String ?? ""
    var uniqueId: String = UIDevice.current.identifierForVendor?.uuidString ?? ""

    func getCpuUsage() -> Float {
        // Placeholder data
        return Float.random(in: 10...40)
    }

    func getMemoryUsage() -> MemoryUsage {
        // Placeholder data
        // Assuming total memory is 8GB and used is around 3.5GB for plausible UI.
        let totalMemory: Int64 = 8 * 1024 * 1024 * 1024
        let usedMemory: Int64 = 3.5 * 1024 * 1024 * 1024
        return MemoryUsage(used: usedMemory, total: totalMemory)
    }
}
