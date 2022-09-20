package models.personajes

import models.enums.PersonajeEnum

/**
 * Tipo de personaje: Trasgo
 */
class Trasgos(
    override val nombre:String="",
    override var vida:Int = 40
) : Personaje(nombre,vida) {
    var maldad:Int =15
    val tipo: PersonajeEnum = PersonajeEnum.TRASGO

    override fun mostrarEstado(): String {
        return "------------\n" +
                "Estado del Personaje:  ${super.id}\n" +
                "Nombre: $nombre, Tipo: $tipo, " +
                "Vida: $vida, Maldad: $maldad \n" +
                "Fecha Creación: ${super.fechaCreacion}, Nivel: ${super.nivel} \n"+
                "Lista de items: ${super.listaOrdenada()} \n" +
                "------------"
    }

}