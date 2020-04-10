package com.article.task.data.di

import com.article.common.mapper.Mapper
import com.article.task.data.features.articles.dto.ArticleDto
import com.article.task.data.features.articles.mapper.ArticlesToDomainMapper
import com.article.task.domain.features.articles.model.Article
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface MappersModule {

    @Binds
    @Singleton
    fun bindArticlesToDomainMapper(mapper: ArticlesToDomainMapper): Mapper<ArticleDto, Article>
}