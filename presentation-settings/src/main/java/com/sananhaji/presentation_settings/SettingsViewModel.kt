package com.sananhaji.presentation_settings

import androidx.lifecycle.viewModelScope
import com.sananhaji.domain.usecase.GetSelectedLanguageUseCase
import com.sananhaji.domain.usecase.LanguageSelectedUseCase
import com.sananhaji.presentation_common.state.MviViewModel
import com.sananhaji.presentation_common.state.UiSingleEvent
import com.sananhaji.presentation_common.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val languageSelectedUseCase: LanguageSelectedUseCase,
    private val getSelectedLanguageUseCase: GetSelectedLanguageUseCase,
    private val settingsConverter: SettingsConverter
) : MviViewModel<SettingsUiModel, UiState<SettingsUiModel>, SettingsAction, UiSingleEvent>() {

    override fun initState(): UiState<SettingsUiModel> = UiState.Loading

    override fun handleAction(action: SettingsAction) {
        when (action) {
            is SettingsAction.Load -> handleLoadAction()
            is SettingsAction.LanguageClicked -> handleLanguageClickedAction(action)
        }
    }

    private fun handleLoadAction() {
        viewModelScope.launch {
            getSelectedLanguageUseCase.execute(GetSelectedLanguageUseCase.Request)
                .map {
                    settingsConverter.convert(it)
                }
                .collect {
                    submitState(it)
                }
        }
    }

    private fun handleLanguageClickedAction(action: SettingsAction.LanguageClicked) = viewModelScope.launch {
        languageSelectedUseCase.execute(LanguageSelectedUseCase.Request(action.language)).collect {
            submitAction(SettingsAction.Load)
        }
    }

}