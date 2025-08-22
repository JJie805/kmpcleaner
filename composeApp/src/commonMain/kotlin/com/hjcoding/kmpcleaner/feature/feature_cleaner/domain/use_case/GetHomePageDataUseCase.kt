import androidx.compose.ui.graphics.Color
import com.hjcoding.kmpcleaner.core.designsystem.icons.Icons
import com.hjcoding.kmpcleaner.core.designsystem.icons.SimilarImage
import com.hjcoding.kmpcleaner.core.designsystem.icons.SimilarScreenshot
import com.hjcoding.kmpcleaner.core.designsystem.icons.Video
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.StorageUsage
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.repository.MediaRespository
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.use_case.GetLargeVideosUseCase
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.use_case.GetSimilarPhotoGroupsUseCase
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.home.CleanupItem
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.home.CleanupType
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

data class HomePageData(
    val storageUsage: StorageUsage,
    val cleanupItems: List<CleanupItem>
)

class GetHomePageDataUseCase(
    private val mediaRepository: MediaRespository,
    private val getSimilarPhotoGroupsUseCase: GetSimilarPhotoGroupsUseCase,
    private val getLargeVideosUseCase: GetLargeVideosUseCase
) {

    suspend operator fun invoke(): Result<HomePageData> {
        return try {
            coroutineScope {
                // --- SIMILAR PHOTOS LOGIC ---
                val similarPhotosJob = async {
                    val allPhotos = mediaRepository.getNonScreenshotPhotos()
                    val similarGroups = getSimilarPhotoGroupsUseCase(allPhotos)
                    val firstGroupPhotos = similarGroups.firstOrNull()?.photos ?: emptyList()
                    val thumbnails = firstGroupPhotos.take(2).map { photo ->
                        async { mediaRepository.getThumbnailBitmap(photo.id, isVideo = false) }
                    }.mapNotNull { it.await() }

                    CleanupItem(
                        type = CleanupType.SIMILAR_PHOTOS,
                        title = "相似图片",
                        describe = "建议清理相似的照片",
                        icon = Icons.SimilarImage,
                        iconColor = Color.White,
                        thumbnails = thumbnails,
                        itemCount = similarGroups.sumOf { it.photos.size },
                        sizeInBytes = similarGroups.sumOf { group -> group.photos.sumOf { it.sizeInBytes } }
                    )
                }

                // --- SIMILAR SCREENSHOTS LOGIC ---
                val screenshotsJob = async {
                    val allScreenshots = mediaRepository.getScreenshotPhotos()
                    val similarScreenshotGroups = getSimilarPhotoGroupsUseCase(allScreenshots)
                    val firstScreenshotGroup = similarScreenshotGroups.firstOrNull()?.photos ?: emptyList()
                    val thumbnails = firstScreenshotGroup.take(2).map { photo ->
                        async { mediaRepository.getThumbnailBitmap(photo.id, isVideo = false) }
                    }.mapNotNull { it.await() }

                    CleanupItem(
                        type = CleanupType.SIMILAR_SCREENSHOTS,
                        title = "相似截图",
                        describe = "查找并清理相似的屏幕截图",
                        icon = Icons.SimilarScreenshot,
                        iconColor = Color.White,
                        thumbnails = thumbnails,
                        itemCount = similarScreenshotGroups.sumOf { it.photos.size },
                        sizeInBytes = similarScreenshotGroups.sumOf { group -> group.photos.sumOf { it.sizeInBytes } }
                    )
                }

                // --- LARGE VIDEOS LOGIC ---
                val largeVideosJob = async {
                    val largeVideos = getLargeVideosUseCase()
                    val thumbnails = largeVideos.take(2).map { video ->
                        async { mediaRepository.getThumbnailBitmap(video.id, isVideo = true) }
                    }.mapNotNull { it.await() }

                    CleanupItem(
                        type = CleanupType.LARGE_VIDEOS,
                        title = "大视频",
                        describe = "建议清理占用空间大的视频",
                        icon = Icons.Video,
                        iconColor = Color.White,
                        thumbnails = thumbnails,
                        itemCount = largeVideos.size,
                        sizeInBytes = largeVideos.sumOf { it.sizeInBytes }
                    )
                }

                val storageJob = async { mediaRepository.getStorageUsage() }

                val storageUsage = storageJob.await()
                val cleanupItems = listOf(
                    similarPhotosJob.await(),
                    screenshotsJob.await(),
                    largeVideosJob.await()
                )

                Result.success(HomePageData(storageUsage, cleanupItems))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
