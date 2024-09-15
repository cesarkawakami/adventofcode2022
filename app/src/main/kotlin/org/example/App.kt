package org.example

import java.io.File

class App {
    fun findMaxCalories(inputFile: String): Int {
        val input = File(inputFile).readText()
        return input.split("\n\n")
            .map { elf ->
                elf.lines()
                    .sumOf { it.toInt() }
            }
            .maxOrNull() ?: 0
    }
}

fun main() {
    val app = App()
    val maxCalories = app.findMaxCalories("input.txt")
    println("The Elf carrying the most Calories has a total of $maxCalories Calories.")
}
