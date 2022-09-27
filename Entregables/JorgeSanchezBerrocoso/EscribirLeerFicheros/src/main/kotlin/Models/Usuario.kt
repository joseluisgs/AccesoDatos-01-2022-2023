package Models

import java.io.Serializable
import java.util.*

class Usuario(val id: String = UUID.randomUUID().toString(), var nombre : String?,var correo: String?) : Serializable {
  init {
      println("Se ha creado el usuario")
  }
    override fun toString(): String{
        return "Usuario(uuid: $id, nombre: $nombre, correo: $correo)"
    }
}