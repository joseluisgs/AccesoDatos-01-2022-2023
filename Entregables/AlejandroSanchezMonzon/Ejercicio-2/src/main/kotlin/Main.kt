import java.io.File
import java.nio.file.Files
import java.nio.file.StandardCopyOption

fun main() {
    println("Copia aquí la ruta del primer fichero: ")
    val fichero1 = readln()

    println("Copia aquí la ruta del segundo fichero: ")
    val fichero2 = readln()

    if (!File(fichero1).exists()) {
        println("No existe el primer fichero.")
        return
    }

    if (File(fichero2).exists()) {
        println("El segundo fichero ya existe. ¿Desea sobreescribirlo? [si/no]")
        val input = readln()

        if (input != "si" && input != "SI") {
            println("Error al copiar el fichero")
            return
        }
    }

    Files.move(File(fichero1).toPath(), File(fichero2).toPath(), StandardCopyOption.REPLACE_EXISTING)
}