package com.article.task.data.features.feature1.mapper

import com.article.common.mapper.Mapper
import com.article.task.data.features.feature1.dto.TestDto
import com.article.task.domain.features.feature1.model.TestModel
import javax.inject.Inject

class TestDtoMapper @Inject constructor() : Mapper<TestDto, TestModel> {
    override fun mapFromObject(source: TestDto): TestModel =
        TestModel(source.id)
}