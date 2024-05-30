package com.sananhaji.domain.repository

import com.sananhaji.domain.entity.Quote
import kotlinx.coroutines.flow.Flow

interface QuoteRepository {

    fun getQuoteList(): Flow<List<Quote>>

}