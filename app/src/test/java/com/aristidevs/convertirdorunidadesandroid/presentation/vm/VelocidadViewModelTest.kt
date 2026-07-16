package com.aristidevs.convertirdorunidadesandroid.presentation.vm

import com.aristidevs.convertirdorunidadesandroid.domain.model.UnidadVelocidad
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class VelocidadViewModelTest {

    private lateinit var viewModel: VelocidadViewModel
    private val delta = 0.001

    @Before
    fun setup() {
        viewModel = VelocidadViewModel()
    }

    @Test
    fun `cuando el viewmodel se inicializa el estado debe ser por defecto`() {
        val estadoActual = viewModel.iuEstado.value
        
        assertEquals(0.0, estadoActual.valorConvertible!!, 0.0)
        assertEquals(UnidadVelocidad.MS, estadoActual.unidadDeConversion)
        assertEquals(0.0, estadoActual.salidaMs!!, 0.0)
    }

    @Test
    fun `cuando se cambia el valor a uno valido el estado debe actualizarse y calcular salidas`() {
        // GIVEN: El usuario escribe "10.0" (m/s por defecto)
        val nuevoValor = "10.0"

        // WHEN
        viewModel.CambioValor(nuevoValor)

        // THEN
        val estado = viewModel.iuEstado.value
        assertEquals(10.0, estado.valorConvertible!!, delta)
        assertEquals(10.0, estado.salidaMs!!, delta)
        assertEquals(36.0, estado.salidaKmH!!, delta)
        assertEquals(32.8, estado.salidaFtS!!, delta)
        assertEquals(22.369, estado.salidaMiH!!, 0.01)
        assertEquals(19.44, estado.salidaNudo!!, 0.01)
    }

    @Test
    fun `cuando se cambia la unidad el viewmodel debe recalcular usando el valor actual`() {
        // GIVEN: Tenemos 100.0 en KM/H
        viewModel.CambioValor("100.0")
        viewModel.CambioUnidad(UnidadVelocidad.KMH)

        // THEN
        val estado = viewModel.iuEstado.value
        assertEquals(UnidadVelocidad.KMH, estado.unidadDeConversion)
        assertEquals(100.0, estado.valorConvertible!!, 0.0)

        // Validamos salidas (100 km/h -> 27.78 m/s segun Velocidad.kt)
        assertEquals(27.78, estado.salidaMs!!, delta)
        assertEquals(100.0, estado.salidaKmH!!, 0.0)
        assertEquals(91.1, estado.salidaFtS!!, delta)
        assertEquals(62.1, estado.salidaMiH!!, delta)
        assertEquals(53.99, estado.salidaNudo!!, 0.1)
    }

    @Test
    fun `cuando se ingresa un texto no numerico el valor debe ser null y las salidas 0`() {
        // GIVEN: El usuario escribe basura
        val entradaInvalida = "velocidad_erronea"

        // WHEN
        viewModel.CambioValor(entradaInvalida)

        // THEN
        val estado = viewModel.iuEstado.value
        assertNull(estado.valorConvertible)
        
        // Validamos que todas las salidas se reseteen a 0.0
        assertEquals(0.0, estado.salidaMs!!, 0.0)
        assertEquals(0.0, estado.salidaKmH!!, 0.0)
        assertEquals(0.0, estado.salidaFtS!!, 0.0)
        assertEquals(0.0, estado.salidaMiH!!, 0.0)
        assertEquals(0.0, estado.salidaNudo!!, 0.0)
    }

    @Test
    fun `cuando se ingresa un valor vacio las salidas deben resetearse a 0`() {
        // GIVEN: Primero ponemos un valor
        viewModel.CambioValor("100.0")
        
        // WHEN: Luego borramos todo (valor vacío)
        viewModel.CambioValor("")

        // THEN
        val estado = viewModel.iuEstado.value
        assertNull(estado.valorConvertible)
        
        // Validamos que todas las salidas se reseteen a 0.0
        assertEquals(0.0, estado.salidaMs!!, 0.0)
        assertEquals(0.0, estado.salidaKmH!!, 0.0)
        assertEquals(0.0, estado.salidaFtS!!, 0.0)
        assertEquals(0.0, estado.salidaMiH!!, 0.0)
        assertEquals(0.0, estado.salidaNudo!!, 0.0)
    }

    @Test
    fun `validar mapeo de todas las unidades en el flujo de estado de velocidad`() {
        val unidades = UnidadVelocidad.values()
        
        unidades.forEach { unidad ->
            viewModel.CambioUnidad(unidad)
            viewModel.CambioValor("1.0")
            
            val estado = viewModel.iuEstado.value
            assertEquals("Fallo en unidad: $unidad", unidad, estado.unidadDeConversion)
            
            // Validamos que todas las salidas se hayan calculado
            assertNotNull("salidaMs es null para $unidad", estado.salidaMs)
            assertNotNull("salidaKmH es null para $unidad", estado.salidaKmH)
            assertNotNull("salidaFtS es null para $unidad", estado.salidaFtS)
            assertNotNull("salidaMiH es null para $unidad", estado.salidaMiH)
            assertNotNull("salidaNudo es null para $unidad", estado.salidaNudo)
        }
    }
}
