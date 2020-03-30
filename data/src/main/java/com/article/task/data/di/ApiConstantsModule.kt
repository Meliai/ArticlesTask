package com.article.task.data.di

import com.article.task.data.core.qualifires.ServerUrl
import dagger.Module
import dagger.Provides

@Module
@Suppress("FunctionOnlyReturningConstant")
class ApiConstantsModule(private val isDebugMode: Boolean) {

    @Provides
    @ServerUrl
    fun provideServerUrl() = when (isDebugMode) {
        true -> SERVER_URL_TEST
        else -> SERVER_URL_PROD
    }

    private companion object {
        const val SERVER_URL_PROD = "http://viesure.free.beeceptor.com/"
        const val SERVER_URL_TEST = "http://viesure.free.beeceptor.com/"
    }
}