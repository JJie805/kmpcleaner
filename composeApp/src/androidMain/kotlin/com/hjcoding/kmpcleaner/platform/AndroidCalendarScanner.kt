package com.hjcoding.kmpcleaner.platform

import android.annotation.SuppressLint
import android.content.Context
import android.provider.CalendarContract
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.CalendarEvent

class AndroidCalendarScanner(private val context: Context) : CalendarScanner {

    @SuppressLint("Range")
    override fun getPastEvents(completion: (List<CalendarEvent>) -> Unit) {
        val events = mutableListOf<CalendarEvent>()
        val contentResolver = context.contentResolver

        val projection = arrayOf(
            CalendarContract.Events._ID,
            CalendarContract.Events.TITLE,
            CalendarContract.Events.DTSTART,
            CalendarContract.Events.DTEND
        )

        // Query for events that have already ended.
        val selection = "${CalendarContract.Events.DTEND} < ?"
        val selectionArgs = arrayOf(System.currentTimeMillis().toString())

        val cursor = contentResolver.query(
            CalendarContract.Events.CONTENT_URI,
            projection,
            selection,
            selectionArgs,
            null
        )

        cursor?.use {
            while (it.moveToNext()) {
                val id = it.getString(it.getColumnIndex(CalendarContract.Events._ID))
                val title = it.getString(it.getColumnIndex(CalendarContract.Events.TITLE))
                val startDate = it.getLong(it.getColumnIndex(CalendarContract.Events.DTSTART))
                val endDate = it.getLong(it.getColumnIndex(CalendarContract.Events.DTEND))
                events.add(CalendarEvent(id, title ?: "", startDate, endDate))
            }
        }
        completion(events)
    }
}