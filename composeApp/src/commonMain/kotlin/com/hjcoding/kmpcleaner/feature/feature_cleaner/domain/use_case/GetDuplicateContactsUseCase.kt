package com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.use_case

import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Contact
import com.hjcoding.kmpcleaner.platform.ContactsScanner

class GetDuplicateContactsUseCase(private val contactsScanner: ContactsScanner) {

    suspend operator fun invoke(): List<List<Contact>> {
        return emptyList()
    }
}