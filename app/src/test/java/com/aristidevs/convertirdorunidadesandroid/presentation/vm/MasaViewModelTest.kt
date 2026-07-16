package com.aristidevs.convertirdorunidadesandroid.presentation.vm

import com.aristidevs.convertirdorunidadesandroid.domain.model.UnidadMasa
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class MasaViewModelTest {

    private lateinit var viewModel: MasaViewModel
    private val delta = 0.001

    @Before
    fun setup() {
        viewModel = MasaViewModel()
    }

    @Test
    fun `cuando el viewmodel se inicializa el estado debe ser por defecto`() {
        val estadoActual = viewModel.iuEstado.value
        
        assertEquals(0.0, estadoActual.valorConvertible!!, 0.0)
        assertEquals(UnidadMasa.GRAMO, estadoActual.unidadDeConversion)
        assertEquals(0.0, estadoActual.salidaGramo!!, 0.0)
    }

    @Test
    fun `cuando se cambia el valor a uno valido el estado debe actualizarse y calcular salidas`() {
        // GIVEN: El usuario escribe "1000.0" (gramos por defecto)
        val nuevoValor = "1000.0"

        // WHEN
        viewModel.CambioValor(nuevoValor)

        // THEN
        val estado = viewModel.iuEstado.value
        assertEquals(1000.0, estado.valorConvertible!!, delta)
        assertEquals(1000.0, estado.salidaGramo!!, delta)
        assertEquals(1.0, estado.salidaKilogramo!!, delta)
        assertEquals(2.2046, estado.salidaLibra!!, 0.001)
        assertEquals(0.001, estado.salidaTonelada!!, delta)
    }

    @Test
    fun `cuando se cambia la unidad el viewmodel debe recalcular usando el valor actual`() {
        // GIVEN: Tenemos 1.0 en gramos
        viewModel.CambioValor("1.0")
        
        // WHEN: Cambiamos la unidad a Kilogramos
        viewModel.CambioUnidad(UnidadMasa.KILOGRAMO)

        // THEN
        val estado = viewModel.iuEstado.value
        assertEquals(UnidadMasa.KILOGRAMO, estado.unidadDeConversion)
        assertEquals(1.0, estado.valorConvertible!!, 0.0)

        // Como ahora 1.0 es Kilogramo, validamos todas las salidas
        assertEquals(1000.0, estado.salidaGramo!!, delta)
        assertEquals(1.0, estado.salidaKilogramo!!, delta)
        assertEquals(2.2046, estado.salidaLibra!!, 0.001)
        assertEquals(0.001, estado.salidaTonelada!!, delta)
    }

    @Test
    fun `cuando se ingresa un texto no numerico el valor debe ser null y las salidas 0`() {
        // GIVEN: El usuario escribe basura
        val entradaInvalida = "masa_invalida"

        // WHEN
        viewModel.CambioValor(entradaInvalida)

        // THEN
        val estado = viewModel.iuEstado.value
        assertNull(estado.valorConvertible)
        
        // Validamos que todas las salidas se reseteen a 0.0
        assertEquals(0.0, estado.salidaGramo!!, 0.0)
        assertEquals(0.0, estado.salidaKilogramo!!, 0.0)
        assertEquals(0.0, estado.salidaLibra!!, 0.0)
        assertEquals(0.0, estado.salidaTonelada!!, 0.0)
    }

    @Test
    fun `cuando se ingresa un valor vacio las salidas deben resetearse a 0`() {
        // GIVEN: Primero ponemos un valor
        viewModel.CambioValor("500.0")
        
        // WHEN: Luego borramos todo (valor vacío)
        viewModel.CambioValor("")

        // THEN
        val estado = viewModel.iuEstado.value
        assertNull(estado.valorConvertible)
        
        // Validamos que todas las salidas se reseteen a 0.0
        assertEquals(0.0, estado.salidaGramo!!, 0.0)
        assertEquals(0.0, estado.salidaKilogramo!!, 0.0)
        assertEquals(0.0, estado.salidaLibra!!, 0.0)
        assertEquals(0.0, estado.salidaTonelada!!, 0.0)
    }

    @Test
    fun `validar mapeo de todas las unidades en el flujo de estado de masa`() {
        // Esta prueba asegura que el 'when' del ViewModel no tenga errores de mapeo
        val unidades = UnidadMasa.values()
        
        unidades.forEach { unidad ->
            viewModel.CambioUnidad(unidad)
            viewModel.CambioValor("1.0")
            
            val estado = viewModel.iuEstado.value
            assertEquals("Fallo en unidad: $unidad", unidad, estado.unidadDeConversion)
            
            // Validamos que todas las salidas se hayan calculado (no sean null)
            assertNotNull("salidaGramo es null para $unidad", estado.salidaGramo)
            assertNotNull("salidaKilogramo es null para $unidad", estado.salidaKilogramo)
            assertNotNull("salidaLibra es null para $unidad", estado.salidaLibra)
            assertNotNull("salidaTonelada es null para $unidad", estado.salidaTonelada)
        }
    }
}
