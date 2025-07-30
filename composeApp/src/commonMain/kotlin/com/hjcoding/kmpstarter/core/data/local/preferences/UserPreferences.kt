package com.hjcoding.kmpstarter.core.data.local.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.hjcoding.kmpstarter.core.data.local.preferences.DataStoreKey.ACCESS_TOKEN
import com.hjcoding.kmpstarter.core.data.local.preferences.DataStoreKey.REFRESH_TOKEN
import com.hjcoding.kmpstarter.core.data.local.preferences.DataStoreKey.AGREED_LICENSE
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

object DataStoreKey{
    val ACCESS_TOKEN = stringPreferencesKey(name = "access_token")
    val REFRESH_TOKEN = stringPreferencesKey(name = "refresh_token")
    val AGREED_LICENSE = booleanPreferencesKey(name = "agreed_license")
}

class UserPreferences(private val dataStore : DataStore<Preferences>) {
    suspend fun saveAccessToken(accessToken:String){
        dataStore.edit { preferences->
            preferences[ACCESS_TOKEN] = accessToken
        }
    }

    val getAccessToken: Flow<String?> = dataStore.data.map { preferences->
        preferences[ACCESS_TOKEN]
    }

    suspend fun saveRefreshToken(accessToken:String){
        dataStore.edit { preferences->
            preferences[REFRESH_TOKEN] = accessToken
        }
    }

    val getRefreshToken: Flow<String?> = dataStore.data.map { preferences->
        preferences[REFRESH_TOKEN]
    }


    suspend fun clearTokens() {
        dataStore.edit {
            it.remove(ACCESS_TOKEN)
            it.remove(REFRESH_TOKEN)
        }
    }

    suspend fun setLicenseAgreement(agreed: Boolean) {
        dataStore.edit { preferences ->
            preferences[AGREED_LICENSE] = agreed
        }
    }

    val licenseAgreementState: Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[AGREED_LICENSE] == true
    }
}
