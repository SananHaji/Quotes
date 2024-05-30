package com.sananhaji.data_repository.repository

import com.sananhaji.data_repository.data_source.LocalSettingsSource
import com.sananhaji.domain.entity.LanguageOption
import com.sananhaji.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SettingsRepositoryImpl @Inject constructor(
    private val localSettingsSource: LocalSettingsSource
) : SettingsRepository {

    override fun getSelectedLanguage(): Flow<String> {
        return localSettingsSource.getSelectedLanguage()
    }

    override suspend fun setSelectedLanguage(language: String) {
        localSettingsSource.saveSelectedLanguage(language)
    }

    override fun getLanguageOptions(): List<LanguageOption> = LanguageOption.entries.toList()


}