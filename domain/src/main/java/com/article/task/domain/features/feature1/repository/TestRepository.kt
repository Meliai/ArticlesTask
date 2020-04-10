package com.article.task.domain.features.feature1.repository

import com.article.task.domain.features.feature1.model.TestModel
import io.reactivex.Observable

interface TestRepository {

    fun getTestModel(): Observable<TestModel>
}