import java.io.File
import java.nio.file.Files
import java.nio.file.StandardCopyOption

fun main(){
    File("fichero1.txt").createNewFile()
    File("fichero2.txt").createNewFile()

    println("Se va a realizar una copia del fichero 1 en el fichero 2. ¿Desea sobrescribirlo? (si/no): ")
    if( leerRespuesta() == "Si" || leerRespuesta() == "si" ){
        Files.copy(File("fichero1.txt").toPath(), File("fichero2.txt").toPath(), StandardCopyOption.REPLACE_EXISTING)
    }

    println("Se ha movido el fichero 1 como fichero 2")
    Files.move(File("fichero1.txt").toPath(), File("fichero2.txt").toPath(), StandardCopyOption.REPLACE_EXISTING)



}

fun leerRespuesta(): String {
    var respuesta = ""
    do {
        println("Dime una repuesta correcta (si/no):")
        respuesta = readln()
        val respuestaIsOk = respuesta.matches(Regex("si|Si|No|no"))
    } while (!respuestaIsOk)
    return respuesta

}