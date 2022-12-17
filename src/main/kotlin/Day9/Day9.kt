package Day9

fun day9PartOne(input: List<String>) {
	var head = Knot()
	var tail = Knot()
	for(line in input) {
		processInstruction(line,head,tail)
	}
	println(tail.historyHash.size)
}

fun day9PartTwo(input: List<String>) {
	var head = Knot()
	var t1 = Knot()
	head.child = t1
	var t2 = Knot()
	t1.child = t2
	var t3 = Knot()
	t2.child = t3
	var t4 = Knot()
	t3.child = t4
	var t5 = Knot()
	t4.child = t5
	var t6 = Knot()
	t5.child = t6
	var t7 = Knot()
	t6.child = t7
	var t8 = Knot()
	t7.child = t8
	var t9 = Knot()
	t8.child = t9
	for(line in input) {
		processDay2Instruction(line,head)
	}
	println(t9.historyHash.size)
}

fun processDay2Instruction(instruction: String, head: Knot) {
	var splitInstruction = instruction.split(" ")
	splitInstruction[0]
	repeat(splitInstruction[1].toInt()) {
		head.move(Direction.valueOf(splitInstruction[0]))
	}
}
fun processInstruction(instruction: String, head: Knot, tail: Knot) {
	var splitInstruction = instruction.split(" ")
	splitInstruction[0]
	repeat(splitInstruction[1].toInt()) {
		head.move(Direction.valueOf(splitInstruction[0]))
		tail.follow(head)
	}
}