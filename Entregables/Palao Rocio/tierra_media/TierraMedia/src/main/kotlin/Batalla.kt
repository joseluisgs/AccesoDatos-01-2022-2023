import models.ejercitos.EjercitoBondadoso
import models.ejercitos.EjercitoMalvado
import models.enums.RazasBondadosas
import models.enums.RazasMalvadas

class Batalla(
    val bondadosos: EjercitoBondadoso = EjercitoBondadoso(),
    val malvados: EjercitoMalvado = EjercitoMalvado()
    ) {

    /**
     * Al inicializar se presentan a los 2 ejércitos.
     */
    init {
        presentacion()
    }


    /**
     * Batalla
     * @param times Veces que se va a repetir las batallas
     */
    fun playBattle(times:Int){
        repeat(times){
            val winner:String = fight()
            println(winner)
        }
    }


    /**
     * Presentación de los dos ejércitos
     */
    private fun presentacion() {
        println(bondadosos.toString())
        println()
        println(malvados.toString())
        println()
    }


    /**
     * La batalla.
     * Ganan dependiendo del valor de la raza y del número de personajes de esa raza que hayan salido.
     */
    private fun fight():String{
        val personajeBondadoso: RazasBondadosas = RazasBondadosas.values()[(0..4).random()]
        val numberPersonajeBondadoso:Int = (1..bondadosos.numberOfPersonaje(personajeBondadoso)).random()
        val personajeMalvado: RazasMalvadas = RazasMalvadas.values()[(0..4).random()]
        val numberPersonajeMalvado:Int = (1..malvados.numberOfPersonaje(personajeMalvado)).random()

        return when{
            ((personajeBondadoso.value*numberPersonajeBondadoso)>(personajeMalvado.value*numberPersonajeMalvado)) ->
                "$numberPersonajeBondadoso $personajeBondadoso gana contra $numberPersonajeMalvado $personajeMalvado"
            ((personajeBondadoso.value*numberPersonajeBondadoso)<(personajeMalvado.value*numberPersonajeMalvado)) ->
                "$numberPersonajeBondadoso $personajeBondadoso pierde contra $numberPersonajeMalvado $personajeMalvado"
            else -> "$numberPersonajeBondadoso $personajeBondadoso empata contra $numberPersonajeMalvado $personajeMalvado"
        }

    }


}