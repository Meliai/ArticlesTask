package com.article.task.presentation.core.navigation

import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppScreen

/**
 * Special [UiThreadRouter] for screens with complicated flow.
 */
class FlowRouter(private val parentRouter: Router?) : UiThreadRouter() {

    fun startFlow(screen: SupportAppScreen) {
        runCommand { navigateTo(screen) }
    }

    fun newRootFlow(screen: SupportAppScreen) {
        runCommand { newRootScreen(screen) }
    }

    fun finishFlow() {
        runCommand { exit() }
    }

    private fun runCommand(command: Router.() -> Unit) {
        if (parentRouter != null)
            parentRouter.command()
        else
            this.command()
    }
}
