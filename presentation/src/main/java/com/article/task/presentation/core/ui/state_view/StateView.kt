package com.article.task.presentation.core.ui.state_view

import io.reactivex.Observable
import io.reactivex.functions.Consumer

/**
 * Interface for state view.
 */
interface StateView {

    fun state(): Consumer<in StateData>

    fun clicks(): Observable<Unit>

    fun enable(): Consumer<in Boolean>

    fun visibility(): Consumer<in Boolean>
}