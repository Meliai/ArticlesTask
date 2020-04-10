package com.article.task.presentation.core.navigation

import ru.terrakok.cicerone.Router

/**
 * Interface to indicate classes which can provide [Router].
 */
interface RouterProvider {
    val router: Router
}