package com.example.composeproject.ui.screens.mainscreen.episode

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composeproject.data.models.mainscreen.Section

@Composable
fun EpisodeList(section: Section) {
    val episodes = section.content.mapNotNull { item ->
        if (item is Map<*, *>) parseEpisode(item) else null
    }

    val squareSize = 140.dp
    val gridHeight = (squareSize * 2) + 12.dp

    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        modifier = Modifier.height(gridHeight),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(episodes) { episode ->
            EpisodeItem(episode = episode, size = squareSize)
        }
    }
}

