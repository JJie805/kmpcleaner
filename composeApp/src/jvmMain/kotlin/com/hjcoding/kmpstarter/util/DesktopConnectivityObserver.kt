package com.hjcoding.kmpstarter.util

import com.hjcoding.kmpstarter.core.data.util.ConnectivityObserver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.net.InetAddress

class DesktopConnectivityObserver(
    private val checkHost: String = "8.8.8.8",      // 用于检测的主机（Google Public DNS）
    private val timeoutMs: Int = 1500,              // ping 超时时间
    private val pollingIntervalMs: Long = 5_000L    // 轮询间隔
) : ConnectivityObserver {

    override val isConnected: Flow<Boolean> = flow {
        while (true) {
            emit(checkNetwork())
            delay(pollingIntervalMs)
        }
    }
        // 只在状态真正改变时才通知下游
        .distinctUntilChanged()
        // IO 线程做网络探测
        .flowOn(Dispatchers.IO)

    private fun checkNetwork(): Boolean {
        return try {
            // isReachable 会发 ICMP 或 TCP 探测（不同平台行为略有差异）
            InetAddress.getByName(checkHost).isReachable(timeoutMs)
        } catch (e: Exception) {
            false
        }
    }
}