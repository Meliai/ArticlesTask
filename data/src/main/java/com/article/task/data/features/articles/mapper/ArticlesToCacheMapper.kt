package com.article.task.data.features.articles.mapper

import com.article.common.mapper.Mapper
import com.article.task.data.features.articles.dto.ArticleCacheDto
import com.article.task.data.features.articles.dto.ArticleDto
import com.article.task.domain.features.articles.model.Article
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter
import javax.inject.Inject

class ArticlesToCacheMapper @Inject constructor() : Mapper<ArticleDto, ArticleCacheDto> {
    override fun mapFromObject(source: ArticleDto): ArticleCacheDto =
        with(source) {
            ArticleCacheDto(
                id,
                title,
                description,
                author,
                date,
                url
            )
        }
}