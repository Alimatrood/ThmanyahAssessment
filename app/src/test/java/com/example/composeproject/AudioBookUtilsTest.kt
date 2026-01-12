package com.example.composeproject

import com.example.composeproject.ui.screens.mainscreen.audiobook.parseAudioBook
import org.junit.Assert.*
import org.junit.Test

class AudioBookUtilsTest {

    @Test
    fun `parseAudioBook with valid map returns AudioBook`() {
        val map = mapOf(
            "audiobook_id" to "audiobook123",
            "name" to "Test AudioBook",
            "author_name" to "Jane Author",
            "description" to "Book description",
            "avatar_url" to "https://example.com/book.jpg",
            "duration" to 36000,
            "language" to "en",
            "release_date" to "2024-01-01"
        )

        val result = parseAudioBook(map)

        assertNotNull(result)
        assertEquals("audiobook123", result?.audiobookId)
        assertEquals("Test AudioBook", result?.name)
        assertEquals("Jane Author", result?.authorName)
        assertEquals("Book description", result?.description)
        assertEquals("https://example.com/book.jpg", result?.avatarUrl)
        assertEquals(36000, result?.duration)
        assertEquals("en", result?.language)
        assertEquals("2024-01-01", result?.releaseDate)
    }

    @Test
    fun `parseAudioBook with missing audiobook_id returns null`() {
        val map = mapOf(
            "name" to "Test AudioBook",
            "duration" to 36000
        )

        val result = parseAudioBook(map)

        assertNull(result)
    }

    @Test
    fun `parseAudioBook with missing name returns null`() {
        val map = mapOf(
            "audiobook_id" to "audiobook123",
            "duration" to 36000
        )

        val result = parseAudioBook(map)

        assertNull(result)
    }

    @Test
    fun `parseAudioBook with missing optional fields uses defaults`() {
        val map = mapOf(
            "audiobook_id" to "audiobook123",
            "name" to "Test AudioBook"
        )

        val result = parseAudioBook(map)

        assertNotNull(result)
        assertEquals("", result?.authorName)
        assertEquals("", result?.description)
        assertEquals("", result?.avatarUrl)
        assertEquals(0, result?.duration)
        assertEquals("", result?.language)
        assertEquals("", result?.releaseDate)
    }

    @Test
    fun `parseAudioBook with duration as double returns integer part`() {
        val map = mapOf(
            "audiobook_id" to "audiobook123",
            "name" to "Test AudioBook",
            "duration" to 7200.9
        )

        val result = parseAudioBook(map)

        assertNotNull(result)
        assertEquals(7200, result?.duration)
    }

    @Test
    fun `parseAudioBook with empty map returns null`() {
        val map = emptyMap<String, Any>()

        val result = parseAudioBook(map)

        assertNull(result)
    }
}


