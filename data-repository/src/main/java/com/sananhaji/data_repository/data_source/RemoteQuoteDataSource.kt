package com.sananhaji.data_repository.data_source

import com.sananhaji.domain.entity.Quote
import kotlinx.coroutines.flow.Flow

interface RemoteQuoteDataSource {

    fun getQuoteList(lang: String): Flow<List<Quote>>

}