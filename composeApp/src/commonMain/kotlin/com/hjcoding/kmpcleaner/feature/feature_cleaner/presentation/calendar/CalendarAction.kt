package com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.calendar

sealed interface CalendarAction {
    data class ToggleSelection(val eventId: String) : CalendarAction
    object DeleteSelected : CalendarAction
}
