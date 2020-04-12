@file:Suppress("NOTHING_TO_INLINE")

package com.article.task.presentation.core.bus

import com.nullgr.core.rx.RxBus
import io.reactivex.Observable

inline fun <reified T : Click> RxBus.clicks(): Observable<T> =
    observable(Click::class.java)
        .filter { it is Click && it is T }
        .map { it as T }

inline fun RxBus.allClicks(): Observable<Click> =
    observable(Click::class.java)
        .filter { it is Click }
        .map { it as Click }

inline fun <T : Click> RxBus.click(click: T) {
    post(Click::class.java, click)
}