package com.example.composeproject

import com.example.composeproject.ui.screens.mainscreen.episode.parseEpisode
import org.junit.Assert.*
import org.junit.Test

class EpisodeUtilsTest {

    @Test
    fun `parseEpisode with valid map returns Episode`() {
        val map = mapOf(
            "episode_id" to "episode123",
            "name" to "Test Episode",
            "season_number" to 2,
            "episode_type" to "full",
            "podcast_name" to "Test Podcast",
            "author_name" to "John Doe",
            "description" to "Episode description",
            "duration" to 1800,
            "avatar_url" to "https://example.com/ep.jpg",
            "audio_url" to "https://example.com/audio.mp3",
            "release_date" to "2024-01-15",
            "podcast_id" to "pod123"
        )

        val result = parseEpisode(map)

        assertNotNull(result)
        assertEquals("episode123", result?.episodeId)
        assertEquals("Test Episode", result?.name)
        assertEquals(2, result?.seasonNumber)
        assertEquals("full", result?.episodeType)
        assertEquals("Test Podcast", result?.podcastName)
        assertEquals("John Doe", result?.authorName)
        assertEquals("Episode description", result?.description)
        assertEquals(1800, result?.duration)
        assertEquals("https://example.com/ep.jpg", result?.avatarUrl)
        assertEquals("https://example.com/audio.mp3", result?.audioUrl)
        assertEquals("2024-01-15", result?.releaseDate)
        assertEquals("pod123", result?.podcastId)
    }

    @Test
    fun `parseEpisode with missing episode_id returns null`() {
        val map = mapOf(
            "name" to "Test Episode",
            "duration" to 1800
        )

        val result = parseEpisode(map)

        assertNull(result)
    }

    @Test
    fun `parseEpisode with missing optional fields uses defaults`() {
        val map = mapOf(
            "episode_id" to "episode123",
            "name" to "Test Episode"
        )

        val result = parseEpisode(map)

        assertNotNull(result)
        assertNull(result?.seasonNumber)
        assertEquals("", result?.episodeType)
        assertEquals("", result?.podcastName)
        assertEquals("", result?.authorName)
        assertEquals("", result?.description)
        assertEquals(0, result?.duration)
        assertEquals("", result?.avatarUrl)
        assertEquals("", result?.audioUrl)
        assertEquals("", result?.releaseDate)
        assertEquals("", result?.podcastId)
    }

    @Test
    fun `parseEpisode with duration as double returns integer part`() {
        val map = mapOf(
            "episode_id" to "episode123",
            "name" to "Test Episode",
            "duration" to 1800.5
        )

        val result = parseEpisode(map)

        assertNotNull(result)
        assertEquals(1800, result?.duration)
    }

    @Test
    fun `parseEpisode with null season_number returns null for seasonNumber`() {
        val map = mapOf(
            "episode_id" to "episode123",
            "name" to "Test Episode",
            "season_number" to null
        )

        val result = parseEpisode(map)

        assertNotNull(result)
        assertNull(result?.seasonNumber)
    }

    @Test
    fun `parseEpisode with empty map returns null`() {
        val map = emptyMap<String, Any>()

        val result = parseEpisode(map)

        assertNull(result)
    }
}


