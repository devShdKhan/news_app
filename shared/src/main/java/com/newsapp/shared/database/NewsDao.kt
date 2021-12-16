package com.newsapp.shared.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.newsapp.shared.models.NewsModel

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNews(news: List<NewsModel>)

    @Query("DELETE FROM news")
    suspend fun deleteAll()

    @Query("SELECT * FROM news WHERE isTopNews=:isTopNews")
    fun getNews(isTopNews: Boolean = false): List<NewsModel>

}