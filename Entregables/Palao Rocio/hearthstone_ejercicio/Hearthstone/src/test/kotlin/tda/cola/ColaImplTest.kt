package tda.cola

import models.personajes.Elfos
import models.personajes.Personaje
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.function.Executable

internal class ColaImplTest {
    private var colaTest: ColaImpl = ColaImpl()
    private var datoTest: Personaje = Elfos("Prueba",50)
    private var datoTest2: Personaje = Elfos("Prueba2",50)

    @Test
    fun encolar() {
        colaTest.encolar(datoTest)
        val result = colaTest.desencolar()
        assertAll(
            Executable{ assertNotNull(result) },
            Executable{ assertEquals(datoTest, result) },
            Executable{ assertEquals(datoTest.id, result.id)},
            Executable{ assertEquals(datoTest.nombre, result.nombre)},
            Executable{ assertEquals(datoTest.vida, result.vida) },
            Executable{ assertEquals(datoTest.nivel, result.nivel) },
            Executable{ assertEquals(datoTest.fechaCreacion, result.fechaCreacion) },
            Executable{ assertEquals(datoTest.listaItems, result.listaItems) }
        )
    }

    @Test
    fun desencolar() {
        colaTest.encolar(datoTest2)
        colaTest.encolar(datoTest)
        val result = colaTest.desencolar()
        assertAll(
            Executable{ assertNotNull(result) },
            Executable{ assertEquals(datoTest2, result) },
            Executable{ assertEquals(datoTest2.id, result.id)},
            Executable{ assertEquals(datoTest2.nombre, result.nombre)},
            Executable{ assertEquals(datoTest2.vida, result.vida) },
            Executable{ assertEquals(datoTest2.nivel, result.nivel) },
            Executable{ assertEquals(datoTest2.fechaCreacion, result.fechaCreacion) },
            Executable{ assertEquals(datoTest2.listaItems, result.listaItems) }
        )
    }
}