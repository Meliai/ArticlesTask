package com.article.task

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.article.task.data.di.ApiConstantsModule
import com.article.task.data.di.InterceptorModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Inject

class App : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        initializeInjector()
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingActivityInjector

    private fun initializeInjector() {
        DaggerAppComponent
            .builder()
            .context(this)
            .appModule(AppModule(BuildConfig.IS_LOG_ENABLED))
            .apiConstantsModule(ApiConstantsModule(BuildConfig.DEBUG))
            .interceptorModule(InterceptorModule(App::class.java.simpleName, HttpLoggingInterceptor.Level.BODY))
            .build()
            .inject(this)
    }
}