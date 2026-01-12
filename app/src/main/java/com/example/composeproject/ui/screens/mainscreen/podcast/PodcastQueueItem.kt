package com.example.composeproject.ui.screens.mainscreen.podcast

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.composeproject.data.models.mainscreen.Podcast



@Composable
fun PodcastQueueItem(
    podcast: Podcast,
    imageSize: Dp = 80.dp,
    itemWidth: Dp = 280.dp
) {
    Row(
        modifier = Modifier
            .width(itemWidth)
            .background(Color.Transparent)
            .clip(RoundedCornerShape(12.dp))
            .padding(12.dp),
        verticalAlignment = Alignment.Top
    ) {
        AsyncImage(
            model = podcast.avatarUrl,
            contentDescription = podcast.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(imageSize)
                .clip(RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(
            modifier = Modifier
                .weight(1f)
                .height(imageSize),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = podcast.name,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Column {
                Text(
                    text = "${podcast.episodeCount} episodes",
                    color = Color.Black,
                    fontSize = 12.sp
                )

                podcast.language?.let { lang ->
                    Text(
                        text = if (lang == "en") "English" else if (lang == "ar") "Arabic" else lang,
                        color = Color.Black,
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}

