import Foundation
import KeychainSwift

import Foundation
import KeychainSwift

/// 设备 ID 工具，使用 Keychain 持久化存储一个 UUID
class DeviceUtil {

    /// 把 keychain 改成静态成员
    private static let keychain = KeychainSwift()

    /// Keychain 存储所用的 service 和 account
    private static let service = "kSSToolkitUUID"
    private static let account = "user"

    /// 获取设备唯一标识
    /// - 返回：一个已在 Keychain 中持久化的 UUID （去除了连字符）
    static func getDeviceId() -> String {
        // 1. 尝试从 Keychain 读取已存的 UUID
        let uuidString = keychain.get(account)

        // 2. 如果没有读到，就新生成一个
        let finalUUID: String
        if let u = uuidString, !u.isEmpty {
            finalUUID = u
        } else {
            let newUUID = UUID().uuidString
            keychain.set(newUUID, forKey: account)
            finalUUID = newUUID
        }

        // 3. 返回去掉连字符的 UUID
        return finalUUID.replacingOccurrences(of: "-", with: "")
    }
}
