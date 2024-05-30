package com.sananhaji.presentation_settings

import com.sananhaji.domain.entity.LanguageOption

data class SettingsUiModel(
    var selectedLanguage: LanguageOption = LanguageOption.AZ,
    var availableLanguages: List<LanguageOption> = listOf(),
)