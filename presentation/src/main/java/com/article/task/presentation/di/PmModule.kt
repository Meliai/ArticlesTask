package com.article.task.presentation.di

import com.article.task.presentation.core.pm.PmKey
import com.article.task.presentation.core.pm.factory.GeneralPmFactory
import com.article.task.presentation.core.pm.factory.PmFactory
import com.article.task.presentation.features.app.pm.AppPm
import com.article.task.presentation.features.articles.pm.ArticlesListPm
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
    @PmKey(ArticlesListPm::class)
    fun bindArticlesListPm(pm: ArticlesListPm): PresentationModel
}