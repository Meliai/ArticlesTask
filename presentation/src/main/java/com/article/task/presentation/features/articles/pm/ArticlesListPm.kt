package com.article.task.presentation.features.articles.pm

import com.article.common.mapper.Mapper
import com.article.task.domain.features.articles.interactor.GetArticlesUseCase
import com.article.task.domain.features.articles.model.Article
import com.article.task.presentation.core.pm.BaseListPm
import com.article.task.presentation.core.pm.ServiceFacade
import com.nullgr.core.adapter.items.ListItem
import me.dmdev.rxpm.action
import me.dmdev.rxpm.state
import javax.inject.Inject

class ArticlesListPm @Inject constructor(
    private val getArticlesUseCase: GetArticlesUseCase,
    private val mapper: Mapper<Article, ListItem>,
    services: ServiceFacade
) : BaseListPm(services) {

    private val loadScreenAction = action<Unit>()
    private val currentList = state<List<Article>>()

    override fun onCreate() {
        super.onCreate()

        loadScreenAction.observable
            .flatMapSingle { uploadData() }
            .retry()
            .subscribe()
            .untilDestroy()

        lifecycleObservable.filter { it == Lifecycle.BINDED }
            .doOnNext { loadScreenAction.consumer.accept(Unit) }
            .subscribe()
            .untilDestroy()
    }

    private fun uploadData() =
        getArticlesUseCase.execute()
            .hideErrorContainer()
            .doOnSuccess { list ->
                currentList.consumer.accept(list)
                items.consumer.accept(mapper.mapFromObjects(list))
            }
            .doOnError(::handleError)
}