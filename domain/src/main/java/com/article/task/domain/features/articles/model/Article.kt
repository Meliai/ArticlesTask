package com.article.task.domain.features.articles.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import org.threeten.bp.ZonedDateTime

@Parcelize
data class Article(
    val id: Int,
    val title: String?,
    val description: String?,
    val author: String?,
    val date: ZonedDateTime?,
    val url: String?
) : Parcelable