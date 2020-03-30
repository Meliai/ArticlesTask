package com.article.task.data.features.articles.api

import com.article.task.data.features.articles.dto.ArticleDto
import io.reactivex.Single
import retrofit2.http.GET

interface ArticlesApi {

    @GET("articles")
    fun getArticles(): Single<List<ArticleDto>>
}
