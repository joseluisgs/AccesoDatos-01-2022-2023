package es.ruymi.ejercicio03.models

import es.ruymi.ejercicio03.utils.Utils03
import java.io.Serializable
import java.util.*

class Usuario constructor (private val uuid: String = UUID.randomUUID().toString(), private var nombre: String = Utils03().nombreAleatorio(), private var correo: String = "correo@prueba.com"): Serializable {

    override fun toString(): String {
        return "Usuario{uuid= $uuid , nombre= $nombre , correo= $correo }"
    }

}