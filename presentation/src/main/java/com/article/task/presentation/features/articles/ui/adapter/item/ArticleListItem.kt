package com.article.task.presentation.features.articles.ui.adapter.item

import com.nullgr.core.adapter.items.ListItem
import java.util.Objects

data class ArticleListItem(
    val id: Int,
    val title: String?,
    val description: String?,
    val url: String?
) : ListItem {

    override fun getUniqueProperty(): Any = Objects.hash(title, description, url)

    override fun getChangePayload(other: ListItem): Any {
        if (other is ArticleListItem) {
            return mutableSetOf<Payload>().apply {
                if (title != other.title) add(Payload.TITLE_CHANGED)
                if (description != other.description) add(Payload.DESCRIPTION_CHANGED)
                if (url != other.url) add(Payload.PHOTO_CHANGED)
            }
        }
        return super.getChangePayload(other)
    }

    enum class Payload {
        TITLE_CHANGED, DESCRIPTION_CHANGED, PHOTO_CHANGED
    }
}