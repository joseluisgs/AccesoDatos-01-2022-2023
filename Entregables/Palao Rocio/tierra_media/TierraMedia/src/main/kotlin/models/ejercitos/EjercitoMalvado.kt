package models.ejercitos

import models.enums.RazasMalvadas
import models.interfaces.Ejercito
/**
 * Clase del Ejercito Malvado
 */
class EjercitoMalvado : Ejercito<RazasMalvadas> {
    private val numSurenos: Pair<RazasMalvadas,Int> = Pair(RazasMalvadas.SUREÑOS_MALOS, functionRandom())
    private val numOrcos: Pair<RazasMalvadas,Int> = Pair(RazasMalvadas.ORCOS, functionRandom())
    private val numGoblins: Pair<RazasMalvadas,Int> = Pair(RazasMalvadas.GOBLINS, functionRandom())
    private val numHuargos: Pair<RazasMalvadas,Int> = Pair(RazasMalvadas.HUARGOS, functionRandom())
    private val numTrolls: Pair<RazasMalvadas,Int> = Pair(RazasMalvadas.TROLLS, functionRandom())

    override fun toString(): String {
        return "Ejército Malvado 😈 \n" +
                " ${numSurenos.first} con un total de ${numSurenos.second} \n" +
                " ${numOrcos.first} con un total de ${numOrcos.second} \n" +
                " ${numGoblins.first} con un total de ${numGoblins.second} \n" +
                " ${numHuargos.first} con un total de ${numHuargos.second} \n" +
                " ${numTrolls.first} con un total de ${numTrolls.second}"
    }


    /**
     * Número de la raza del personaje
     */
    override fun numberOfPersonaje(personaje: RazasMalvadas):Int{
        return when(personaje){
            RazasMalvadas.SUREÑOS_MALOS -> numSurenos.second
            RazasMalvadas.ORCOS -> numOrcos.second
            RazasMalvadas.GOBLINS -> numGoblins.second
            RazasMalvadas.HUARGOS -> numHuargos.second
            RazasMalvadas.TROLLS -> numTrolls.second
        }
    }
}