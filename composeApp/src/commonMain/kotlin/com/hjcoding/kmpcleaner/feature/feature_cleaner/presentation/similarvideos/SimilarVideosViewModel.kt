package com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.similarvideos

import androidx.compose.ui.graphics.ImageBitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Video
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.repository.MediaRespository
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.use_case.DeleteVideosUseCase
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.use_case.GetSimilarVideoGroupsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SimilarVideosViewModel(
    private val getSimilarVideoGroupsUseCase: GetSimilarVideoGroupsUseCase,
    private val deleteVideosUseCase: DeleteVideosUseCase,
    private val mediaRepository: MediaRespository
) : ViewModel() {

    private val _uiState = MutableStateFlow(SimilarVideosUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadSimilarVideos()
    }

    fun onAction(action: SimilarVideosAction) {
        when (action) {
            is SimilarVideosAction.ToggleSelection -> {
                _uiState.update {
                    val newSelection = if (it.selectedVideos.contains(action.videoId)) {
                        it.selectedVideos - action.videoId
                    } else {
                        it.selectedVideos + action.videoId
                    }
                    it.copy(selectedVideos = newSelection)
                }
            }
            SimilarVideosAction.DeleteSelected -> {
                viewModelScope.launch {
                    val idsToDelete = _uiState.value.selectedVideos.toList()
                    deleteVideosUseCase(idsToDelete)
                        .onSuccess {
                            loadSimilarVideos()
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

    suspend fun loadBitmap(video: Video): ImageBitmap? {
        return mediaRepository.getThumbnailBitmap(video.id, isVideo = true)
    }

    private fun loadSimilarVideos() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, selectedVideos = emptySet()) }
            try {
                val allVideos = mediaRepository.getAllVideos()
                val videoGroups = getSimilarVideoGroupsUseCase(allVideos)
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        videoGroups = videoGroups
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
