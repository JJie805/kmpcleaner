package com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model

data class CalendarEvent(
    val id: String,
    val title: String,
    val startTime: Long,
    val endTime: Long
)
