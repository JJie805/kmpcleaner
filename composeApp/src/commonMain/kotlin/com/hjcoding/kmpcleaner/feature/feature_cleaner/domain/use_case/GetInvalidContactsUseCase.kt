package com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.use_case

import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Contact
import com.hjcoding.kmpcleaner.platform.ContactsScanner
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

class GetInvalidContactsUseCase(private val contactsScanner: ContactsScanner) {

    suspend operator fun invoke(): List<Contact> {
        val contacts = suspendCancellableCoroutine<List<Contact>> { continuation ->
            contactsScanner.getContacts { result ->
                continuation.resume(result)
            }
        }

        return contacts.filter { 
            it.name.isBlank() && it.phoneNumbers.isEmpty() && it.emails.isEmpty()
        }
    }
}