package com.example.composeproject

import com.example.composeproject.ui.screens.mainscreen.audioarticle.parseAudioArticle
import org.junit.Assert.*
import org.junit.Test

class AudioArticleUtilsTest {

    @Test
    fun `parseAudioArticle with valid map returns AudioArticle`() {
        val map = mapOf(
            "article_id" to "article123",
            "name" to "Test Article",
            "author_name" to "Article Author",
            "description" to "Article description",
            "avatar_url" to "https://example.com/article.jpg",
            "duration" to 600,
            "release_date" to "2024-02-20"
        )

        val result = parseAudioArticle(map)

        assertNotNull(result)
        assertEquals("article123", result?.articleId)
        assertEquals("Test Article", result?.name)
        assertEquals("Article Author", result?.authorName)
        assertEquals("Article description", result?.description)
        assertEquals("https://example.com/article.jpg", result?.avatarUrl)
        assertEquals(600, result?.duration)
        assertEquals("2024-02-20", result?.releaseDate)
    }

    @Test
    fun `parseAudioArticle with missing article_id returns null`() {
        val map = mapOf(
            "name" to "Test Article",
            "duration" to 600
        )

        val result = parseAudioArticle(map)

        assertNull(result)
    }

    @Test
    fun `parseAudioArticle with missing name returns null`() {
        val map = mapOf(
            "article_id" to "article123",
            "duration" to 600
        )

        val result = parseAudioArticle(map)

        assertNull(result)
    }

    @Test
    fun `parseAudioArticle with missing optional fields uses defaults`() {
        val map = mapOf(
            "article_id" to "article123",
            "name" to "Test Article"
        )

        val result = parseAudioArticle(map)

        assertNotNull(result)
        assertEquals("", result?.authorName)
        assertEquals("", result?.description)
        assertEquals("", result?.avatarUrl)
        assertEquals(0, result?.duration)
        assertEquals("", result?.releaseDate)
    }

    @Test
    fun `parseAudioArticle with duration as double returns integer part`() {
        val map = mapOf(
            "article_id" to "article123",
            "name" to "Test Article",
            "duration" to 450.7
        )

        val result = parseAudioArticle(map)

        assertNotNull(result)
        assertEquals(450, result?.duration)
    }

    @Test
    fun `parseAudioArticle with null duration returns 0`() {
        val map = mapOf(
            "article_id" to "article123",
            "name" to "Test Article",
            "duration" to null
        )

        val result = parseAudioArticle(map)

        assertNotNull(result)
        assertEquals(0, result?.duration)
    }

    @Test
    fun `parseAudioArticle with empty map returns null`() {
        val map = emptyMap<String, Any>()

        val result = parseAudioArticle(map)

        assertNull(result)
    }
}


