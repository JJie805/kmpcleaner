package com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.contacts

import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Contact

data class ContactsUiState(
    val isLoading: Boolean = false,
    val duplicateContactGroups: List<List<Contact>> = emptyList(),
    val invalidContacts: List<Contact> = emptyList(),
    val selectedContacts: Set<String> = emptySet(),
    val error: String? = null
)
