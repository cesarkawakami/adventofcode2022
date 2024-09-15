package org.example

class App {
    fun findMaxCalories(): Int {
        val input = this::class.java.getResource("/input.txt")?.readText()
            ?: throw IllegalStateException("Input file not found")
        return input.split("\n\n")
            .map { elf ->
                elf.lines()
                    .sumOf { it.toIntOrNull() ?: 0 }
            }
            .maxOrNull() ?: 0
    }
}

fun main() {
    val app = App()
    val maxCalories = app.findMaxCalories()
    println("The Elf carrying the most Calories has a total of $maxCalories Calories.")
}
