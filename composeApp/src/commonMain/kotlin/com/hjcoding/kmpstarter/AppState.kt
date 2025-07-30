package com.hjcoding.kmpstarter

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import com.hjcoding.kmpstarter.core.data.util.ConnectivityObserver
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@Composable
fun rememberAppState(
    connectivityObserver: ConnectivityObserver,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
): AppState = remember(
    connectivityObserver,
    coroutineScope,
){
    AppState(
        connectivityObserver = connectivityObserver,
        coroutineScope = coroutineScope,
    )
}

@Stable
class AppState(
    connectivityObserver : ConnectivityObserver,
    coroutineScope: CoroutineScope,
){
    val isOffline = connectivityObserver.isConnected
        .map(Boolean::not)
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = false,
        )
}
