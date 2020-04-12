package com.article.task.presentation.features.details.ui

import android.os.Bundle
import com.article.task.domain.features.articles.model.Article
import com.article.task.presentation.R
import com.article.task.presentation.core.ui.fragment.BaseFragment
import com.article.task.presentation.core.ui.system_ui.LightStatusBarConfigProvider
import com.article.task.presentation.core.ui.system_ui.StatusBarConfigProvider
import com.article.task.presentation.features.details.pm.ArticleDetailsPm
import com.article.task.presentation.utils.loadImage
import com.article.task.presentation.utils.toFormattedString
import com.nullgr.core.ui.extensions.toggleView
import kotlinx.android.synthetic.main.fragment_article_details.*
import me.dmdev.rxpm.bindTo

class ArticleDetailsFragment : BaseFragment<ArticleDetailsPm>() {

    override val screenLayout: Int = R.layout.fragment_article_details
    override val classToken: Class<ArticleDetailsPm> = ArticleDetailsPm::class.java
    override val statusBarConfigProvider: StatusBarConfigProvider = LightStatusBarConfigProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            it.getParcelable<Article>(ARTICLE)?.let { article -> presentationModel.setArticle(article) }
        }
    }

    override fun onBindPresentationModel(pm: ArticleDetailsPm) {
        super.onBindPresentationModel(pm)
        pm.articleState.bindTo {
            with(it) {
                articlePhotoImageView.loadImage(
                    url,
                    R.drawable.ic_no_photo,
                    R.drawable.ic_no_photo
                )
                articleDetailsTitleTextView.toggleView(!title.isNullOrBlank())
                articleDetailsTitleTextView.text = title

                articleDetailsDescriptionTextView.toggleView(!description.isNullOrBlank())
                articleDetailsDescriptionTextView.text = description

                articleDetailsDateTextView.toggleView(date != null)
                articleDetailsDateTextView.text = date?.toFormattedString()

                articleDetailsAuthorTextView.text = if (!author.isNullOrBlank()) {
                    author
                } else "-"
            }
        }
    }

    companion object {
        private const val ARTICLE = "article"
        fun newInstance(article: Article): ArticleDetailsFragment {
            return ArticleDetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARTICLE, article)
                }
            }
        }
    }
}
