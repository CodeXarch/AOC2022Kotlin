fun day8PartOne(input: List<String>) {
	var totalVisible = 0
	var forest: MutableList<MutableList<Int>> = mutableListOf()
	for(line in input) {
		var rowOfTrees: MutableList<Int> = mutableListOf()
		for(char in line) {
			rowOfTrees.add(char.toString().toInt())
		}
		forest.add(rowOfTrees)
	}
	for(row in 1 until forest.size-1) {
		for(column in 1 until forest[0].size-1) {
			var coordinate = Pair(row,column)
			if(visibleFromEast(coordinate,forest) || visibleFromWest(coordinate,forest) ||
				visibleFromNorth(coordinate, forest) || visibleFromSouth(coordinate, forest)) {
				totalVisible++
			}
		}
	}
	println(totalVisible+forest.size+forest[0].size+forest.size-2 + forest[0].size-2)
}

fun day8PartTwo(input: List<String>) {
	var highestScenicScore: Long = 0
	var forest: MutableList<MutableList<Int>> = mutableListOf()
	for(line in input) {
		var rowOfTrees: MutableList<Int> = mutableListOf()
		for(char in line) {
			rowOfTrees.add(char.toString().toInt())
		}
		forest.add(rowOfTrees)
	}
	for(row in 0 until forest.size) {
		for(column in 0 until forest[0].size) {
			var scoreToEast = treesEast(Pair(row,column), forest)
			var scoreToNorth = treesNorth(Pair(row,column), forest)
			var scoreToSouth = treesSouth(Pair(row,column), forest)
			var scoreToWest = treesWest(Pair(row,column), forest)
			//println("$row,$column: $scoreToNorth*$scoreToWest*$scoreToSouth*$scoreToEast")

			var scenicScore = scoreToEast*scoreToNorth*scoreToSouth*scoreToWest
			if(scenicScore > highestScenicScore) {
				highestScenicScore = scenicScore
			}
		}
	}
	println(highestScenicScore)
}

fun treesEast(coordinate: Pair<Int,Int>, forest: MutableList<MutableList<Int>>): Long {
	var row = coordinate.first
	var col = coordinate.second
	var num = forest[row][col]
	if(col == forest[0].size-1) {
		return 0L
	}
	var treesSeen: Long = 0
	for(i in col+1 until forest[0].size) {
		if(forest[row][i] >= num) {
			return treesSeen+1
		}
		treesSeen++
	}
	return treesSeen
}


fun visibleFromEast(coordinate: Pair<Int,Int>, forest: MutableList<MutableList<Int>>): Boolean {
	var row = coordinate.first
	var col = coordinate.second
	var num = forest[row][col]
	for(i in col+1 until forest[0].size) {
		if(forest[row][i] >= num) {
			return false
		}
	}
	return true
}
fun treesWest(coordinate: Pair<Int,Int>, forest: MutableList<MutableList<Int>>): Long {
	var row = coordinate.first
	var col = coordinate.second
	var num = forest[row][col]
	if(col == 0) {
		return 0L
	}
	var treesSeen: Long = 0
	for(i in col-1 downTo 0) {
		if(forest[row][i] >= num) {
			return treesSeen+1
		}
		treesSeen++
	}
	return treesSeen
}
fun visibleFromWest(coordinate: Pair<Int,Int>, forest: MutableList<MutableList<Int>>): Boolean {
	var row = coordinate.first
	var col = coordinate.second
	var num = forest[row][col]
	for(i in col-1 downTo 0) {
		if(forest[row][i] >= num) {
			return false
		}
	}
	return true
}
fun treesNorth(coordinate: Pair<Int,Int>, forest: MutableList<MutableList<Int>>): Long {
	var row = coordinate.first
	var col = coordinate.second
	var num = forest[row][col]
	if(row == 0) {
		return 0L
	}
	var treesSeen: Long = 0
	for(i in row-1 downTo 0) {
		if(forest[i][col] >= num) {
			return treesSeen+1
		}
		treesSeen++
	}
	return treesSeen
}
fun visibleFromNorth(coordinate: Pair<Int,Int>, forest: MutableList<MutableList<Int>>): Boolean {
	var row = coordinate.first
	var col = coordinate.second
	var num = forest[row][col]
	for(i in row-1 downTo 0) {
		if(forest[i][col] >= num) {
			return false
		}
	}
	return true
}
fun treesSouth(coordinate: Pair<Int,Int>, forest: MutableList<MutableList<Int>>): Long {
	var row = coordinate.first
	var col = coordinate.second
	var num = forest[row][col]
	if(row == forest.size-1) {
		return 0L
	}
	var treesSeen: Long = 0
	for(i in row+1 until forest.size) {
		if(forest[i][col] >= num) {
			return treesSeen+1
		}
		treesSeen++
	}
	return treesSeen
}
fun visibleFromSouth(coordinate: Pair<Int,Int>, forest: MutableList<MutableList<Int>>): Boolean {
	var row = coordinate.first
	var col = coordinate.second
	var num = forest[row][col]
	for(i in row+1 until forest.size) {
		if(forest[i][col] >= num) {
			return false
		}
	}
	return true
}