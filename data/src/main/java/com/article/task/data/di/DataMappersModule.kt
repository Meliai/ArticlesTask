package com.article.task.data.di

import com.article.common.mapper.Mapper
import com.article.task.data.features.articles.dto.ArticleCacheDto
import com.article.task.data.features.articles.dto.ArticleDto
import com.article.task.data.features.articles.mapper.ArticlesFromCacheMapper
import com.article.task.data.features.articles.mapper.ArticlesToCacheMapper
import com.article.task.data.features.articles.mapper.ArticlesToDomainMapper
import com.article.task.domain.features.articles.model.Article
import dagger.Binds
import dagger.Module

@Module
interface DataMappersModule {

    @Binds
    fun bindArticlesToDomainMapper(
        mapper: ArticlesToDomainMapper
    ): Mapper<ArticleDto, Article>

    @Binds
    fun bindArticlesToCacheMapper(
        mapper: ArticlesToCacheMapper
    ): Mapper<ArticleDto, ArticleCacheDto>

    @Binds
    fun bindArticlesFromCacheMapper(
        mapper: ArticlesFromCacheMapper
    ): Mapper<ArticleCacheDto, ArticleDto>
}