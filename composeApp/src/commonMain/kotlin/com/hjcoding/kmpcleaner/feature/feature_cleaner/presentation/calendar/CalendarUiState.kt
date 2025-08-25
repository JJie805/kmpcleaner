package com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.calendar

import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.CalendarEvent

data class CalendarUiState(
    val isLoading: Boolean = true,
    val events: List<CalendarEvent> = emptyList(),
    val selectedEvents: Set<String> = emptySet(),
    val error: String? = null
)
