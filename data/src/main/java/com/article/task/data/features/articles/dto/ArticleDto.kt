package com.article.task.data.features.articles.dto

import com.google.gson.annotations.SerializedName

data class ArticleDto(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("author") val author: String?,
    @SerializedName("release_date") val date: String?,
    @SerializedName("image") val url: String?
)