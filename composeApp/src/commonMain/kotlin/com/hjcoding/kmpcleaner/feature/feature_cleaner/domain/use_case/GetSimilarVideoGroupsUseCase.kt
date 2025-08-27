package com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.use_case

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.toPixelMap
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Video
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.VideoGroup
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.repository.MediaRespository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetSimilarVideoGroupsUseCase(
    private val mediaRepository: MediaRespository
) {

    suspend operator fun invoke(videos: List<Video>): List<VideoGroup> {
        return withContext(Dispatchers.Default) {
            val groups = mutableListOf<VideoGroup>()
            val visited = mutableSetOf<String>()
            val videoHashes = mutableMapOf<String, List<Long>>()

            for (video in videos) {
                if (visited.contains(video.id)) continue

                val keyFrameHashes = videoHashes.getOrPut(video.id) {
                    val keyframes = mediaRepository.getKeyFrames(video.id)
                    keyframes.mapNotNull { it?.differenceHash() }
                }

                if (keyFrameHashes.isEmpty()) continue

                val currentGroup = mutableListOf(video)
                for (otherVideo in videos) {
                    if (otherVideo.id == video.id || visited.contains(otherVideo.id)) continue

                    val otherKeyFrameHashes = videoHashes.getOrPut(otherVideo.id) {
                        val keyframes = mediaRepository.getKeyFrames(otherVideo.id)
                        keyframes.mapNotNull { it?.differenceHash() }
                    }

                    if (isSimilar(keyFrameHashes, otherKeyFrameHashes)) {
                        currentGroup.add(otherVideo)
                    }
                }

                if (currentGroup.size > 1) {
                    groups.add(VideoGroup(currentGroup))
                    visited.addAll(currentGroup.map { it.id })
                }
            }
            groups
        }
    }

    private fun isSimilar(hashes1: List<Long>, hashes2: List<Long>): Boolean {
        for (h1 in hashes1) {
            for (h2 in hashes2) {
                if (hammingDistance(h1, h2) <= HAMMING_DISTANCE_THRESHOLD) {
                    return true
                }
            }
        }
        return false
    }

    private fun ImageBitmap.differenceHash(): Long {
        val pixelMap = this.toPixelMap()
        val width = 9
        val height = 8
        if (pixelMap.width != width || pixelMap.height != height) {
            // Handle incorrect size if necessary, maybe resize or log a warning
            return 0L
        }

        var hash = 0L
        var bitIndex = 0
        for (y in 0 until height) {
            for (x in 0 until width - 1) {
                val leftPixelLuminance = pixelMap[x, y].luminance()
                val rightPixelLuminance = pixelMap[x + 1, y].luminance()
                if (leftPixelLuminance > rightPixelLuminance) {
                    hash = hash or (1L shl bitIndex)
                }
                bitIndex++
            }
        }
        return hash
    }

    private fun hammingDistance(h1: Long, h2: Long): Int {
        return (h1 xor h2).countOneBits()
    }

    companion object {
        private const val HAMMING_DISTANCE_THRESHOLD = 5
    }
}