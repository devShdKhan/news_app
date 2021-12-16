package com.newsapp.shared.models


data class BaseResponse(
    val status: String? = null,
    val message: String? = null,
    val totalResults: Int? = null,
    val articles: ArrayList<NewsModel>? = null
)