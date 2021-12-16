package com.news.topnews.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.newsapp.shared.base.BaseViewModel
import com.newsapp.shared.constant.BaseConstants
import com.newsapp.shared.models.NewsModel
import com.newsapp.shared.models.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TopNewsViewModel @Inject constructor(val repo: TopNewsRepository) : BaseViewModel() {

    val news: LiveData<Response<List<NewsModel>>> get() = repo.news

    val parmas = mapOf(
        BaseConstants.ApiConstant.COUNTRY to "in",
        BaseConstants.ApiConstant.API_KEY to BaseConstants.ApiConstant.API_KEY_VALUE
    )

    init {
        getNews()
    }

    fun getNews() {
        repo.getTopNews(viewModelScope, parmas)
    }

}