package models.ejercitos

import models.enums.RazasBondadosas
import models.interfaces.Ejercito

/**
 * Clase del Ejercito Bondadoso
 */
class EjercitoBondadoso: Ejercito<RazasBondadosas> {

    private val numPelosos: Pair<RazasBondadosas,Int> = Pair(RazasBondadosas.PELOSOS, functionRandom())
    private val numSurenos: Pair<RazasBondadosas,Int> = Pair(RazasBondadosas.SUREÑOS_BUENOS, functionRandom())
    private val numEnanos: Pair<RazasBondadosas,Int> = Pair(RazasBondadosas.ENANOS, functionRandom())
    private val numNumenoreanos: Pair<RazasBondadosas,Int> = Pair(RazasBondadosas.NUMENOREANOS, functionRandom())
    private val numElfos: Pair<RazasBondadosas,Int> = Pair(RazasBondadosas.ELFOS, functionRandom())


    override fun toString(): String {
        return "Ejército Bondadoso 😇 \n" +
                " ${numPelosos.first} con un total de ${numPelosos.second} \n" +
                " ${numSurenos.first} con un total de ${numSurenos.second} \n" +
                " ${numEnanos.first} con un total de ${numEnanos.second} \n" +
                " ${numNumenoreanos.first} con un total de ${numNumenoreanos.second} \n" +
                " ${numElfos.first} con un total de ${numElfos.second}"
    }


    /**
     * Número de la raza del personaje
     */
    override fun numberOfPersonaje(personaje: RazasBondadosas):Int{
        return when(personaje){
            RazasBondadosas.PELOSOS -> numPelosos.second
            RazasBondadosas.SUREÑOS_BUENOS -> numSurenos.second
            RazasBondadosas.ENANOS -> numEnanos.second
            RazasBondadosas.NUMENOREANOS -> numNumenoreanos.second
            RazasBondadosas.ELFOS -> numElfos.second
        }
    }


}