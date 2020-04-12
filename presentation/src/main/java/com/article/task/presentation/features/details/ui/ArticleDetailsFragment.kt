package com.article.task.presentation.features.details.ui

import android.os.Bundle
import com.article.task.domain.features.articles.model.Article
import com.article.task.presentation.R
import com.article.task.presentation.core.ui.fragment.BaseFragment
import com.article.task.presentation.core.ui.system_ui.LightStatusBarConfigProvider
import com.article.task.presentation.core.ui.system_ui.StatusBarConfigProvider
import com.article.task.presentation.features.details.pm.ArticleDetailsPm
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
            articleDetailsTitleTextView.text = it.title
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
