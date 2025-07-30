package com.hjcoding.kmpstarter.core.data.util

import kotlinx.coroutines.flow.Flow

interface ConnectivityObserver {
    val isConnected: Flow<Boolean>
}