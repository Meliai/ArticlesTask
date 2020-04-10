package com.article.task.presentation.core.pm.factory

import me.dmdev.rxpm.PresentationModel

/**
 * Base interface for all pm factories.
 */
interface PmFactory {
    fun <T : PresentationModel> createViewModel(modelClass: Class<T>): T
}