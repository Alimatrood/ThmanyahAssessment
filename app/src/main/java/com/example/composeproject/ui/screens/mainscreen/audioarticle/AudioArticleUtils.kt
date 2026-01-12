package com.example.composeproject.ui.screens.mainscreen.audioarticle

import com.example.composeproject.data.models.mainscreen.AudioArticle

fun parseAudioArticle(map: Map<*, *>): AudioArticle? {
    return try {
        AudioArticle(
            articleId = map["article_id"] as String,
            name = map["name"] as String,
            authorName = map["author_name"] as? String ?: "",
            description = map["description"] as? String ?: "",
            avatarUrl = map["avatar_url"] as? String ?: "",
            duration = (map["duration"] as? Number)?.toInt() ?: 0,
            releaseDate = map["release_date"] as? String ?: "",
        )
    } catch (e: Exception) {
        null
    }
}

