package factories

import models.Item
import models.enums.ItemsEnum

/**
 * Creación de items aleatorios
 */
object ItemFactory {

    fun itemFactory():Item{
    val tipo = when((1..4).random()){
                1 -> ItemsEnum.COMIDA
                2 -> ItemsEnum.HECHIZO
                3 -> ItemsEnum.POCION
                else -> {
                    ItemsEnum.MATERIAL
                }
             }
     return Item(tipo)
    }
}