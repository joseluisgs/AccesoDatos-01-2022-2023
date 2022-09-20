package models

import models.enums.ItemsEnum
import java.time.LocalDate
import java.util.UUID

/**
 * Items
 */
data class Item (val tipo: ItemsEnum){
    val id:UUID = UUID.randomUUID()
    val fecha: LocalDate = LocalDate.now()
    val nivel:Int =(1..3).random()
}