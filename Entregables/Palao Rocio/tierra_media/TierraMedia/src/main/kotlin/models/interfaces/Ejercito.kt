package models.interfaces
/**
 * Interfaz para los ejércitos que se creen
 */
interface Ejercito<T> {

    /**
     * Función para dar un número aleatorio de personajes del ejército.
     */
    fun functionRandom():Int = (1..10).random()

    /**
     * Número de la raza del personaje
     */
    fun numberOfPersonaje(personaje: T):Int
}