package com.article.task.domain.features.articles.interactor

import com.article.task.domain.features.articles.model.Article
import com.article.task.domain.features.articles.repository.ArticlesRepository
import com.nullgr.core.interactor.SingleUseCase
import com.nullgr.core.rx.schedulers.SchedulersFacade
import io.reactivex.Single
import javax.inject.Inject

class GetArticlesUseCase @Inject constructor(
    private val repository: ArticlesRepository,
    schedulersFacade: SchedulersFacade
) : SingleUseCase<List<Article>, Unit>(schedulersFacade) {

    override fun buildUseCaseObservable(params: Unit?): Single<List<Article>> =
        repository.getAllArticles()
}