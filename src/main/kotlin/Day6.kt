fun day6PartOne(input: List<String>) {
	var windowedInput = input[0].windowed(4,1)
	var startOfPacketFound = false
	var startOfPacket = 0
	var i = 0
	while(!startOfPacketFound) {
		var isAllMatch = windowedInput.take(i+1).last()
		println(isAllMatch)
		println(isAllMatch)
		if(isAllMatch.allUnique()) {
			println("found start of packet!")
			startOfPacketFound = true
			startOfPacket = i+4
		}
		i++
	}
	println(startOfPacket)
}

fun day6PartTwo(input: List<String>) {
	var windowedInput = input[0].windowed(14,1)
	var startOfPacketFound = false
	var startOfPacket = 0
	var i = 0
	while(!startOfPacketFound) {
		var isAllMatch = windowedInput.take(i+1).last()
		println(isAllMatch)
		if(isAllMatch.allUnique()) {
			println("fount start-of-message")
			startOfPacketFound = true
			startOfPacket = i+14
		}
		i++
	}
	println(startOfPacket)
}

fun String.allUnique(): Boolean = all(hashSetOf<Char>()::add)