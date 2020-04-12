package com.article.task.data.di

import com.article.task.data.core.qualifires.Cache
import com.article.task.data.core.qualifires.Remote
import com.article.task.data.features.articles.datasource.ArticlesDataSource
import com.article.task.data.features.articles.datasource.ArticlesLocalDataSource
import com.article.task.data.features.articles.datasource.ArticlesRemoteDataSource
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface DataSourceModule {

    @Remote
    @Binds
    @Singleton
    fun bindRemoteArticlesDataSource(source: ArticlesRemoteDataSource): ArticlesDataSource

    @Cache
    @Binds
    @Singleton
    fun bindLocalArticlesDataSource(source: ArticlesLocalDataSource): ArticlesDataSource
}