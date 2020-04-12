package com.article.task.domain.features.articles.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import org.threeten.bp.LocalDate

@Parcelize
data class Article(
    val id: Int,
    val title: String?,
    val description: String?,
    val author: String?,
    val date: LocalDate?,
    val url: String?
) : Parcelable