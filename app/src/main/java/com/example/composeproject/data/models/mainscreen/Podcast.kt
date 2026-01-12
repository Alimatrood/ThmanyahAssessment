package com.example.composeproject.data.models.mainscreen

import com.google.gson.annotations.SerializedName

data class Podcast(
    @SerializedName("podcast_id")
    val podcastId: String,

    @SerializedName("name")
    override val name: String,

    @SerializedName("description")
    override val description: String,

    @SerializedName("avatar_url")
    override val avatarUrl: String,

    @SerializedName("episode_count")
    val episodeCount: Int,

    @SerializedName("duration")
    override val duration: Int,

    @SerializedName("language")
    val language: String? = null,
) : ContentItem
