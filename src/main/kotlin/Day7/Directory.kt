package Day7

class Directory(
    name: String = ""
) {
    var name: String = name
    var parentDirectory: Directory? = null
    var directories: MutableMap<String, Directory> = mutableMapOf()
    var files: MutableMap<String, File> = mutableMapOf()
}