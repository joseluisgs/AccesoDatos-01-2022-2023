import Models.Usuario
import java.io.File
import java.nio.file.InvalidPathException
import java.util.*
import kotlin.collections.ArrayList

fun main(){
    println("Introduceme el path")
    var path = readlnOrNull()

    println("Introduceme el primer nombre")
    val nombre1 =readlnOrNull()
    println("Introduceme el primer correo")
    val correo1 = readlnOrNull()

    println("Introduceme el segundo nombre")
    val nombre2 =readlnOrNull()
    println("Introduceme el segundo correo")
    val correo2 = readlnOrNull()

    println("Introduceme el tercer nombre")
    val nombre3 =readlnOrNull()
    println("Introduceme el tercer correo")
    val correo3 = readlnOrNull()

    var lista = ArrayList<Usuario>()
    lista.add(Usuario(UUID.randomUUID().toString(),"$nombre1","$correo1"))
    lista.add(Usuario(UUID.randomUUID().toString(),"$nombre2","$correo2"))
    lista.add(Usuario(UUID.randomUUID().toString(),"$nombre3","$correo3"))

    escribirFicheroTexto(lista,path)
    leerFicheroTexto(path)

}



private fun escribirFicheroTexto(array: ArrayList<Usuario>, path: String?){
    File(path).writeText(array.toString())
}


private fun leerFicheroTexto(path:String?){
   val txt = File(path).readText()
    println(txt)
}











