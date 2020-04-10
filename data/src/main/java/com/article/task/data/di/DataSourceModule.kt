package com.article.task.data.di

import com.article.task.data.features.articles.datasource.ArticlesDataSource
import com.article.task.data.features.articles.datasource.ArticlesRemoteDataSource
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface DataSourceModule {

    @Binds
    @Singleton
    fun bindArticlesDataSource(source: ArticlesRemoteDataSource): ArticlesDataSource
}