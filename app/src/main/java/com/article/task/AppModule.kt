package com.article.task

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.article.common.di.qualifires.ComputationFacade
import com.article.task.data.cache.ApplicationDatabase
import com.nullgr.core.hardware.NetworkChecker
import com.nullgr.core.preferences.defaultPrefs
import com.nullgr.core.resources.ResourceProvider
import com.nullgr.core.rx.RxBus
import com.nullgr.core.rx.SingletonRxBusProvider
import com.nullgr.core.rx.schedulers.ComputationSchedulersFacade
import com.nullgr.core.rx.schedulers.IoToMainSchedulersFacade
import com.nullgr.core.rx.schedulers.SchedulersFacade
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Suppress("TooManyFunctions")
@Module
class AppModule(private val enableLog: Boolean) {

    @Singleton
    @Provides
    fun provideSchedulersFacade(): SchedulersFacade = IoToMainSchedulersFacade()

    @Singleton
    @Provides
    @ComputationFacade
    fun provideComputationSchedulersFacade(): SchedulersFacade = ComputationSchedulersFacade()

    @Singleton
    @Provides
    fun provideResourceProvider(context: Context): ResourceProvider = ResourceProvider(context)

    @Singleton
    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences = defaultPrefs(context)

    @Singleton
    @Provides
    fun provideNetworkChecker(context: Context): NetworkChecker = NetworkChecker(context)

    @Singleton
    @Provides
    fun provideRxBus(): RxBus = SingletonRxBusProvider.BUS

    @Provides
    @Singleton
    fun provideDatabase(context: Context): ApplicationDatabase =
        Room.databaseBuilder(context, ApplicationDatabase::class.java, DB_NAME)
            .fallbackToDestructiveMigration()
            .build()

    private companion object {
        const val DB_NAME = "articles.db"
    }
}