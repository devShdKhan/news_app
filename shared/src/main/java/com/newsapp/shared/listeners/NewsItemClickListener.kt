package com.newsapp.shared.listeners

import com.newsapp.shared.models.NewsModel

interface NewsItemClickListener {

    fun onNewsClick(news:NewsModel)
}