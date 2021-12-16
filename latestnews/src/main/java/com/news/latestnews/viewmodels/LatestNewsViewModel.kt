package com.news.latestnews.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.newsapp.shared.base.BaseViewModel
import com.newsapp.shared.constant.BaseConstants
import com.newsapp.shared.models.NewsModel
import com.newsapp.shared.models.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LatestNewsViewModel @Inject constructor(private val repo: LatestNewsRepository) :
    BaseViewModel() {

    val news: LiveData<Response<List<NewsModel>>> get() = repo.news
    val parmas = mapOf(
        BaseConstants.ApiConstant.QUERY to "india",
        BaseConstants.ApiConstant.API_KEY to BaseConstants.ApiConstant.API_KEY_VALUE
    )

    init {
        getNews()
    }

    private fun getNews() {
        repo.getLatestNews(viewModelScope, parmas)
    }

}