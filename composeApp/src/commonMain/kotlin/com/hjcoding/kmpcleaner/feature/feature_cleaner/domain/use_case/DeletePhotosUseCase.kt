package com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.use_case

import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.repository.MediaRespository

class DeletePhotosUseCase(private val mediaRepository: MediaRespository) {

    suspend operator fun invoke(ids: List<String>): Result<Unit> {
        if (ids.isEmpty()) {
            return Result.success(Unit)
        }
        return mediaRepository.deletePhotos(ids)
    }
}
