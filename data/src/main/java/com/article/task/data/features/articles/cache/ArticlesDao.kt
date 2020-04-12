package com.article.task.data.features.articles.cache

import androidx.room.Dao
import androidx.room.Query
import com.article.task.data.cache.BaseDao
import com.article.task.data.features.articles.dto.ArticleCacheDto
import io.reactivex.Single

@Dao
interface ArticlesDao : BaseDao<ArticleCacheDto> {

    @Query("SELECT * from $TYPE_TABLE_NAME WHERE id=:id")
    fun getById(id: Int): Single<ArticleCacheDto>

    @Query("SELECT * from $TYPE_TABLE_NAME")
    fun getAll(): Single<List<ArticleCacheDto>>

    companion object {
        const val TYPE_TABLE_NAME = "articles"
    }
}