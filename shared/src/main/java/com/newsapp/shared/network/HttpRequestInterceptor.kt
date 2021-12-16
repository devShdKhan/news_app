package com.newsapp.shared.network

import okhttp3.Interceptor
import okhttp3.Response

class HttpRequestInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val httpUrl = request.url()
        val url = httpUrl.newBuilder().build()
        val requestBuilder = request.newBuilder().url(url).build()
        return chain.proceed(requestBuilder)
    }

}