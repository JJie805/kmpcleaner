package com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.use_case

import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Video
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.repository.MediaRespository

/**
 * Use case to get a list of large videos.
 */
class GetLargeVideosUseCase(private val mediaRepository: MediaRespository) {

    /**
     * @param sizeThresholdInBytes The minimum size in bytes for a video to be considered "large".
     * @return A list of large videos, sorted by size in descending order.
     */
    suspend operator fun invoke(sizeThresholdInBytes: Long = DEFAULT_THRESHOLD_BYTES): List<Video> {
        return mediaRepository.getAllVideos()
            .filter { it.sizeInBytes >= sizeThresholdInBytes }
            .sortedByDescending { it.sizeInBytes }
    }

    companion object {
        // Default threshold: 100 MB
        private const val DEFAULT_THRESHOLD_BYTES = 1 * 1024 * 1024L
    }
}
