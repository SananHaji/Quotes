package com.sananhaji.presentation_home

import android.content.Context
import com.sananhaji.domain.usecase.GetQuotesUseCase
import com.sananhaji.presentation_common.state.CommonResultConverter
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class QuoteListConverter @Inject constructor(@ApplicationContext private val context: Context) :
    CommonResultConverter<GetQuotesUseCase.Response, QuoteListModel>() {

    override fun convertSuccess(data: GetQuotesUseCase.Response): QuoteListModel {
        return QuoteListModel(
            quotes = data.quotes.map {
                QuoteModel(it.id, it.quote, it.authorName)
            }
        )
    }
}