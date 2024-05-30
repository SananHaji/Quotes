package com.sananhaji.domain.usecase

import com.sananhaji.domain.entity.LanguageOption
import com.sananhaji.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetSelectedLanguageUseCase(
    configuration: Configuration,
    private val settingsRepository: SettingsRepository
) : UseCase<GetSelectedLanguageUseCase.Request, GetSelectedLanguageUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> = settingsRepository.getSelectedLanguage()
        .map { selectedLanguage ->
            val languageOptions = settingsRepository.getLanguageOptions()
            Response(LanguageOption.entries.find { it.key == selectedLanguage } ?: LanguageOption.EN, languageOptions)
        }

    object Request : UseCase.Request

    data class Response(
        val selectedLanguage: LanguageOption,
        val languageOption: List<LanguageOption>,
    ) : UseCase.Response

}