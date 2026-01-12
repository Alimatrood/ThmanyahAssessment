package com.example.composeproject

import com.example.composeproject.ui.screens.mainscreen.podcast.parseInt
import org.junit.Assert.assertEquals
import org.junit.Test

class ParseIntTest {

    @Test
    fun `parseInt with integer number returns correct value`() {
        assertEquals(42, parseInt(42))
    }

    @Test
    fun `parseInt with double number returns integer part`() {
        assertEquals(42, parseInt(42.9))
    }

    @Test
    fun `parseInt with float number returns integer part`() {
        assertEquals(100, parseInt(100.5f))
    }

    @Test
    fun `parseInt with long number returns integer value`() {
        assertEquals(999, parseInt(999L))
    }

    @Test
    fun `parseInt with valid string number returns parsed value`() {
        assertEquals(123, parseInt("123"))
    }

    @Test
    fun `parseInt with string containing decimal returns 0`() {
        assertEquals(0, parseInt("42.5"))
    }

    @Test
    fun `parseInt with invalid string returns 0`() {
        assertEquals(0, parseInt("not a number"))
    }

    @Test
    fun `parseInt with empty string returns 0`() {
        assertEquals(0, parseInt(""))
    }

    @Test
    fun `parseInt with null returns 0`() {
        assertEquals(0, parseInt(null))
    }

    @Test
    fun `parseInt with boolean returns 0`() {
        assertEquals(0, parseInt(true))
    }

    @Test
    fun `parseInt with list returns 0`() {
        assertEquals(0, parseInt(listOf(1, 2, 3)))
    }

    @Test
    fun `parseInt with negative number returns correct value`() {
        assertEquals(-50, parseInt(-50))
    }

    @Test
    fun `parseInt with negative string number returns correct value`() {
        assertEquals(-100, parseInt("-100"))
    }

    @Test
    fun `parseInt with zero returns 0`() {
        assertEquals(0, parseInt(0))
    }

    @Test
    fun `parseInt with string zero returns 0`() {
        assertEquals(0, parseInt("0"))
    }
}


