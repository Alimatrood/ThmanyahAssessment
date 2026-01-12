package com.example.composeproject.ui.screens.mainscreen.audiobook

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.composeproject.data.models.mainscreen.AudioBook
import com.example.composeproject.ui.components.PlayButton

@Composable
fun AudioBookItem(audioBook: AudioBook,
                  size: Dp,
                  titleFontSize: TextUnit = 14.sp,
                  subtitleFontSize: TextUnit = 12.sp,
                  playButtonSize: Dp = 48.dp,
                  contentPadding: Dp = 12.dp
) {
    val durationMinutes = audioBook.duration / 60
    val hours = durationMinutes/60
    val minutes = durationMinutes%60

    Box(
        modifier = Modifier
            .size(size)
            .clip(RoundedCornerShape(12.dp))
    ) {
        AsyncImage(
            model = audioBook.avatarUrl,
            contentDescription = audioBook.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.9f)
                        ),
                        startY = 100f
                    )
                )
        )

        PlayButton(
            modifier = Modifier.align(Alignment.Center),
            size = playButtonSize
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding),
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = audioBook.name,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = titleFontSize,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                lineHeight = 16.sp
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "By ${audioBook.authorName}",
                color = Color.White.copy(alpha = 0.8f),
                fontSize = subtitleFontSize,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = if (hours > 0) "${hours}h ${minutes}m" else "${minutes}m",
                color = Color.White.copy(alpha = 0.6f),
                fontSize = subtitleFontSize
            )
        }
    }
}

