package com.aristidevs.convertirdorunidadesandroid.transformador

import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class VolumenTest {

    private lateinit var volumenTest: Volumen
    private val delta = 0.001

    @Before
    fun onBefore() {
        volumenTest = Volumen()
    }

    // --- PRUEBAS PARA CENTIMETRO (ccm) ---
    @Test
    fun `validar precision matematica en la conversion desde centimetro`() {
        volumenTest.setCentimetro(1000.0)
        volumenTest.ccm()
        assertEquals(0.001, volumenTest.getCmm(), delta)
        assertEquals(0.03531, volumenTest.getCmft(), delta)
        assertEquals(61.0237, volumenTest.getCmin(), delta)
        assertEquals(1.0, volumenTest.getCmlt(), delta)
        assertEquals(0.26417, volumenTest.getCmg(), delta)
    }

    @Test
    fun `validar conversion desde centimetro con valores negativos`() {
        volumenTest.setCentimetro(-1000.0)
        volumenTest.ccm()
        assertEquals(-0.001, volumenTest.getCmm(), delta)
        assertEquals(-0.03531, volumenTest.getCmft(), delta)
        assertEquals(-61.0237, volumenTest.getCmin(), delta)
        assertEquals(-1.0, volumenTest.getCmlt(), delta)
        assertEquals(-0.26417, volumenTest.getCmg(), delta)
    }

    @Test
    fun `validar conversion desde centimetro con valores muy pequeños`() {
        volumenTest.setCentimetro(0.1)
        volumenTest.ccm()
        assertEquals(0.0000001, volumenTest.getCmm(), 1e-8)
        assertEquals(0.00000353, volumenTest.getCmft(), 1e-8)
        assertEquals(0.006102, volumenTest.getCmin(), 0.0001)
        assertEquals(0.0001, volumenTest.getCmlt(), delta)
        assertEquals(0.0000264, volumenTest.getCmg(), 1e-7)
    }

    @Test
    fun `validar conversion desde centimetro con valores muy grandes`() {
        volumenTest.setCentimetro(1000000.0)
        volumenTest.ccm()
        assertEquals(1.0, volumenTest.getCmm(), delta)
        assertEquals(35.3146, volumenTest.getCmft(), delta)
        assertEquals(61023.74, volumenTest.getCmin(), delta)
        assertEquals(1000.0, volumenTest.getCmlt(), delta)
        assertEquals(264.172, volumenTest.getCmg(), 0.1)
    }

    // --- PRUEBAS PARA METRO (cm) ---
    @Test
    fun `validar precision matematica en la conversion desde metro`() {
        volumenTest.setMetro(1.0)
        volumenTest.cm()
        assertEquals(1000000.0, volumenTest.getMcm(), delta)
        assertEquals(35.3, volumenTest.getMft(), delta)
        assertEquals(61023.74, volumenTest.getMin(), delta)
        assertEquals(1000.0, volumenTest.getMlt(), delta)
        assertEquals(264.17, volumenTest.getMg(), delta)
    }

    @Test
    fun `validar conversion desde metro con valores negativos`() {
        volumenTest.setMetro(-1.0)
        volumenTest.cm()
        assertEquals(-1000000.0, volumenTest.getMcm(), delta)
        assertEquals(-35.3, volumenTest.getMft(), delta)
        assertEquals(-61023.74, volumenTest.getMin(), delta)
        assertEquals(-1000.0, volumenTest.getMlt(), delta)
        assertEquals(-264.17, volumenTest.getMg(), delta)
    }

    @Test
    fun `validar conversion desde metro con valores muy pequeños`() {
        volumenTest.setMetro(0.0001)
        volumenTest.cm()
        assertEquals(100.0, volumenTest.getMcm(), delta)
        assertEquals(0.00353, volumenTest.getMft(), delta)
        assertEquals(6.10237, volumenTest.getMin(), delta)
        assertEquals(0.1, volumenTest.getMlt(), delta)
        assertEquals(0.02641, volumenTest.getMg(), delta)
    }

    @Test
    fun `validar conversion desde metro con valores muy grandes`() {
        volumenTest.setMetro(100.0)
        volumenTest.cm()
        assertEquals(1.0E8, volumenTest.getMcm(), delta)
        assertEquals(3530.0, volumenTest.getMft(), delta)
        assertEquals(6102374.0, volumenTest.getMin(), delta)
        assertEquals(100000.0, volumenTest.getMlt(), delta)
        assertEquals(26417.0, volumenTest.getMg(), delta)
    }

    // --- PRUEBAS PARA PIE (cft) ---
    @Test
    fun `validar precision matematica en la conversion desde pie`() {
        volumenTest.setPie(1.0)
        volumenTest.cft()
        assertEquals(28316.84, volumenTest.getFtcm(), delta)
        assertEquals(0.0283, volumenTest.getFtm(), delta)
        assertEquals(1728.0, volumenTest.getFtin(), delta)
        assertEquals(28.3, volumenTest.getFtlt(), delta)
        assertEquals(7.48, volumenTest.getFtg(), delta)
    }

    @Test
    fun `validar conversion desde pie con valores negativos`() {
        volumenTest.setPie(-1.0)
        volumenTest.cft()
        assertEquals(-28316.84, volumenTest.getFtcm(), delta)
        assertEquals(-0.0283, volumenTest.getFtm(), delta)
        assertEquals(-1728.0, volumenTest.getFtin(), delta)
        assertEquals(-28.3, volumenTest.getFtlt(), delta)
        assertEquals(-7.48, volumenTest.getFtg(), delta)
    }

    @Test
    fun `validar conversion desde pie con valores muy pequeños`() {
        volumenTest.setPie(0.01)
        volumenTest.cft()
        assertEquals(283.168, volumenTest.getFtcm(), delta)
        assertEquals(0.000283, volumenTest.getFtm(), delta)
        assertEquals(17.28, volumenTest.getFtin(), delta)
        assertEquals(0.283, volumenTest.getFtlt(), delta)
        assertEquals(0.0748, volumenTest.getFtg(), delta)
    }

    @Test
    fun `validar conversion desde pie con valores muy grandes`() {
        volumenTest.setPie(1000.0)
        volumenTest.cft()
        assertEquals(2.831684E7, volumenTest.getFtcm(), delta)
        assertEquals(28.3, volumenTest.getFtm(), delta)
        assertEquals(1728000.0, volumenTest.getFtin(), delta)
        assertEquals(28300.0, volumenTest.getFtlt(), delta)
        assertEquals(7480.0, volumenTest.getFtg(), delta)
    }

    // --- PRUEBAS PARA PULGADA (cin) ---
    @Test
    fun `validar precision matematica en la conversion desde pulgada`() {
        volumenTest.setPulgada(1728.0)
        volumenTest.cin()
        assertEquals(28316.846, volumenTest.getIncm(), 0.1)
        assertEquals(0.02832, volumenTest.getInm(), 0.001)
        assertEquals(1.0, volumenTest.getInft(), delta)
        assertEquals(28.3168, volumenTest.getInlt(), delta)
        assertEquals(7.4805, volumenTest.getIng(), delta)
    }

    @Test
    fun `validar conversion desde pulgada con valores negativos`() {
        volumenTest.setPulgada(-1728.0)
        volumenTest.cin()
        assertEquals(-28316.846, volumenTest.getIncm(), 0.1)
        assertEquals(-0.02832, volumenTest.getInm(), 0.001)
        assertEquals(-1.0, volumenTest.getInft(), delta)
        assertEquals(-28.3168, volumenTest.getInlt(), delta)
        assertEquals(-7.4805, volumenTest.getIng(), delta)
    }

    @Test
    fun `validar conversion desde pulgada con valores muy pequeños`() {
        volumenTest.setPulgada(1.0)
        volumenTest.cin()
        assertEquals(16.3870, volumenTest.getIncm(), delta)
        assertEquals(0.000016, volumenTest.getInm(), 1e-6)
        assertEquals(0.000578, volumenTest.getInft(), 1e-6)
        assertEquals(0.016387, volumenTest.getInlt(), delta)
        assertEquals(0.004329, volumenTest.getIng(), 0.0001)
    }

    @Test
    fun `validar conversion desde pulgada con valores muy grandes`() {
        volumenTest.setPulgada(1728000.0)
        volumenTest.cin()
        assertEquals(28316846.592, volumenTest.getIncm(), delta)
        assertEquals(28.327, volumenTest.getInm(), 0.1)
        assertEquals(1000.0, volumenTest.getInft(), delta)
        assertEquals(28316.84, volumenTest.getInlt(), 1.0)
        assertEquals(7480.519, volumenTest.getIng(), 0.1)
    }

    // --- PRUEBAS PARA LITRO (clt) ---
    @Test
    fun `validar precision matematica en la conversion desde litro`() {
        volumenTest.setLitro(1000.0)
        volumenTest.clt()
        assertEquals(1000000.0, volumenTest.getLtcm(), delta)
        assertEquals(1.0, volumenTest.getLtm(), delta)
        assertEquals(35.3146, volumenTest.getLtft(), delta)
        assertEquals(61023.0, volumenTest.getLtin(), delta)
        assertEquals(264.172, volumenTest.getLtg(), 0.01)
    }

    @Test
    fun `validar conversion desde litro con valores negativos`() {
        volumenTest.setLitro(-1000.0)
        volumenTest.clt()
        assertEquals(-1000000.0, volumenTest.getLtcm(), delta)
        assertEquals(-1.0, volumenTest.getLtm(), delta)
        assertEquals(-35.3146, volumenTest.getLtft(), delta)
        assertEquals(-61023.0, volumenTest.getLtin(), delta)
        assertEquals(-264.172, volumenTest.getLtg(), 0.01)
    }

    @Test
    fun `validar conversion desde litro con valores muy pequeños`() {
        volumenTest.setLitro(0.1)
        volumenTest.clt()
        assertEquals(100.0, volumenTest.getLtcm(), delta)
        assertEquals(0.0001, volumenTest.getLtm(), delta)
        assertEquals(0.00353, volumenTest.getLtft(), delta)
        assertEquals(6.1023, volumenTest.getLtin(), delta)
        assertEquals(0.02641, volumenTest.getLtg(), delta)
    }

    @Test
    fun `validar conversion desde litro con valores muy grandes`() {
        volumenTest.setLitro(1000000.0)
        volumenTest.clt()
        assertEquals(1.0E9, volumenTest.getLtcm(), delta)
        assertEquals(1000.0, volumenTest.getLtm(), delta)
        assertEquals(35314.66, volumenTest.getLtft(), 1.0)
        assertEquals(6.1023E7, volumenTest.getLtin(), 10.0)
        assertEquals(264172.05, volumenTest.getLtg(), 1.0)
    }

    // --- PRUEBAS PARA GALON (cg) ---
    @Test
    fun `validar precision matematica en la conversion desde galon`() {
        volumenTest.setGalon(1.0)
        volumenTest.cg()
        assertEquals(3785.41, volumenTest.getGcm(), delta)
        assertEquals(0.0037, volumenTest.getGm(), delta)
        assertEquals(0.13368, volumenTest.getGft(), delta)
        assertEquals(231.0, volumenTest.getGin(), delta)
        assertEquals(3.785, volumenTest.getGlt(), delta)
    }

    @Test
    fun `validar conversion desde galon con valores negativos`() {
        volumenTest.setGalon(-1.0)
        volumenTest.cg()
        assertEquals(-3785.41, volumenTest.getGcm(), delta)
        assertEquals(-0.0037, volumenTest.getGm(), delta)
        assertEquals(-0.13368, volumenTest.getGft(), delta)
        assertEquals(-231.0, volumenTest.getGin(), delta)
        assertEquals(-3.785, volumenTest.getGlt(), delta)
    }

    @Test
    fun `validar conversion desde galon con valores muy pequeños`() {
        volumenTest.setGalon(0.01)
        volumenTest.cg()
        assertEquals(37.8541, volumenTest.getGcm(), delta)
        assertEquals(0.000037, volumenTest.getGm(), 1e-6)
        assertEquals(0.001336, volumenTest.getGft(), 1e-5)
        assertEquals(2.31, volumenTest.getGin(), delta)
        assertEquals(0.03785, volumenTest.getGlt(), delta)
    }

    @Test
    fun `validar conversion desde galon con valores muy grandes`() {
        volumenTest.setGalon(1000.0)
        volumenTest.cg()
        assertEquals(3785410.0, volumenTest.getGcm(), delta)
        assertEquals(3.7, volumenTest.getGm(), delta)
        assertEquals(133.68, volumenTest.getGft(), delta)
        assertEquals(231000.0, volumenTest.getGin(), delta)
        assertEquals(3785.0, volumenTest.getGlt(), delta)
    }
}
