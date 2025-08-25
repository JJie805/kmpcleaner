package com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.similarphotos

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Photo
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.SimilarPhotoGroup
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.screenshots.AsyncPhotoView
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SimilarPhotosScreenRoot(
    viewModel: SimilarPhotosViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    SimilarPhotosScreen(
        uiState = uiState,
        onAction = viewModel::onAction,
        loadBitmap = { photo -> viewModel.loadBitmap(photo) }
    )
}

@Composable
fun SimilarPhotosScreen(
    uiState: SimilarPhotosUiState,
    onAction: (SimilarPhotosAction) -> Unit,
    loadBitmap: suspend (Photo) -> androidx.compose.ui.graphics.ImageBitmap?
) {
    Scaffold(
        bottomBar = {
            if (uiState.selectedPhotos.isNotEmpty()) {
                Button(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    onClick = { onAction(SimilarPhotosAction.DeleteSelected) }
                ) {
                    Text("Delete (${uiState.selectedPhotos.size})")
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
                    items(uiState.photoGroups) { group ->
                        PhotoGroupItem(
                            group = group,
                            selectedPhotos = uiState.selectedPhotos,
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
private fun PhotoGroupItem(
    group: SimilarPhotoGroup,
    selectedPhotos: Set<String>,
    onAction: (SimilarPhotosAction) -> Unit,
    loadBitmap: suspend (Photo) -> androidx.compose.ui.graphics.ImageBitmap?
) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(
            text = "Group (${group.photos.size})",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        LazyRow(
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp)
        ) {
            items(group.photos) { photo ->
                PhotoItem(
                    photo = photo,
                    isSelected = selectedPhotos.contains(photo.id),
                    onToggleSelection = { onAction(SimilarPhotosAction.ToggleSelection(photo.id)) },
                    loadBitmap = loadBitmap
                )
            }
        }
    }
}

@Composable
private fun PhotoItem(
    photo: Photo,
    isSelected: Boolean,
    onToggleSelection: () -> Unit,
    loadBitmap: suspend (Photo) -> androidx.compose.ui.graphics.ImageBitmap?
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
