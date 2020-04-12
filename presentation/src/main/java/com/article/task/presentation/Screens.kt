package com.article.task.presentation

import androidx.fragment.app.Fragment
import com.article.task.presentation.features.articles.ui.ArticlesListFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    object ArticlesList : SupportAppScreen() {
        override fun getFragment(): Fragment = ArticlesListFragment.newInstance()
    }
}