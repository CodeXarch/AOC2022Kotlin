package Day7

fun day7PartOne(input: List<String>) {
	var christmasFileSystem = ChristmasFileSystem()
	for(line in input) {
		christmasFileSystem.executeInstruction(line)
	}
	christmasFileSystem.recursivelySum(christmasFileSystem.rootDirectory!!)
	println(christmasFileSystem.totalUnder100000)
}

fun day7PartTwo(input: List<String>) {
	var christmasFileSystem = ChristmasFileSystem()
	for(line in input) {
		christmasFileSystem.executeInstruction(line)
	}
	christmasFileSystem.calculateRemainingSpace()
	println(christmasFileSystem.remainingSpace)
	println("Space to be freed: ${christmasFileSystem.neededSpace - christmasFileSystem.remainingSpace}")
	println(christmasFileSystem.findSizeOfIdealDeletion())
}