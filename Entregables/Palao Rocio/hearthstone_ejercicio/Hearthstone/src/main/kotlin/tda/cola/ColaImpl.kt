package tda.cola

import models.personajes.Personaje

/**
 * Implementación de una cola
 */
class ColaImpl: Cola, ArrayList<Personaje>() {
    /**
     * Añadir un dato a la cola.
     * @param dato Nuevo Personaje a añadir.
     */
    override fun encolar(dato: Personaje) {
        this.add(dato)
    }

    /**
     * Eliminar un dato de la cola.
     * @return el dato eliminado.
     */
    override fun desencolar(): Personaje {
        return this.removeAt(0)
    }


}