package com.sananhaji.data_repository.repository

import com.sananhaji.data_repository.data_source.LocalSettingsSource
import com.sananhaji.data_repository.data_source.RemoteQuoteDataSource
import com.sananhaji.domain.entity.Quote
import com.sananhaji.domain.repository.QuoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class QuoteRepositoryImpl @Inject constructor(
    private val remoteQuoteDataSource: RemoteQuoteDataSource,
    private val localSettingsSource: LocalSettingsSource
) : QuoteRepository {

    override fun getQuoteList(): Flow<List<Quote>> =
        localSettingsSource.getSelectedLanguage().flatMapLatest { lang -> remoteQuoteDataSource.getQuoteList(lang) }

}