package com.article.task.data.features.feature1.datasource

import com.article.task.data.features.feature1.api.TestApi
import com.article.task.data.features.feature1.dto.TestDto
import io.reactivex.Observable
import javax.inject.Inject

class TestRemoteDataSource @Inject constructor(
    private val api: TestApi
) : TestDataSource {

    override fun getTestModel(): Observable<TestDto> =
        api.getTestModel()
            .andThen(Observable.just(TestDto("123")))
}