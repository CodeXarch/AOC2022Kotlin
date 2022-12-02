fun Day1(input: List<String>) {
    var elfList = mutableListOf<MutableList<Int>>()
    var elfNum = 0
    elfList.add(mutableListOf())
    for(i in input.indices) {
        if(input[i].isBlank()) {
            elfList.add(mutableListOf())
        }
        else {
            elfList.last().add(Integer.valueOf(input[i]))
        }
    }
    for(elf in elfList) {
        println("I'm an elf! I have:")
        for(calorieFood in elf) {
            println(calorieFood)
        }
    }
    var max = elfList.stream().map { item -> item.sum() }.sorted(Comparator{ o1, o2 -> o2 - o1 }).limit(3).reduce(Integer::sum)
    println("Most calories: $max")
}
