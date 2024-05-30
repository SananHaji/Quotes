package com.sananhaji.data_local.source

import com.sananhaji.data_local.utils.DataStoreUtils
import com.sananhaji.data_repository.data_source.LocalSettingsSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalSettingsSourceImpl @Inject constructor(
    val dataStoreUtils: DataStoreUtils
) : LocalSettingsSource {

    override fun getSelectedLanguage(): Flow<String> {
        return dataStoreUtils.getSelectedLanguage()
    }

    override suspend fun saveSelectedLanguage(lang: String) {
        dataStoreUtils.saveSelectedLanguage(lang)
    }

}