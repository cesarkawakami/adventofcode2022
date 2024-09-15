package aoc22

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.types.int

class App : CliktCommand() {
    private val part by option(help = "Part of the problem to solve (1 or 2)").int().default(1)

    override fun run() {
        val calories = readCalories()
        val result = when (part) {
            1 -> findMaxCalories(calories)
            2 -> findTopThreeCalories(calories)
            else -> throw IllegalArgumentException("Invalid part number. Choose 1 or 2.")
        }
        println(result)
    }

    private fun readCalories(): List<Int> {
        val input = this::class.java.getResource("/input.txt")?.readText()
            ?: throw IllegalStateException("Input file not found")
        return input.split("\n\n")
            .map { elf ->
                elf.lines()
                    .sumOf { it.toIntOrNull() ?: 0 }
            }
    }

    private fun findMaxCalories(calories: List<Int>): String {
        val maxCalories = calories.maxOrNull() ?: 0
        return "The Elf carrying the most Calories has a total of $maxCalories Calories."
    }

    private fun findTopThreeCalories(calories: List<Int>): String {
        val topThreeSum = calories.sortedDescending().take(3).sum()
        return "The top three Elves are carrying a total of $topThreeSum Calories."
    }
}

fun main(args: Array<String>) = App().main(args)
