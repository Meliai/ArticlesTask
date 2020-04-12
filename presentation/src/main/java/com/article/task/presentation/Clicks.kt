package com.article.task.presentation

import com.article.task.presentation.core.bus.Click

sealed class Clicks : Click {
    data class OpenAricleClicked(val id: Int) : Click
}
