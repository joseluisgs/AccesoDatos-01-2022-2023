package controllers

import kotlinx.datetime.Month
import models.loadAccidentesFromCsv
import java.io.File
import java.time.format.TextStyle
import java.util.*


object AccidentesColectionController {
    fun procesarColecciones() {
        println("Ejemplo de Accidentes con Colecciones y Secuencias")
        println("======================")
        // Vamos a leer los accidentes
        val accidentes by lazy { loadAccidentesFromCsv(File("data/accidentes.csv")) }

        println()
        println("Accidentes fines de semana noche y con alcohol")
        val res01 = accidentes.filter {
            (it.fecha.dayOfWeek.value > 5) && (it.hora.hour > 20 || it.hora.hour < 6) && (it.positivoAlcohol)
        }

        println("Numero de accidentes Fines de semana de noche con positivo en alcohol: ${res01.size}")

        println("Accidentes fines de semana y noche")

        var res02 = accidentes.asSequence().filter {
            (it.fecha.dayOfWeek.value > 5) && (it.hora.hour > 20 || it.hora.hour < 6)
        }.toList()

        println("Numero de accidentes Fines de semana de noche: ${res02.size}")

        println("Los 10 días con más accidentes")
        val accidentesPorDias: Map<String, Int> = accidentes.groupingBy { it.fecha.toString() }.eachCount()

        accidentesPorDias.entries.sortedByDescending { it.value }.take(10)
            .map { it.key + " -> " + it.value }.forEach { println(it) }


        println()
        println("Estadisticas por Barrios")

        val resBarrios = accidentes
            // Desestructuramos el objeto accidente en sus propiedades
            .filter { it.distrito != "NULL" && it.distrito != "9" }
            .groupBy { it.distrito }


        println("Numero de accidentes medio por barrios: ${resBarrios.map { it.value.size }.average()}")

        val maximo = resBarrios.maxBy { it.value.size }

        println("Barrio con Mayor número de accidentes: " + maximo.key + " -> " + maximo.value.size)

        val minimo = resBarrios.minBy { it.value.size }

        println("Barrio con Menor número de accidentes: ${minimo.key} -> ${minimo.value.size}")

        println("Accidentes por meses")

        // Secuencias vs Colecciones
        val res03 = accidentes.asSequence()
            .filter { it.fecha.month == Month.APRIL }
            .toList()
        println("Numero de Expedientes en abril: " + res03.size)

        val res04 = accidentes
            .filter { it.fecha.month == Month.MAY }
        println("Numero de Expedientes en mayo: " + res04.size)

        val res05 = accidentes
            .groupBy { it.fecha.month.getDisplayName(TextStyle.FULL, Locale("es", "ES")) }
            .map { it.key + " -> " + it.value.size }
        res05.forEach { println(it) }


        println()
        println("Accidentes por sexo")
        var res = accidentes.count { it.sexo == "Hombre" }
        println("Numero de Expedientes sexo Hombre: $res")
        res = accidentes.count { it.sexo == "Mujer" }
        println("Numero de Expedientes sexo Mujer: $res")

        val resultado = accidentes.groupBy { it.sexo }.mapValues { it.value }


        println("Numero de accidentes por sexo")
        resultado.forEach { println("${it.key} -> ${it.value.size}") }

    }
}