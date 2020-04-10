package com.article.task.presentation.di

import com.article.task.presentation.core.di.FragmentScope
import com.article.task.presentation.features.onboaring.ui.OnBoardingFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindOnBoardingFragment(): OnBoardingFragment
}