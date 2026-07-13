package com.aristidevs.convertirdorunidadesandroid.transformador

import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class MasaTest {

    private lateinit var masaTest: Masa
    private val delta = 0.001

    @Before
    fun onBefore() {
        masaTest = Masa()
    }

    // --- PRUEBAS PARA GRAMO (cgramo) ---
    @Test
    fun `validar precision matematica en la conversion desde gramo`() {
        masaTest.setGramo(1000.0)
        masaTest.cgramo()
        assertEquals(1.0, masaTest.getGkg(), delta)
        assertEquals(2.20463, masaTest.getGlib(), 0.001)
        assertEquals(0.001, masaTest.getGtn(), delta)
    }

    @Test
    fun `validar conversion desde gramo con valores negativos`() {
        masaTest.setGramo(-1000.0)
        masaTest.cgramo()
        assertEquals(-1.0, masaTest.getGkg(), delta)
        assertEquals(-2.20463, masaTest.getGlib(), 0.001)
        assertEquals(-0.001, masaTest.getGtn(), delta)
    }

    @Test
    fun `validar conversion desde gramo con valores muy pequeños`() {
        masaTest.setGramo(0.1)
        masaTest.cgramo()
        assertEquals(0.0001, masaTest.getGkg(), delta)
        assertEquals(0.00022, masaTest.getGlib(), 0.0001)
        assertEquals(1.0E-7, masaTest.getGtn(), 1e-8)
    }

    @Test
    fun `validar conversion desde gramo con valores muy grandes`() {
        masaTest.setGramo(1000000.0)
        masaTest.cgramo()
        assertEquals(1000.0, masaTest.getGkg(), delta)
        assertEquals(2204.63, masaTest.getGlib(), 0.1)
        assertEquals(1.0, masaTest.getGtn(), delta)
    }

    // --- PRUEBAS PARA KILOGRAMO (ckilogramo) ---
    @Test
    fun `validar precision matematica en la conversion desde kilogramo`() {
        masaTest.setKilogramo(1.0)
        masaTest.ckilogramo()
        assertEquals(1000.0, masaTest.getKgg(), delta)
        assertEquals(2.20462, masaTest.getKglb(), delta)
        assertEquals(0.001, masaTest.getKgtn(), delta)
    }

    @Test
    fun `validar conversion desde kilogramo con valores negativos`() {
        masaTest.setKilogramo(-1.0)
        masaTest.ckilogramo()
        assertEquals(-1000.0, masaTest.getKgg(), delta)
        assertEquals(-2.20462, masaTest.getKglb(), delta)
        assertEquals(-0.001, masaTest.getKgtn(), delta)
    }

    @Test
    fun `validar conversion desde kilogramo con valores muy pequeños`() {
        masaTest.setKilogramo(0.001)
        masaTest.ckilogramo()
        assertEquals(1.0, masaTest.getKgg(), delta)
        assertEquals(0.002204, masaTest.getKglb(), delta)
        assertEquals(0.000001, masaTest.getKgtn(), 1e-7)
    }

    @Test
    fun `validar conversion desde kilogramo con valores muy grandes`() {
        masaTest.setKilogramo(1000.0)
        masaTest.ckilogramo()
        assertEquals(1000000.0, masaTest.getKgg(), delta)
        assertEquals(2204.62, masaTest.getKglb(), 0.1)
        assertEquals(1.0, masaTest.getKgtn(), delta)
    }

    // --- PRUEBAS PARA LIBRA (clibra) ---
    @Test
    fun `validar precision matematica en la conversion desde libra`() {
        masaTest.setLibra(1.0)
        masaTest.clibra()
        assertEquals(453.59, masaTest.getLbg(), delta)
        assertEquals(0.45359, masaTest.getLbkg(), delta)
        assertEquals(0.000453, masaTest.getLbtn(), 0.0001)
    }

    @Test
    fun `validar conversion desde libra con valores negativos`() {
        masaTest.setLibra(-1.0)
        masaTest.clibra()
        assertEquals(-453.59, masaTest.getLbg(), delta)
        assertEquals(-0.45359, masaTest.getLbkg(), delta)
        assertEquals(-0.000453, masaTest.getLbtn(), 0.0001)
    }

    @Test
    fun `validar conversion desde libra con valores muy pequeños`() {
        masaTest.setLibra(0.01)
        masaTest.clibra()
        assertEquals(4.5359, masaTest.getLbg(), delta)
        assertEquals(0.00453, masaTest.getLbkg(), delta)
        assertEquals(4.5359E-6, masaTest.getLbtn(), 1e-7)
    }

    @Test
    fun `validar conversion desde libra con valores muy grandes`() {
        masaTest.setLibra(1000.0)
        masaTest.clibra()
        assertEquals(453590.0, masaTest.getLbg(), delta)
        assertEquals(453.59237, masaTest.getLbkg(), delta)
        assertEquals(0.45359, masaTest.getLbtn(), delta)
    }

    // --- PRUEBAS PARA TONELADA (ctonelada) ---
    @Test
    fun `validar precision matematica en la conversion desde tonelada`() {
        masaTest.setTonelada(1.0)
        masaTest.ctonelada()
        assertEquals(1000000.0, masaTest.getTng(), delta)
        assertEquals(1000.0, masaTest.getTnkg(), delta)
        assertEquals(2204.62, masaTest.getTnlb(), 0.1)
    }

    @Test
    fun `validar conversion desde tonelada con valores negativos`() {
        masaTest.setTonelada(-1.0)
        masaTest.ctonelada()
        assertEquals(-1000000.0, masaTest.getTng(), delta)
        assertEquals(-1000.0, masaTest.getTnkg(), delta)
        assertEquals(-2204.62, masaTest.getTnlb(), 0.1)
    }

    @Test
    fun `validar conversion desde tonelada con valores muy pequeños`() {
        masaTest.setTonelada(0.001)
        masaTest.ctonelada()
        assertEquals(1000.0, masaTest.getTng(), delta)
        assertEquals(1.0, masaTest.getTnkg(), delta)
        assertEquals(2.20462, masaTest.getTnlb(), delta)
    }

    @Test
    fun `validar conversion desde tonelada con valores muy grandes`() {
        masaTest.setTonelada(100.0)
        masaTest.ctonelada()
        assertEquals(1.0E8, masaTest.getTng(), delta)
        assertEquals(100000.0, masaTest.getTnkg(), delta)
        assertEquals(220462.26, masaTest.getTnlb(), 1.0)
    }
}
