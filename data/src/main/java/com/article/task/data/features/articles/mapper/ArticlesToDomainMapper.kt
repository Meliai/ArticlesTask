package com.article.task.data.features.articles.mapper

import com.article.common.mapper.Mapper
import com.article.task.data.features.articles.dto.ArticleDto
import com.article.task.domain.features.articles.model.Article
import org.threeten.bp.ZonedDateTime
import org.threeten.bp.format.DateTimeFormatter
import javax.inject.Inject

class ArticlesToDomainMapper @Inject constructor() : Mapper<ArticleDto, Article> {
    override fun mapFromObject(source: ArticleDto): Article =
        with(source) {
            Article(
                id,
                title,
                description,
                author,
                ZonedDateTime.parse(date, DateTimeFormatter.ofPattern("M/DD/YYYY")),
                url
            )
        }
}