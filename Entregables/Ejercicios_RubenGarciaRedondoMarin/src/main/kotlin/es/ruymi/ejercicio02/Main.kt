package es.ruymi.ejercicio02

import es.ruymi.ejercicio03.models.Usuario
import es.ruymi.ejercicio03.utils.Utils
import java.io.File
import java.util.*
import kotlin.collections.ArrayList

//Hacer una aplicación que copie o mueva ficheros, preguntando si quiere sobreescribir o no.



fun main() {
    var ruta1 = ""
    val lista = ArrayList<Usuario>()
    Utils().rellenarListaUsuario(lista, 10)
    println("Dime el archivo a copiar:")
    ruta1 = readln()
    println("Dime la ruta de destino:")
    val rutaDestino = readln()
    val ruta2 = File(rutaDestino)
    val fichero = File(rutaDestino)
    if(fichero.exists()){
        println("El archivo en la ruta $ruta2 existe, ¿deseas sobreescribirlo?")
        do{
            var sel = ""
            var res = false
            sel = readln()
            res = Utils().comprobarSeleccion(sel)
            if(!res){
                if(sel.uppercase(Locale.getDefault()) == "SI"){
                    File(ruta1).copyTo(ruta2)
                    println("Fichero copiado correctamente")
                }else{
                    println("Fichero no copiado")
                    res = true;
                }
            }else{
                println("Selección no válida")
            }
        }while(!res)


    }


}


