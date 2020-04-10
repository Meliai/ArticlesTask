package com.article.task.domain.features.articles.repository

import com.article.task.domain.features.articles.model.Article
import io.reactivex.Single

interface ArticlesRepository {

    fun getAllArticles(): Single<List<Article>>
}