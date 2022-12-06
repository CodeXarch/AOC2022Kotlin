fun day4partOne(input: List<String>) {
	var redundantPairs = 0
	var pairList: MutableList<Pair<String,String>> = mutableListOf()
	for(line in input) {
		var pairArray = line.split(",")
		var pair = Pair(pairArray[0],pairArray[1])
		pairList.add(pair)
	}
	for(pair in pairList) {
		var firstArray = pair.first.split("-")
		var secondArray = pair.second.split("-")
		if((firstArray[0].toInt() >= secondArray[0].toInt() && firstArray[1].toInt() <= secondArray[1].toInt()) ||
			(secondArray[0].toInt() >= firstArray[0].toInt() && secondArray[1].toInt() <= firstArray[1].toInt())) {
			println("found redundant pair: ${firstArray[0]}-${firstArray[1]} | ${secondArray[0]}-${secondArray[1]}")
			redundantPairs++
		}
	}
	println(redundantPairs)
}

fun day4PartTwo(input: List<String>) {
	var redundantPairs = 0
	var pairList: MutableList<Pair<String,String>> = mutableListOf()
	for(line in input) {
		var pairArray = line.split(",")
		var pair = Pair(pairArray[0],pairArray[1])
		pairList.add(pair)
	}
	for(pair in pairList) {
		var firstArray = pair.first.split("-")
		var secondArray = pair.second.split("-")
		if((firstArray[0].toInt() <= secondArray[0].toInt() && firstArray[1].toInt() >= secondArray[0].toInt()) ||
			(firstArray[0].toInt() <= secondArray[1].toInt() && firstArray[1].toInt() >= secondArray[1].toInt()) ||
			(secondArray[0].toInt() <= firstArray[0].toInt() && secondArray[1].toInt() >= firstArray[0].toInt()) ||
			(secondArray[0].toInt() <= firstArray[1].toInt() && secondArray[1].toInt() >= firstArray[1].toInt())) {
			println("found redundant pair: ${firstArray[0]}-${firstArray[1]} | ${secondArray[0]}-${secondArray[1]}")
			redundantPairs++
		}
	}
	println(redundantPairs)
}
