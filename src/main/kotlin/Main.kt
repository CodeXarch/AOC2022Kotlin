import java.io.File
import java.util.stream.Collectors
import kotlin.jvm.optionals.getOrNull

fun main() {
    var file = File("src/main/resources/input.txt")
    var input = file.readLines()
    Day2(input)
}