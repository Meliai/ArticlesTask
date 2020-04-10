package com.article.task.data.features.articles.api

import com.article.task.data.features.articles.dto.ArticleDto
import io.reactivex.Single

class MockedApi : ArticlesApi {
    override fun getArticles(): Single<List<ArticleDto>> =
        Single.just(listOf(
            ArticleDto(
                1,
                "title",
                "description",
                "author",
                "6/25/2018",
                null
            )
        ))
}