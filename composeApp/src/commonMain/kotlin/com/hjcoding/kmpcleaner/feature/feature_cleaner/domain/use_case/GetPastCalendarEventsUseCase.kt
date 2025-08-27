package com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.use_case

import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.CalendarEvent
import com.hjcoding.kmpcleaner.platform.CalendarScanner
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

class GetPastCalendarEventsUseCase(private val calendarScanner: CalendarScanner) {

    suspend operator fun invoke(): List<CalendarEvent> {
        return suspendCancellableCoroutine { continuation ->
            calendarScanner.getPastEvents { events ->
                continuation.resume(events)
            }
        }
    }
}