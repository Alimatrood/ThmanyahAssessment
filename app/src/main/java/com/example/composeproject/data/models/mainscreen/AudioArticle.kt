package com.example.composeproject.data.models.mainscreen

import com.google.gson.annotations.SerializedName

data class AudioArticle(
    @SerializedName("article_id")
    val articleId: String,

    @SerializedName("name")
    override val name: String,

    @SerializedName("author_name")
    val authorName: String,

    @SerializedName("description")
    override val description: String,

    @SerializedName("avatar_url")
    override val avatarUrl: String,

    @SerializedName("duration")
    override val duration: Int,

    @SerializedName("release_date")
    val releaseDate: String,

) : ContentItem
