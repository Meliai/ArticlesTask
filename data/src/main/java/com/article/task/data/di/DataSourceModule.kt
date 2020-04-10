package com.article.task.data.di

import com.article.task.data.features.feature1.datasource.TestDataSource
import com.article.task.data.features.feature1.datasource.TestRemoteDataSource
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Suppress("TooManyFunctions")
@Module
interface DataSourceModule {

    @Binds
    @Singleton
    fun bindTestDataSource(source: TestRemoteDataSource): TestDataSource
}