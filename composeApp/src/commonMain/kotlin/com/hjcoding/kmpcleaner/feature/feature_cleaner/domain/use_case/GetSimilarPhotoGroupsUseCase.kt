package com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.use_case

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.toPixelMap
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Photo
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.SimilarPhotoGroup
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.repository.MediaRespository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * 一个高性能的 UseCase，用于从一个只包含元数据的照片列表中找出相似的照片分组。
 *
 * 工作流程:
 * 1. 在后台计算线程池 (Dispatchers.Default) 中执行所有密集计算。
 * 2. 遍历元数据列表，而不是预加载的位图列表。
 * 3. 在需要时，通过 MediaRepository 按需、逐一地加载每张照片的 8x8 哈希位图。
 * 4. 计算哈希值并进行比较，找出相似的组。
 * 5. 使用内部缓存来避免重复加载和计算同一张照片的哈希值。
 * 6. 最终返回一个只包含元数据的相似照片分组列表。
 */
class GetSimilarPhotoGroupsUseCase(
    private val mediaRepository: MediaRespository // 通过构造函数注入 Repository
) {
    /**
     * @param photos 一个只包含元数据（ID, 日期, 尺寸等）的轻量级照片列表。
     * @return 一个由相似照片组成的组的列表，列表中的 Photo 对象同样只包含元数据。
     */
    suspend operator fun invoke(photos: List<Photo>): List<SimilarPhotoGroup> {
        // 关键步骤1：将所有 CPU 密集型工作切换到专用的计算线程池。
        return withContext(Dispatchers.Default) {
            val groups = mutableListOf<SimilarPhotoGroup>()
            val visited = mutableSetOf<String>()

            // 关键步骤2：创建一个哈希缓存。在循环中按需填充，避免重复工作。
            val photoHashes = mutableMapOf<String, Long>()

            for (photo in photos) {
                // 如果照片已分组，则跳过
                if (visited.contains(photo.id)) continue

                // 关键步骤3：按需获取当前照片的哈希值。
                // getOrPut: 如果缓存中已有，则直接返回；否则，执行 lambda 来计算并存入缓存。
                // 尝试从缓存获取或计算 hash1
                val hash1 = photoHashes[photo.id] ?: run {
                    val hashBitmap = mediaRepository.getDhashBitmap(photo.id)
                    val computedHash = hashBitmap?.differenceHash()
                    // 如果计算成功，就存入缓存
                    if (computedHash != null) {
                        photoHashes[photo.id] = computedHash
                    }
                    computedHash
                }
                println("photo.id ${photo.id } hash1 $hash1")
                // 如果 hash1 最终为 null (计算失败且缓存中没有)，则跳过
                if (hash1 == null) continue

                val currentGroup = mutableListOf(photo)

                for (otherPhoto in photos) {
                    // 跳过自身和已分组的照片
                    if (otherPhoto.id == photo.id || visited.contains(otherPhoto.id)) continue

                    // 优化：在进行昂贵的哈希比较前，先进行廉价的元数据粗筛
                    if (isUnlikelyToBeSimilar(photo, otherPhoto)) continue

                    // 关键步骤4：为待比较的照片按需获取哈希值
                    val hash2 = photoHashes[otherPhoto.id] ?: run {
                        val hashBitmap = mediaRepository.getDhashBitmap(otherPhoto.id)
                        val computedHash = hashBitmap?.differenceHash()
                        // 如果计算成功，就存入缓存
                        if (computedHash != null) {
                            photoHashes[otherPhoto.id] = computedHash
                        }
                        computedHash
                    }
                    if (hash2 == null) continue
                    println("otherPhoto.id ${otherPhoto.id } hash2 $hash2")
                    // 关键步骤5：进行汉明距离比较
                    if (hammingDistance(hash1, hash2) <= HAMMING_DISTANCE_THRESHOLD) {
                        currentGroup.add(otherPhoto)
                    }
                }

                // 如果找到了一个包含多张照片的组
                if (currentGroup.size > 1) {
                    val groupId = "group_${photo.id}"
                    groups.add(SimilarPhotoGroup(groupId, currentGroup))
                    // 将组内所有照片标记为已访问，避免重复计算
                    visited.addAll(currentGroup.map { it.id })
                }
            }
            groups
        }
    }

    /**
     * 一个廉价的预检查，用于快速排除掉明显不相似的照片。
     * @return true 如果两张照片明显不相似，可以跳过后续的哈希比较。
     */
    private fun isUnlikelyToBeSimilar(photo1: Photo, photo2: Photo): Boolean {
        // 规则1：如果创建时间相差超过1天，则不像
        if (kotlin.math.abs(photo1.creationDate - photo2.creationDate) > SECONDS_IN_A_DAY) {
            return true
        }
        // 规则2：如果尺寸（宽度或高度）相差超过200像素，则不像
        if (kotlin.math.abs(photo1.width - photo2.width) > 200 ||
            kotlin.math.abs(photo1.height - photo2.height) > 200) {
            return true
        }
        return false
    }

    companion object {
        // 将魔法数字定义为常量，便于理解和调整
        private const val HAMMING_DISTANCE_THRESHOLD = 5
        private const val SECONDS_IN_A_DAY = 24 * 60 * 60
    }
}

