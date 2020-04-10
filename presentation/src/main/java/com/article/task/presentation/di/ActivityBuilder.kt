package com.article.task.presentation.di

import com.article.task.presentation.features.app.ui.AppActivity
import com.article.task.presentation.core.di.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector
    fun bindAppActivity(): AppActivity
}