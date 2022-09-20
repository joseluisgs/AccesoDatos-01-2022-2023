package creators

import models.Usuario
import models.UsuarioSerializable
import java.util.*

class UsuarioCreator(){
    
    fun createFromTerminal() : Usuario {
        return Usuario(UUID.randomUUID(), leerUsuario(), leerCorreo())
    }

    private fun leerCorreo(): String {
        var email = ""
        do {
            println("Dime un email correcto")
            email = readln()
            var emailIsOk = email.matches(Regex("[a-zA-Z0-9]+@[a-z]+\\.[a-z]{2,3}"))
        } while (!emailIsOk)
        return email

    }

    private fun leerUsuario(): String {
        println("Dime un nombre")
        return readln()
    }

    fun createRandom(): Usuario {
        return Usuario(UUID.randomUUID(), nombreRandom(), emailRandom() )
    }

    fun createRandomSerializable(): UsuarioSerializable {
        return UsuarioSerializable(UUID.randomUUID(), nombreRandom(), emailRandom() )
    }

    fun nombreRandom(): String{
        val lista = listOf("Pepe", "Alfonso", "Juanito", "Maria", "Natalia", "Eva", " Manolo")
        return lista[(Math.random()*(lista.size)).toInt()]
    }

    fun emailRandom(): String{
        var lista = listOf("email@gmail.com", "email@hotmail.com", "email@educamadrid.com", "correo@gmail.com", "correo5@gmail.com" )
        return lista[(Math.random()*(lista.size)).toInt()]
    }
}