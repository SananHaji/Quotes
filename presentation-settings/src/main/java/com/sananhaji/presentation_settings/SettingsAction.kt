package com.sananhaji.presentation_settings

import com.sananhaji.presentation_common.state.UiAction

sealed class SettingsAction : UiAction {

    data object Load : SettingsAction()
    data class LanguageClicked(val language: String) : SettingsAction()

}