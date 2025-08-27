package com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.use_case

import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Contact
import com.hjcoding.kmpcleaner.platform.ContactsScanner

class GetDuplicateContactsUseCase(private val contactsScanner: ContactsScanner) {

    suspend operator fun invoke(): List<List<Contact>> {
        val contacts = contactsScanner.getContacts()
        val duplicates = mutableListOf<List<Contact>>()
        val visited = mutableSetOf<String>()

        for (contact in contacts) {
            if (visited.contains(contact.id)) continue

            val currentGroup = mutableListOf(contact)
            for (otherContact in contacts) {
                if (contact.id == otherContact.id || visited.contains(otherContact.id)) continue

                if (contact.name == otherContact.name && contact.phoneNumbers.intersect(otherContact.phoneNumbers).isNotEmpty()) {
                    currentGroup.add(otherContact)
                }
            }

            if (currentGroup.size > 1) {
                duplicates.add(currentGroup)
                visited.addAll(currentGroup.map { it.id })
            }
        }

        return duplicates
    }
}