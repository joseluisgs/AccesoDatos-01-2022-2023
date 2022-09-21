enum class RazaBuena(var valor: Int) {
    PELOSO(1), SURENO_BUENO(2), ENANO(3), NUMENOREANO(4), ELFO(5)
}

enum class RazaMala(var valor: Int) {
    SURENO_MALO(1), ORCO(2), GOBLIN(3), HUARGO(4), TROLL(5)
}

fun main() {
    var puntosB = 0
    var puntosM = 0

    for (i in 0 until 10) {
        val pjBueno = RazaBuena.values().random()
        val pjMalo = RazaMala.values().random()

        if (pjBueno.valor > pjMalo.valor) {
            println(
                """
                ===========
                 BATALLA $i
                ===========
                · El $pjBueno ha ganado al $pjMalo, malos derrotados.
            """.trimIndent()
            )

            puntosB++

        } else if (pjBueno.valor < pjMalo.valor) {
            println(
                """
                ===========
                 BATALLA $i
                ===========
                · El $pjMalo ha ganado al $pjBueno, buenos derrotados.
            """.trimIndent()
            )

            puntosM++

        } else {
            println(
                """
                ===========
                 BATALLA $i
                ===========
                · El $pjMalo y el $pjBueno no son capaces de derrotarse...
            """.trimIndent()
            )
        }
    }

    if (puntosM < puntosB) {
        println(
            """
            ===============================================================
            GUERRA GANADA POR EL BANDO DE LOS BUENOS CON $puntosB VICTORIAS
            ===============================================================
        """.trimIndent()
        )
    } else {
        println(
            """
            ==============================================================
            GUERRA GANADA POR EL BANDO DE LOS MALOS CON $puntosM VICTORIAS
            ==============================================================
        """.trimIndent()
        )
    }
}

