package com.example.composeproject

import com.example.composeproject.ui.screens.mainscreen.podcast.parsePodcast
import org.junit.Assert.*
import org.junit.Test

class PodcastUtilsTest {

    @Test
    fun `parsePodcast with valid map returns Podcast`() {
        val map = mapOf(
            "podcast_id" to "podcast123",
            "name" to "Test Podcast",
            "description" to "A test description",
            "avatar_url" to "https://example.com/image.jpg",
            "episode_count" to 10,
            "duration" to 3600,
            "language" to "en"
        )

        val result = parsePodcast(map)

        assertNotNull(result)
        assertEquals("podcast123", result?.podcastId)
        assertEquals("Test Podcast", result?.name)
        assertEquals("A test description", result?.description)
        assertEquals("https://example.com/image.jpg", result?.avatarUrl)
        assertEquals(10, result?.episodeCount)
        assertEquals(3600, result?.duration)
        assertEquals("en", result?.language)
    }

    @Test
    fun `parsePodcast with episode_count as string returns correct value`() {
        val map = mapOf(
            "podcast_id" to "podcast123",
            "name" to "Test Podcast",
            "description" to "Description",
            "avatar_url" to "https://example.com/image.jpg",
            "episode_count" to "25",
            "duration" to 1800,
            "language" to "ar"
        )

        val result = parsePodcast(map)

        assertNotNull(result)
        assertEquals(25, result?.episodeCount)
    }

    @Test
    fun `parsePodcast with duration as string returns correct value`() {
        val map = mapOf(
            "podcast_id" to "podcast123",
            "name" to "Test Podcast",
            "description" to "Description",
            "avatar_url" to "https://example.com/image.jpg",
            "episode_count" to 5,
            "duration" to "7200",
            "language" to "en"
        )

        val result = parsePodcast(map)

        assertNotNull(result)
        assertEquals(7200, result?.duration)
    }

    @Test
    fun `parsePodcast with missing podcast_id returns null`() {
        val map = mapOf(
            "name" to "Test Podcast",
            "description" to "Description",
            "avatar_url" to "https://example.com/image.jpg",
            "episode_count" to 10,
            "duration" to 3600
        )

        val result = parsePodcast(map)

        assertNull(result)
    }

    @Test
    fun `parsePodcast with missing name returns null`() {
        val map = mapOf(
            "podcast_id" to "podcast123",
            "description" to "Description",
            "avatar_url" to "https://example.com/image.jpg",
            "episode_count" to 10,
            "duration" to 3600
        )

        val result = parsePodcast(map)

        assertNull(result)
    }

    @Test
    fun `parsePodcast with missing avatar_url uses empty string`() {
        val map = mapOf(
            "podcast_id" to "podcast123",
            "name" to "Test Podcast",
            "description" to "Description",
            "episode_count" to 10,
            "duration" to 3600
        )

        val result = parsePodcast(map)

        assertNotNull(result)
        assertEquals("", result?.avatarUrl)
    }

    @Test
    fun `parsePodcast with missing language returns null for language`() {
        val map = mapOf(
            "podcast_id" to "podcast123",
            "name" to "Test Podcast",
            "description" to "Description",
            "avatar_url" to "https://example.com/image.jpg",
            "episode_count" to 10,
            "duration" to 3600
        )

        val result = parsePodcast(map)

        assertNotNull(result)
        assertNull(result?.language)
    }

    @Test
    fun `parsePodcast with null episode_count returns 0`() {
        val map = mapOf(
            "podcast_id" to "podcast123",
            "name" to "Test Podcast",
            "description" to "Description",
            "avatar_url" to "https://example.com/image.jpg",
            "episode_count" to null,
            "duration" to 3600
        )

        val result = parsePodcast(map)

        assertNotNull(result)
        assertEquals(0, result?.episodeCount)
    }

    @Test
    fun `parsePodcast with empty map returns null`() {
        val map = emptyMap<String, Any>()

        val result = parsePodcast(map)

        assertNull(result)
    }

}


