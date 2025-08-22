package com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.screenshots

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.dp
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Photo
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ScreenshotsScreenRoot(
    viewModel: ScreenshotsViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    ScreenshotsScreen(
        uiState = uiState,
        onAction = viewModel::onAction,
        loadBitmap = viewModel::loadBitmap
    )
}

@Composable
fun ScreenshotsScreen(
    uiState: ScreenshotsUiState,
    onAction: (ScreenshotsAction) -> Unit,
    loadBitmap: suspend (Photo) -> ImageBitmap?
) {
    Scaffold(
        modifier = Modifier.fillMaxSize().background(Color.Red),
        bottomBar = {
            if (uiState.selectedScreenshots.isNotEmpty()) {
                Button(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    onClick = { onAction(ScreenshotsAction.DeleteSelected) }
                ) {
                    Text("Delete (${uiState.selectedScreenshots.size})")
                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier.fillMaxSize().padding(paddingValues).background(Color.Blue),
            contentAlignment = Alignment.Center
        ) {
            if (uiState.isLoading) {
                CircularProgressIndicator()
            } else if (uiState.error != null) {
                Text("Error: ${uiState.error}")
            } else {
                Text("Found ${uiState.screenshots.size} screenshots")
            }
        }
    }
}

@Composable
private fun ScreenshotItem(
    photo: Photo,
    isSelected: Boolean,
    onToggleSelection: () -> Unit,
    loadBitmap: suspend (Photo) -> ImageBitmap?
) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .clickable { onToggleSelection() }
    ) {
        AsyncPhotoView(
            photo = photo,
            loadBitmap = loadBitmap
        )
        if (isSelected) {
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
fun AsyncPhotoView(photo: Photo, loadBitmap: suspend (Photo) -> ImageBitmap?) {
    var imageBitmap by remember { mutableStateOf<ImageBitmap?>(null) }

    LaunchedEffect(photo.id) {
        imageBitmap = loadBitmap(photo)
    }

    if (imageBitmap != null) {
        Image(bitmap = imageBitmap!!, contentDescription = null, modifier = Modifier.aspectRatio(1f))
    } else {
        Box(modifier = Modifier.aspectRatio(1f).background(Color.Gray)) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}

@Preview
@Composable
fun ScreenshotsScreenPreview() {
    ScreenshotsScreen(
        uiState = ScreenshotsUiState(
            isLoading = false,
            screenshots = listOf(
                Photo(id = "1", creationDate = 0, sizeInBytes = 0, width = 0, height = 0),
                Photo(id = "2", creationDate = 0, sizeInBytes = 0, width = 0, height = 0),
                Photo(id = "3", creationDate = 0, sizeInBytes = 0, width = 0, height = 0),
            ),
            selectedScreenshots = setOf("2")
        ),
        onAction = {},
        loadBitmap = { null }
    )
}
