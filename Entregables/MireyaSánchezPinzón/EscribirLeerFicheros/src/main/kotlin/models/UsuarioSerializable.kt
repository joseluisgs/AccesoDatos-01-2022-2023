package models

import java.io.Serializable
import java.util.*

class UsuarioSerializable(val id: UUID, val username: String, val mail: String) : Serializable {
        override fun toString(): String {
            return "Usuario(id=$id, username='$username', mail='$mail')"
        }
}
