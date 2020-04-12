package com.article.task.presentation.di

import com.article.task.presentation.core.di.FragmentScope
import com.article.task.presentation.features.articles.di.ArticlesListModule
import com.article.task.presentation.features.articles.ui.ArticlesListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @FragmentScope
    @ContributesAndroidInjector(modules = [ArticlesListModule::class])
    abstract fun bindArticlesListFragment(): ArticlesListFragment
}