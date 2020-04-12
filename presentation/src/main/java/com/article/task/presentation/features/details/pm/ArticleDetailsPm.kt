package com.article.task.presentation.features.details.pm

import com.article.task.domain.features.articles.model.Article
import com.article.task.presentation.core.pm.BasePm
import com.article.task.presentation.core.pm.ServiceFacade
import me.dmdev.rxpm.state
import javax.inject.Inject

class ArticleDetailsPm @Inject constructor(
    services: ServiceFacade
) : BasePm(services) {
    val articleState = state<Article>()

    fun setArticle(article: Article) {
        articleState.consumer.accept(article)
    }
}