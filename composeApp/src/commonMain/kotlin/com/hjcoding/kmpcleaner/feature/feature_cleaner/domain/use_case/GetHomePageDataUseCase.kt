import androidx.compose.ui.graphics.Color
import com.hjcoding.kmpcleaner.core.designsystem.icons.Icons
import com.hjcoding.kmpcleaner.core.designsystem.icons.SimilarImage
import com.hjcoding.kmpcleaner.core.designsystem.icons.SimilarScreenshot
import com.hjcoding.kmpcleaner.core.designsystem.icons.Video
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.StorageUsage
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.repository.MediaRespository
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.use_case.GetDuplicateContactsUseCase
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.use_case.GetInvalidContactsUseCase
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.use_case.GetLargeVideosUseCase
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.use_case.GetPastCalendarEventsUseCase
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.use_case.GetScreenshotsUseCase
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.use_case.GetSimilarPhotoGroupsUseCase
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.use_case.GetSimilarVideoGroupsUseCase
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.home.CleanupItem
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.home.CleanupType
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.home.DisplayType
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

data class HomePageData(
    val storageUsage: StorageUsage,
    val cleanupItems: List<CleanupItem>
)

class GetHomePageDataUseCase(
    private val mediaRepository: MediaRespository,
    private val getSimilarPhotoGroupsUseCase: GetSimilarPhotoGroupsUseCase,
    private val getLargeVideosUseCase: GetLargeVideosUseCase,
    private val getScreenshotsUseCase: GetScreenshotsUseCase,
    private val getSimilarVideoGroupsUseCase: GetSimilarVideoGroupsUseCase,
    private val getDuplicateContactsUseCase: GetDuplicateContactsUseCase,
    private val getInvalidContactsUseCase: GetInvalidContactsUseCase,
    private val getPastCalendarEventsUseCase: GetPastCalendarEventsUseCase
) {

    suspend operator fun invoke(): Result<HomePageData> {
        return try {
            coroutineScope {
                // --- SIMILAR PHOTOS LOGIC ---
                val similarPhotosJob = async {
                    val allPhotos = mediaRepository.getNonScreenshotPhotos()
                    val similarGroups = getSimilarPhotoGroupsUseCase(allPhotos)
                    val itemCount = similarGroups.sumOf { it.photos.size }
                    val mediaItems = similarGroups.firstOrNull()?.photos?.take(2) ?: emptyList()

                    CleanupItem(
                        type = CleanupType.SIMILAR_PHOTOS,
                        title = "相似图片",
                        describe = "建议清理相似的照片",
                        icon = Icons.SimilarImage,
                        iconColor = Color.White,
                        mediaItems = mediaItems,
                        itemCount = itemCount,
                        sizeInBytes = similarGroups.sumOf { group -> group.photos.sumOf { it.sizeInBytes } },
                        displayType = if (itemCount > 0) DisplayType.FULL_WIDTH_WITH_THUMBNAILS else DisplayType.SIMPLE_ROW
                    )
                }

                // --- SIMILAR SCREENSHOTS LOGIC ---
                val screenshotsJob = async {
                    val allScreenshots = mediaRepository.getScreenshotPhotos()
                    val similarScreenshotGroups = getSimilarPhotoGroupsUseCase(allScreenshots)
                    val itemCount = similarScreenshotGroups.sumOf { it.photos.size }
                    val mediaItems = similarScreenshotGroups.firstOrNull()?.photos?.take(2) ?: emptyList()

                    CleanupItem(
                        type = CleanupType.SIMILAR_SCREENSHOTS,
                        title = "相似截图",
                        describe = "查找并清理相似的屏幕截图",
                        icon = Icons.SimilarScreenshot,
                        iconColor = Color.White,
                        mediaItems = mediaItems,
                        itemCount = itemCount,
                        sizeInBytes = similarScreenshotGroups.sumOf { group -> group.photos.sumOf { it.sizeInBytes } },
                        displayType = if (itemCount > 0) DisplayType.FULL_WIDTH_WITH_THUMBNAILS else DisplayType.SIMPLE_ROW
                    )
                }

                // --- LARGE VIDEOS LOGIC ---
                val largeVideosJob = async {
                    val largeVideos = getLargeVideosUseCase()
                    val itemCount = largeVideos.size
                    val mediaItems = largeVideos.take(2)

                    CleanupItem(
                        type = CleanupType.LARGE_VIDEOS,
                        title = "大视频",
                        describe = "建议清理占用空间大的视频",
                        icon = Icons.Video,
                        iconColor = Color.White,
                        mediaItems = mediaItems,
                        itemCount = itemCount,
                        sizeInBytes = largeVideos.sumOf { it.sizeInBytes },
                        displayType = if (itemCount > 0) DisplayType.FULL_WIDTH_WITH_THUMBNAILS else DisplayType.SIMPLE_ROW
                    )
                }

                // --- SIMILAR VIDEOS LOGIC ---
                val similarVideosJob = async {
                    val allVideos = mediaRepository.getAllVideos()
                    val similarVideoGroups = getSimilarVideoGroupsUseCase(allVideos)
                    val itemCount = similarVideoGroups.sumOf { it.videos.size }
                    val mediaItems = similarVideoGroups.firstOrNull()?.videos?.take(2) ?: emptyList()
                    
                    CleanupItem(
                        type = CleanupType.SIMILAR_VIDEOS,
                        title = "相似视频",
                        describe = "查找并清理相似的视频",
                        icon = Icons.Video,
                        iconColor = Color.White,
                        mediaItems = mediaItems,
                        itemCount = itemCount,
                        sizeInBytes = similarVideoGroups.sumOf { group -> group.videos.sumOf { it.sizeInBytes } },
                        displayType = if (itemCount > 0) DisplayType.FULL_WIDTH_WITH_THUMBNAILS else DisplayType.SIMPLE_ROW
                    )
                }

                // --- GRID ITEMS ---
                val allScreenshotsJob = async {
                    val allScreenshots = getScreenshotsUseCase()
                    CleanupItem(
                        type = CleanupType.ALL_SCREENSHOTS,
                        title = "所有截图",
                        describe = "清理所有屏幕截图",
                        icon = Icons.SimilarScreenshot,
                        iconColor = Color.White,
                        mediaItems = emptyList(),
                        itemCount = allScreenshots.size,
                        sizeInBytes = allScreenshots.sumOf { it.sizeInBytes },
                        displayType = DisplayType.GRID
                    )
                }

                val contactsJob = async {
                    val duplicateContacts = getDuplicateContactsUseCase()
                    val invalidContacts = getInvalidContactsUseCase()
                    val totalCount = duplicateContacts.sumOf { it.size } + invalidContacts.size
                    CleanupItem(
                        type = CleanupType.CONTACTS,
                        title = "通讯录清理",
                        describe = "合并重复联系人、清理无效联系人",
                        icon = Icons.SimilarImage,
                        iconColor = Color.White,
                        mediaItems = emptyList(),
                        itemCount = totalCount,
                        sizeInBytes = 0,
                        displayType = DisplayType.GRID
                    )
                }

                val calendarJob = async {
                    val pastEvents = getPastCalendarEventsUseCase()
                    CleanupItem(
                        type = CleanupType.CALENDAR,
                        title = "日历清理",
                        describe = "清理已过期的日历和提醒事项",
                        icon = Icons.SimilarImage,
                        iconColor = Color.White,
                        mediaItems = emptyList(),
                        itemCount = pastEvents.size,
                        sizeInBytes = 0,
                        displayType = DisplayType.GRID
                    )
                }


                val storageJob = async { mediaRepository.getStorageUsage() }

                val storageUsage = storageJob.await()
                val cleanupItems = listOf(
                    similarPhotosJob.await(),
                    screenshotsJob.await(),
                    largeVideosJob.await(),
                    allScreenshotsJob.await(),
                    similarVideosJob.await(),
                    contactsJob.await(),
                    calendarJob.await()
                )

                Result.success(HomePageData(storageUsage, cleanupItems))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}