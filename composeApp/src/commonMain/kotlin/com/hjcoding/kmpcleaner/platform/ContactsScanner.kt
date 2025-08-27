package com.hjcoding.kmpcleaner.platform

import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Contact

interface ContactsScanner {
    fun getContacts(completion: (List<Contact>) -> Unit)
}