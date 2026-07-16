package com.aristidevs.convertirdorunidadesandroid.presentation.vm

import com.aristidevs.convertirdorunidadesandroid.domain.model.UnidadVolumen
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class VolumenViewModelTest {

    private lateinit var viewModel: VolumenViewModel
    private val delta = 0.001

    @Before
    fun setup() {
        viewModel = VolumenViewModel()
    }

    @Test
    fun `cuando el viewmodel se inicializa el estado debe ser por defecto`() {
        val estadoActual = viewModel.iuEstado.value
        
        assertEquals(0.0, estadoActual.valorConvertible!!, 0.0)
        assertEquals(UnidadVolumen.CENTIMETRO, estadoActual.unidadDeConversion)
        assertEquals(0.0, estadoActual.salidaCentimetro!!, 0.0)
    }

    @Test
    fun `cuando se cambia el valor a uno valido el estado debe actualizarse y calcular salidas`() {
        // GIVEN: El usuario escribe "1000.0" (centimetros cubicos por defecto)
        val nuevoValor = "1000.0"

        // WHEN
        viewModel.CambioValor(nuevoValor)

        // THEN
        val estado = viewModel.iuEstado.value
        assertEquals(1000.0, estado.valorConvertible!!, delta)
        assertEquals(1000.0, estado.salidaCentimetro!!, delta)
        assertEquals(0.001, estado.salidaMetro!!, delta)
        assertEquals(0.03531, estado.salidaPie!!, delta)
        assertEquals(61.0237, estado.salidaPulgada!!, delta)
        assertEquals(1.0, estado.salidaLitro!!, delta)
        assertEquals(0.26417, estado.salidaGalon!!, delta)
    }

    @Test
    fun `cuando se cambia la unidad el viewmodel debe recalcular usando el valor actual`() {
        // GIVEN: Tenemos 1.0 en Metros Cubicos
        viewModel.CambioValor("1.0")
        viewModel.CambioUnidad(UnidadVolumen.METRO)

        // THEN
        val estado = viewModel.iuEstado.value
        assertEquals(UnidadVolumen.METRO, estado.unidadDeConversion)
        assertEquals(1.0, estado.valorConvertible!!, 0.0)

        // Validamos salidas (1 m3 -> 1000 Litros segun Volumen.kt)
        assertEquals(1000000.0, estado.salidaCentimetro!!, delta)
        assertEquals(1.0, estado.salidaMetro!!, delta)
        assertEquals(35.3, estado.salidaPie!!, delta)
        assertEquals(61023.74, estado.salidaPulgada!!, delta)
        assertEquals(1000.0, estado.salidaLitro!!, delta)
        assertEquals(264.17, estado.salidaGalon!!, delta)
    }

    @Test
    fun `cuando se ingresa un texto no numerico el valor debe ser null y las salidas 0`() {
        // GIVEN: El usuario escribe basura
        val entradaInvalida = "volumen_incorrecto"

        // WHEN
        viewModel.CambioValor(entradaInvalida)

        // THEN
        val estado = viewModel.iuEstado.value
        assertNull(estado.valorConvertible)
        
        // Validamos que todas las salidas se reseteen a 0.0
        assertEquals(0.0, estado.salidaCentimetro!!, 0.0)
        assertEquals(0.0, estado.salidaMetro!!, 0.0)
        assertEquals(0.0, estado.salidaPie!!, 0.0)
        assertEquals(0.0, estado.salidaPulgada!!, 0.0)
        assertEquals(0.0, estado.salidaLitro!!, 0.0)
        assertEquals(0.0, estado.salidaGalon!!, 0.0)
    }

    @Test
    fun `cuando se ingresa un valor vacio las salidas deben resetearse a 0`() {
        // GIVEN: Primero ponemos un valor
        viewModel.CambioValor("10.0")
        
        // WHEN: Luego borramos todo (valor vacío)
        viewModel.CambioValor("")

        // THEN
        val estado = viewModel.iuEstado.value
        assertNull(estado.valorConvertible)
        
        // Validamos que todas las salidas se reseteen a 0.0
        assertEquals(0.0, estado.salidaCentimetro!!, 0.0)
        assertEquals(0.0, estado.salidaMetro!!, 0.0)
        assertEquals(0.0, estado.salidaPie!!, 0.0)
        assertEquals(0.0, estado.salidaPulgada!!, 0.0)
        assertEquals(0.0, estado.salidaLitro!!, 0.0)
        assertEquals(0.0, estado.salidaGalon!!, 0.0)
    }

    @Test
    fun `validar mapeo de todas las unidades en el flujo de estado de volumen`() {
        val unidades = UnidadVolumen.values()
        
        unidades.forEach { unidad ->
            viewModel.CambioUnidad(unidad)
            viewModel.CambioValor("1.0")
            
            val estado = viewModel.iuEstado.value
            assertEquals("Fallo en unidad: $unidad", unidad, estado.unidadDeConversion)
            
            // Validamos que todas las salidas se hayan calculado
            assertNotNull("salidaCentimetro es null para $unidad", estado.salidaCentimetro)
            assertNotNull("salidaMetro es null para $unidad", estado.salidaMetro)
            assertNotNull("salidaPie es null para $unidad", estado.salidaPie)
            assertNotNull("salidaPulgada es null para $unidad", estado.salidaPulgada)
            assertNotNull("salidaLitro es null para $unidad", estado.salidaLitro)
            assertNotNull("salidaGalon es null para $unidad", estado.salidaGalon)
        }
    }
}
