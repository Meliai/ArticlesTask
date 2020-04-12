package com.article.task.presentation.features.articles.di

import com.article.task.presentation.core.di.FragmentScope
import com.article.task.presentation.features.articles.ui.adapter.ArticlesListDelegatesFactory
import com.nullgr.core.adapter.AdapterDelegatesFactory
import com.nullgr.core.adapter.DynamicAdapter
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [ArticlesListModule.Declarations::class])
class ArticlesListModule {

    @Module
    interface Declarations {
        @Binds
        @FragmentScope
        fun delegatesFactory(factory: ArticlesListDelegatesFactory): AdapterDelegatesFactory
    }

    @Provides
    @FragmentScope
    fun dynamicAdapter(factory: AdapterDelegatesFactory): DynamicAdapter = DynamicAdapter(factory)
}