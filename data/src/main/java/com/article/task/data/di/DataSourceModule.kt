package com.article.task.data.di

import com.article.task.data.features.articles.datasource.ArticlesDataSource
import com.article.task.data.features.articles.datasource.ArticlesRemoteDataSource
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Suppress("TooManyFunctions")
@Module
interface DataSourceModule {

    @Binds
    @Singleton
    fun bindTestDataSource(source: ArticlesRemoteDataSource): ArticlesDataSource
}