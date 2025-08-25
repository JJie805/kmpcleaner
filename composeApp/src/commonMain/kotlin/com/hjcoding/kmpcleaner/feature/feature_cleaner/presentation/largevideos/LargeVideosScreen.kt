package com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.largevideos

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Video
import org.koin.compose.viewmodel.koinViewModel
import androidx.compose.foundation.clickable
import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.foundation.Image

@Composable
fun LargeVideosScreenRoot(
    viewModel: LargeVideosViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    LargeVideosScreen(
        uiState = uiState,
        onAction = viewModel::onAction,
        loadBitmap = { video -> viewModel.loadBitmap(video) }
    )
}

@Composable
fun LargeVideosScreen(
    uiState: LargeVideosUiState,
    onAction: (LargeVideosAction) -> Unit,
    loadBitmap: suspend (Video) -> ImageBitmap?
) {
    Scaffold(
        bottomBar = {
            if (uiState.selectedVideos.isNotEmpty()) {
                Button(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    onClick = { onAction(LargeVideosAction.DeleteSelected) }
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
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 128.dp),
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(4.dp)
                ) {
                    items(uiState.videos, key = { it.id }) { video ->
                        VideoItem(
                            video = video,
                            isSelected = uiState.selectedVideos.contains(video.id),
                            onToggleSelection = { onAction(LargeVideosAction.ToggleSelection(video.id)) },
                            loadBitmap = loadBitmap
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun VideoItem(
    video: Video,
    isSelected: Boolean,
    onToggleSelection: () -> Unit,
    loadBitmap: suspend (Video) -> ImageBitmap?
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

@Composable
fun AsyncVideoView(video: Video, loadBitmap: suspend (Video) -> ImageBitmap?) {
    var imageBitmap by remember { mutableStateOf<ImageBitmap?>(null) }

    LaunchedEffect(video.id) {
        imageBitmap = loadBitmap(video)
    }

    if (imageBitmap != null) {
        Image(bitmap = imageBitmap!!, contentDescription = null, modifier = Modifier.aspectRatio(1f))
    } else {
        Box(modifier = Modifier.aspectRatio(1f).background(Color.Gray)) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}
