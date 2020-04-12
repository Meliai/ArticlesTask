package com.article.task.data.features.articles.repository

import com.article.common.mapper.Mapper
import com.article.task.data.core.qualifires.Cache
import com.article.task.data.core.qualifires.Remote
import com.article.task.data.features.articles.datasource.ArticlesDataSource
import com.article.task.data.features.articles.dto.ArticleDto
import com.article.task.domain.features.articles.model.Article
import com.article.task.domain.features.articles.repository.ArticlesRepository
import io.reactivex.Single
import javax.inject.Inject

class ArticlesDataRepository @Inject constructor(
    @Cache private val localDataSource: ArticlesDataSource,
    @Remote private val remoteDataSource: ArticlesDataSource,
    private val mapper: Mapper<ArticleDto, Article>
) : ArticlesRepository {

    override fun getAllArticles(): Single<List<Article>> =
        remoteDataSource.getArticles()
            .onErrorResumeNext(localDataSource.getArticles())
            .map(mapper::mapFromObjects)
}