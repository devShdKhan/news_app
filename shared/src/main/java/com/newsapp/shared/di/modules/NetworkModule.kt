package com.newsapp.shared.di.modules

import android.content.Context
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.newsapp.shared.constant.BaseConstants
import com.newsapp.shared.network.HttpRequestInterceptor
import com.newsapp.shared.network.RetrofitApiClient
import com.newsapp.shared.utils.ConnectionDetector
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    const val BASE_URL = "https://newsapi.org/"

    @Provides
    @Singleton
    fun provideRequestInterceptor(): HttpRequestInterceptor = HttpRequestInterceptor()

    @Provides
    @Singleton
    fun provideOkHttpClient(requestInterceptor: HttpRequestInterceptor) =
        OkHttpClient.Builder().apply {
            addInterceptor(requestInterceptor)
            connectTimeout(BaseConstants.API_CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(BaseConstants.API_READ_WRITE_TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(BaseConstants.API_READ_WRITE_TIMEOUT, TimeUnit.SECONDS)
        }.build()


    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().client(okHttpClient)
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun getRetrofitApiInterface(retrofit: Retrofit) = retrofit.create(RetrofitApiClient::class.java)

}