package com.example.composeproject.data.models.mainscreen


sealed interface ContentItem {
    val name: String
    val description: String
    val avatarUrl: String
    val duration: Int
}
