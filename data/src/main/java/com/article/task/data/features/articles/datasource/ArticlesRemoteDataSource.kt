package com.article.task.data.features.articles.datasource

import com.article.task.data.features.articles.api.ArticlesApi
import com.article.task.data.features.articles.dto.ArticleDto
import io.reactivex.Single
import javax.inject.Inject

class ArticlesRemoteDataSource @Inject constructor(
    private val api: ArticlesApi
) : ArticlesDataSource {

    override fun getArticles(): Single<List<ArticleDto>> =
        api.getArticles()
}