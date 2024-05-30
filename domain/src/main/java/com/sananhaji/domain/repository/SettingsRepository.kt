package com.sananhaji.domain.repository

import com.sananhaji.domain.entity.LanguageOption
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {

    fun getSelectedLanguage(): Flow<String>

    suspend fun setSelectedLanguage(language: String)

    fun getLanguageOptions(): List<LanguageOption>

}