fun Day2(input: List<String>) {
    var points = 0
    for(line in input) {
        points += calculateResult(line)
    }
    println("Final points: $points")
}

fun calculateResult(battle: String): Int {
    var rpsPlay = battle.split(" ")
    var opponent = rpsPlay.get(0)
    var mine = rpsPlay.get(1)
    return battleResultPart2(opponent, mine)
}

fun battleResult(opponent: String, mine: String): Int {
    return when(opponent) {
        "A" -> if(mine.equals("X")) 1+3 else if(mine.equals("Y")) 2+6 else 3+0
        "B" -> if(mine.equals("X")) 1+0 else if(mine.equals("Y")) 2+3 else 3+6
        "C" -> if(mine.equals("X")) 1+6 else if(mine.equals("Y")) 2+0 else 3+3
        else -> -1
    }
}
fun battleResultPart2(opponent: String, mine: String): Int {
    return when(opponent) {
        "A" -> if(mine.equals("X")) 3+0 else if(mine.equals("Y")) 1+3 else 2+6
        "B" -> if(mine.equals("X")) 1+0 else if(mine.equals("Y")) 2+3 else 3+6
        "C" -> if(mine.equals("X")) 2+0 else if(mine.equals("Y")) 3+3 else 1+6
        else -> -1
    }
}