import androidx.compose.ui.graphics.Color
import com.hjcoding.kmpcleaner.core.designsystem.icons.Icons
import com.hjcoding.kmpcleaner.core.designsystem.icons.SimilarImage
import com.hjcoding.kmpcleaner.core.designsystem.icons.SimilarScreenshot
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.StorageUsage
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.repository.MediaRespository
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.use_case.GetSimilarPhotoGroupsUseCase
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.home.CleanupItem // 复用你的数据类
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.home.CleanupType
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.mappers.toPhotoUi
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

data class HomePageData(
    val storageUsage: StorageUsage,
    val cleanupItems: List<CleanupItem>
)

class GetHomePageDataUseCase(
    private val mediaRepository: MediaRespository,
    private val getSimilarPhotoGroupsUseCase: GetSimilarPhotoGroupsUseCase
) {

    suspend operator fun invoke(): Result<HomePageData> {
        return try {
            coroutineScope {
                // --- SIMILAR PHOTOS LOGIC ---
                val similarPhotosJob = async {
                    // 1. 获取所有原始图片
                    val allPhotos = mediaRepository.getNonScreenshotPhotos()

                    // 2. 【核心】调用 worker UseCase 来查找相似分组
                    val similarGroups = getSimilarPhotoGroupsUseCase(allPhotos)

                    // 3. 从相似分组中提取真实数据来构建 CleanupItem
                    val firstGroupPhotos = similarGroups.firstOrNull()?.photos ?: emptyList()

                    CleanupItem(
                        type = CleanupType.SIMILAR_PHOTOS,
                        title = "相似图片",
                        describe = "建议清理相似的照片",
                        icon = Icons.SimilarImage,
                        iconColor = Color.White,
                        // 4. 【已修复】从第一个相似组中获取前两张作为缩略图
                        thumbnails = firstGroupPhotos.take(2).map { it.toPhotoUi() },
                        // 5. 【已修复】计算所有相似图片的总数
                        itemCount = similarGroups.sumOf { it.photos.size },
                        // 6. 【已修复】计算所有相似图片的总大小
                        sizeInBytes = similarGroups.sumOf { group -> group.photos.sumOf { it.sizeInBytes } }
                    )
                }

                // --- SIMILAR SCREENSHOTS LOGIC (REUSE THE USECASE!) ---
                val screenshotsJob = async {
                    // 1. 获取所有截图
                    val allScreenshots = mediaRepository.getScreenshotPhotos()

                    // 2. 【核心】复用同一个 worker UseCase 来查找相似截图
                    val similarScreenshotGroups = getSimilarPhotoGroupsUseCase(allScreenshots)

                    // 3. 从分组中提取数据
                    val firstScreenshotGroup = similarScreenshotGroups.firstOrNull()?.photos ?: emptyList()

                    CleanupItem(
                        type = CleanupType.SIMILAR_SCREENSHOTS,
                        title = "相似截图",
                        describe = "查找并清理相似的屏幕截图",
                        icon = Icons.SimilarScreenshot,
                        iconColor = Color.White,
                        // 4. 【已修复】获取真实的相似截图缩略图
                        thumbnails = firstScreenshotGroup.take(2).map { it.toPhotoUi() },
                        // 5. 【已修复】计算相似截图总数
                        itemCount = similarScreenshotGroups.sumOf { it.photos.size },
                        // 6. 【已修复】计算相似截图总大小
                        sizeInBytes = similarScreenshotGroups.sumOf { group -> group.photos.sumOf { it.sizeInBytes } }
                    )
                }

                val storageJob = async { mediaRepository.getStorageUsage() }

                val storageUsage = storageJob.await()
                val cleanupItems = listOf(similarPhotosJob.await(), screenshotsJob.await())

                Result.success(HomePageData(storageUsage, cleanupItems))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}