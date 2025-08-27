package com.hjcoding.kmpcleaner.platform

import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.CalendarEvent

interface CalendarScanner {
    fun getPastEvents(completion: (List<CalendarEvent>) -> Unit)
}