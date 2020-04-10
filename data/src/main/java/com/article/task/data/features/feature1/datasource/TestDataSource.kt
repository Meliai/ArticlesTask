package com.article.task.data.features.feature1.datasource

import com.article.task.data.features.feature1.dto.TestDto
import io.reactivex.Observable

interface TestDataSource {

    fun getTestModel(): Observable<TestDto>
}