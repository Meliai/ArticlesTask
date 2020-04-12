package com.article.task.data.features.articles.datasource

import com.article.common.mapper.Mapper
import com.article.task.data.cache.ApplicationDatabase
import com.article.task.data.features.articles.dto.ArticleCacheDto
import com.article.task.data.features.articles.dto.ArticleDto
import io.reactivex.Single
import javax.inject.Inject

class ArticlesLocalDataSource @Inject constructor(
    private val db: ApplicationDatabase,
    private val fromCacheMapper: Mapper<ArticleCacheDto, ArticleDto>
) : ArticlesDataSource {

    override fun getArticles(): Single<List<ArticleDto>> =
        db.cachedArticlesDao().getAll()
            .map(fromCacheMapper::mapFromObjects)
}