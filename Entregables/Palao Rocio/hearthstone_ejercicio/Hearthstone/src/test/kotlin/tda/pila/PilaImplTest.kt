package tda.pila

import models.Item
import models.enums.ItemsEnum
import models.personajes.Elfos
import models.personajes.Personaje
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.function.Executable
import tda.cola.ColaImpl

internal class PilaImplTest {
    private var pilaTest: PilaImpl = PilaImpl()
    private var datoTest: Item = Item(tipo = ItemsEnum.HECHIZO)
    private var datoTest2: Item = Item(tipo = ItemsEnum.COMIDA)

    @Test
    fun apilar() {
        pilaTest.apilar(datoTest)
        val result = pilaTest.desapilar()
        assertAll(
            Executable{ assertNotNull(result) },
            Executable{ assertEquals(datoTest, result) },
            Executable{ assertEquals(datoTest.id, result.id)},
            Executable{ assertEquals(datoTest.fecha, result.fecha)},
            Executable{ assertEquals(datoTest.nivel, result.nivel)}
        )
    }

    @Test
    fun desapilar() {
        pilaTest.apilar(datoTest)
        pilaTest.apilar(datoTest2)
        val result = pilaTest.desapilar()
        assertAll(
            Executable{ assertNotNull(result) },
            Executable{ assertEquals(datoTest2, result) },
            Executable{ assertEquals(datoTest2.id, result.id)},
            Executable{ assertEquals(datoTest2.fecha, result.fecha)},
            Executable{ assertEquals(datoTest2.nivel, result.nivel)}
        )
    }
}