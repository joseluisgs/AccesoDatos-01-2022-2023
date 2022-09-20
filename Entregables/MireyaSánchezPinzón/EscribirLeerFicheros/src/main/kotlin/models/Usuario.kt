package models

import java.util.*

class Usuario(val id: UUID, val username: String, val mail: String) {

    override fun toString(): String {
        return "Usuario(id=$id, username='$username', mail='$mail')"
    }
}