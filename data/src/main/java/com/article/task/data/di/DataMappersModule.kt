package com.article.task.data.di

import com.article.common.mapper.Mapper
import com.article.task.data.features.articles.dto.TestDto
import com.article.task.data.features.articles.mapper.TestDtoMapper
import com.article.task.domain.features.feature1.model.TestModel
import dagger.Binds
import dagger.Module

@Module
interface DataMappersModule {

    @Binds
    fun bindTestDtoMapper(
        mapper: TestDtoMapper
    ): Mapper<TestDto, TestModel>
}