package com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.home

import GetHomePageDataUseCase
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.material.icons.filled.Screenshot
import androidx.compose.material.icons.filled.VideoLibrary
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.repository.MediaRespository
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.model.StorageInfo
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.theme.Blue500
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.theme.Green500
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.theme.Orange500
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.theme.Purple500
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.theme.Red500
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.theme.Yellow500
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getHomePageDataUseCase: GetHomePageDataUseCase,
    private val mediaRespository: MediaRespository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeState())
    val uiState = _uiState.asStateFlow()

    init {
        load()
    }

    private fun load() {
        viewModelScope.launch {
            val homePageData = getHomePageDataUseCase()

            val cleanupItems = mutableListOf<CleanupItem>()

            homePageData.similarPhotoGroup?.let {
                cleanupItems.add(
                    CleanupItem(
                        type = CleanupType.SIMILAR_PHOTOS,
                        title = "相似照片",
                        describe = "${it.count} 张照片",
                        icon = Icons.Default.PhotoLibrary,
                        iconColor = Blue500,
                        mediaItems = it.photos,
                        itemCount = it.count,
                        sizeInBytes = it.sizeInBytes,
                        displayType = DisplayType.FULL_WIDTH_WITH_THUMBNAILS
                    )
                )
            }

            homePageData.largeVideoGroup?.let {
                cleanupItems.add(
                    CleanupItem(
                        type = CleanupType.LARGE_VIDEOS,
                        title = "大视频",
                        describe = "${it.count} 个视频",
                        icon = Icons.Default.VideoLibrary,
                        iconColor = Red500,
                        mediaItems = it.videos,
                        itemCount = it.count,
                        sizeInBytes = it.sizeInBytes,
                        displayType = DisplayType.FULL_WIDTH_WITH_THUMBNAILS
                    )
                )
            }

            homePageData.similarVideoGroup?.let {
                cleanupItems.add(
                    CleanupItem(
                        type = CleanupType.SIMILAR_VIDEOS,
                        title = "相似视频",
                        describe = "${it.count} 个视频",
                        icon = Icons.Default.VideoLibrary,
                        iconColor = Orange500,
                        mediaItems = it.videos,
                        itemCount = it.count,
                        sizeInBytes = it.sizeInBytes,
                        displayType = DisplayType.FULL_WIDTH_WITH_THUMBNAILS
                    )
                )
            }

            homePageData.screenshotsGroup?.let {
                cleanupItems.add(
                    CleanupItem(
                        type = CleanupType.ALL_SCREENSHOTS,
                        title = "所有截图",
                        describe = "${it.count} 张截图",
                        icon = Icons.Default.Screenshot,
                        iconColor = Green500,
                        mediaItems = it.photos,
                        itemCount = it.count,
                        sizeInBytes = it.sizeInBytes,
                        displayType = DisplayType.GRID
                    )
                )
            }

            cleanupItems.add(
                CleanupItem(
                    type = CleanupType.CONTACTS,
                    title = "联系人清理",
                    describe = "清理重复和无效联系人",
                    icon = Icons.Default.Contacts,
                    iconColor = Purple500,
                    displayType = DisplayType.SIMPLE_ROW
                )
            )

            cleanupItems.add(
                CleanupItem(
                    type = CleanupType.CALENDAR,
                    title = "日历清理",
                    describe = "清理过期日历和提醒",
                    icon = Icons.Default.CalendarMonth,
                    iconColor = Yellow500,
                    displayType = DisplayType.SIMPLE_ROW
                )
            )

            _uiState.update {
                it.copy(
                    isLoading = false,
                    storageInfo = StorageInfo(
                        totalStorage = homePageData.storageInfo.total,
                        usedStorage = homePageData.storageInfo.used,
                        freeStorage = homePageData.storageInfo.free
                    ),
                    cleanupItems = cleanupItems
                )
            }
        }
    }

    fun onAction(action: HomeAction) {
        when (action) {
            is HomeAction.OnCleanupItemClick -> {
                // TODO
            }
        }
    }
}



