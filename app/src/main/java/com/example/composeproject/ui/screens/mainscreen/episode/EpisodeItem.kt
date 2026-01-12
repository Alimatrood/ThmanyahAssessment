package com.example.composeproject.ui.screens.mainscreen.episode

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
import com.example.composeproject.data.models.mainscreen.Episode
import com.example.composeproject.ui.components.PlayButton

@Composable
fun EpisodeItem(
    episode: Episode,
    size: Dp,
    titleFontSize: TextUnit = 12.sp,
    subtitleFontSize: TextUnit = 10.sp,
    playButtonSize: Dp = 40.dp,
    contentPadding: Dp = 10.dp
) {
    val durationMinutes = episode.duration / 60
    val hours = durationMinutes / 60
    val minutes = durationMinutes % 60

    Box(
        modifier = Modifier
            .size(size)
            .clip(RoundedCornerShape(12.dp))
    ) {
        AsyncImage(
            model = episode.avatarUrl,
            contentDescription = episode.name,
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
                        startY = size.value * 0.5f
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
                text = episode.name,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = titleFontSize,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                lineHeight = titleFontSize * 1.2f
            )

            Spacer(modifier = Modifier.height(4.dp))
            
            Text(
                text = episode.podcastName,
                color = Color.White.copy(alpha = 0.7f),
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
