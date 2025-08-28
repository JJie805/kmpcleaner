package com.hjcoding.kmpcleaner.feature.feature_toolbox.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hjcoding.kmpcleaner.feature.feature_toolbox.domain.use_case.GetSystemInfoUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class ToolboxViewModel(private val getSystemInfoUseCase: GetSystemInfoUseCase) : ViewModel() {

    private val _state = MutableStateFlow(ToolboxState(
        toolItems = listOf(
            ToolItem("密码保险箱", Icons.Default.Book),
            ToolItem("订阅管理器", Icons.Default.Book)
        )
    ))
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            while (true) {
                val systemInfo = getSystemInfoUseCase()
//                _uiState.update { it.copy(systemInfo = systemInfo) }
                delay(1000) // Refresh every second
            }
        }
    }

    fun onAction(action: ToolboxAction) {
        // No actions yet
    }
}