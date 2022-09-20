import models.tablero.MatrizImpl

/**
 * Ejercicio Hearthstone
 * @author Rocío P.F
 * @version 1.0
 * github: Rochiio
 */
fun main(args: Array<String>) {
    val game = Juego(MatrizImpl())
    game.play()
}