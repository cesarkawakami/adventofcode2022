package aoc22.day01

import aoc22.GenericDay

class Day01 : GenericDay {
    fun readCalories(input: String): List<Int> {
        return input.split("\n\n")
            .map { elf ->
                elf.lines()
                    .sumOf { it.toIntOrNull() ?: 0 }
            }
    }

    fun findMaxCalories(calories: List<Int>): Int {
        return calories.maxOrNull() ?: 0
    }

    fun findTopThreeCalories(calories: List<Int>): Int {
        return calories.sortedDescending().take(3).sum()
    }

    override fun part1(input: String): String {
        val calories = readCalories(input)
        return findMaxCalories(calories).toString()
    }

    override fun part2(input: String): String {
        val calories = readCalories(input)
        return findTopThreeCalories(calories).toString()
    }
}
