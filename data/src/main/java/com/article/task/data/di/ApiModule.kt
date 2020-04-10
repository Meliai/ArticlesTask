package com.article.task.data.di

import com.article.task.data.features.articles.api.ArticlesApi
import com.article.task.data.features.articles.api.MockedApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): ArticlesApi =
        when (ApiConfig.USE_MOCKED_API) {
            true -> MockedApi()
            else -> retrofit.create<ArticlesApi>(ArticlesApi::class.java)
        }

    object ApiConfig {
        const val USE_MOCKED_API = false
    }
}