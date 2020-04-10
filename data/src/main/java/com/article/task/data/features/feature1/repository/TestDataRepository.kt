package com.article.task.data.features.feature1.repository

import com.article.common.mapper.Mapper
import com.article.task.data.features.feature1.datasource.TestDataSource
import com.article.task.data.features.feature1.dto.TestDto
import com.article.task.domain.features.feature1.model.TestModel
import com.article.task.domain.features.feature1.repository.TestRepository
import io.reactivex.Observable
import javax.inject.Inject

class TestDataRepository @Inject constructor(
    private val source: TestDataSource,
    private val mapper: Mapper<TestDto, TestModel>
) : TestRepository {

    override fun getTestModel(): Observable<TestModel> =
        source.getTestModel().map(mapper::mapFromObject)
}