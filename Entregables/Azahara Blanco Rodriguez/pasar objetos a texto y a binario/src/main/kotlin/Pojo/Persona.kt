package Pojo

import java.io.Serializable
import java.util.*

class Persona(): Serializable {
    var r = Random()
    var id : String  = UUID.randomUUID().toString()
    var edad : Int = r.nextInt(80)
    var clasificacio : String = "alumno"

    constructor(id : String, edad : Int, clasidicacion : String) : this() {
        this.id = id
        this.edad = edad
        this.clasificacio =clasificacio
    }


}