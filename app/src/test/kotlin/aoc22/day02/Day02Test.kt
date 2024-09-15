package aoc22.day02

import java.io.File
import kotlin.test.Test
import kotlin.test.assertEquals

class Day02Test {
    private val day02 = Day02()
    private val testInput = """
        A Y
        B X
        C Z
    """.trimIndent()

    private val inputFile = File("src/test/resources/day02_input.txt")
    private val fileInput = inputFile.readText()

    @Test
    fun testPart1() {
        val result = day02.part1(testInput)
        assertEquals("15", result, "The total score for part 1 should be 15")
    }

    @Test
    fun testPart2() {
        val result = day02.part2(testInput)
        assertEquals("12", result, "The total score for part 2 should be 12")
    }

    @Test
    fun testPart1WithInputFile() {
        val result = day02.part1(fileInput)
        println("Part 1 result: $result")
    }

    @Test
    fun testPart2WithInputFile() {
        val result = day02.part2(fileInput)
        println("Part 2 result: $result")
    }
}
