package com.sananhaji.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.sananhaji.domain.usecase.GetQuotesUseCase
import com.sananhaji.presentation_common.state.UiState
import com.sananhaji.presentation_home.QuoteListConverter
import com.sananhaji.presentation_home.QuoteModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class QuotePagingSource(
    private val quotesUseCase: GetQuotesUseCase,
    private val quoteListConverter: QuoteListConverter
) : PagingSource<Int, QuoteModel>() {
    override fun getRefreshKey(state: PagingState<Int, QuoteModel>): Int =
        state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        } ?: 1

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, QuoteModel> {
        return try {
            val position = params.key ?: 1
            val response =
                quotesUseCase.execute(GetQuotesUseCase.Request).map { quoteListConverter.convert(it) }.first()

            when (response) {
                is UiState.Success -> {
                    val quotes = response.data.quotes
                    LoadResult.Page(
                        data = quotes,
                        prevKey = if (position == 1) null else position - 1,
                        nextKey = if (quotes.isEmpty()) null else position + 1
                    )
                }

                is UiState.Error -> {
                    LoadResult.Error(Exception(response.errorMessage))
                }

                else -> {
                    val quotes = emptyList<QuoteModel>()
                    LoadResult.Page(
                        data = quotes,
                        prevKey = if (position == 1) null else position - 1,
                        nextKey = if (quotes.isEmpty()) null else position + 1
                    )
                }
            }

        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }
}