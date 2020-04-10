package com.article.task.data.features.articles.repository

import com.article.common.mapper.Mapper
import com.article.task.data.features.articles.datasource.ArticlesDataSource
import com.article.task.data.features.articles.dto.ArticleDto
import com.article.task.domain.features.articles.model.Article
import com.article.task.domain.features.articles.repository.ArticlesRepository
import io.reactivex.Single
import javax.inject.Inject

class ArticlesDataRepository @Inject constructor(
    private val source: ArticlesDataSource,
    private val mapper: Mapper<ArticleDto, Article>
) : ArticlesRepository {

    override fun getAllArticles(): Single<List<Article>> =
        source.getArticles().map(mapper::mapFromObjects)
}