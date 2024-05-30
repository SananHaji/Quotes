package com.sananhaji.presentation_settings

import android.content.Context
import com.sananhaji.domain.usecase.GetSelectedLanguageUseCase
import com.sananhaji.presentation_common.state.CommonResultConverter
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SettingsConverter @Inject constructor(@ApplicationContext private val context: Context) :
    CommonResultConverter<GetSelectedLanguageUseCase.Response, SettingsUiModel>() {

    override fun convertSuccess(data: GetSelectedLanguageUseCase.Response): SettingsUiModel {
        return SettingsUiModel(data.selectedLanguage, data.languageOption)
    }

}