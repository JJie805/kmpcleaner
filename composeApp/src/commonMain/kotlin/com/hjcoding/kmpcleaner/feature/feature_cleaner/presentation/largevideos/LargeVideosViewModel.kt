package com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.largevideos

import androidx.compose.ui.graphics.ImageBitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Video
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.repository.MediaRespository
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.use_case.DeleteVideosUseCase
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.use_case.GetLargeVideosUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LargeVideosViewModel(
    private val getLargeVideosUseCase: GetLargeVideosUseCase,
    private val deleteVideosUseCase: DeleteVideosUseCase,
    private val mediaRepository: MediaRespository
) : ViewModel() {

    private val _uiState = MutableStateFlow(LargeVideosUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadLargeVideos()
    }

    fun onAction(action: LargeVideosAction) {
        when (action) {
            is LargeVideosAction.ToggleSelection -> {
                _uiState.update {
                    val newSelection = if (it.selectedVideos.contains(action.videoId)) {
                        it.selectedVideos - action.videoId
                    } else {
                        it.selectedVideos + action.videoId
                    }
                    it.copy(selectedVideos = newSelection)
                }
            }
            LargeVideosAction.DeleteSelected -> {
                viewModelScope.launch {
                    val idsToDelete = _uiState.value.selectedVideos.toList()
                    deleteVideosUseCase(idsToDelete)
                        .onSuccess {
                            loadLargeVideos()
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

    private fun loadLargeVideos() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, selectedVideos = emptySet()) }
            try {
                val videos = getLargeVideosUseCase()
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        videos = videos
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
