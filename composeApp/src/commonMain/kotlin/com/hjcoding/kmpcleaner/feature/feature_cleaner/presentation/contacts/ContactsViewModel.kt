package com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.contacts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.use_case.DeleteContactsUseCase
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.use_case.GetContactsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ContactsViewModel(
    private val getContactsUseCase: GetContactsUseCase,
    private val deleteContactsUseCase: DeleteContactsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(ContactsUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadContacts()
    }

    fun onAction(action: ContactsAction) {
        when (action) {
            is ContactsAction.ToggleSelection -> {
                _uiState.update {
                    val newSelection = if (it.selectedContacts.contains(action.contactId)) {
                        it.selectedContacts - action.contactId
                    } else {
                        it.selectedContacts + action.contactId
                    }
                    it.copy(selectedContacts = newSelection)
                }
            }
            ContactsAction.DeleteSelected -> {
                viewModelScope.launch {
                    val idsToDelete = _uiState.value.selectedContacts.toList()
                    deleteContactsUseCase(idsToDelete)
                        .onSuccess {
                            loadContacts()
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

    private fun loadContacts() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, selectedContacts = emptySet()) }
            try {
                val contacts = getContactsUseCase()
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        contacts = contacts
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
