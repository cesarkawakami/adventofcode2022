package aoc22.day02

import aoc22.GenericDay

class Day02 : GenericDay {
    private enum class Shape(val score: Int) {
        ROCK(1),
        PAPER(2),
        SCISSORS(3),
    }

    private fun parseShape(char: Char): Shape =
        when (char) {
            'A', 'X' -> Shape.ROCK
            'B', 'Y' -> Shape.PAPER
            'C', 'Z' -> Shape.SCISSORS
            else -> throw IllegalArgumentException("Invalid shape: $char")
        }

    private fun roundScore(
        opponent: Shape,
        you: Shape,
    ): Int {
        val outcome =
            when {
                opponent == you -> 3
                (opponent == Shape.ROCK && you == Shape.PAPER) ||
                    (opponent == Shape.PAPER && you == Shape.SCISSORS) ||
                    (opponent == Shape.SCISSORS && you == Shape.ROCK) -> 6
                else -> 0
            }
        return outcome + you.score
    }

    private fun parseRound(round: String): Pair<Shape, Shape> {
        val (opponent, you) = round.split(" ")
        return Pair(parseShape(opponent[0]), parseShape(you[0]))
    }

    private fun calculateTotalScore(rounds: List<String>): Int {
        return rounds.sumOf { round ->
            val (opponent, you) = parseRound(round)
            roundScore(opponent, you)
        }
    }

    override fun part1(input: String): String {
        val rounds = input.trim().split("\n")
        return calculateTotalScore(rounds).toString()
    }

    override fun part2(input: String): String {
        val rounds = input.trim().split("\n")
        return rounds.sumOf { round ->
            val (opponentChar, resultChar) = round.split(" ")
            val opponent = parseShape(opponentChar[0])
            val you =
                when (resultChar[0]) {
                    'X' -> Shape.values()[(opponent.ordinal + 2) % 3] // Lose
                    'Y' -> opponent // Draw
                    'Z' -> Shape.values()[(opponent.ordinal + 1) % 3] // Win
                    else -> throw IllegalArgumentException("Invalid result: ${resultChar[0]}")
                }
            roundScore(opponent, you)
        }.toString()
    }
}
