package com.sananhaji.data_remote.networking.entity

import com.squareup.moshi.Json

data class QuoteApiModel(
    @Json(name = "id")  val id: String?,
    @Json(name = "quote")  val quote: String?,
    @Json(name = "tags")  val tags: List<String>?,
    @Json(name = "authorName")  val authorName: String?,
    @Json(name = "authorId")  val authorId: String?,
)