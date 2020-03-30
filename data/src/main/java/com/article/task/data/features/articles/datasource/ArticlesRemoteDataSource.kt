package com.article.task.data.features.articles.datasource

import com.article.task.data.features.articles.api.ArticlesApi
import com.article.task.data.features.articles.dto.TestDto
import io.reactivex.Observable
import javax.inject.Inject

class ArticlesRemoteDataSource @Inject constructor(
    private val api: ArticlesApi
) : ArticlesDataSource {

    override fun getTestModel(): Observable<TestDto> =
        api.getTestModel()
            .andThen(Observable.just(TestDto("123")))
}