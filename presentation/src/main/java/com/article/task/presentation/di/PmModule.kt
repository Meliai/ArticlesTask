package com.article.task.presentation.di

import com.article.task.presentation.features.app.pm.AppPm
import com.article.task.presentation.features.onboaring.pm.OnBoardingPm
import com.article.task.presentation.core.pm.PmKey
import com.article.task.presentation.core.pm.factory.GeneralPmFactory
import com.article.task.presentation.core.pm.factory.PmFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import me.dmdev.rxpm.PresentationModel

@Module
interface PmModule {

    @Binds
    fun viewModelFactory(factory: GeneralPmFactory): PmFactory

    @Binds
    @IntoMap
    @PmKey(AppPm::class)
    fun bindAppPm(pm: AppPm): PresentationModel

    @Binds
    @IntoMap
    @PmKey(OnBoardingPm::class)
    fun bindOnBoardingPm(pm: OnBoardingPm): PresentationModel
}