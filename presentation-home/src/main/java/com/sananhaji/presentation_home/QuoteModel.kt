package com.sananhaji.presentation_home

import androidx.paging.PagingData
import com.sananhaji.domain.entity.Quote

data class QuoteListModel(
    val quotes: List<QuoteModel> = listOf(),
)

data class QuotePagingModel(
    val quotes: PagingData<QuoteModel> = PagingData.empty(),
)

data class QuoteModel(
    val id: String,
    val quote: String,
    val authorName: String,
)

