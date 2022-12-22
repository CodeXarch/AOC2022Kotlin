fun day10PartOne(input: List<String>) {
	var finished: Boolean = false
	var i = 0
	var x = 1
	var cycle = 0
	var executionCounter = 0
	var currentInstruction: List<String> = listOf("noop")
	var sumOfSignalStrengths = 0
	while(!finished) {
		cycle++
		if(cycle == 20 || cycle == 60 || cycle == 100 || cycle == 140 || cycle == 180 || cycle == 220) {
			println("adding $cycle * $x = ${cycle*x}")
			sumOfSignalStrengths += (cycle * x)
		}
		if(currentInstruction[0] == "noop") {
			currentInstruction = input[i].split(" ").toList()
			if(currentInstruction[0] == "noop") {
				i++
				if(i == input.size-1) {
					finished = true
				}
				continue
			}
			else {
				executionCounter++
			}
		}
		else {
			if(executionCounter == 0) {
				executionCounter++
				continue
			}
			else {
				x += currentInstruction[1].toInt()
				executionCounter = 0
				i++
				if(i == input.size-1) {
					finished == true
					break
				}
				currentInstruction = input[i].split(" ").toList()
			}
		}
	}
	println(sumOfSignalStrengths)
}

fun day10PartTwo(input: List<String>) {
	var i = 0
	var x = 1
	var cycle = 0
	var executionCounter = 0
	var currentInstruction: List<String> = listOf("noop")
	var sumOfSignalStrengths = 0
	var screen: MutableList<MutableList<String>> = mutableListOf()
	var lineOne: MutableList<String> = mutableListOf()
	var lineTwo: MutableList<String> = mutableListOf()
	var lineThree: MutableList<String> = mutableListOf()
	var lineFour: MutableList<String> = mutableListOf()
	var lineFive: MutableList<String> = mutableListOf()
	var lineSix: MutableList<String> = mutableListOf()

	while(cycle <= 240) {
		cycle++
		if(cycle < 41) {
			println("cycle: $cycle , sprite: $x")
			if(spriteOverlapsCycle(cycle,x)) {
				lineOne.add("#")
			}
			else {
				lineOne.add(".")
			}
		}
		else if(cycle < 81) {
			if(spriteOverlapsCycle(cycle-40,x)) {
				lineTwo.add("#")
			}
			else {
				lineTwo.add(".")
			}
		}
		else if(cycle < 121) {
			if(spriteOverlapsCycle(cycle-80,x)) {
				lineThree.add("#")
			}
			else {
				lineThree.add(".")
			}
		}
		else if(cycle < 161) {
			if(spriteOverlapsCycle(cycle-120,x)) {
				lineFour.add("#")
			}
			else {
				lineFour.add(".")
			}
		}
		else if(cycle < 201) {
			if(spriteOverlapsCycle(cycle-160,x)) {
				lineFive.add("#")
			}
			else {
				lineFive.add(".")
			}
		}
		else {
			if(spriteOverlapsCycle(cycle-200,x)) {
				lineSix.add("#")
			}
			else {
				lineSix.add(".")
			}
		}
		if(currentInstruction[0] == "noop") {
			if(i <= input.size -1) {
				currentInstruction = input[i].split(" ").toList()
			}
			if(currentInstruction[0] == "noop") {
				i++
				continue
			}
			else {
				executionCounter++
			}
		}
		else {
			if(executionCounter == 0) {
				executionCounter++
				continue
			}
			else {
				x += currentInstruction[1].toInt()
				executionCounter = 0
				i++
				if(i <= input.size-1) {
					currentInstruction = input[i].split(" ").toList()
				}
			}
		}
	}
	screen.add(lineOne)
	screen.add(lineTwo)
	screen.add(lineThree)
	screen.add(lineFour)
	screen.add(lineFive)
	screen.add(lineSix)
	for(line in screen) {
		for(string in line) {
			print(string)
		}
		println()
	}
}

fun spriteOverlapsCycle(cycle: Int, sprite: Int): Boolean {
	if(sprite == cycle-1 || sprite +1 == cycle -1 || sprite -1 == cycle-1) {
		return true
	}
	return false
}