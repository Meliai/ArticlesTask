package com.article.task.data.features.articles.mapper

import com.article.common.mapper.Mapper
import com.article.task.data.features.articles.dto.ArticleDto
import com.article.task.domain.features.feature1.model.TestModel
import javax.inject.Inject

class TestDtoMapper @Inject constructor() : Mapper<ArticleDto, TestModel> {
    override fun mapFromObject(source: ArticleDto): TestModel =
        TestModel(source.id.toString())
}