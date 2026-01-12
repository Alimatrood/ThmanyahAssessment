package com.example.composeproject.ui.screens.mainscreen.episode

import com.example.composeproject.data.models.mainscreen.Episode

fun parseEpisode(map: Map<*, *>): Episode? {
    return try {
        Episode(
            episodeId = map["episode_id"] as String,
            name = map["name"] as String,
            seasonNumber = (map["season_number"] as? Number)?.toInt(),
            episodeType = map["episode_type"] as? String ?: "",
            podcastName = map["podcast_name"] as? String ?: "",
            authorName = map["author_name"] as? String ?: "",
            description = map["description"] as? String ?: "",
            duration = (map["duration"] as? Number)?.toInt() ?: 0,
            avatarUrl = map["avatar_url"] as? String ?: "",
            audioUrl = map["audio_url"] as? String ?: "",
            releaseDate = map["release_date"] as? String ?: "",
            podcastId = map["podcast_id"] as? String ?: "",
        )
    } catch (e: Exception) {
        null
    }
}

