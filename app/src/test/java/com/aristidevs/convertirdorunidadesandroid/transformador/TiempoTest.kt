package com.aristidevs.convertirdorunidadesandroid.transformador

import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class TiempoTest {

    private lateinit var tiempoTest: Tiempo
    private val delta = 0.001

    @Before
    fun onBefore() {
        tiempoTest = Tiempo()
    }

    // --- PRUEBAS PARA SEGUNDO (cSegundo) ---
    @Test
    fun `validar precision matematica en la conversion desde segundo`() {
        tiempoTest.setSegundo(86400.0) // 1 día en segundos
        tiempoTest.cSegundo()
        assertEquals(1440.0, tiempoTest.sm(), delta)
        assertEquals(24.0, tiempoTest.sh(), delta)
        assertEquals(1.0, tiempoTest.sd(), delta)
        assertEquals(0.0027376, tiempoTest.sa(), 0.000001)
    }

    @Test
    fun `validar conversion desde segundo con valores negativos`() {
        tiempoTest.setSegundo(-60.0)
        tiempoTest.cSegundo()
        assertEquals(-1.0, tiempoTest.sm(), delta)
        assertEquals(-0.01666, tiempoTest.sh(), delta)
        assertEquals(-0.000694, tiempoTest.sd(), 0.000001)
        assertEquals(-0.0000019, tiempoTest.sa(), 0.0000001)
    }

    @Test
    fun `validar conversion desde segundo con valores muy pequeños`() {
        tiempoTest.setSegundo(0.1)
        tiempoTest.cSegundo()
        assertEquals(0.001666, tiempoTest.sm(), delta)
        assertTrue(tiempoTest.sh() > 0)
    }

    @Test
    fun `validar conversion desde segundo con valores muy grandes`() {
        tiempoTest.setSegundo(31560000.0) // 1 año según la fórmula de sa
        tiempoTest.cSegundo()
        assertEquals(1.0, tiempoTest.sa(), delta)
    }

    // --- PRUEBAS PARA MINUTO (cMinuto) ---
    @Test
    fun `validar precision matematica en la conversion desde minuto`() {
        tiempoTest.setMinuto(1440.0) // 1 día en minutos
        tiempoTest.cMinuto()
        assertEquals(86400.0, tiempoTest.ms(), delta)
        assertEquals(24.0, tiempoTest.mh(), delta)
        assertEquals(1.0, tiempoTest.md(), delta)
        assertEquals(0.0027376, tiempoTest.ma(), 0.000001)
    }

    @Test
    fun `validar conversion desde minuto con valores negativos`() {
        tiempoTest.setMinuto(-60.0)
        tiempoTest.cMinuto()
        assertEquals(-3600.0, tiempoTest.ms(), delta)
        assertEquals(-1.0, tiempoTest.mh(), delta)
    }

    @Test
    fun `validar conversion desde minuto con valores muy pequeños`() {
        tiempoTest.setMinuto(0.01)
        tiempoTest.cMinuto()
        assertEquals(0.6, tiempoTest.ms(), delta)
    }

    @Test
    fun `validar conversion desde minuto con valores muy grandes`() {
        tiempoTest.setMinuto(525600.0) // Aproximadamente 1 año
        tiempoTest.cMinuto()
        assertTrue(tiempoTest.ma() > 0.9)
    }

    // --- PRUEBAS PARA HORA (cHora) ---
    @Test
    fun `validar precision matematica en la conversion desde hora`() {
        tiempoTest.setHora(24.0)
        tiempoTest.cHora()
        assertEquals(86400.0, tiempoTest.hs(), delta)
        assertEquals(1440.0, tiempoTest.hm(), delta)
        assertEquals(1.0, tiempoTest.hd(), delta)
        assertEquals(0.0027397, tiempoTest.ha(), 0.000001)
    }

    @Test
    fun `validar conversion desde hora con valores negativos`() {
        tiempoTest.setHora(-1.0)
        tiempoTest.cHora()
        assertEquals(-3600.0, tiempoTest.hs(), delta)
        assertEquals(-60.0, tiempoTest.hm(), delta)
    }

    @Test
    fun `validar conversion desde hora con valores muy pequeños`() {
        tiempoTest.setHora(0.001)
        tiempoTest.cHora()
        assertEquals(3.6, tiempoTest.hs(), delta)
    }

    @Test
    fun `validar conversion desde hora con valores muy grandes`() {
        tiempoTest.setHora(8760.0)
        tiempoTest.cHora()
        assertEquals(1.0, tiempoTest.ha(), delta)
    }

    // --- PRUEBAS PARA DÍA (cDía) ---
    @Test
    fun `validar precision matematica en la conversion desde día`() {
        tiempoTest.setDia(1.0)
        tiempoTest.cDía()
        assertEquals(86400.0, tiempoTest.ds(), delta)
        assertEquals(1440.0, tiempoTest.dm(), delta)
        assertEquals(24.0, tiempoTest.dh(), delta)
        assertEquals(0.0027397, tiempoTest.da(), 0.000001)
    }

    @Test
    fun `validar conversion desde día con valores negativos`() {
        tiempoTest.setDia(-1.0)
        tiempoTest.cDía()
        assertEquals(-86400.0, tiempoTest.ds(), delta)
        assertEquals(-24.0, tiempoTest.dh(), delta)
    }

    @Test
    fun `validar conversion desde día con valores muy pequeños`() {
        tiempoTest.setDia(0.01)
        tiempoTest.cDía()
        assertEquals(864.0, tiempoTest.ds(), delta)
    }

    @Test
    fun `validar conversion desde día con valores muy grandes`() {
        tiempoTest.setDia(365.0)
        tiempoTest.cDía()
        assertEquals(1.0, tiempoTest.da(), delta)
    }

    // --- PRUEBAS PARA AÑO (cAño) ---
    @Test
    fun `validar precision matematica en la conversion desde año`() {
        tiempoTest.setAño(1.0)
        tiempoTest.cAño()
        assertEquals(31560000.0, tiempoTest.`as`(), delta)
        assertEquals(525600.0, tiempoTest.am(), delta)
        assertEquals(8760.0, tiempoTest.ah(), delta)
        assertEquals(365.0, tiempoTest.ad(), delta)
    }

    @Test
    fun `validar conversion desde año con valores negativos`() {
        tiempoTest.setAño(-1.0)
        tiempoTest.cAño()
        assertEquals(-31560000.0, tiempoTest.`as`(), delta)
        assertEquals(-365.0, tiempoTest.ad(), delta)
    }

    @Test
    fun `validar conversion desde año con valores muy pequeños`() {
        tiempoTest.setAño(0.001)
        tiempoTest.cAño()
        assertEquals(31560.0, tiempoTest.`as`(), delta)
    }

    @Test
    fun `validar conversion desde año con valores muy grandes`() {
        tiempoTest.setAño(10.0)
        tiempoTest.cAño()
        assertEquals(3650.0, tiempoTest.ad(), delta)
    }
}
