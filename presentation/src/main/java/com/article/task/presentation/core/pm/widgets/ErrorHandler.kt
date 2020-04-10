package com.article.task.presentation.core.pm.widgets

import com.article.common.errors.NetworkConnectionError
import com.article.task.presentation.ErrorData
import com.article.task.presentation.core.pm.BasePm

class ErrorHandler(private val pm: BasePm) {

    fun handleError(error: Throwable) {
        val errorData = when (error) {
            is NetworkConnectionError -> ErrorData.NetworkErrorState(pm.resources)
            else -> ErrorData.ErrorState(pm.resources)
        }

        pm.setErrorStateData(errorData)
        if (pm.isEmptyScreen) {
            pm.setErrorViewVisibility(true)
        } else {
            pm.setErrorViewVisibility(false)
        }
    }
}

fun BasePm.errorHandler() = ErrorHandler(this)