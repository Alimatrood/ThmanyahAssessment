package com.example.composeproject.ui.screens.mainscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeproject.data.models.mainscreen.HomeResponse
import com.example.composeproject.data.models.mainscreen.Section
import com.example.composeproject.ui.screens.mainscreen.audioarticle.AudioArticleList
import com.example.composeproject.ui.screens.mainscreen.audiobook.AudioBookList
import com.example.composeproject.ui.screens.mainscreen.audiobook.PopularAudioBooksList
import com.example.composeproject.ui.screens.mainscreen.episode.EditorPickEpisodeList
import com.example.composeproject.ui.screens.mainscreen.episode.EpisodeList
import com.example.composeproject.ui.screens.mainscreen.podcast.PodcastList
import com.example.composeproject.ui.screens.mainscreen.podcast.PodcastQueueList
import com.example.composeproject.ui.viewmodels.MainViewModel
import com.example.composeproject.ui.viewmodels.UiState

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Box(modifier = modifier) {
        when (val state = uiState) {
            is UiState.Idle -> {
                IdleContent()
            }
            is UiState.Loading -> {
                LoadingContent()
            }
            is UiState.Success -> {
                HomeContent(homeResponse = state.data)
            }
            is UiState.Error -> {
                ErrorContent(
                    message = state.message,
                    onRetry = { viewModel.refresh() }
                )
            }
            else ->{}
        }
    }
}

@Composable
private fun IdleContent() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Test",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}

@Composable
private fun LoadingContent() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator(color = Color.Black)
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Loading Content...",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Composable
private fun ErrorContent(
    message: String,
    onRetry: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Error",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.Red
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = message,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onRetry, colors= ButtonDefaults.buttonColors(
                containerColor = Color.Black,
            )
            ) {
                Text("Retry", color = Color.White)
            }
        }
    }
}

@Composable
private fun HomeContent(homeResponse: HomeResponse) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        items(homeResponse.sections) { section ->
            SectionCard(section = section)
        }
    }
}

@Composable
private fun SectionCard(section: Section) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = section.name,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        when {

            section.contentType == "episode" && section.name.contains("Editor", ignoreCase = true) -> {
                EditorPickEpisodeList(section = section)
            }
            section.contentType == "podcast" && section.name.contains("New", ignoreCase = true) -> {
                PodcastQueueList(section = section)
            }

            section.contentType == "podcast" -> {
                PodcastList(section = section)
            }
            section.contentType == "episode" -> {
                EpisodeList(section = section)
            }
            section.contentType == "audio_book" && section.name.contains("Popular", ignoreCase = true) -> {
                PopularAudioBooksList(section = section)
            }
            section.contentType == "audio_book" -> {
                AudioBookList(section = section)
            }
            section.contentType == "audio_article" -> {
                AudioArticleList(section = section)
            }
        }
    }
}
