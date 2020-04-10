package com.article.task

import android.content.Context
import com.article.task.data.di.ApiConstantsModule
import com.article.task.data.di.ApiModule
import com.article.task.data.di.DataMappersModule
import com.article.task.data.di.DataSourceModule
import com.article.task.data.di.InterceptorModule
import com.article.task.data.di.NetworkModule
import com.article.task.data.di.RepoModule
import com.article.task.presentation.di.ActivityBuilder
import com.article.task.presentation.di.FragmentBuilder
import com.article.task.presentation.di.NavigationModule
import com.article.task.presentation.di.PmModule
import com.article.task.presentation.di.PresentationMappersModule

import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    // common
    AndroidSupportInjectionModule::class,
    AppModule::class,
    // data
    ApiModule::class,
    ApiConstantsModule::class,
    NetworkModule::class,
    DataSourceModule::class,
    DataMappersModule::class,
    // domain
    RepoModule::class,
    // presentation
    PmModule::class,
    ActivityBuilder::class,
    FragmentBuilder::class,
    PresentationMappersModule::class,
    // navigation
    NavigationModule::class
])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder

        fun appModule(module: AppModule): Builder

        fun apiConstantsModule(module: ApiConstantsModule): Builder

        fun interceptorModule(module: InterceptorModule): Builder

        fun build(): AppComponent
    }

    fun inject(application: App)

    fun context(): Context
}