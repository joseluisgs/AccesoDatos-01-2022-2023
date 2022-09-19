import java.io.File
import java.nio.file.InvalidPathException

fun main(args: Array<String>) {

    //Handle path argument
    args.handlePathArg()

    //More args?
}

private fun Array<String>.handlePathArg() {
    firstOrNull { it.startsWith("--path=") }
        ?.removePrefix("--path=")
        ?.apply { if (isNullOrEmpty()) throw IllegalArgumentException("Path cannot be empty") }
        ?.let { File(it) }
        ?.apply { if (!exists()) throw InvalidPathException(absolutePath, "Path does not exist") }
        ?.printPathInfo()
        ?: throw IllegalArgumentException(
            "No path argument specified, please use --path=<path> to specify the path"
        )
}

private fun File.printPathInfo() {
    println("Absolute Path: $absolutePath")
    println("Can write: ${canWrite()}")
    println("Can read: ${canRead()}")
    println("Can execute: ${canExecute()}")
    printSubFoldersInfo()
}

private fun File.printSubFoldersInfo() {
    listFiles()
        ?.apply { if (any()) println("SubFolders:") }
        ?.forEach {
            println(" - ${it.name}")
            println("    Can write: ${it.canWrite()}")
            println("    Can read: ${it.canRead()}")
            println("    Can execute: ${it.canExecute()}")
        }
}