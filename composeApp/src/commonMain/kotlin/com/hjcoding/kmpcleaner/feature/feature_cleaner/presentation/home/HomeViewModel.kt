package com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.home

import GetHomePageDataUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.mappers.toStorageInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getHomePageDataUseCase: GetHomePageDataUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state = _state
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            _state.value
        )

    init {
        loadData()
    }

    fun onAction(action: HomeAction) {
        when (action) {
            HomeAction.Refresh -> loadData()
        }
    }

    private fun loadData() = viewModelScope.launch {
        _state.update { it.copy(isLoading = true, error = null) }

        getHomePageDataUseCase().onSuccess { homePageData ->
            _state.update {
                it.copy(
                    isLoading = false,
                    cleanupItems = homePageData.cleanupItems,
                    storageInfo = homePageData.storageUsage.toStorageInfo()
                )
            }
        }.onFailure { error ->
            _state.update {
                it.copy(
                    isLoading = false,
                    error = error.message ?: "加载失败，请重试"
                )
            }
        }
    }
}



