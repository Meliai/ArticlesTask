package com.article.task.presentation.features.articles.ui.adapter

import com.article.task.presentation.features.articles.ui.adapter.delegate.ArticleDelegate
import com.article.task.presentation.features.articles.ui.adapter.item.ArticleListItem
import com.nullgr.core.adapter.AdapterDelegate
import com.nullgr.core.adapter.AdapterDelegatesFactory
import com.nullgr.core.adapter.items.ListItem
import com.nullgr.core.rx.RxBus
import javax.inject.Inject

class ArticlesListDelegatesFactory @Inject constructor(
    private val bus: RxBus
) : AdapterDelegatesFactory {

    override fun createDelegate(clazz: Class<ListItem>): AdapterDelegate =
        when (clazz) {
            ArticleListItem::class.java -> ArticleDelegate(bus)
            else -> throw IllegalArgumentException("No delegate defined for ${clazz.simpleName}")
        }
}