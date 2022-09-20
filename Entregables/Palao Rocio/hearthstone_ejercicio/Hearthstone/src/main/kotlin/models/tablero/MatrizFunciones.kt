package models.tablero

import models.Item


interface MatrizFunciones{
    fun inicializarMatriz(number: Int)
    fun getCasilla(fil:Int, col:Int): Casilla

    fun setCasillaItem(itemNew: Item?, fil:Int, col:Int)
}