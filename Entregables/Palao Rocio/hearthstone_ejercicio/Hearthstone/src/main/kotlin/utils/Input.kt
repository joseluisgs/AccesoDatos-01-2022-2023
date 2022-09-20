package utils

object Input {

    fun pedirTablero():Int{
    var number:Int
        do {
            println("Dí el tamaño de la cuadrícula min.6 max.10 y sólo puede ser par")
            number = readln().toIntOrNull() ?: 0
        }while (number<6 || number>10 || number%2!=0)
        return number
    }

    fun pedirSegundos():Int{
        var number: Int
            do {
                println("Cuánto quieres que dure el juego? min 30seg max100seg")
                number = readln().toIntOrNull() ?: 0
            }while (number<30 || number>100)
        return number
    }
}