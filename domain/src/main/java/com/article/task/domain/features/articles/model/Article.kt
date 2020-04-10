package com.article.task.domain.features.articles.model

import org.threeten.bp.ZonedDateTime

data class Article(
    val id: Int,
    val title: String?,
    val description: String?,
    val author: String?,
    val date: ZonedDateTime?,
    val url: String?
)