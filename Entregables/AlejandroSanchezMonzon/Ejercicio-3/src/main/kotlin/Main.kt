import models.Usuario
import java.io.File
import java.nio.file.Paths
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val lista = ArrayList<Usuario>()
    val lista2 = ArrayList<Usuario>()
    val ruta: String = Paths.get("").toAbsolutePath().toString()
    val ficheroPath = "$ruta${File.separator}data${File.separator}fichero.txt"
    val ficheroPath2 = "$ruta${File.separator}data${File.separator}ficheroB.txt"

    if (File(ficheroPath).startsWith(" ")) {
        println("Datos actualizados.")
    } else {
        lista.add(Usuario(UUID.randomUUID().toString(), "Pepe", "correo1@prueba.com"))
        lista.add(Usuario(UUID.randomUUID().toString(), "Juan", "correo2@prueba.com"))
        lista.add(Usuario(UUID.randomUUID().toString(), "Antonio", "correo3@prueba.com"))

        File(ficheroPath).writeText(lista.toString())
    }

    if (File(ficheroPath2).startsWith(" ")) {
        println("Datos actualizados.")
    } else {
        lista2.add(Usuario(UUID.randomUUID().toString(), "Pepe", "correo1@prueba.com"))
        lista2.add(Usuario(UUID.randomUUID().toString(), "Juan", "correo2@prueba.com"))
        lista2.add(Usuario(UUID.randomUUID().toString(), "Antonio", "correo3@prueba.com"))

        File(ficheroPath2).writeBytes(lista2.toString().toByteArray())
    }

    val listaPrintada = File(ficheroPath).readText()
    println(listaPrintada)

    val listaPrintada2 = File(ficheroPath).readBytes().toString(Charsets.UTF_8)
    println(listaPrintada2)

    println("")

    println("Vamos a añadir otro dato al fichero de texto -> ")
    addDatoTexto(lista, ficheroPath)

    println("Vamos a añadir otro dato al fichero binario -> ")
    addDatoBinario(lista2, ficheroPath2)
}

fun addDatoBinario(lista2: ArrayList<Usuario>, ficheroPath2: String) {
    var nombre = ""
    var correo = ""

    println("Dime el nombre: ")
    nombre = readln()

    println("Dime el correo: ")
    correo = readln()

    val newUsuario = Usuario(UUID.randomUUID().toString(), nombre, correo)
    lista2.add(newUsuario)

    File(ficheroPath2).writeBytes(lista2.toString().toByteArray())
    println(lista2.toString())
}

fun addDatoTexto(lista: ArrayList<Usuario>, ficheroPath: String) {
    var nombre = ""
    var correo = ""

    println("Dime el nombre: ")
    nombre = readln()

    println("Dime el correo: ")
    correo = readln()

    val newUsuario = Usuario(UUID.randomUUID().toString(), nombre, correo)
    lista.add(newUsuario)

    File(ficheroPath).writeText(lista.toString())
    println(lista.toString())
}