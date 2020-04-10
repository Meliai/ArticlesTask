package com.article.task.presentation.features.app.pm

import com.article.task.presentation.Screens
import com.article.task.presentation.core.pm.BasePm
import com.article.task.presentation.core.pm.ServiceFacade
import com.article.task.presentation.core.pm.listeners.ConnectionListener
import me.dmdev.rxpm.action
import javax.inject.Inject

class AppPm @Inject constructor(
    services: ServiceFacade
) : BasePm(services), ConnectionListener {

    val coldStartAction = action<Unit>()

    override fun onCreate() {
        super.onCreate()

        coldStartAction.observable
            .doOnNext { router.newRootScreen(Screens.OnBoardingFlow) }
            .retry()
            .subscribe()
            .untilDestroy()
    }
}