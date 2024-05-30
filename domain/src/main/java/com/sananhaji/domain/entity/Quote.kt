package com.sananhaji.domain.entity

data class Quote(
    val id: String,
    val quote: String,
    val tags: List<String>,
    val authorName: String,
    val authorId: String,
)
