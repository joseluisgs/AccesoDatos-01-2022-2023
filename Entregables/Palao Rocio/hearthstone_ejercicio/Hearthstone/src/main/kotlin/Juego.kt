import factories.ItemFactory
import factories.PersonajeFactory
import models.Item
import models.enums.ItemsEnum
import models.personajes.Elfos
import models.personajes.Humanos
import models.personajes.Personaje
import models.personajes.Trasgos
import models.tablero.Matriz
import tda.cola.ColaImpl
import tda.pila.PilaImpl
import utils.Input

class Juego(private var tablero:Matriz) {
    private var tiempo:Int
    private val tamTablero:Int
    private var caballerosDeElrond: ColaImpl = ColaImpl()
    private var amazonasDeIsengard: ColaImpl = ColaImpl()
    private var listaItems: PilaImpl = PilaImpl()


    /**
     * Pedir datos para iniciar el juego
     */
    init {
        tamTablero = Input.pedirTablero()
        tiempo = Input.pedirSegundos()
        addPersonajes()
        addItems()
        tablero.inicializarMatriz(tamTablero)
    }


    /**
     * Función principal para saber hasta cuándo debe seguir el juego.
     */
    fun play(){
        do {
            turnoCaballeros()
            turnoAmazonas()
            if (tiempo%5==0){
                reponer()
            }
            --tiempo
        }while (tiempo>0 && !ganadores() && listaItems.size>0)
        informe()
    }


    /**
     * Informe de las batallas.
     */
    private fun informe() {
       val listaCaballeros = caballerosDeElrond.sortedByDescending { it.listaItems.size}
       val listaAmazonas = amazonasDeIsengard.sortedByDescending { it.listaItems.size }


        println("Informe de resultados:\n" +
                "\nEquipo Caballeros de Elrond🧙🏻‍:")
        listaCaballeros.forEach { a ->  println(a.mostrarEstado())}
        println("\nEquipo Amazonas de Isengard🧝🏻‍:")
        listaAmazonas.forEach { a -> println(a.mostrarEstado()) }

    }


    /**
     * Reponer el tablero de items donde se haya quedado vacío
     */
    private fun reponer() {
        for (i in 0 until tamTablero){
            for (j in 0 until tamTablero){
                tablero.getCasilla(i,j).item ?: tablero.setCasillaItem(listaItems.desapilar(),i, j)
            }
        }
    }


    /**
     * Acciones a realizar por las amazonas en su turno
     */
    private fun turnoAmazonas() {
        val jugadorSacado= amazonasDeIsengard.desencolar()
        val fila = (0 until tamTablero).random()
        val columna = (0 until tamTablero).random()
        val itemSelected = tablero.getCasilla(fila,columna).item
        itemSelected?.let { destinado(jugadorSacado, itemSelected, fila, columna) }
        amazonasDeIsengard.encolar(jugadorSacado)
    }


    /**
     * Acciones a realizar por los caballeros en su turno
     */
    private fun turnoCaballeros() {
        val jugadorSacado= caballerosDeElrond.desencolar()
        val fila = (0 until tamTablero).random()
        val columna = (0 until tamTablero).random()
        val itemSelected = tablero.getCasilla(fila,columna).item
        itemSelected?.let { destinado(jugadorSacado, itemSelected, fila, columna) }
        caballerosDeElrond.encolar(jugadorSacado)
    }


    /**
     * Para saber si el personaje está destinado a recoger el item encontrado.
     */
    private fun destinado(jugadorSacado: Personaje, itemSelected: Item, fila: Int, columna: Int) {
        when{
            itemSelected.tipo==ItemsEnum.COMIDA -> itemComida(itemSelected,jugadorSacado, fila, columna)
            itemSelected.tipo==ItemsEnum.MATERIAL && jugadorSacado is Humanos -> itemMaterial(itemSelected,jugadorSacado, fila, columna)
            itemSelected.tipo==ItemsEnum.POCION && jugadorSacado is Trasgos -> itemPocion(itemSelected,jugadorSacado, fila, columna)
            itemSelected.tipo==ItemsEnum.HECHIZO && jugadorSacado is Elfos -> itemHechizo(itemSelected,jugadorSacado, fila, columna)
        }
    }


    /**
     * Acciones si ha sido destiando el personaje y es el item de hechizo
     */
    private fun itemHechizo(itemSelected: Item,hechizero: Elfos, fila: Int, columna: Int) {
        hechizero.inmortalidad += 7
        hechizero.setItem(itemSelected)
        tablero.setCasillaItem(null,fila, columna)
    }


    /**
     * Acciones si ha sido destiando el personaje y es el item de pocion
     */
    private fun itemPocion(itemSelected: Item,trasgo: Trasgos, fila: Int, columna: Int) {
        trasgo.maldad += 2
        trasgo.setItem(itemSelected)
        tablero.setCasillaItem(null,fila, columna)
    }


    /**
     * Acciones si ha sido destiando el personaje y es el item de material
     */
    private fun itemMaterial(itemSelected: Item,humano: Humanos, fila: Int, columna: Int) {
        humano.escudo += 5
        humano.setItem(itemSelected)
        tablero.setCasillaItem(null,fila, columna)
    }


    /**
     * Acciones si ha sido destiando el personaje y es el item de comida
     */
    private fun itemComida(itemSelected: Item, jugadorSacado: Personaje, fila: Int, columna: Int) {
        jugadorSacado.setItem(itemSelected)
        tablero.setCasillaItem(null,fila, columna)
    }


    /**
     * Saber si ha ganado algún equipo.
     */
    private fun ganadores():Boolean {
        when{
            caballerosDeElrond.todoACinco() -> return true
            amazonasDeIsengard.todoACinco() -> return true
        }
      return false
    }


    /**
     * Añadir items a su cola.
     */
    private fun addItems() {
        repeat(200){
            listaItems.add(ItemFactory.itemFactory())
        }
    }


    /**
     * Añadir los personajes a su cola.
     */
    private fun addPersonajes() {
        repeat(3){
            caballerosDeElrond.encolar(PersonajeFactory.personajeFactory())
            amazonasDeIsengard.encolar(PersonajeFactory.personajeFactory())
        }
    }


    /**
     * Función de extensión para saber si todos los integrantes de la batalla tienen sus items a 5 o más
     */
    private fun ColaImpl.todoACinco(): Boolean {
        var correcto = 0
        for (i:Personaje in this){
            if (i.listaItems.size>=5){
                correcto++
            }
        }
        return correcto == 3

    }


}





