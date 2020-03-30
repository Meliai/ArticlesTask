package com.article.task.data.features.articles.repository

import com.article.common.mapper.Mapper
import com.article.task.data.features.articles.datasource.ArticlesDataSource
import com.article.task.data.features.articles.dto.TestDto
import com.article.task.domain.features.feature1.model.TestModel
import com.article.task.domain.features.feature1.repository.TestRepository
import io.reactivex.Observable
import javax.inject.Inject

class TestDataRepository @Inject constructor(
    private val source: ArticlesDataSource,
    private val mapper: Mapper<TestDto, TestModel>
) : TestRepository {

    override fun getTestModel(): Observable<TestModel> =
        source.getTestModel().map(mapper::mapFromObject)
}