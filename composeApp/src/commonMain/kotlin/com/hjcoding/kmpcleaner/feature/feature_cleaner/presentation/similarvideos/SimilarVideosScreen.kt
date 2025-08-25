package com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.similarvideos

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.VideoGroup
import org.koin.compose.viewmodel.koinViewModel
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Video
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.clickable
import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.ui.graphics.Color
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.largevideos.AsyncVideoView

@Composable
fun SimilarVideosScreenRoot(
    viewModel: SimilarVideosViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    SimilarVideosScreen(
        uiState = uiState,
        onAction = viewModel::onAction,
        loadBitmap = { video -> viewModel.loadBitmap(video) }
    )
}

@Composable
fun SimilarVideosScreen(
    uiState: SimilarVideosUiState,
    onAction: (SimilarVideosAction) -> Unit,
    loadBitmap: suspend (Video) -> androidx.compose.ui.graphics.ImageBitmap?
) {
    Scaffold(
        bottomBar = {
            if (uiState.selectedVideos.isNotEmpty()) {
                Button(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    onClick = { onAction(SimilarVideosAction.DeleteSelected) }
                ) {
                    Text("Delete (${uiState.selectedVideos.size})")
                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            if (uiState.isLoading) {
                CircularProgressIndicator()
            } else if (uiState.error != null) {
                Text("Error: ${uiState.error}")
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(vertical = 8.dp)
                ) {
                    items(uiState.videoGroups) { group ->
                        VideoGroupItem(
                            group = group,
                            selectedVideos = uiState.selectedVideos,
                            onAction = onAction,
                            loadBitmap = loadBitmap
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun VideoGroupItem(
    group: VideoGroup,
    selectedVideos: Set<String>,
    onAction: (SimilarVideosAction) -> Unit,
    loadBitmap: suspend (Video) -> androidx.compose.ui.graphics.ImageBitmap?
) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(
            text = "Group (${group.videos.size})",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        LazyRow(
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp)
        ) {
            items(group.videos) { video ->
                VideoItem(
                    video = video,
                    isSelected = selectedVideos.contains(video.id),
                    onToggleSelection = { onAction(SimilarVideosAction.ToggleSelection(video.id)) },
                    loadBitmap = loadBitmap
                )
            }
        }
    }
}

@Composable
private fun VideoItem(
    video: Video,
    isSelected: Boolean,
    onToggleSelection: () -> Unit,
    loadBitmap: suspend (Video) -> androidx.compose.ui.graphics.ImageBitmap?
) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .clickable { onToggleSelection() }
    ) {
        AsyncVideoView(
            video = video,
            loadBitmap = loadBitmap
        )
        if (isSelected) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(Color.Black.copy(alpha = 0.5f))
            )
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = "Selected",
                tint = Color.Green,
                modifier = Modifier.align(Alignment.TopEnd).padding(8.dp)
            )
        }
    }
}
