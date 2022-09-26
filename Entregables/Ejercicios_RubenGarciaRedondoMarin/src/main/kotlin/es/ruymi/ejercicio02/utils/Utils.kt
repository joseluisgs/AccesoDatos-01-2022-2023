package es.ruymi.ejercicio03.utils

import es.ruymi.ejercicio02.factory.UsuarioFactory
import es.ruymi.ejercicio03.models.Usuario
import es.ruymi.ejercicio03.models.Usuario03

class Utils() {
    fun nombreAleatorio(): String {
        val lista = listOf<String>(
            "Manolo",
            "Vladimir",
            "Ruben",
            "Alejandro",
            "Mireya",
            "Alvaro",
            "Pedro",
            "Maria",
            "Isabel",
            "Raul"
        )
        return lista.random()
    }

    fun correoAleatorio(): String {
        val lista = listOf(
            "prueba1@gmail.com",
            "prueba2@gmail.com",
            "prueba3@gmail.com",
            "prueba4@gmail.com",
            "prueba5@gmail.com",
            "prueba6@gmail.com",
            "prueba7@gmail.com",
            "prueba8@gmail.com",
            "prueba9@gmail.com",
    )
        return lista.random()
    }

    fun rellenarListaUsuario(lista: ArrayList<Usuario>, n: Int): ArrayList<Usuario> {
        repeat(n) {
            lista.add(UsuarioFactory().usuarioCreator())
        }
        return lista
    }

    fun comprobarSeleccion(res: String): Boolean {
        val reg = Regex("Si | SI | si | sI | no |No | nO | NO")
        return reg.matches(res)
    }
}



