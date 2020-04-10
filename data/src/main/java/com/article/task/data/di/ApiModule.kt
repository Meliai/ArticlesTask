package com.article.task.data.di

import com.article.task.data.features.feature1.api.TestApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): TestApi = retrofit.create<TestApi>(TestApi::class.java)

    object ApiConfig {
        const val USE_MOCKED_AUTO_LOGIN_API = false
    }
}