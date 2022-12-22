import java.io.File
import Day9.day9PartOne
import Day9.day9PartTwo

fun main() {
    var file = File("src/main/resources/input.txt")
    var input = file.readLines()
    day10PartTwo(input)
}