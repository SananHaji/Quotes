package com.sananhaji.data_local.utils

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStoreUtils(
    val context: Context
) {

    private companion object {
        val SELECTED_LANGUAGE_KEY = stringPreferencesKey("SELECTED_LANGUAGE_KEY")
    }

    suspend fun saveSelectedLanguage(lang: String) {
        context.dataStore.edit { preferences ->
            preferences[SELECTED_LANGUAGE_KEY] = lang
        }
    }

    fun getSelectedLanguage(): Flow<String> {
        return context.dataStore.data.map { preferences ->
            preferences[SELECTED_LANGUAGE_KEY] ?: "en"
        }
    }

}