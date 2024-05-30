package com.sananhaji.domain.usecase

import com.sananhaji.domain.entity.Quote
import com.sananhaji.domain.repository.QuoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetQuotesUseCase(
    configuration: Configuration,
    private val quoteRepository: QuoteRepository
) : UseCase<GetQuotesUseCase.Request, GetQuotesUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> = quoteRepository.getQuoteList().map { Response(it) }

    object Request : UseCase.Request

    data class Response(
        val quotes: List<Quote>
    ) : UseCase.Response

}