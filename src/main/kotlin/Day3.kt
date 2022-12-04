fun Day3Part1(input: List<String>) {
	var totalPriority = 0
	var rucksackList: MutableList<Pair<String,String>> = mutableListOf()
	for(line in input) {
		rucksackList.add(Pair(line.substring(0,line.length/2),line.substring(line.length/2,line.length)))
	}
	for(rucksack in rucksackList) {
		for(char in rucksack.first) {
			if(rucksack.second.contains(char)) {
				totalPriority += getPriorityValue(char)
				break
			}
		}
	}
	println(totalPriority)
}

fun Day3(input: List<String>) {
	var totalPriority = 0
	var groupsOfThree: MutableList<Triple<String,String,String>> = mutableListOf()
	var i = 0
	var temporaryList: MutableList<String> = mutableListOf()
	for(line in input) {
		temporaryList.add(line)
		if(i == 2) {
			groupsOfThree.add(Triple(temporaryList[0],temporaryList[1],temporaryList[2]))
			i = 0
			temporaryList.clear()
			continue
		}
		i++
	}
	for(group in groupsOfThree) {
		for(char in group.first) {
			if(group.second.contains(char) && group.third.contains(char)) {
				totalPriority += getPriorityValue(char)
				break
			}
		}
	}
	println(totalPriority)
}
fun getPriorityValue(key: Char): Int {
	return when(key) {
		'a' -> 1
		'b' -> 2
		'c' -> 3
		'd' -> 4
		'e' -> 5
		'f' -> 6
		'g' -> 7
		'h' -> 8
		'i' -> 9
		'j' -> 10
		'k' -> 11
		'l' -> 12
		'm' -> 13
		'n' -> 14
		'o' -> 15
		'p' -> 16
		'q' -> 17
		'r' -> 18
		's' -> 19
		't' -> 20
		'u' -> 21
		'v' -> 22
		'w' -> 23
		'x' -> 24
		'y' -> 25
		'z' -> 26
		'a'.uppercaseChar() -> 1+26
		'b'.uppercaseChar() -> 2+26
		'c'.uppercaseChar() -> 3+26
		'd'.uppercaseChar() -> 4+26
		'e'.uppercaseChar() -> 5+26
		'f'.uppercaseChar() -> 6+26
		'g'.uppercaseChar() -> 7+26
		'h'.uppercaseChar() -> 8+26
		'i'.uppercaseChar() -> 9+26
		'j'.uppercaseChar() -> 10+26
		'k'.uppercaseChar() -> 11+26
		'l'.uppercaseChar() -> 12+26
		'm'.uppercaseChar() -> 13+26
		'n'.uppercaseChar() -> 14+26
		'o'.uppercaseChar() -> 15+26
		'p'.uppercaseChar() -> 16+26
		'q'.uppercaseChar() -> 17+26
		'r'.uppercaseChar() -> 18+26
		's'.uppercaseChar() -> 19+26
		't'.uppercaseChar() -> 20+26
		'u'.uppercaseChar() -> 21+26
		'v'.uppercaseChar() -> 22+26
		'w'.uppercaseChar() -> 23+26
		'x'.uppercaseChar() -> 24+26
		'y'.uppercaseChar() -> 25+26
		'z'.uppercaseChar() -> 26+26
		else -> -1
	}


}