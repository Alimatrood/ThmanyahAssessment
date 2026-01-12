package com.example.composeproject.ui.screens.mainscreen.audiobook

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeproject.data.models.mainscreen.Section

@Composable
fun PopularAudioBooksList(section: Section) {
    val audioBooks = section.content.mapNotNull { item ->
        if (item is Map<*, *>) parseAudioBook(item) else null
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
        items(audioBooks) { audioBook ->
            AudioBookItem(
                audioBook = audioBook,
                size = 140.dp,
                titleFontSize = 12.sp,
                subtitleFontSize = 10.sp,
                playButtonSize = 40.dp,
                contentPadding = 10.dp
            )
        }
    }
}
