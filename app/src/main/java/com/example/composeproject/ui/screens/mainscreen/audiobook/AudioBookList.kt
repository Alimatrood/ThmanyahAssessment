package com.example.composeproject.ui.screens.mainscreen.audiobook

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeproject.data.models.mainscreen.Section

@Composable
fun AudioBookList(section: Section) {
    val audioBooks = section.content.mapNotNull { item ->
        if (item is Map<*, *>) parseAudioBook(item) else null
    }

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(audioBooks) { audioBook ->
            AudioBookItem(
                audioBook = audioBook,
                size = 200.dp,
                titleFontSize = 14.sp,
                subtitleFontSize = 12.sp,
                playButtonSize = 48.dp,
                contentPadding = 12.dp
            )
        }
    }
}

