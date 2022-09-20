package models.tablero

import factories.ItemFactory
import models.Item

/**
 * Implementación de la matriz
 */
class MatrizImpl: ArrayList<ArrayList<Casilla>>(), Matriz {

    /**
     * Inicializar la matriz
     * @param number Número de casillas que tendrá la matriz
     */
    override fun inicializarMatriz(number: Int) {
        for (i in 0 until number) {
            val column = ArrayList<Casilla>()
            for (j in 0 until number) {
                column.add(j, Casilla(ItemFactory.itemFactory()))
            }
            this.add(column)
        }
    }


    /**
     * Conseguir casilla
     * @param fil Fila de la casilla
     * @param col Columna de la casilla
     * @return la casilla elegida.
     */
    override fun getCasilla(fil: Int, col: Int): Casilla {
        return this[fil][col]
    }


    /**
     * Cambiar el item a una casilla.
     * @param itemNew El nuevo tipo de item a poner.
     * @param fil Fila de la Casilla
     * @param col Columna de la casilla
     */
    override fun setCasillaItem(itemNew: Item?, fil: Int, col: Int) {
        this[fil][col].item = itemNew
    }

}