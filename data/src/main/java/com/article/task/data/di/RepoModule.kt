package com.article.task.data.di

import com.article.task.data.features.feature1.repository.TestDataRepository
import com.article.task.domain.features.feature1.repository.TestRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepoModule {

    @Binds
    @Singleton
    fun bindTestRepository(repo: TestDataRepository): TestRepository
}