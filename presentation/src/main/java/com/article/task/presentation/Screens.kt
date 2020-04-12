package com.article.task.presentation

import androidx.fragment.app.Fragment
import com.article.task.domain.features.articles.model.Article
import com.article.task.presentation.features.articles.ui.ArticlesListFragment
import com.article.task.presentation.features.details.ui.ArticleDetailsFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    object ArticlesList : SupportAppScreen() {
        override fun getFragment(): Fragment = ArticlesListFragment.newInstance()
    }

    data class ArticleDetails(val article: Article) : SupportAppScreen() {
        override fun getFragment(): Fragment = ArticleDetailsFragment.newInstance(article)
    }
}