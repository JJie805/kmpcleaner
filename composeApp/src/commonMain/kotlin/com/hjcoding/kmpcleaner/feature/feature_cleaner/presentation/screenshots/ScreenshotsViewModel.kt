package com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.screenshots

import androidx.compose.ui.graphics.ImageBitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Photo
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.repository.MediaRespository
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.use_case.GetScreenshotsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ScreenshotsViewModel(
    private val getScreenshotsUseCase: GetScreenshotsUseCase,
    private val mediaRepository: MediaRespository
) : ViewModel() {

    private val _uiState = MutableStateFlow(ScreenshotsUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadScreenshots()
    }

    fun onAction(action: ScreenshotsAction) {
        when (action) {
            is ScreenshotsAction.ToggleSelection -> {
                _uiState.update {
                    val newSelection = if (it.selectedScreenshots.contains(action.photoId)) {
                        it.selectedScreenshots - action.photoId
                    } else {
                        it.selectedScreenshots + action.photoId
                    }
                    it.copy(selectedScreenshots = newSelection)
                }
            }
            ScreenshotsAction.DeleteSelected -> {
                // TODO: Implement deletion logic
            }
        }
    }

    suspend fun loadBitmap(photo: Photo): ImageBitmap? {
        return mediaRepository.getThumbnailBitmap(photo.id, isVideo = false)
    }

    private fun loadScreenshots() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            try {
                val screenshots = getScreenshotsUseCase()
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        screenshots = screenshots
                    )
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = e.message
                    )
                }
            }
        }
    }
}
