package com.newsapp.shared.network

import com.newsapp.shared.models.BaseResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface RetrofitApiClient {


    @JvmSuppressWildcards
    @GET("v2/top-headlines")
    fun getTopNews(@QueryMap map: Map<String, String>): Deferred<BaseResponse>


    @JvmSuppressWildcards
    @GET("v2/everything")
    fun getLatestNews(@QueryMap map: Map<String, String>): Deferred<BaseResponse>

}