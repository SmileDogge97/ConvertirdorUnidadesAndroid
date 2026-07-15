package com.aristidevs.convertirdorunidadesandroid.presentation.vm

import com.aristidevs.convertirdorunidadesandroid.domain.model.UnidadArea
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class AreaViewModelTest {

    private lateinit var viewModel: AreaViewModel

    @Before
    fun setup() {
        viewModel = AreaViewModel()
    }

    @Test
    fun `cuando el viewmodel se inicializa el estado debe ser por defecto`() {
        val estadoActual = viewModel.iuEstado.value
        
        assertEquals(0.0, estadoActual.valorConvertible)
        assertEquals(UnidadArea.METRO, estadoActual.unidadDeConversion)
        assertEquals(0.0, estadoActual.salidaMetro)
    }

    @Test
    fun `cuando se cambia el valor a uno valido el estado debe actualizarse y calcular salidas`() {
        // GIVEN: El usuario escribe "10.0" (metros por defecto)
        val nuevoValor = "10.0"

        // WHEN
        viewModel.CambioValor(nuevoValor)

        // THEN
        val estado = viewModel.iuEstado.value
        assertEquals(10.0, estado.valorConvertible!!, 0.001)
        assertEquals(10.0, estado.salidaMetro!!, 0.001)
        assertEquals(0.001, estado.salidaHectarea!!, 0.001)
        assertEquals(100000.0, estado.salidaCentimetro!!, 0.001)
        assertEquals(15499.969, estado.salidaPulgada!!, 0.1)
        assertEquals(107.6, estado.salidaPie!!, 0.001)
        assertEquals(11.956, estado.salidaYarda!!, 0.01)
        assertEquals(0.00000386, estado.salidaMilla!!, 1e-7)
    }

    @Test
    fun `cuando se cambia la unidad el viewmodel debe recalcular usando el valor actual`() {
        // GIVEN: Tenemos 1.0 en metros
        viewModel.CambioValor("1.0")
        
        // WHEN: Cambiamos la unidad a Hectareas
        viewModel.CambioUnidad(UnidadArea.HECTAREA)

        // THEN
        val estado = viewModel.iuEstado.value
        assertEquals(UnidadArea.HECTAREA, estado.unidadDeConversion)
        assertEquals(1.0, estado.valorConvertible!!, 0.0)

        // Como ahora 1.0 es Hectarea, validamos todas las salidas segun Area.cht()
        assertEquals(10000.0, estado.salidaMetro!!, 0.001)
        assertEquals(1.0, estado.salidaHectarea!!, 0.0)
        assertEquals(100000000.0, estado.salidaCentimetro!!, 0.1)
        assertEquals(15499969.0, estado.salidaPulgada!!, 1.0)
        assertEquals(107639.104, estado.salidaPie!!, 0.01)
        assertEquals(11959.9005, estado.salidaYarda!!, 0.001)
        assertEquals(0.003861, estado.salidaMilla!!, 0.000001)
    }

    @Test
    fun `cuando se ingresa un texto no numerico el valor debe ser null y las salidas 0`() {
        // GIVEN: El usuario escribe basura
        val entradaInvalida = "texto_invalido"

        // WHEN
        viewModel.CambioValor(entradaInvalida)

        // THEN
        val estado = viewModel.iuEstado.value
        assertNull(estado.valorConvertible)
        
        // Validamos que todas las salidas se reseteen a 0.0
        assertEquals(0.0, estado.salidaMetro!!, 0.0)
        assertEquals(0.0, estado.salidaHectarea!!, 0.0)
        assertEquals(0.0, estado.salidaCentimetro!!, 0.0)
        assertEquals(0.0, estado.salidaPulgada!!, 0.0)
        assertEquals(0.0, estado.salidaPie!!, 0.0)
        assertEquals(0.0, estado.salidaYarda!!, 0.0)
        assertEquals(0.0, estado.salidaMilla!!, 0.0)
    }

    @Test
    fun `cuando se ingresa un valor vacio las salidas deben resetearse a 0`() {
        // GIVEN: Primero ponemos un valor
        viewModel.CambioValor("50.0")
        
        // WHEN: Luego borramos todo (valor vacío)
        viewModel.CambioValor("")

        // THEN
        val estado = viewModel.iuEstado.value
        assertNull(estado.valorConvertible)
        
        // Validamos que todas las salidas se reseteen a 0.0
        assertEquals(0.0, estado.salidaMetro!!, 0.0)
        assertEquals(0.0, estado.salidaHectarea!!, 0.0)
        assertEquals(0.0, estado.salidaCentimetro!!, 0.0)
        assertEquals(0.0, estado.salidaPulgada!!, 0.0)
        assertEquals(0.0, estado.salidaPie!!, 0.0)
        assertEquals(0.0, estado.salidaYarda!!, 0.0)
        assertEquals(0.0, estado.salidaMilla!!, 0.0)
    }

    @Test
    fun `validar mapeo de todas las unidades en el flujo de estado`() {
        // Esta prueba asegura que el 'when' del ViewModel no tenga errores de mapeo
        val unidades = UnidadArea.values()
        
        unidades.forEach { unidad ->
            viewModel.CambioUnidad(unidad)
            viewModel.CambioValor("1.0")
            
            val estado = viewModel.iuEstado.value
            assertEquals("Fallo en unidad: $unidad", unidad, estado.unidadDeConversion)
            
            // Validamos que todas las salidas se hayan calculado (no sean null)
            assertNotNull("salidaMetro es null para $unidad", estado.salidaMetro)
            assertNotNull("salidaHectarea es null para $unidad", estado.salidaHectarea)
            assertNotNull("salidaCentimetro es null para $unidad", estado.salidaCentimetro)
            assertNotNull("salidaPulgada es null para $unidad", estado.salidaPulgada)
            assertNotNull("salidaPie es null para $unidad", estado.salidaPie)
            assertNotNull("salidaYarda es null para $unidad", estado.salidaYarda)
            assertNotNull("salidaMilla es null para $unidad", estado.salidaMilla)
        }
    }
}
