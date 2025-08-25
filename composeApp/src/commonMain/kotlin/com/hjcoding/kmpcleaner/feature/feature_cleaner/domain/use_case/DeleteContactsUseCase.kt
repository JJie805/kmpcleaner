package com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.use_case

class DeleteContactsUseCase {
    suspend operator fun invoke(ids: List<String>): Result<Unit> {
        // Placeholder implementation
        println("Deleting contacts: $ids")
        return Result.success(Unit)
    }
}
