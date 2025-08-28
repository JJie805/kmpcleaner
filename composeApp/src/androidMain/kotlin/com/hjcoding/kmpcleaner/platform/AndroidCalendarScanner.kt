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

        // First, get a list of writable calendar IDs
        val writableCalendars = mutableListOf<String>()
        val calendarProjection = arrayOf(CalendarContract.Calendars._ID)
        val calendarSelection = "${CalendarContract.Calendars.CALENDAR_ACCESS_LEVEL} >= ${CalendarContract.Calendars.CAL_ACCESS_CONTRIBUTOR}"
        val calendarCursor = contentResolver.query(
            CalendarContract.Calendars.CONTENT_URI,
            calendarProjection,
            calendarSelection,
            null,
            null
        )

        calendarCursor?.use {
            while (it.moveToNext()) {
                writableCalendars.add(it.getString(it.getColumnIndex(CalendarContract.Calendars._ID)))
            }
        }

        if (writableCalendars.isEmpty()) {
            completion(emptyList())
            return
        }

        // Now, query for events only in those writable calendars
        val eventProjection = arrayOf(
            CalendarContract.Events._ID,
            CalendarContract.Events.TITLE,
            CalendarContract.Events.DTSTART,
            CalendarContract.Events.DTEND
        )

        val eventSelection = "${CalendarContract.Events.DTEND} < ? AND ${CalendarContract.Events.CALENDAR_ID} IN (${writableCalendars.joinToString(",")})
        val eventSelectionArgs = arrayOf(System.currentTimeMillis().toString())

        val eventCursor = contentResolver.query(
            CalendarContract.Events.CONTENT_URI,
            eventProjection,
            eventSelection,
            eventSelectionArgs,
            null
        )

        eventCursor?.use {
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