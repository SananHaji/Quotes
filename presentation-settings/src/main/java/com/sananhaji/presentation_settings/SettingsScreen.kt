package com.sananhaji.presentation_settings

import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.os.LocaleListCompat
import androidx.navigation.NavController
import com.sananhaji.presentation_common.state.CommonScreen
import com.sananhaji.domain.R
import com.sananhaji.core_utils.findActivity

@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel,
    navController: NavController
) {
    var expanded by remember { mutableStateOf(false) }

    val context = LocalContext.current //context

    val onClickRefreshActivity = { lang:String->
        //context.findActivity() is kotlin extension function
        context.findActivity()?.runOnUiThread {
            val appLocale = LocaleListCompat.forLanguageTags(lang) //here ta is hardcoded for testing purpose,you can add users selected language code.
            AppCompatDelegate.setApplicationLocales(appLocale)
        }
    }

    LaunchedEffect(Unit) {
        viewModel.submitAction(SettingsAction.Load)
    }

    viewModel.uiStateFlow.collectAsState().value.let { state ->
        CommonScreen(state = state) {
            Column {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Column {
                        Text(text = stringResource(it.selectedLanguage.lang), modifier = Modifier.padding(bottom = 16.dp))
                        Button(onClick = { expanded = true }) {
                            Text(text = stringResource(id = R.string.change_language))
                        }
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            it.availableLanguages.forEach { option ->
                                DropdownMenuItem(onClick = {
                                    onClickRefreshActivity(option.key)
                                    viewModel.submitAction(SettingsAction.LanguageClicked(option.key))
                                    expanded = false
                                }, text = { Text(text = stringResource(id = option.lang)) })
                            }
                        }
                    }
                }

            }
        }
    }

}