fun day7PartOne(input: List<String>) {
	var root = Directory("/")
	var currentDirectory: String? = "/"
	var directoriesAtMost100000: MutableMap<String, Long> = mutableMapOf()
	for(line in input) {
		println("executing line $line")
		var splitLine = line.split(" ")
		if(splitLine[0] == "$") {
			when(splitLine[1]) {
				"cd" -> currentDirectory = changeDirectory(splitLine[2], root, currentDirectory)
				"ls" -> continue
			}
		}
		else if(splitLine[0] == "dir") {
			var directory = Directory(name = splitLine[1])
			directory.parentDirectory = findDirectory(root,currentDirectory)
			findDirectory(root,currentDirectory)?.directories?.putIfAbsent(directory.name,directory)
		}
		else {
			var file = File(name = splitLine[1], size = splitLine[0].toLong())
			findDirectory(root,currentDirectory)?.files?.putIfAbsent(file.name,file)
		}
	}


	recursivelySumAllFiles(root, directoriesAtMost100000)

	var answer = directoriesAtMost100000.values.sum()
	println(answer)
}

fun recursivelySumAllFiles(directory: Directory, directoriesAtMost100000: MutableMap<String,Long>) : Long{
	var total:Long = 0
	for(file in directory.files) {
		total += file.value.size
	}
	for(child in directory.directories.values) {
		total += recursivelySumAllFiles(child, directoriesAtMost100000)
	}
	if(total <= 100000) {
		directoriesAtMost100000.put(directory.name,total)
	}
	return total

}
fun changeDirectory(directoryName: String, root: Directory, currentDirectory: String?): String? {
	var current: Directory? = findDirectory(root, currentDirectory)
	if(directoryName == "..") {
		return current?.parentDirectory?.name
	}
	var directory = current?.directories?.get(directoryName)
	return if(directory != null) {
		return directory.name
	}
	else {
		if(directoryName.equals("/")) return "/"
		var newDirectory = Directory(directoryName)
		newDirectory.parentDirectory = current
		current?.directories?.putIfAbsent(newDirectory.name,newDirectory)
		return newDirectory.name
	}
}

fun findDirectory(directory:Directory, currentDirectory: String?): Directory? {
	if(currentDirectory.equals("/")) return directory
	for(child in directory.directories.values) {
		if(child.name.equals(currentDirectory)) {
			return child
		}
		else {
			var maybe = findDirectory(child, currentDirectory)
			if(maybe != null) {
				return maybe
			}
		}
	}
	return null
}

class Directory(
	name: String = ""
) {
	var name: String = name
	var parentDirectory: Directory? = null
	var directories: MutableMap<String,Directory> = mutableMapOf()
	var files: MutableMap<String,File> = mutableMapOf()
}

class File(
	var name: String = "",
	var size: Long = 0
) {

}