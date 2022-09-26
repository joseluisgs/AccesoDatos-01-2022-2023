package es.ruymi.ejercicio03.utils
class Utils03() {
    fun nombreAleatorio(): String {
        val lista = listOf<String>(
            "Manolo",
            "Vladimir",
            "Ruben",
            "Alejandro",
            "Mireya",
            "Alvaro",
            "Pedro",
            "Maria",
            "Isabel",
            "Raul"
        )
        return lista[(Math.random() * lista.size).toInt()]
    }
}

