package com.example.composeproject.data.models.mainscreen

import com.google.gson.annotations.SerializedName

data class Episode(


    @SerializedName("episode_id")
    val episodeId: String,

    @SerializedName("name")
    override val name: String,

    @SerializedName("season_number")
    val seasonNumber: Int? = null,

    @SerializedName("episode_type")
    val episodeType: String,

    @SerializedName("podcast_name")
    val podcastName: String,

    @SerializedName("author_name")
    val authorName: String,

    @SerializedName("description")
    override val description: String,

    @SerializedName("duration")
    override val duration: Int,

    @SerializedName("avatar_url")
    override val avatarUrl: String,

    @SerializedName("audio_url")
    val audioUrl: String,

    @SerializedName("release_date")
    val releaseDate: String,

    @SerializedName("podcast_id")
    val podcastId: String,

) : ContentItem
