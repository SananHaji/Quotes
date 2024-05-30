package com.sananhaji.presentation_home

import com.sananhaji.presentation_common.state.UiAction

sealed class HomeUiAction : UiAction {

    data object LoadPaging : HomeUiAction()

    data class AddedQuoteToFavorites(val quoteId: String) : HomeUiAction()

}