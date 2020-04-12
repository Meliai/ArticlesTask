package com.article.task.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.article.task.data.features.articles.cache.ArticlesDao
import com.article.task.data.features.articles.dto.ArticleCacheDto

@Database(
    entities = [
        ArticleCacheDto::class
    ],
    version = 1,
    exportSchema = false
)

abstract class ApplicationDatabase : RoomDatabase() {

    abstract fun cachedArticlesDao(): ArticlesDao
}
