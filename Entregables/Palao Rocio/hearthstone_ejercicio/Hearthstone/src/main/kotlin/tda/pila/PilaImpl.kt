package tda.pila

import models.Item

/**
 * Implementación de una pila
 */
class PilaImpl: Pila, ArrayList<Item>(){
    /**
     * Añadir un dato a la pila.
     * @param dato Nuevo item a añadir.
     */
     fun apilar(dato: Item) {
        this.add(dato)
    }


    /**
     * Eliminar un dato de la pila.
     * @return el dato eliminado.
     */
     fun desapilar(): Item {
        return this.removeAt(this.size-1)
    }


}