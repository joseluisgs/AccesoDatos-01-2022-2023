package models.personajes

import models.enums.PersonajeEnum
/**
 * Tipo de personaje: Elfo
 */
class Elfos(
    override val nombre:String="",
    override var vida:Int = 50
) : Personaje(nombre,vida) {
    var inmortalidad:Int =10
    val tipo:PersonajeEnum = PersonajeEnum.ELFO

    override fun mostrarEstado(): String {
        return "------------- \n" +
                "Estado del Personaje:  ${super.id}\n" +
                "Nombre: $nombre, Tipo: $tipo, " +
                "Vida: $vida, Inmortalidad: $inmortalidad \n" +
                "Fecha Creación: ${super.fechaCreacion}, Nivel: ${super.nivel} \n"+
                "Lista de items: ${super.listaOrdenada()} \n" +
                "------------"
    }

}