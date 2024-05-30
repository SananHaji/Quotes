package com.sananhaji.presentation_home

import android.util.Log
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.sananhaji.domain.entity.Quote
import com.sananhaji.domain.repository.QuoteRepository
import com.sananhaji.domain.usecase.GetQuotesUseCase
import com.sananhaji.paging_source.QuotePagingSource
import com.sananhaji.presentation_common.state.MviViewModel
import com.sananhaji.presentation_common.state.UiSingleEvent
import com.sananhaji.presentation_common.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getQuotesUseCase: GetQuotesUseCase,
    private val quoteListConverter: QuoteListConverter
) : MviViewModel<QuotePagingModel, UiState<QuotePagingModel>, HomeUiAction, UiSingleEvent>() {

    val quoteListPager = Pager(
        config = PagingConfig(pageSize = 20),
        pagingSourceFactory = { QuotePagingSource(getQuotesUseCase, quoteListConverter) }
    ).flow.cachedIn(viewModelScope)

    override fun initState(): UiState<QuotePagingModel> = UiState.Loading

    override fun handleAction(action: HomeUiAction) {
        when (action) {
            is HomeUiAction.LoadPaging -> {
                viewModelScope.launch {
                    quoteListPager.collect { pagingData ->
                        submitState(UiState.Success(QuotePagingModel(pagingData)))
                    }
                }
            }

            is HomeUiAction.AddedQuoteToFavorites -> addedQuoteToFavorites(action.quoteId)
        }
    }

    private fun addedQuoteToFavorites(quoteId: String) {
        Log.d("TAGTAGTAG", "addedQuoteToFavorites: $quoteId")
    }

}