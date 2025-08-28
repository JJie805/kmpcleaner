package com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.use_case

import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.CalendarEvent

class GetDuplicatePastEventsUseCase(
    private val getPastCalendarEventsUseCase: GetPastCalendarEventsUseCase
) {

    suspend operator fun invoke(): List<List<CalendarEvent>> {
        val pastEvents = getPastCalendarEventsUseCase()
        
        if (pastEvents.isEmpty()) {
            return emptyList()
        }

        // Group events by title, start, and end time to find duplicates.
        return pastEvents
            .groupBy { "${it.title}-${it.startDate}-${it.endDate}" }
            .filter { it.value.size > 1 }
            .map { it.value }
    }
}