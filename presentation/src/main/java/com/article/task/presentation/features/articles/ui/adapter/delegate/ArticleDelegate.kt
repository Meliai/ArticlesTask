package com.article.task.presentation.features.articles.ui.adapter.delegate

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.article.task.presentation.Clicks
import com.article.task.presentation.R
import com.article.task.presentation.core.bus.Click
import com.article.task.presentation.core.bus.click
import com.article.task.presentation.features.articles.ui.adapter.item.ArticleListItem
import com.article.task.presentation.utils.loadImage
import com.article.task.presentation.utils.withAdapterPosition
import com.nullgr.core.adapter.items.ListItem
import com.nullgr.core.adapter.ktx.AdapterDelegate
import com.nullgr.core.adapter.ktx.ViewHolder
import com.nullgr.core.rx.RxBus
import com.nullgr.core.ui.extensions.toggleView
import kotlinx.android.synthetic.main.item_article.*

class ArticleDelegate(
    private val bus: RxBus
) : AdapterDelegate() {
    override val layoutResource: Int = R.layout.item_article
    override val itemType: Any = ArticleListItem::class

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return super.onCreateViewHolder(parent).apply {
            with(this as ViewHolder) {
                itemView.setOnClickListener {
                    withAdapterPosition<ArticleListItem> { _, item, _ ->
                        bus.click(Clicks.OpenAricleClicked(item.id))
                    }
                }
            }
        }
    }

    override fun onBindViewHolder(items: List<ListItem>, position: Int, holder: RecyclerView.ViewHolder) {
        val item = items[position] as ArticleListItem

        with(holder as ViewHolder) {
            articleImageView.loadImage(
                item.url,
                R.drawable.ic_no_photo_gray_small,
                R.drawable.ic_no_photo_gray_small
            )

            articleTitleTextView.text = item.title ?: "-"
            articleDescriptionTextView.text = item.description
            articleDescriptionTextView.toggleView(!item.description.isNullOrBlank())
        }
    }

    override fun onBindViewHolder(items: List<ListItem>, position: Int, holder: RecyclerView.ViewHolder, payload: Any) {
        val item = items[position] as ArticleListItem
        with(holder as ViewHolder) {
            when (payload) {
                ArticleListItem.Payload.TITLE_CHANGED ->
                    articleTitleTextView.text = item.title
                ArticleListItem.Payload.DESCRIPTION_CHANGED ->
                    articleDescriptionTextView.text = item.description
                ArticleListItem.Payload.PHOTO_CHANGED ->
                    articleImageView.loadImage(
                        item.url,
                        R.drawable.ic_no_photo_gray_small,
                        R.drawable.ic_no_photo_gray_small
                    )
            }
        }
    }
}