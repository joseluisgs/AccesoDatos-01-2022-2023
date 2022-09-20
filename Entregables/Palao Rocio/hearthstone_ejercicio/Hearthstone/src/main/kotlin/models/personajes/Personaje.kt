package models.personajes

import models.Item
import java.time.LocalDate
import java.util.UUID

abstract class Personaje(open val nombre:String, open var vida:Int ) {
    val id:UUID = UUID.randomUUID()
    val fechaCreacion : LocalDate = LocalDate.now()
    val nivel : Int = (1..3).random()
    var listaItems: ArrayList<Item> = ArrayList()


    fun listaOrdenada(): List<Item> {
        return listaItems.sortedBy { it.fecha }
    }

    open fun setItem(item: Item){
        this.listaItems.add(item)
    }
    abstract fun mostrarEstado():String
}