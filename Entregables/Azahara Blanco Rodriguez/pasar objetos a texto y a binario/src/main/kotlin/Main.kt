import Pojo.Persona
import java.io.*
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.*


fun main(args: Array<String>) {


   pasarAtextoYDeTextoAObjeto()

   pararABinarioYDeBinarioAObjeto()




}




    /*
     Crearemos una lista de Personas y la pasaremos la lista completa a binario.
     Despues ese fichero a vinario lo pasaremos a una lista de personas.
     */
fun pararABinarioYDeBinarioAObjeto() {

        println("pasar una lista a binario")
        var file = pasarUnaListaABinario()

        println("pasar de binario a una lista")
        pasarDeFicheroBinarioALista(file)

    }


/*
 pasar de un objeto a texto y de nuevo a objeto csv
 */
private fun pasarAtextoYDeTextoAObjeto() {


    println("pasar una lista  a csv")
    var file = pasarUnaListaATexto()

    println("pasar de csv a una lista")
    pasarDeFicheroTextoALista(file)





}

fun pasarDeFicheroTextoALista(f: File) {

    println("\"obteniendo del fichero: ${f.getAbsolutePath()}")

    //fichero donde guardaremos las personas
    var l = ArrayList<Persona>()

    println("empezamos la lectura linea a linea")
    var br = BufferedReader(FileReader(f))
    var linea = br.readLine()
    while (linea != null) {
        println("leemos una linea")
        println(linea)
        println("la pasamos a persona")
        l.add(pasardeLineaAPersona(linea))
        linea = br.readLine()
    }
    br.close()
    println("leido desde texto")
    println(l)
}

fun pasarUnaListaATexto(): File {

    //creamos lista de personas
    var lista: List<Persona> = listOf<Persona>(Persona(), Persona(), Persona())
    println("creamos una lista")
    println(lista)

    //si el fichero no existe lo creamos
    var f = File("Personas.txt")
    println("\"Escribiendo en el fichero: ${f.getAbsolutePath()}")

    if (Files.notExists(Path.of(f.getAbsolutePath()))) {
        Files.createFile(Path.of(f.getAbsolutePath()))
        println("el fichero no exite asi que lo creamos")
    }

    //empezamos la escritura
    var pr = PrintWriter(FileWriter(f, false))
    println("escribimos en el fichero")
    lista.forEach { l -> pr.println(l.id.toString() + "," + l.edad + "," + l.clasificacio) }
    pr.close()
    println("acabada la esritura")

    return f
}


fun pasardeLineaAPersona(linea: String): Persona {
var componentes = linea.split(",")
    var p = Persona( componentes[0] , componentes[1].toInt(), componentes[2] )
    println(p)
    return p
}

private fun pasarDeFicheroBinarioALista(file: File) {

    println("cogiendo del fichero  : ${file.absolutePath} ")
    //hacer el objeto de leztura de binario
    var ois = ObjectInputStream(FileInputStream(file))

    //realizar la lectura as la lista que es
    println("pasar la lista improtante que sea serializable")
    var list: ArrayList<Persona> = ois.readObject() as ArrayList<Persona>
    println(list)
    println("finalizando")
    ois.close()
    println("sacado del fichero")
    println(list)
}

private fun pasarUnaListaABinario(): File {
    //Creamos una collecion ArrayList de 3 personas
    var l = ArrayList<Persona>()
    l.add(Persona())
    l.add(Persona())
    l.add(Persona())

    println("la lista de personas a guardar")
    println(l)

    //crearemos si no exixte un Fichero que se llame binarios donde guardaremos los datos

    //ver si hay un fichero y si no crearVehiculo
    var file = File(Paths.get("").toString() + "binarios")

    if (Files.notExists(Path.of(Paths.get("").toString() + "binarios"))) {
        println("creando fichero")
        Files.createFile(Path.of(Paths.get("").toString() + "binarios"))
    }
    println("pasando al fichero : ${file.absolutePath }")


    //realizamos ahora la excritura

    var objectOutputStream = ObjectOutputStream(FileOutputStream(file, false))
    try {
        println("empezamos la escritura")
        objectOutputStream.writeObject(l)
        println("escribinendo la lista de personas en binario")
    } catch (e: IOException) {
        println("la excritura falló")
    } finally {
        println("cerrando la escritura")
        objectOutputStream.close()
    }
    return file
}

fun pedirPath(): Path {
    var p : String?
    do { p = readLine() } while ( (p==null))
    return Path.of(p)
    }
