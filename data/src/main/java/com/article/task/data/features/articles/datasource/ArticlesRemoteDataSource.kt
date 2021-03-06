package com.article.task.data.features.articles.datasource

import com.article.common.mapper.Mapper
import com.article.task.data.cache.ApplicationDatabase
import com.article.task.data.features.articles.api.ArticlesApi
import com.article.task.data.features.articles.dto.ArticleCacheDto
import com.article.task.data.features.articles.dto.ArticleDto
import io.reactivex.Single
import javax.inject.Inject

class ArticlesRemoteDataSource @Inject constructor(
    private val api: ArticlesApi,
    private val db: ApplicationDatabase,
    private val toCacheMapper: Mapper<ArticleDto, ArticleCacheDto>
) : ArticlesDataSource {

    override fun getArticles(): Single<List<ArticleDto>> =
        api.getArticles().flatMap {
            db.cachedArticlesDao()
                .addAll(toCacheMapper.mapFromObjects(it))
                .andThen(Single.just(it))
        }
}