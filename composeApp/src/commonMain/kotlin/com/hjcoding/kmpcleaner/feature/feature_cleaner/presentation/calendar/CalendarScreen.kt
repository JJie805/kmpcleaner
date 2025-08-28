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
import androidx.compose.ui.text.font.FontWeight
import com.hjcoding.kmpcleaner.ui.EmptyState
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

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
                    Text("Delete Selected (${uiState.selectedEvents.size})")
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
            } else if (uiState.duplicateEventGroups.isEmpty()) {
                EmptyState(message = "非常干净，没有发现可清理的过期重复事件。")
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(uiState.duplicateEventGroups) { group ->
                        DuplicateEventGroupItem(group)
                    }
                }
            }
        }
    }
}

@Composable
private fun DuplicateEventGroupItem(group: List<CalendarEvent>) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            val firstEvent = group.first()
            Text(firstEvent.title, fontWeight = FontWeight.Bold)
            val startTime = Instant.fromEpochMilliseconds(firstEvent.startDate).toLocalDateTime(TimeZone.currentSystemDefault())
            val endTime = Instant.fromEpochMilliseconds(firstEvent.endDate).toLocalDateTime(TimeZone.currentSystemDefault())
            val formattedStartTime = "${startTime.year}-${startTime.monthNumber.toString().padStart(2, '0')}-${startTime.dayOfMonth.toString().padStart(2, '0')} ${startTime.hour.toString().padStart(2, '0')}:${startTime.minute.toString().padStart(2, '0')}"
            val formattedEndTime = "${endTime.hour.toString().padStart(2, '0')}:${endTime.minute.toString().padStart(2, '0')}"
            Text(text = "时间: $formattedStartTime - $formattedEndTime", style = MaterialTheme.typography.bodyMedium)
            Text("发现 ${group.size} 个重复项", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
            Spacer(Modifier.height(8.dp))
            Button(onClick = { /* TODO: Merge/Delete action */ }, modifier = Modifier.align(Alignment.End)) {
                Text("清理")
            }
        }
    }
}
