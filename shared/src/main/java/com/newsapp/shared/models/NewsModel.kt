package com.newsapp.shared.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "news")
data class NewsModel(
    @PrimaryKey(autoGenerate = true)
    val newsId: Int,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?,
    var isTopNews: Boolean?
) : Serializable

