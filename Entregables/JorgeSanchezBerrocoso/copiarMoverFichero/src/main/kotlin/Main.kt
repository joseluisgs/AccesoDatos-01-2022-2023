import java.io.File
import java.nio.file.Files
import java.nio.file.StandardCopyOption

fun List(): ArrayList<String> {
    var ficheros = ArrayList<String>()
    println("Meta la direccion de un fichero")
    var fichero = readln()
    ficheros.add(fichero)
    return ficheros
}

fun main() {
    var fichero : ArrayList<String>
    fichero = List()

    if (fichero.size != 1) {
        println("Error, debe indicar la ruta del fichero")
        return
    }

    val fichero1 = fichero[0]
    if (!File(fichero1).exists()){
        println("Error, el fichero no existe")
        return
    }



    println("Desea copiar el fichero: si/no")
    var sino = readln()

    if (sino.equals("si")){
        println("Indique la ruta donde quiere copiarlo")
        var rutaDestino = readln()
        Files.copy(File(fichero1).toPath(), File(rutaDestino).toPath(), StandardCopyOption.REPLACE_EXISTING)
    }

    println("Desea mover el fichero: si/no")
    var siinoo = readln()
    if (sino.equals("si")){
        println("Indique la ruta donde quiere copiarlo")
        var rutaDestino = readln()
        Files.move(File(fichero1).toPath(), File(rutaDestino).toPath(), StandardCopyOption.REPLACE_EXISTING)
    }





}


