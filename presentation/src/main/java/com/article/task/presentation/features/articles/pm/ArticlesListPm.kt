package com.article.task.presentation.features.articles.pm

import com.article.common.mapper.Mapper
import com.article.task.domain.features.articles.interactor.GetArticlesUseCase
import com.article.task.domain.features.articles.model.Article
import com.article.task.presentation.Clicks
import com.article.task.presentation.ErrorData
import com.article.task.presentation.Screens
import com.article.task.presentation.core.bus.clicks
import com.article.task.presentation.core.pm.BaseListPm
import com.article.task.presentation.core.pm.ServiceFacade
import com.nullgr.core.adapter.items.ListItem
import com.nullgr.core.collections.isNotNullOrEmpty
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

        setErrorStateData(ErrorData.ErrorState(resources))

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

    override fun onBind() {
        super.onBind()
        bus.clicks<Clicks.OpenAricleClicked>()
            .debounceAction()
            .doOnNext { click ->
                val article = currentList.valueOrNull?.firstOrNull { click.id == it.id }
                article?.let { router.navigateTo(Screens.ArticleDetails(it)) }
            }
            .subscribe()
            .untilUnbind()
    }

    private fun uploadData() =
        getArticlesUseCase.execute()
            .hideErrorContainer()
            .doOnSuccess { list ->
                if (list.isNotNullOrEmpty()) {
                    currentList.consumer.accept(list.sortedByDescending { it.date })
                    items.consumer.accept(mapper.mapFromObjects(currentList.value))
                } else {
                    setErrorViewVisibility(true)
                }
            }
            .doOnError(::handleError)
}