package com.sananhaji.data_remote.networking.response

import com.sananhaji.data_remote.networking.entity.QuoteApiModel
import com.squareup.moshi.Json

data class GetQuotesResponse(
    @Json(name = "quotes") val quoteList: List<QuoteApiModel>
)
