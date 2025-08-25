package com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.use_case

import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.CalendarEvent

class GetCalendarEventsUseCase {
    operator fun invoke(): List<CalendarEvent> {
        // Placeholder implementation
        return listOf(
            CalendarEvent("1", "Meeting with John", System.currentTimeMillis(), System.currentTimeMillis() + 3600000),
            CalendarEvent("2", "Dentist appointment", System.currentTimeMillis() + 86400000, System.currentTimeMillis() + 86400000 + 1800000)
        )
    }
}
