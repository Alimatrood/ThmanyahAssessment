package com.example.composeproject.ui.screens.mainscreen.podcast

import com.example.composeproject.data.models.mainscreen.Podcast

fun parsePodcast(map: Map<*, *>): Podcast? {
    return try {
        Podcast(
            podcastId = map["podcast_id"] as String,
            name = map["name"] as String,
            description = map["description"] as String,
            avatarUrl = map["avatar_url"] as? String ?: "",
            episodeCount = parseInt(map["episode_count"]),
            duration = parseInt(map["duration"]),
            language = map["language"] as? String,
        )
    } catch (e: Exception) {
        null
    }
}

fun parseInt(value: Any?): Int {
    return when (value) {
        is Number -> value.toInt()
        is String -> value.toIntOrNull() ?: 0
        else -> 0
    }
}

