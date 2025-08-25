package com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.use_case

import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.CalendarEvent
import kotlin.time.Clock
import kotlin.time.ExperimentalTime


class GetCalendarEventsUseCase {
    @OptIn(ExperimentalTime::class)
    operator fun invoke(): List<CalendarEvent> {
        // Placeholder implementation
        return listOf(
            CalendarEvent("1", "Meeting with John", Clock.System.now().toEpochMilliseconds(), Clock.System.now().toEpochMilliseconds() + 3600000),
            CalendarEvent("2", "Dentist appointment", Clock.System.now().toEpochMilliseconds() + 86400000, Clock.System.now().toEpochMilliseconds() + 86400000 + 1800000)
        )
    }
}
