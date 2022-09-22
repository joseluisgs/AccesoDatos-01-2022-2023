package utils

import java.nio.file.Files
import java.nio.file.Path

class Input {

    /**
     * Pedir el comando necesario.
     * @return el comando.
     */
    fun getStringPath(): String {
        var entrada: String
        do {
            println(
                """
                Escribe el comando para copiar o mover un archivo 
                cp/mv rutaArchivo nuevaRuta
                """.trimIndent()
            )
            entrada = readln()
        } while (!rutaCorrecta(entrada))
        return entrada
    }


    /**
     * Ver si la ruta inicial es correcta y si se ha escrito bien el comando cp/mv.
     * @param line entrada de datos.
     * @return si es correcto o no.
     */
    private fun rutaCorrecta(line: String): Boolean {
        val comando = line.split(" ".toRegex())
        if (comando[0] == "cp" || comando[0] == "mv") {
            return Files.exists(Path.of(comando[1]).toAbsolutePath())
        } else {
            println("Comando no reconocido")
        }
        return false
    }


    /**
     * Preguntar si se desea sobreescribir el archivo.
     * @return boolean dependiendo de la elección.
     */
    fun sobreescribirArchivo(): Boolean {
        var line = ""
        do {
            println("Desea sobreescribir el archivo?   si/no")
            line = readln()
        } while (!line.equals("si", ignoreCase = true) && !line.equals("no", ignoreCase = true))
        return line.equals("si", ignoreCase = true)
    }
}