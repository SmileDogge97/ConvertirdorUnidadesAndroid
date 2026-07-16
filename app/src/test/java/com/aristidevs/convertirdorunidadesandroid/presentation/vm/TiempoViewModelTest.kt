package com.aristidevs.convertirdorunidadesandroid.presentation.vm

import com.aristidevs.convertirdorunidadesandroid.domain.model.UnidadTiempo
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class TiempoViewModelTest {

    private lateinit var viewModel: TiempoViewModel
    private val delta = 0.001

    @Before
    fun setup() {
        viewModel = TiempoViewModel()
    }

    @Test
    fun `cuando el viewmodel se inicializa el estado debe ser por defecto`() {
        val estadoActual = viewModel.iuEstado.value
        
        assertEquals(0.0, estadoActual.valorConvertible!!, 0.0)
        assertEquals(UnidadTiempo.SEGUNDO, estadoActual.unidadDeConversion)
        assertEquals(0.0, estadoActual.salidaSegundo!!, 0.0)
    }

    @Test
    fun `cuando se cambia el valor a uno valido el estado debe actualizarse y calcular salidas`() {
        // GIVEN: El usuario escribe "3600.0" (segundos por defecto)
        val nuevoValor = "3600.0"

        // WHEN
        viewModel.CambioValor(nuevoValor)

        // THEN
        val estado = viewModel.iuEstado.value
        assertEquals(3600.0, estado.valorConvertible!!, delta)
        assertEquals(3600.0, estado.salidaSegundo!!, delta)
        assertEquals(60.0, estado.salidaMinuto!!, delta)
        assertEquals(1.0, estado.salidaHora!!, delta)
        assertEquals(0.0416, estado.salidaDia!!, 0.001)
        assertEquals(0.000114, estado.salidaAño!!, 0.00001)
    }

    @Test
    fun `cuando se cambia la unidad el viewmodel debe recalcular usando el valor actual`() {
        // GIVEN: Tenemos 1.0 en Horas
        viewModel.CambioValor("1.0")
        viewModel.CambioUnidad(UnidadTiempo.HORA)
        
        // WHEN: Cambiamos el valor a 24.0 (horas)
        viewModel.CambioValor("24.0")

        // THEN
        val estado = viewModel.iuEstado.value
        assertEquals(UnidadTiempo.HORA, estado.unidadDeConversion)
        assertEquals(24.0, estado.valorConvertible!!, 0.0)

        // Validamos que 24 horas equivalgan a 1 dia
        assertEquals(86400.0, estado.salidaSegundo!!, delta)
        assertEquals(1440.0, estado.salidaMinuto!!, delta)
        assertEquals(24.0, estado.salidaHora!!, delta)
        assertEquals(1.0, estado.salidaDia!!, delta)
    }

    @Test
    fun `cuando se ingresa un texto no numerico el valor debe ser null y las salidas 0`() {
        // GIVEN: El usuario escribe basura
        val entradaInvalida = "tiempo_invalido"

        // WHEN
        viewModel.CambioValor(entradaInvalida)

        // THEN
        val estado = viewModel.iuEstado.value
        assertNull(estado.valorConvertible)
        
        // Validamos que todas las salidas se reseteen a 0.0
        assertEquals(0.0, estado.salidaSegundo!!, 0.0)
        assertEquals(0.0, estado.salidaMinuto!!, 0.0)
        assertEquals(0.0, estado.salidaHora!!, 0.0)
        assertEquals(0.0, estado.salidaDia!!, 0.0)
        assertEquals(0.0, estado.salidaAño!!, 0.0)
    }

    @Test
    fun `cuando se ingresa un valor vacio las salidas deben resetearse a 0`() {
        // GIVEN: Primero ponemos un valor
        viewModel.CambioValor("60.0")
        
        // WHEN: Luego borramos todo (valor vacío)
        viewModel.CambioValor("")

        // THEN
        val estado = viewModel.iuEstado.value
        assertNull(estado.valorConvertible)
        
        // Validamos que todas las salidas se reseteen a 0.0
        assertEquals(0.0, estado.salidaSegundo!!, 0.0)
        assertEquals(0.0, estado.salidaMinuto!!, 0.0)
        assertEquals(0.0, estado.salidaHora!!, 0.0)
        assertEquals(0.0, estado.salidaDia!!, 0.0)
        assertEquals(0.0, estado.salidaAño!!, 0.0)
    }

    @Test
    fun `validar mapeo de todas las unidades en el flujo de estado de tiempo`() {
        val unidades = UnidadTiempo.values()
        
        unidades.forEach { unidad ->
            viewModel.CambioUnidad(unidad)
            viewModel.CambioValor("1.0")
            
            val estado = viewModel.iuEstado.value
            assertEquals("Fallo en unidad: $unidad", unidad, estado.unidadDeConversion)
            
            // Validamos que todas las salidas se hayan calculado
            assertNotNull("salidaSegundo es null para $unidad", estado.salidaSegundo)
            assertNotNull("salidaMinuto es null para $unidad", estado.salidaMinuto)
            assertNotNull("salidaHora es null para $unidad", estado.salidaHora)
            assertNotNull("salidaDia es null para $unidad", estado.salidaDia)
            assertNotNull("salidaAño es null para $unidad", estado.salidaAño)
        }
    }
}
