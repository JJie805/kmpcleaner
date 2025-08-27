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
        var totalUsage: Float = 0.0
        var kr: kern_return_t
        var task_info_count: mach_msg_type_number_t
        var tinfo = task_thread_times_info.init()

        task_info_count = mach_msg_type_number_t(TASK_THREAD_TIMES_INFO_COUNT)
        kr = task_info(mach_task_self_, task_flavor_t(TASK_THREAD_TIMES_INFO), &tinfo, &task_info_count)

        if kr != KERN_SUCCESS {
            return -1
        }

        var threads_list: thread_act_array_t? = nil
        var threads_count: mach_msg_type_number_t = 0
        defer { 
            if threads_list != nil {
                vm_deallocate(mach_task_self_, vm_address_t(UnsafePointer(threads_list!).pointee), vm_size_t(threads_count))
            }
        }

        kr = task_threads(mach_task_self_, &threads_list, &threads_count)

        if kr != KERN_SUCCESS {
            return -1
        }

        for i in 0..<threads_count {
            var thread_info_count = mach_msg_type_number_t(THREAD_BASIC_INFO_COUNT)
            var thinfo = thread_basic_info.init()
            kr = thread_info(threads_list![Int(i)], thread_flavor_t(THREAD_BASIC_INFO), &thinfo, &thread_info_count)
            if kr != KERN_SUCCESS {
                return -1
            }
            let thread_basic_info = thinfo as thread_basic_info
            if (thread_basic_info.flags & TH_FLAGS_IDLE) == 0 {
                totalUsage += Float(thread_basic_info.cpu_usage) / Float(TH_USAGE_SCALE) * 100
            }
        }

        return totalUsage
    }

    func getMemoryUsage() -> MemoryUsage {
        var taskInfo = mach_task_basic_info()
        var count = mach_msg_type_number_t(MemoryLayout<mach_task_basic_info>.size)/4
        let kerr: kern_return_t = withUnsafeMutablePointer(to: &taskInfo) {
            $0.withMemoryRebound(to: integer_t.self, capacity: 1) { 
                task_info(mach_task_self_, task_flavor_t(MACH_TASK_BASIC_INFO), $0, &count)
            }
        }

        if kerr == KERN_SUCCESS {
            let used = taskInfo.resident_size
            let total = ProcessInfo.processInfo.physicalMemory
            return MemoryUsage(used: Int64(used), total: Int64(total))
        } else {
            return MemoryUsage(used: 0, total: 0)
        }
    }
}
