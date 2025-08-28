package com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.calendar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.use_case.DeleteCalendarEventsUseCase
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.use_case.GetDuplicatePastEventsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CalendarViewModel(
    private val getDuplicatePastEventsUseCase: GetDuplicatePastEventsUseCase,
    private val deleteCalendarEventsUseCase: DeleteCalendarEventsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(CalendarUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadDuplicateEvents()
    }

    fun onAction(action: CalendarAction) {
        when (action) {
            is CalendarAction.ToggleSelection -> {
                _uiState.update {
                    val newSelection = if (it.selectedEvents.contains(action.eventId)) {
                        it.selectedEvents - action.eventId
                    } else {
                        it.selectedEvents + action.eventId
                    }
                    it.copy(selectedEvents = newSelection)
                }
            }
            CalendarAction.DeleteSelected -> {
                viewModelScope.launch {
                    val idsToDelete = _uiState.value.selectedEvents.toList()
                    deleteCalendarEventsUseCase(idsToDelete)
                        .onSuccess {
                            loadDuplicateEvents()
                        }
                        .onFailure { error ->
                            _uiState.update {
                                it.copy(error = error.message)
                            }
                        }
                }
            }
        }
    }

    private fun loadDuplicateEvents() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, selectedEvents = emptySet()) }
            try {
                val duplicateGroups = getDuplicatePastEventsUseCase()
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        duplicateEventGroups = duplicateGroups
                    )
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = e.message
                    )
                }
            }
        }
    }
}
