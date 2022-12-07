package Day7

class ChristmasFileSystem {
    var rootDirectory: Directory? = null
    var currentDirectory: Directory? = null
    var totalUnder100000: Long = 0
    val totalSpace: Long = 70000000
    val neededSpace: Long = 30000000
    var remainingSpace: Long = 0
    var directoriesAboveNeededSpace: MutableSet<Long> = mutableSetOf()

    fun calculateRemainingSpace() {
        remainingSpace = totalSpace - getTotalSpace(rootDirectory, false)
    }

    fun findSizeOfIdealDeletion(): Long {
        getTotalSpace(rootDirectory, true)
        for(number in directoriesAboveNeededSpace) {
            println(number)
        }
        return directoriesAboveNeededSpace.stream().sorted().findFirst().get()
    }

    fun getTotalSpace(directory: Directory?, remainingSpaceCalculated: Boolean): Long {
        var totalSpace = 0L
        for(file in directory?.files!!) {
            totalSpace += file.value.size
        }
        for(child in directory?.directories?.values!!) {
            totalSpace += getTotalSpace(child,remainingSpaceCalculated)
        }
        if(remainingSpaceCalculated) {
            if(totalSpace >= neededSpace - remainingSpace) {
                directoriesAboveNeededSpace.add(totalSpace)
            }
        }
        return totalSpace
    }
    fun cd(destination: String) {
        if(destination == "..") {
            currentDirectory = currentDirectory?.parentDirectory
        }
        else if(currentDirectory?.directories?.contains(destination) == true) {
            currentDirectory = currentDirectory?.directories?.get(destination)
        }
        else {
            var newDirectory = Directory(destination)
            newDirectory.parentDirectory = currentDirectory
            if(rootDirectory == null) {
                rootDirectory = newDirectory
            }
            else {
                addDir(newDirectory)
            }
            currentDirectory = newDirectory
        }
    }
    private fun addDir(directory: Directory) {
        currentDirectory?.directories?.putIfAbsent(directory.name,directory)
    }
    private fun addFile(file: File) {
        currentDirectory?.files?.putIfAbsent(file.name,file)
    }

    fun executeInstruction(instruction: String) {
        var splitInstruction = instruction.split(" ")
        if(splitInstruction[0] == "$") {
            when(splitInstruction[1]) {
                "cd" -> cd(splitInstruction[2])
                "ls" -> Unit
            }
        }
        else if(splitInstruction[0] == "dir") {
            var directory = Directory(name = splitInstruction[1])
            directory.parentDirectory = currentDirectory
            addDir(directory)
        }
        else {
            var file = File(name = splitInstruction[1], size = splitInstruction[0].toLong())
            addFile(file)
        }
    }

    fun printAllDirectories(directory: Directory) {
        println("/" + directory.name)
        for(file in directory.files) {
            println(file.key)
        }
        for(child in directory.directories.values) {
            printAllDirectories(child)
        }
    }
    fun recursivelySum(directory: Directory): Long {
        var total: Long = 0
        for(file in directory.files) {
            total += file.value.size
        }
        for(child in directory.directories.values) {
            total += recursivelySum(child)
        }
        if(total <= 100000L) {
            totalUnder100000+=total
        }
        return total
    }
}