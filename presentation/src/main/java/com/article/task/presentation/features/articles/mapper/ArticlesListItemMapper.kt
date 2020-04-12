package com.article.task.presentation.features.articles.mapper

import com.article.common.mapper.Mapper
import com.article.task.domain.features.articles.model.Article
import com.article.task.presentation.features.articles.ui.adapter.item.ArticleListItem
import com.nullgr.core.adapter.items.ListItem
import javax.inject.Inject

class ArticlesListItemMapper @Inject constructor() : Mapper<Article, ListItem> {

    override fun mapFromObject(source: Article): ListItem =
        with(source) {
            ArticleListItem(
                title = title,
                description = description,
                url = url
            )
        }
}