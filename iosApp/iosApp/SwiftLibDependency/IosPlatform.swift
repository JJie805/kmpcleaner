import Foundation
import ComposeApp
import FirebaseAnalytics
import FirebaseCore

class IosPlatform : ComposeApp.Platform {
    // 设备名称 + 系统版本
    var name: String = "Ios \(UIDevice.current.systemName) \(UIDevice.current.systemVersion)"
    // 系统版本号
    var systemVersion: String = UIDevice.current.systemVersion
    // App 版本名（Version Name）
    var appVersionName: String = Bundle.main.infoDictionary?["CFBundleShortVersionString"] as? String ?? ""
    // App 版本号／构建号（Version Code）
    var appVersionCode: String = Bundle.main.infoDictionary?["CFBundleVersion"] as? String ?? ""
    // 唯一 ID
    var uniqueId: String = DeviceUtil.getDeviceId()
}
