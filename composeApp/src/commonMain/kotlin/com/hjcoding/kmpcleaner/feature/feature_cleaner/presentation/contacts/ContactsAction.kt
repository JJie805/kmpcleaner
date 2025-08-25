package com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.contacts

sealed interface ContactsAction {
    data class ToggleSelection(val contactId: String) : ContactsAction
    object DeleteSelected : ContactsAction
}
