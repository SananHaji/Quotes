package com.sananhaji.data_remote.networking.service

import com.sananhaji.data_remote.networking.response.GetQuotesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface QuoteService {

    @GET("/_functions/quotes")
    suspend fun getQuotes(@Query("lang") lang: String): GetQuotesResponse

    @GET("/_functions/getAuthor")
    suspend fun getAuthor(): GetQuotesResponse

}