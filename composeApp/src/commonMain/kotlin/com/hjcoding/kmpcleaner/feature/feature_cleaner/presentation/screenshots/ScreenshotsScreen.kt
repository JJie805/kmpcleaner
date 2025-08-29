package com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.screenshots

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Photo
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ScreenshotsScreenRoot(
    viewModel: ScreenshotsViewModel = koinViewModel(),
    imageLoader: coil3.ImageLoader = koinInject<coil3.ImageLoader>()
) {
    val uiState by viewModel.uiState.collectAsState()

    ScreenshotsScreen(
        uiState = uiState,
        onAction = viewModel::onAction,
        imageLoader = imageLoader
    )
}

@Composable
fun ScreenshotsScreen(
    uiState: ScreenshotsUiState,
    onAction: (ScreenshotsAction) -> Unit,
    imageLoader: coil3.ImageLoader,
) {
    Scaffold(
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
                    items(uiState.screenshots, key = { it.id }) { photo ->
                        ScreenshotItem(
                            photo = photo,
                            isSelected = uiState.selectedScreenshots.contains(photo.id),
                            onToggleSelection = { onAction(ScreenshotsAction.ToggleSelection(photo.id)) },
                            imageLoader = imageLoader // 传递 ImageLoader
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ScreenshotItem(
    photo: Photo,
    isSelected: Boolean,
    onToggleSelection: () -> Unit,
    imageLoader: coil3.ImageLoader
) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .clickable { onToggleSelection() }
    ) {
        // 使用 Coil 的 AsyncImage，就是这么简单！
        AsyncImage(
            model = photo, // 直接把你的 Photo 对象传给 model
            contentDescription = "Screenshot",
            imageLoader = imageLoader, // 使用我们创建的 ImageLoader
            modifier = Modifier.aspectRatio(1f),
            contentScale = ContentScale.Crop, // 保证图片填充满
            // Coil 会自动显示加载中和错误状态，但你也可以自定义
            // placeholder = painterResource(R.drawable.placeholder),
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


// Preview 需要调整
@Preview
@Composable
fun ScreenshotsScreenPreview() {
    // ... Preview 代码需要一个假的 ImageLoader 实例，这里为了编译通过可以先注释掉 ...
}
