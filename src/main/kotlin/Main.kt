import java.io.File
import Day7.day7PartOne
import Day7.day7PartTwo

fun main() {
    var file = File("src/main/resources/input.txt")
    var input = file.readLines()
    day7PartTwo(input)
}