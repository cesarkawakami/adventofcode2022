package aoc22.day01

import kotlin.test.Test
import kotlin.test.assertEquals

class Day01Test {
    private val day01 = Day01()
    private val calories = day01.readCalories()

    @Test
    fun testPart1() {
        val result = day01.findMaxCalories(calories)
        assertEquals(24000, result, "The Elf carrying the most Calories should have 24000 Calories")
    }

    @Test
    fun testPart2() {
        val result = day01.findTopThreeCalories(calories)
        assertEquals(45000, result, "The top three Elves should be carrying a total of 45000 Calories")
    }
}
