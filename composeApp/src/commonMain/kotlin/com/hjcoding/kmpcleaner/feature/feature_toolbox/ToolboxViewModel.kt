package com.hjcoding.kmpcleaner.feature.feature_toolbox

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class ToolboxViewModel : ViewModel() {

    private val _state = MutableStateFlow(ToolboxState())
    val state = _state
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            ToolboxState(
                gaugeItems = listOf(
                    GaugeInfo("CPU 占用", 14),
                    GaugeInfo("内存占用", 2),
                    GaugeInfo("存储剩余", 11)
                ),
                toolItems = listOf(
                    ToolItem("密码保险箱", Icons.Default.Lock),
                    ToolItem("订阅管理器", Icons.Default.ShoppingCart)
                )
            )
        )

    fun onAction(action: ToolboxAction) {
        // No actions yet
    }
}
