package com.example.composeproject.ui.screens.mainscreen.podcast

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.composeproject.data.models.mainscreen.Section

@Composable
fun PodcastList(section: Section) {
    val podcasts = section.content.mapNotNull { item ->
        if (item is Map<*, *>) parsePodcast(item) else null
    }

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(podcasts) { podcast ->
            PodcastItem(podcast = podcast)
        }
    }
}

