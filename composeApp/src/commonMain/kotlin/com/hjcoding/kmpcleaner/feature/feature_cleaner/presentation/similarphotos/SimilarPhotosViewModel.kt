package com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.similarphotos

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

class SimilarPhotosViewModel(
    private val getSimilarPhotoGroupsUseCase: GetSimilarPhotoGroupsUseCase,
    private val deletePhotosUseCase: DeletePhotosUseCase,
    private val mediaRepository: MediaRespository
) : ViewModel() {

    private val _uiState = MutableStateFlow(SimilarPhotosUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadSimilarPhotos()
    }

    fun onAction(action: SimilarPhotosAction) {
        when (action) {
            is SimilarPhotosAction.ToggleSelection -> {
                _uiState.update {
                    val newSelection = if (it.selectedPhotos.contains(action.photoId)) {
                        it.selectedPhotos - action.photoId
                    } else {
                        it.selectedPhotos + action.photoId
                    }
                    it.copy(selectedPhotos = newSelection)
                }
            }
            SimilarPhotosAction.DeleteSelected -> {
                viewModelScope.launch {
                    val idsToDelete = _uiState.value.selectedPhotos.toList()
                    deletePhotosUseCase(idsToDelete)
                        .onSuccess {
                            loadSimilarPhotos()
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

    private fun loadSimilarPhotos() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, selectedPhotos = emptySet()) }
            try {
                val allPhotos = mediaRepository.getNonScreenshotPhotos()
                val photoGroups = getSimilarPhotoGroupsUseCase(allPhotos)
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
