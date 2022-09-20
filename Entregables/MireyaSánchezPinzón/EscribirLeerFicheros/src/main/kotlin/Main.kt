import creators.UsuarioCreator
import models.Usuario
import models.UsuarioSerializable
import java.io.*
import java.util.*

fun main(){
    val lista = ArrayList<Usuario>()

    repeat(3){
        lista.add(UsuarioCreator().createRandom())
    }

    val fichero = File("fichero.txt")

    if (!fichero.startsWith(" ")) {
        //Escribo
        fichero.writeText(lista.toString())
    }

    //Leemos
    var lectura = fichero.readText()
    println(lectura)

    //Insertamos un nuevo usuario desde la terminal
    val nuevoUsuario = UsuarioCreator().createFromTerminal()
    fichero.appendText(nuevoUsuario.toString())

    //Leemoos el fichero actualizado
    lectura = fichero.readText()
    println(lectura)

    //Archivos Binarios
    val listaSerializable = ArrayList<UsuarioSerializable>()

    repeat(3){
        listaSerializable.add(UsuarioCreator().createRandomSerializable())
    }

    val ficheroBinario = File("ficheroBinario.txt")
    ObjectOutputStream(FileOutputStream(ficheroBinario)).use { it -> it.writeObject(listaSerializable) }

    ObjectInputStream(FileInputStream(ficheroBinario)).use { it -> it.readObject() }.also { println(it) }
    ObjectInputStream(FileInputStream(ficheroBinario)).use { it -> println(it.readObject()) }

}












