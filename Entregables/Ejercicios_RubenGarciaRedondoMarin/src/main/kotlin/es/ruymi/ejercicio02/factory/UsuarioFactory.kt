package es.ruymi.ejercicio02.factory

import es.ruymi.ejercicio03.models.Usuario
import es.ruymi.ejercicio03.models.Usuario03
import es.ruymi.ejercicio03.utils.Utils
import java.util.*

class UsuarioFactory() {
    fun usuarioCreator(): Usuario{
        return Usuario(UUID.randomUUID().toString(), Utils().nombreAleatorio(), Utils().correoAleatorio() )
    }
}