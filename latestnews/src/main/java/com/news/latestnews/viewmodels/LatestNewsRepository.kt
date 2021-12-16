package com.news.latestnews.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.newsapp.shared.constant.BaseConstants
import com.newsapp.shared.database.NewsDataBaseRepository
import com.newsapp.shared.models.NewsModel
import com.newsapp.shared.models.Response
import com.newsapp.shared.network.RetrofitApiClient
import com.newsapp.shared.utils.ConnectionDetector
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class LatestNewsRepository @Inject constructor(
    private val mApiClient: RetrofitApiClient,
    private val newsDataBaseRepository: NewsDataBaseRepository,
    private val connectionDetector: ConnectionDetector
) {

    private val newsLiveData = MutableLiveData<Response<List<NewsModel>>>()
    val news: LiveData<Response<List<NewsModel>>> get() = newsLiveData


    /**
     *   Api Call for Latest News List
     *   viewModelScoped is for calling this coroutine in the viewmodel scope
     *   params: is the query parameter which api required
     */
    fun getLatestNews(viewModelScoped: CoroutineScope, params: Map<String, String>) {
        viewModelScoped.launch(Dispatchers.IO) {

            val newsList = newsDataBaseRepository.getData(isTopNews = false)
            newsLiveData.postValue(Response.Success(newsList))


            if (!connectionDetector.isOnline()) {
                return@launch
            }

            if (newsList.isEmpty())
                newsLiveData.postValue(Response.Loading())

            kotlin.runCatching {
                val response = mApiClient.getLatestNews(params)
                response.await().let {
                    if (it.status == BaseConstants.ApiConstant.API_SUCCESS) {
                        newsDataBaseRepository.inserData(it.articles)
                        newsLiveData.postValue(Response.Success(it.articles ?: listOf()))
                    } else newsLiveData.postValue(Response.Error(it.message))
                }
            }.onFailure {
                newsLiveData.postValue(Response.Error(it.message))
            }
        }
    }
}
