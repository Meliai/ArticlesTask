package com.article.task.data.features.articles.mapper

import com.article.common.mapper.Mapper
import com.article.task.data.features.articles.dto.ArticleCacheDto
import com.article.task.data.features.articles.dto.ArticleDto
import javax.inject.Inject

class ArticlesFromCacheMapper @Inject constructor() : Mapper<ArticleCacheDto, ArticleDto> {
    override fun mapFromObject(source: ArticleCacheDto): ArticleDto =
        with(source) {
            ArticleDto(
                id,
                title,
                description,
                author,
                date,
                url
            )
        }
}