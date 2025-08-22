package com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.use_case

import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Photo
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.repository.MediaRespository

class GetScreenshotsUseCase(private val mediaRepository: MediaRespository) {

    suspend operator fun invoke(): List<Photo> {
        return mediaRepository.getScreenshotPhotos()
            .sortedByDescending { it.creationDate }
    }
}
