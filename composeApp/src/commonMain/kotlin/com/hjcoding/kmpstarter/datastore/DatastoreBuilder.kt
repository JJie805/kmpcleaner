package com.hjcoding.kmpstarter.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import okio.Path.Companion.toPath

// shared/src/androidMain/kotlin/createDataStore.kt
/**
 * Gets the singleton DataStore instance, creating it if necessary.
 */
internal const val dataStoreFileName = "dice.preferences_pb"
fun createDataStore(producePath: () -> String): DataStore<Preferences> =
    PreferenceDataStoreFactory.createWithPath(
        produceFile = {producePath().toPath()}
    )