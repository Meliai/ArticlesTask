package com.article.task.data.di

import com.article.task.data.features.articles.api.ArticlesApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): ArticlesApi = retrofit.create<ArticlesApi>(ArticlesApi::class.java)

    object ApiConfig {
        const val USE_MOCKED_AUTO_LOGIN_API = false
    }
}