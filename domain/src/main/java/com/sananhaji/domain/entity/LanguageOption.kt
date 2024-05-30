package com.sananhaji.domain.entity

import androidx.annotation.StringRes
import com.sananhaji.domain.R

enum class LanguageOption(val key: String, @StringRes val lang: Int) {
    AZ("az", R.string.lang_azerbaijan),
    EN("en", R.string.lang_english),
    RU("ru", R.string.lang_russian),
    TR("tr", R.string.lang_turkish),
}