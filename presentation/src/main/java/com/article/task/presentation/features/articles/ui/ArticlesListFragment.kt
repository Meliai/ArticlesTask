package com.article.task.presentation.features.articles.ui

import android.os.Bundle
import android.view.View
import com.article.task.presentation.R
import com.article.task.presentation.core.ui.fragment.BaseListFragment
import com.article.task.presentation.core.ui.system_ui.LightStatusBarConfigProvider
import com.article.task.presentation.core.ui.system_ui.StatusBarConfigProvider
import com.article.task.presentation.features.articles.pm.ArticlesListPm
import com.nullgr.core.ui.decor.DividerItemDecoration

class ArticlesListFragment : BaseListFragment<ArticlesListPm>() {

    override val screenLayout: Int = R.layout.fragment_articles_list
    override val classToken: Class<ArticlesListPm> = ArticlesListPm::class.java
    override val statusBarConfigProvider: StatusBarConfigProvider = LightStatusBarConfigProvider

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsView?.context?.let {
            itemsView?.addItemDecoration(DividerItemDecoration(it, R.drawable.item_divider, false))
        }
    }

    companion object {
        fun newInstance(): ArticlesListFragment = ArticlesListFragment()
    }
}
