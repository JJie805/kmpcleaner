package com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model

/**
 * Represents a calendar event.
 * @param id The unique identifier of the event.
 * @param title The title of the event.
 * @param startDate The start date of the event in milliseconds since epoch.
 * @param endDate The end date of the event in milliseconds since epoch.
 */
data class CalendarEvent(
    val id: String,
    val title: String,
    val startDate: Long,
    val endDate: Long
)