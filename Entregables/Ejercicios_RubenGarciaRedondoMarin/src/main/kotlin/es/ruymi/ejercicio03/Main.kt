package es.ruymi.ejercicio03

import es.ruymi.ejercicio03.utils.Utils03
import es.ruymi.ejercicio03.models.Usuario03
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.util.*
import kotlin.collections.ArrayList

//Hacer una lista con 3 usuarios (UUID, nombre, correo). Que esa lista la pase a un fichero de texto y luego lo lea,
// que se pueda añadir al fichero (es decir, que se pueda añadir sobre ese fichero), y hacerlo también con ficherios
//binarios


fun main(){
    val lista = ArrayList<Usuario03>()
    val fichero = File("lista.txt")
    var nombre: String = ""
    var correo: String = ""

    repeat(3){ lista.add(Usuario03(UUID.randomUUID().toString(), Utils03().nombreAleatorio(), "correo@prueba.es")) }
    if(!fichero.exists() || fichero.startsWith(" ")){
        fichero.delete()
        fichero.writeText(lista.toString())
    }

    val listaUsuarios = File("lista.txt").readText()
    println("listaUsuarios: $listaUsuarios")

    println("Dime un nombre: ")
    nombre = readln()
    println("Dime un correo: ")
    correo = readln()
    val usuario = Usuario03(UUID.randomUUID().toString(), nombre, correo)
    fichero.appendText(" $usuario")

    //fichero con binario

    val write = ObjectOutputStream(FileOutputStream("ficheroBinario"))
    write.writeObject(usuario)

    //Ahora leemos el fichero binario
    val reader = ObjectInputStream(FileInputStream("ficheroBinario"))
    println(reader.readObject().toString())

    //Vamos a meter en ese fichero otro usuario mas
    write.writeObject(usuario)


}