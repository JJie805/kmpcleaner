package com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.contacts

import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Contact

data class ContactsUiState(
    val isLoading: Boolean = true,
    val contacts: List<Contact> = emptyList(),
    val selectedContacts: Set<String> = emptySet(),
    val error: String? = null
)
