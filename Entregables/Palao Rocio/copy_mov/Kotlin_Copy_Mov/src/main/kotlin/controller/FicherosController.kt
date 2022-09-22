package controller

import utils.Input
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardCopyOption

class FicherosController(private val inputs: Input) {

    /**
     * Para preguntar por el comando, y realizar todas las acciones.
     */
    init{
        val line = inputs.getStringPath()
        val separated = line.split(" ")
        val inicialPath = Paths.get(separated[1]).toAbsolutePath()
        val finalPath = Paths.get(separated[2]).toAbsolutePath()

        if (inicialPath.rutaInicialCorrecta()){
            selectedCommand(separated[0], inicialPath, finalPath)
        }
    }


    /**
     * Para seleccionar si es copiar o mover.
     * @param command contiene si es copiar o mover.
     * @param inicialPath ruta inicial del fichero.
     * @param finalPath ruta final del fichero.
     */
    private fun selectedCommand(command: String, inicialPath: Path, finalPath: Path) {
        when(command){
            "cp" -> makeCp(inicialPath, finalPath)
            "mv" -> makeMv(inicialPath,finalPath)
        }
    }


    /**
     * Mover el fichero de la ruta inicial a la ruta final.
     * @param inicialPath ruta inicial del fichero.
     * @param finalPath ruta final del fichero.
     */
    private fun makeMv(inicialPath: Path, finalPath: Path) {
        if (!Files.exists(finalPath)) {
            finalPath.createFinalPath()
        }
        Files.move(inicialPath, finalPath, StandardCopyOption.REPLACE_EXISTING)
    }


    /**
     * Copiar el fichero desde la ruta inicial hasta la ruta final.
     * @param inicialPath ruta inicial del fichero.
     * @param finalPath ruta final del fichero.
     */
    private fun makeCp(inicialPath: Path, finalPath: Path) {
        if (Files.exists(finalPath)){
            if (!inputs.sobreescribirArchivo()){
                println("No se copió el archivo")
                return
            }
        }else{
            finalPath.createFinalPath()
        }

        Files.copy(inicialPath, finalPath, StandardCopyOption.REPLACE_EXISTING)
    }




    /**
     * Función de extensión.
     * Crear la ruta final.
     */
    private fun Path.createFinalPath() {
        if (Files.notExists(this)){
            Files.createDirectories(this)
        }
    }


    /**
     * Función de extensión.
     * Para saber si la ruta inicial dada existe.
     * @return si existe o no.
     */
    private fun Path.rutaInicialCorrecta(): Boolean {
        return Files.exists(this)
    }
}