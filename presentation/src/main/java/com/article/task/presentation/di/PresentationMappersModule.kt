package com.article.task.presentation.di

import com.article.common.mapper.Mapper
import com.article.task.domain.features.articles.model.Article
import com.article.task.presentation.features.articles.mapper.ArticlesListItemMapper
import com.nullgr.core.adapter.items.ListItem
import dagger.Binds
import dagger.Module

@Module
interface PresentationMappersModule {
    @Binds
    fun bindArticlesListItemMapper(
        mapper: ArticlesListItemMapper
    ): Mapper<Article, ListItem>
}