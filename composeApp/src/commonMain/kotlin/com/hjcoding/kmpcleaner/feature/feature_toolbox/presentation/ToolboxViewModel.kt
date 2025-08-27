package com.hjcoding.kmpcleaner.feature.feature_toolbox.presentation.presentation

import com.hjcoding.kmpcleaner.feature.feature_toolbox.domain.GetSystemInfoUseCase
import com.hjcoding.kmpcleaner.feature.feature_toolbox.domain.SystemInfo
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class ToolboxState(
    val systemInfo: SystemInfo? = null
)

class ToolboxViewModel(private val getSystemInfoUseCase: GetSystemInfoUseCase) : ViewModel() {

    private val _uiState = MutableStateFlow(ToolboxState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            while (true) {
                val systemInfo = getSystemInfoUseCase()
                _uiState.update { it.copy(systemInfo = systemInfo) }
                delay(1000) // Refresh every second
            }
        }
    }
}