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
object AppModule {

    @Provides
    @Singleton
    fun provideConnectionDetector(@ApplicationContext context: Context): ConnectionDetector =
        ConnectionDetector(context)
}