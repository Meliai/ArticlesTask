package com.article.task.data.di

import com.article.task.data.features.articles.repository.ArticlesDataRepository
import com.article.task.domain.features.articles.repository.ArticlesRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepoModule {

    @Binds
    @Singleton
    fun bindArticlesRepository(repo: ArticlesDataRepository): ArticlesRepository
}