package com.sananhaji.domain.usecase

import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import com.sananhaji.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class LanguageSelectedUseCase(
    configuration: Configuration,
    private val settingsRepository: SettingsRepository
) : UseCase<LanguageSelectedUseCase.Request, LanguageSelectedUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> = flow {
        settingsRepository.setSelectedLanguage(request.language)
        Response
    }

    data class Request(val language: String) : UseCase.Request

    object Response : UseCase.Response

}