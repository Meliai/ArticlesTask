package com.article.task.data.features.articles.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.article.task.data.features.articles.cache.ArticlesDao

@Entity(tableName = ArticlesDao.TYPE_TABLE_NAME)
data class ArticleCacheDto(
    @PrimaryKey
    val id: Int,
    val title: String?,
    val description: String?,
    val author: String?,
    val date: String?,
    val url: String?
)