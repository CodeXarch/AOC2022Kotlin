import java.io.File

fun main() {
    var file = File("src/main/resources/input.txt")
    var input = file.readLines()
    Day3(input)
}