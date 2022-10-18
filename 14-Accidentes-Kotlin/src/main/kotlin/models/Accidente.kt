package models

import org.jetbrains.kotlinx.dataframe.annotations.DataSchema
import java.io.File
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

// Podemos usar anotaciones para Data Frames, no es obligatorio si solo usamos colecciones
@DataSchema
data class Accidente(
    val numExpediente: String,
    val fecha: LocalDate,
    val hora: LocalTime,
    val localizacion: String,
    val distrito: String,
    val tipoAccidente: String,
    val meteorologia: String,
    val tipoVehiculo: String,
    val tipoPersona: String,
    val sexo: String,
    val positivoAlcohol: Boolean = false,
    val positivoDrogas: Boolean = false,
)

// Tengo que procesarlos a mano para limpiar datos
fun loadAccidentesFromCsv(csvFile: File): List<Accidente> {
    // Leemos los datos...
    val accidentes: List<Accidente> = csvFile.readLines()
        .drop(1)
        .map { it.split(";") }
        .map {
            it.map { campo -> campo.trim() }
            Accidente(
                numExpediente = it[0],
                fecha = getFecha(it[1]),
                hora = getHora(it[2]),
                localizacion = it[3],
                distrito = it[6],
                tipoAccidente = it[7],
                meteorologia = it[8],
                tipoVehiculo = it[9],
                tipoPersona = it[10],
                sexo = it[12],
                positivoAlcohol = it[17] == "S",
                positivoDrogas = it[18] == "1"
            )
        }
    return accidentes
}

private fun getFecha(fecha: String): LocalDate {
    val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    return LocalDate.parse(fecha, formatter)
}

private fun getHora(hora: String): LocalTime {
    var hora = hora
    hora = if (hora.length <= 7) "0$hora" else hora
    val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss")
    return LocalTime.parse(hora, formatter)
}
