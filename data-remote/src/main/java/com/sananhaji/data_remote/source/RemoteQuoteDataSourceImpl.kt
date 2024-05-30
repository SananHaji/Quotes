package com.sananhaji.data_remote.source

import com.sananhaji.data_remote.networking.entity.QuoteApiModel
import com.sananhaji.data_remote.networking.service.QuoteService
import com.sananhaji.data_repository.data_source.RemoteQuoteDataSource
import com.sananhaji.domain.entity.Quote
import com.sananhaji.domain.entity.UseCaseException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemoteQuoteDataSourceImpl @Inject constructor(
    private val quoteService: QuoteService
) : RemoteQuoteDataSource {

    override fun getQuoteList(lang: String): Flow<List<Quote>> = flow {
        emit(quoteService.getQuotes(lang))
    }.map { response ->
        response.quoteList.map { quoteApiModel ->
            convert(quoteApiModel = quoteApiModel)
        }
    }.catch { throw UseCaseException.QuoteException(it) }

    private fun convert(quoteApiModel: QuoteApiModel): Quote =
        Quote(
            quoteApiModel.id.orEmpty(),
            quoteApiModel.quote.orEmpty(),
            quoteApiModel.tags.orEmpty(),
            quoteApiModel.authorName.orEmpty(),
            quoteApiModel.authorId.orEmpty()
        )

}