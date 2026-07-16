package com.aristidevs.convertirdorunidadesandroid.presentation.vm

import com.aristidevs.convertirdorunidadesandroid.domain.model.UnidadTemperatura
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class TemperaturaViewModelTest {

    private lateinit var viewModel: TemperaturaViewModel
    private val delta = 0.001

    @Before
    fun setup() {
        viewModel = TemperaturaViewModel()
    }

    @Test
    fun `cuando el viewmodel se inicializa el estado debe ser por defecto`() {
        val estadoActual = viewModel.iuEstado.value
        
        assertEquals(0.0, estadoActual.valorConvertible!!, 0.0)
        assertEquals(UnidadTemperatura.CELSIUS, estadoActual.unidadDeConversion)
        assertEquals(0.0, estadoActual.salidaCelsius!!, 0.0)
    }

    @Test
    fun `cuando se cambia el valor a uno valido el estado debe actualizarse y calcular salidas`() {
        // GIVEN: El usuario escribe "25.0" (celsius por defecto)
        val nuevoValor = "25.0"

        // WHEN
        viewModel.CambioValor(nuevoValor)

        // THEN
        val estado = viewModel.iuEstado.value
        assertEquals(25.0, estado.valorConvertible!!, delta)
        assertEquals(25.0, estado.salidaCelsius!!, delta)
        assertEquals(298.15, estado.salidaKelvin!!, delta)
        assertEquals(77.0, estado.salidaFarenheit!!, delta)
        assertEquals(536.67, estado.salidaRankine!!, delta)
    }

    @Test
    fun `cuando se cambia la unidad el viewmodel debe recalcular usando el valor actual`() {
        // GIVEN: Tenemos 100.0 en Celsius
        viewModel.CambioValor("100.0")
        
        // WHEN: Cambiamos la unidad a Fahrenheit
        viewModel.CambioUnidad(UnidadTemperatura.FAHRENHEIT)

        // THEN
        val estado = viewModel.iuEstado.value
        assertEquals(UnidadTemperatura.FAHRENHEIT, estado.unidadDeConversion)
        assertEquals(100.0, estado.valorConvertible!!, 0.0)

        // Como ahora 100.0 es Fahrenheit, validamos salidas principales
        assertEquals(37.777, estado.salidaCelsius!!, 0.001)
        assertEquals(100.0, estado.salidaFarenheit!!, 0.0)
        assertEquals(310.927, estado.salidaKelvin!!, 0.001)
        assertEquals(559.67, estado.salidaRankine!!, 0.001)
    }

    @Test
    fun `cuando se ingresa un texto no numerico el valor debe ser null y las salidas 0`() {
        // GIVEN: El usuario escribe basura
        val entradaInvalida = "error"

        // WHEN
        viewModel.CambioValor(entradaInvalida)

        // THEN
        val estado = viewModel.iuEstado.value
        assertNull(estado.valorConvertible)
        
        // Validamos que las salidas correspondan a 0.0 Celsius (default cuando valor es null)
        assertEquals(0.0, estado.salidaCelsius!!, 0.0)
        assertEquals(273.15, estado.salidaKelvin!!, 0.001)
        assertEquals(32.0, estado.salidaFarenheit!!, 0.001)
        assertEquals(491.67, estado.salidaRankine!!, 0.01)
    }

    @Test
    fun `cuando se ingresa un valor vacio las salidas deben resetearse a 0`() {
        // GIVEN: Primero ponemos un valor
        viewModel.CambioValor("32.0")
        
        // WHEN: Luego borramos todo (valor vacío)
        viewModel.CambioValor("")

        // THEN
        val estado = viewModel.iuEstado.value
        assertNull(estado.valorConvertible)
        
        // Validamos que las salidas correspondan a 0.0 Celsius
        assertEquals(0.0, estado.salidaCelsius!!, 0.0)
        assertEquals(273.15, estado.salidaKelvin!!, 0.001)
        assertEquals(32.0, estado.salidaFarenheit!!, 0.001)
        assertEquals(491.67, estado.salidaRankine!!, 0.01)
    }

    @Test
    fun `validar mapeo de todas las unidades en el flujo de estado de temperatura`() {
        val unidades = UnidadTemperatura.values()
        
        unidades.forEach { unidad ->
            viewModel.CambioUnidad(unidad)
            viewModel.CambioValor("0.0")
            
            val estado = viewModel.iuEstado.value
            assertEquals("Fallo en unidad: $unidad", unidad, estado.unidadDeConversion)
            
            // Validamos que todas las salidas se hayan calculado
            assertNotNull("salidaCelsius es null para $unidad", estado.salidaCelsius)
            assertNotNull("salidaKelvin es null para $unidad", estado.salidaKelvin)
            assertNotNull("salidaFarenheit es null para $unidad", estado.salidaFarenheit)
            assertNotNull("salidaRankine es null para $unidad", estado.salidaRankine)
        }
    }
}
