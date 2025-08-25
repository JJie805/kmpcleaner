package com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.use_case

class DeleteCalendarEventsUseCase {
    suspend operator fun invoke(ids: List<String>): Result<Unit> {
        // Placeholder implementation
        println("Deleting calendar events: $ids")
        return Result.success(Unit)
    }
}
