package aoc22

import kotlin.test.Test
import kotlin.test.assertEquals

class AppTest {
    private val app = App()
    private val calories = app.readCalories()

    @Test
    fun testPart1() {
        val result = app.findMaxCalories(calories)
        assertEquals(24000, result, "The Elf carrying the most Calories should have 24000 Calories")
    }

    @Test
    fun testPart2() {
        val result = app.findTopThreeCalories(calories)
        assertEquals(45000, result, "The top three Elves should be carrying a total of 45000 Calories")
    }
}
