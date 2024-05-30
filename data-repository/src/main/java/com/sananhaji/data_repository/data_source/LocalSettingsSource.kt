package com.sananhaji.data_repository.data_source

import kotlinx.coroutines.flow.Flow


interface LocalSettingsSource {

    fun getSelectedLanguage(): Flow<String>

    suspend fun saveSelectedLanguage(lang: String)

}