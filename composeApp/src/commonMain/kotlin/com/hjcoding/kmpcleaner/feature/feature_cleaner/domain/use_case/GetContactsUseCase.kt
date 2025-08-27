package com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.use_case

import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Contact

class GetContactsUseCase {
    operator fun invoke(): List<Contact> {
        // Placeholder implementation
        return listOf(
            Contact("1", "John Doe",  emptyList(), emptyList()),
            Contact("2", "Jane Doe", emptyList(), emptyList())
        )
    }
}
