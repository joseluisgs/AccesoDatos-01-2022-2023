package models

import java.io.Serializable
import java.util.*

class Usuario(val uuid: String = UUID.randomUUID().toString(), val usuario: String? = "", val correo: String? = ""):
    Serializable {

    init {
        print("Usuario creado. \n")
    }

    override fun toString(): String {
        return "Usuario(uuid='$uuid', usuario=$usuario, correo=$correo)"
    }
}