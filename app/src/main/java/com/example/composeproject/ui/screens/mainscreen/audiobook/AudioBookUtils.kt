package com.example.composeproject.ui.screens.mainscreen.audiobook

import com.example.composeproject.data.models.mainscreen.AudioBook

fun parseAudioBook(map: Map<*, *>): AudioBook? {
    return try {
        AudioBook(
            audiobookId = map["audiobook_id"] as String,
            name = map["name"] as String,
            authorName = map["author_name"] as? String ?: "",
            description = map["description"] as? String ?: "",
            avatarUrl = map["avatar_url"] as? String ?: "",
            duration = (map["duration"] as? Number)?.toInt() ?: 0,
            language = map["language"] as? String ?: "",
            releaseDate = map["release_date"] as? String ?: "",
        )
    } catch (e: Exception) {
        null
    }
}

