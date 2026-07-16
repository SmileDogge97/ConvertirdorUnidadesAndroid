package com.aristidevs.convertirdorunidadesandroid.presentation.vm

import com.aristidevs.convertirdorunidadesandroid.domain.model.UnidadLongitud
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class LongitudViewModelTest {

    private lateinit var viewModel: LongitudViewModel
    private val delta = 0.001

    @Before
    fun setup() {
        viewModel = LongitudViewModel()
    }

    @Test
    fun `cuando el viewmodel se inicializa el estado debe ser por defecto`() {
        val estadoActual = viewModel.iuEstado.value
        
        assertEquals(0.0, estadoActual.valorConvertible!!, 0.0)
        assertEquals(UnidadLongitud.METRO, estadoActual.unidadDeConversion)
        assertEquals(0.0, estadoActual.salidaMetro!!, 0.0)
    }

    @Test
    fun `cuando se cambia el valor a uno valido el estado debe actualizarse y calcular salidas`() {
        // GIVEN: El usuario escribe "1000.0" (metros por defecto)
        val nuevoValor = "1000.0"

        // WHEN
        viewModel.CambioValor(nuevoValor)

        // THEN
        val estado = viewModel.iuEstado.value
        assertEquals(1000.0, estado.valorConvertible!!, delta)
        assertEquals(1000.0, estado.salidaMetro!!, delta)
        assertEquals(1.0, estado.salidaKilometro!!, delta)
        assertEquals(100000.0, estado.salidaCentimetro!!, delta)
        assertEquals(39370.0, estado.salidaPulgada!!, 1.0)
        assertEquals(3281.0, estado.salidaPies!!, 1.0)
        assertEquals(1093.6, estado.salidaYardas!!, 0.1)
        assertEquals(0.62137, estado.salidaMillas!!, 0.001)
        assertEquals(0.53995, estado.salidaMillasNauticas!!, 0.001)
    }

    @Test
    fun `cuando se cambia la unidad el viewmodel debe recalcular usando el valor actual`() {
        // GIVEN: Tenemos 1.0 en metros
        viewModel.CambioValor("1.0")
        
        // WHEN: Cambiamos la unidad a Kilometros
        viewModel.CambioUnidad(UnidadLongitud.KILOMETRO)

        // THEN
        val estado = viewModel.iuEstado.value
        assertEquals(UnidadLongitud.KILOMETRO, estado.unidadDeConversion)
        assertEquals(1.0, estado.valorConvertible!!, 0.0)

        // Como ahora 1.0 es Kilometro, validamos todas las salidas segun la precision del transformador
        assertEquals(1000.0, estado.salidaMetro!!, delta)
        assertEquals(1.0, estado.salidaKilometro!!, delta)
        assertEquals(100000.0, estado.salidaCentimetro!!, delta)
        assertEquals(39370.0, estado.salidaPulgada!!, 1.0)
        assertEquals(3281.0, estado.salidaPies!!, 1.0)
        assertEquals(1093.6, estado.salidaYardas!!, 0.1)
        assertEquals(0.62137, estado.salidaMillas!!, 0.001)
        assertEquals(0.53995, estado.salidaMillasNauticas!!, 0.001)
        assertEquals(1.057E-13, estado.salidaAñosLuz!!, 1e-15)
    }

    @Test
    fun `cuando se ingresa un texto no numerico el valor debe ser null y las salidas 0`() {
        // GIVEN: El usuario escribe basura
        val entradaInvalida = "abc"

        // WHEN
        viewModel.CambioValor(entradaInvalida)

        // THEN
        val estado = viewModel.iuEstado.value
        assertNull(estado.valorConvertible)
        
        // Validamos que todas las salidas se reseteen a 0.0
        assertEquals(0.0, estado.salidaMetro!!, 0.0)
        assertEquals(0.0, estado.salidaKilometro!!, 0.0)
        assertEquals(0.0, estado.salidaCentimetro!!, 0.0)
        assertEquals(0.0, estado.salidaPulgada!!, 0.0)
        assertEquals(0.0, estado.salidaPies!!, 0.0)
        assertEquals(0.0, estado.salidaYardas!!, 0.0)
        assertEquals(0.0, estado.salidaMillas!!, 0.0)
        assertEquals(0.0, estado.salidaMillasNauticas!!, 0.0)
        assertEquals(0.0, estado.salidaAñosLuz!!, 0.0)
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
        assertEquals(0.0, estado.salidaKilometro!!, 0.0)
        assertEquals(0.0, estado.salidaCentimetro!!, 0.0)
        assertEquals(0.0, estado.salidaPulgada!!, 0.0)
        assertEquals(0.0, estado.salidaPies!!, 0.0)
        assertEquals(0.0, estado.salidaYardas!!, 0.0)
        assertEquals(0.0, estado.salidaMillas!!, 0.0)
        assertEquals(0.0, estado.salidaMillasNauticas!!, 0.0)
        assertEquals(0.0, estado.salidaAñosLuz!!, 0.0)
    }

    @Test
    fun `validar mapeo de todas las unidades en el flujo de estado de longitud`() {
        val unidades = UnidadLongitud.values()
        
        unidades.forEach { unidad ->
            viewModel.CambioUnidad(unidad)
            viewModel.CambioValor("1.0")
            
            val estado = viewModel.iuEstado.value
            assertEquals("Fallo en unidad: $unidad", unidad, estado.unidadDeConversion)
            
            // Validamos que las salidas no sean null
            assertNotNull("salidaMetro es null para $unidad", estado.salidaMetro)
            assertNotNull("salidaKilometro es null para $unidad", estado.salidaKilometro)
            assertNotNull("salidaCentimetro es null para $unidad", estado.salidaCentimetro)
            assertNotNull("salidaPulgada es null para $unidad", estado.salidaPulgada)
            assertNotNull("salidaPies es null para $unidad", estado.salidaPies)
            assertNotNull("salidaYardas es null para $unidad", estado.salidaYardas)
            assertNotNull("salidaMillas es null para $unidad", estado.salidaMillas)
            assertNotNull("salidaMillasNauticas es null para $unidad", estado.salidaMillasNauticas)
            assertNotNull("salidaAñosLuz es null para $unidad", estado.salidaAñosLuz)
        }
    }
}
