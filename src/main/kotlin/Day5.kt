fun day5PartOne(input: List<String>) {
	var crateList: MutableList<String> = mutableListOf()
	var instructionList: MutableList<String> = mutableListOf()
	var isStillCrate = true
	var crateColumnList: MutableList<MutableList<String>> = mutableListOf()
	for(line in input) {
		if(line.isNullOrBlank()) {
			isStillCrate = false
			continue
		}
		if(isStillCrate) {
			crateList.add(line)
		}
		else {
			instructionList.add(line)
		}
	}
	for(crateLine in crateList) {
		val chunked = crateLine.chunked(4).toMutableList()
		chunked.replaceAll { item -> if(item.isBlank()) "   " else item.trim() }
		crateColumnList.add(chunked)
	}
	var largestRow = 0
	for(row in crateColumnList) {
		if(row.size > largestRow) {
			largestRow = row.size
		}
	}
	for(row in crateColumnList) {
		if(row.size < largestRow) {
			for(i in 0 until largestRow - row.size) {
				row.add("   ")
			}
		}
	}
	crateColumnList.removeAt(crateColumnList.size-1)
	for(row in crateColumnList) {
		println(row)
	}
	println("---------")
	for(instruction in instructionList) {
		executeInstruction(instruction, crateColumnList)
	}
	for(row in crateColumnList) {
		println(row)
	}
}

fun day5PartTwo(input: List<String>) {
	var crateList: MutableList<String> = mutableListOf()
	var instructionList: MutableList<String> = mutableListOf()
	var isStillCrate = true
	var crateColumnList: MutableList<MutableList<String>> = mutableListOf()
	for(line in input) {
		if(line.isNullOrBlank()) {
			isStillCrate = false
			continue
		}
		if(isStillCrate) {
			crateList.add(line)
		}
		else {
			instructionList.add(line)
		}
	}
	for(crateLine in crateList) {
		val chunked = crateLine.chunked(4).toMutableList()
		chunked.replaceAll { item -> if(item.isBlank()) "   " else item.trim() }
		crateColumnList.add(chunked)
	}
	var largestRow = 0
	for(row in crateColumnList) {
		if(row.size > largestRow) {
			largestRow = row.size
		}
	}
	for(row in crateColumnList) {
		if(row.size < largestRow) {
			for(i in 0 until largestRow - row.size) {
				row.add("   ")
			}
		}
	}
	crateColumnList.removeAt(crateColumnList.size-1)
	for(row in crateColumnList) {
		println(row)
	}
	println("---------")
	for(instruction in instructionList) {
		executeInstruction(instruction, crateColumnList)
	}
	for(row in crateColumnList) {
		println(row)
	}
}

fun executeInstruction(instruction: String, crateColumnList: MutableList<MutableList<String>>) {
	var splitInstruction =instruction.split(" ")
	var numberToMove = splitInstruction[1].toInt()
	var fromLocation = splitInstruction[3].toInt()
	var toLocation = splitInstruction[5].toInt()
	println("new instruction: move $numberToMove from $fromLocation to $toLocation")
		for(i in 0 until crateColumnList.size) {
			if(crateColumnList[i][fromLocation-1].isBlank()) {
				continue
			}
			else {
				var movingCrateList: MutableList<String> = mutableListOf()
				for(j in 0 until numberToMove) {
					var crate = String(crateColumnList[i+j][fromLocation-1].toCharArray())
					movingCrateList.add(crate)
					crateColumnList[i+j][fromLocation-1] = "   "
				}
				println("moving $movingCrateList from $fromLocation to $toLocation")
				for(j in 0 until crateColumnList.size) {
					if(crateColumnList[j][toLocation-1].isBlank() && j != crateColumnList.size-1) {
						continue
					}
					else {
						for(k in 0 until movingCrateList.size) {
							if(j-k <= 0) {
								crateColumnList.add(0,mutableListOf())
								for(l in 0 until crateColumnList[1].size) {
									if(l == toLocation-1) {
										crateColumnList[0].add(movingCrateList[movingCrateList.size-1-k])
									}
									else {
										crateColumnList[0].add("   ")
									}
								}
							}
							else {
								if(crateColumnList[j-k][toLocation-1].isBlank()) {
									crateColumnList[j-k][toLocation-1] = movingCrateList[movingCrateList.size-1-k]
								}
								else {
									crateColumnList[j-1-k][toLocation-1] = movingCrateList[movingCrateList.size-1-k]
								}
							}
						}
						break
					}
				}
				break
			}
		}
		for(row in crateColumnList) {
			println(row)
		}
		println("------")
	for(row in crateColumnList) {
		println(row)
	}
}