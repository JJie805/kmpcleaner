package com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.similarscreenshots

import androidx.compose.ui.graphics.ImageBitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Photo
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.repository.MediaRespository
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.use_case.DeletePhotosUseCase
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.use_case.GetSimilarPhotoGroupsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SimilarScreenshotsViewModel(
    private val getSimilarPhotoGroupsUseCase: GetSimilarPhotoGroupsUseCase,
    private val deletePhotosUseCase: DeletePhotosUseCase,
    private val mediaRepository: MediaRespository
) : ViewModel() {

    private val _uiState = MutableStateFlow(SimilarScreenshotsUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadSimilarScreenshots()
    }

    fun onAction(action: SimilarScreenshotsAction) {
        when (action) {
            is SimilarScreenshotsAction.ToggleSelection -> {
                _uiState.update {
                    val newSelection = if (it.selectedPhotos.contains(action.photoId)) {
                        it.selectedPhotos - action.photoId
                    } else {
                        it.selectedPhotos + action.photoId
                    }
                    it.copy(selectedPhotos = newSelection)
                }
            }
            SimilarScreenshotsAction.DeleteSelected -> {
                viewModelScope.launch {
                    val idsToDelete = _uiState.value.selectedPhotos.toList()
                    deletePhotosUseCase(idsToDelete)
                        .onSuccess {
                            loadSimilarScreenshots()
                        }
                        .onFailure { error ->
                            _uiState.update {
                                it.copy(error = error.message)
                            }
                        }
                }
            }
        }
    }

    suspend fun loadBitmap(photo: Photo): ImageBitmap? {
        return mediaRepository.getThumbnailBitmap(photo.id, isVideo = false)
    }

    private fun loadSimilarScreenshots() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, selectedPhotos = emptySet()) }
            try {
                val allScreenshots = mediaRepository.getScreenshotPhotos()
                val photoGroups = getSimilarPhotoGroupsUseCase(allScreenshots)
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        photoGroups = photoGroups
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
