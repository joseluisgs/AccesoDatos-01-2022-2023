package utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun String.toLocalDate(): LocalDate {
    println(this)

    val formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy")
    return LocalDate.parse(this.trim(), formatter)
}