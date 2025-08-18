package com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.use_case

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.toPixelMap
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Photo
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.SimilarPhotoGroup
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetSimilarPhotoGroupsUseCase {
    suspend operator fun invoke(photos: List<Photo>): List<SimilarPhotoGroup> {
        return withContext(Dispatchers.Default) {
            val groups = mutableListOf<SimilarPhotoGroup>()
            val visited = mutableSetOf<String>()

            // 缓存哈希，避免重复计算
            val photoHashes = photos.associate { it.id to it.hashThumbnail.averageHash() }

            for (photo in photos) {
                if (visited.contains(photo.id)) continue

                val hash1 = photoHashes[photo.id] ?: continue
                val group = mutableListOf(photo)

                for (other in photos) {
                    if (other.id == photo.id || visited.contains(other.id)) continue

                    // 粗筛：创建时间差（秒） & 尺寸差（像素）
                    if (kotlin.math.abs(other.creationDate - photo.creationDate) > 60 * 60) continue
                    if (kotlin.math.abs(other.width - photo.width) > 100 ||
                        kotlin.math.abs(other.height - photo.height) > 100) continue

                    val hash2 = photoHashes[other.id] ?: continue
                    if (hammingDistance(hash1, hash2) <= 5) {
                        group.add(other)
                    }
                }

                if (group.size > 1) {
                    // 用当前时间戳或第一个 Photo ID 来生成分组 ID
                    val groupId = "group_${photo.id}_}"
                    groups.add(SimilarPhotoGroup(groupId, group))
                    visited.addAll(group.map { it.id })
                }
            }

            groups
        }
    }
}

/**
 * 计算 ImageBitmap 的平均哈希（aHash）
 */
fun ImageBitmap.averageHash(): Long {
    val pixelMap = this.toPixelMap()
    val width = pixelMap.width
    val height = pixelMap.height

    println("Image size: ${width}x${height}")

    // 计算平均亮度
    var sum = 0f
    for (y in 0 until height) {
        for (x in 0 until width) {
            val lum = pixelMap[x, y].luminance()
            sum += lum
        }
    }
    val avg = sum / (width * height)
    println("Average luminance: $avg")

    // 生成哈希
    var hash = 0L
    var bitIndex = 0
    for (y in 0 until height) {
        for (x in 0 until width) {
            val lum = pixelMap[x, y].luminance()
            if (lum >= avg) {
                hash = hash or (1L shl bitIndex)
            }
            bitIndex++
        }
    }

    println("Hash: $hash (binary: ${hash.toString(2).padStart(bitIndex, '0')})")
    return hash
}

/**
 * 计算汉明距离（跨平台）
 */
fun hammingDistance(h1: Long, h2: Long): Int {
    return (h1 xor h2).countOneBits()
}