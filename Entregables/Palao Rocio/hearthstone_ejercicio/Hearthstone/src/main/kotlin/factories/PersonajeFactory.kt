package factories

import models.personajes.Elfos
import models.personajes.Humanos
import models.personajes.Personaje
import models.personajes.Trasgos

/**
 * Creación de personajes aleatorio.
 */
object PersonajeFactory {
    private val nombresElfo = listOf("Abraahham Alcolädorl", "Róbertörl Pávonnerl" ,"Bëatrisz Sánchëzrl")
    private val nombresHumano = listOf("Gemarr de Torricond", "Kevyn Valdeswyn" , "Víctoref Fernándezred")
    private val nombresTrasgo = listOf("Jesússr Benaventantad" , "Albertonnf Ruizrd")



    fun personajeFactory(): Personaje {
        val personaje = when((1..3).random()){
            1 -> Elfos(nombre = nombresElfo.random())
            2 -> Humanos(nombre = nombresHumano.random())
            else -> {
                Trasgos(nombre = nombresTrasgo.random())
            }
        }
        return personaje
    }
}