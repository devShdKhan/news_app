package com.newsapp.shared.database

import com.newsapp.shared.models.NewsModel
import javax.inject.Inject

class NewsDataBaseRepository @Inject constructor(private val newsDao: NewsDao) {

    /**
     *   Fet Data from RoomDatabse
     */
    suspend fun getData(isTopNews: Boolean) = newsDao.getNews(isTopNews)


    /**
     *   Insert Data in RoomDatabse
     */
    suspend fun inserData(news: List<NewsModel>?, isTopNews: Boolean = false) {
        news?.forEach { it.isTopNews = isTopNews }
        newsDao.insertNews(news ?: listOf())
    }
}