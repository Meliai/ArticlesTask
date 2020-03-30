package com.article.task.data.features.articles.datasource

import com.article.task.data.features.articles.dto.ArticleDto
import io.reactivex.Single

interface ArticlesDataSource {

    fun getArticles(): Single<ArticleDto>
}