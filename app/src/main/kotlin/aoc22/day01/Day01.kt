package aoc22.day01

class Day01 {
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
}