/**
 * 计算 ImageBitmap 的平均哈希（aHash）。
 * 这是一个扩展函数，可以直接在 ImageBitmap? 对象上调用。
 */
private fun ImageBitmap.averageHash(): Long {
    val pixelMap = this.toPixelMap()
    val width = pixelMap.width
    val height = pixelMap.height

    if (width == 0 || height == 0) return 0L

    var sum = 0f
    for (y in 0 until height) {
        for (x in 0 until width) {
            sum += pixelMap[x, y].luminance()
        }
    }
    val avg = sum / (width * height)

    var hash = 0L
    var bitIndex = 0
    for (y in 0 until height) {
        for (x in 0 until width) {
            if (pixelMap[x, y].luminance() >= avg) {
                hash = hash or (1L shl bitIndex)
            }
            bitIndex++
        }
    }
    return hash
}

/**
 * 计算 ImageBitmap 的差异哈希（dHash）。
 * 它通过比较水平相邻像素的亮度来工作，比 aHash更能抵抗整体亮度和对比度的变化。
 *
 * 重要：要生成一个完整的 64 位哈希，输入的 ImageBitmap 尺寸应为 9x8。
 */
private fun ImageBitmap.differenceHash(): Long {
    // 1. 将图片缩放到 9x8 尺寸。这一步应该在调用此函数之前，
    //    由 MediaRepository 在请求平台层提供缩略图时完成。
    //    我们在这里假设输入的 'this' 已经是 9x8 的 ImageBitmap。
    val pixelMap = this.toPixelMap()

    // 明确我们期望的尺寸，便于理解代码
    val width = 9
    val height = 8

    // 健壮性检查：如果传入的图片尺寸不对，返回一个错误值或抛出异常
    if (pixelMap.width != width || pixelMap.height != height) {
        // 在实际项目中，您可以在这里打日志或返回一个固定的错误哈希
        println("Warning: Input bitmap for dHash is not 9x8, results may be inaccurate. width ${pixelMap.width} height ${pixelMap.height}")
        return 0L // 或者其他您定义的错误码
    }

    var hash = 0L
    var bitIndex = 0
    for (y in 0 until height) { // 遍历 8 行
        // 关键点：宽度只遍历到倒数第二个像素 (0 到 7)，因为我们要比较 x 和 x+1
        for (x in 0 until width - 1) { // 遍历 8 次比较 (需要 9 个像素)

            // 2. 获取左右相邻两个像素的亮度
            val leftPixelLuminance = pixelMap[x, y].luminance()
            val rightPixelLuminance = pixelMap[x + 1, y].luminance()

            // 3. 进行比较：如果左边比右边亮，则该 bit 位为 1，否则为 0
            if (leftPixelLuminance > rightPixelLuminance) {
                // 使用位运算，将 hash 的第 bitIndex 位置为 1
                hash = hash or (1L shl bitIndex)
            }

            // 移动到下一个 bit 位
            bitIndex++
        }
    }
    return hash
}

/**
 * 计算两个哈希值之间的汉明距离（既有多少个 bit 位不同）。
 */
private fun hammingDistance(h1: Long, h2: Long): Int {
    // a xor b 会得到一个二进制数，其中为1的位就代表原始两个数在该位上不同
    // .countOneBits() 是一个高效的内置函数，用于计算二进制表示中1的数量
    return (h1 xor h2).countOneBits()
}