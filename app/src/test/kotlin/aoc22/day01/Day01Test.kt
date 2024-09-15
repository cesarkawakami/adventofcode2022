package aoc22.day01

import java.io.File
import kotlin.test.Test
import kotlin.test.assertEquals

class Day01Test {
    private val day01 = Day01()
    private val testInput = """
        1000
        2000
        3000

        4000

        5000
        6000

        7000
        8000
        9000

        10000
    """.trimIndent()
    private val calories = day01.readCalories(testInput)

    private val inputFile = File("src/main/resources/input.txt")
    private val fileInput = inputFile.readText()
    private val fileCalories = day01.readCalories(fileInput)

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

    @Test
    fun testPart1WithInputFile() {
        val result = day01.findMaxCalories(fileCalories)
        assertEquals(0, result, "The Elf carrying the most Calories from input file")
    }

    @Test
    fun testPart2WithInputFile() {
        val result = day01.findTopThreeCalories(fileCalories)
        assertEquals(0, result, "The top three Elves from input file")
    }
}
