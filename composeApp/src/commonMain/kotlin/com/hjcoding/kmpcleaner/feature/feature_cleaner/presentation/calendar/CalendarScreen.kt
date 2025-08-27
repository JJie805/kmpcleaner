package com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.calendar

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.CalendarEvent
import org.koin.compose.viewmodel.koinViewModel
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.ui.graphics.Color
import kotlinx.datetime.TimeZone
import kotlinx.datetime.number
import kotlinx.datetime.toLocalDateTime
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@Composable
fun CalendarScreenRoot(
    viewModel: CalendarViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    CalendarScreen(
        uiState = uiState,
        onAction = viewModel::onAction
    )
}

@Composable
fun CalendarScreen(
    uiState: CalendarUiState,
    onAction: (CalendarAction) -> Unit
) {
    Scaffold(
        bottomBar = {
            if (uiState.selectedEvents.isNotEmpty()) {
                Button(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    onClick = { onAction(CalendarAction.DeleteSelected) }
                ) {
                    Text("Delete (${uiState.selectedEvents.size})")
                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            if (uiState.isLoading) {
                CircularProgressIndicator()
            } else if (uiState.error != null) {
                Text("Error: ${uiState.error}")
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(vertical = 8.dp)
                ) {
                    items(uiState.events, key = { it.id }) { event ->
                        CalendarEventItem(
                            event = event,
                            isSelected = uiState.selectedEvents.contains(event.id),
                            onToggleSelection = { onAction(CalendarAction.ToggleSelection(event.id)) }
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalTime::class)
@Composable
private fun CalendarEventItem(
    event: CalendarEvent,
    isSelected: Boolean,
    onToggleSelection: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onToggleSelection() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = event.title, style = MaterialTheme.typography.bodyLarge)
            val startTime = Instant.fromEpochMilliseconds(event.startDate)
                .toLocalDateTime(TimeZone.currentSystemDefault())
            val endTime = Instant.fromEpochMilliseconds(event.endDate)
                .toLocalDateTime(TimeZone.currentSystemDefault())
            val formattedStartTime = "${startTime.year}-${startTime.month.number.toString().padStart(2, '0')}-${startTime.day.toString().padStart(2, '0')} ${startTime.hour.toString().padStart(2, '0')}:${startTime.minute.toString().padStart(2, '0')}"
            val formattedEndTime = "${endTime.hour.toString().padStart(2, '0')}:${endTime.minute.toString().padStart(2, '0')}"
            Text(text = "$formattedStartTime - $formattedEndTime", style = MaterialTheme.typography.bodyMedium)
        }
        if (isSelected) {
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = "Selected",
                tint = Color.Green,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}
