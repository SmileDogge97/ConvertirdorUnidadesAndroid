package com.aristidevs.convertirdorunidadesandroid.transformador

import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class AreaTest {

    private lateinit var areaTest: Area
    private val delta = 0.001

    @Before
    fun onBefore() {
        areaTest = Area()
    }

    // --- PRUEBAS PARA METRO (cmt) ---
    @Test
    fun `validar precision matematica en la conversion desde metro`() {
        areaTest.setm(1.0)
        areaTest.cmt()
        assertEquals(0.0001, areaTest.getMh(), delta)
        assertEquals(10000.0, areaTest.getMcm(), delta)
        assertEquals(1549.996, areaTest.getMin(), 0.01)
        assertEquals(10.76, areaTest.getMft(), delta)
        assertEquals(1.1956, areaTest.getMyd(), 0.001)
        assertEquals(3.8610E-7, areaTest.getMmi(), delta)
    }

    @Test
    fun `validar conversion desde metro con valores negativos`() {
        areaTest.setm(-10.0)
        areaTest.cmt()
        assertEquals(-0.001, areaTest.getMh(), delta)
        assertEquals(-100000.0, areaTest.getMcm(), delta)
        assertEquals(-15499.96, areaTest.getMin(), 0.1)
        assertEquals(-107.6, areaTest.getMft(), delta)
        assertEquals(-11.956, areaTest.getMyd(), 0.01)
        assertEquals(-3.8610e-6, areaTest.getMmi(), 1e-7)
    }

    @Test
    fun `validar conversion desde metro con valores muy pequeños`() {
        areaTest.setm(0.00001)
        areaTest.cmt()
        assertEquals(1e-9, areaTest.getMh(), 1e-10)
        assertEquals(0.1, areaTest.getMcm(), delta)
        assertEquals(0.01549, areaTest.getMin(), 0.001)
        assertEquals(0.0001076, areaTest.getMft(), 1e-7)
        assertEquals(0.000011956, areaTest.getMyd(), 1e-8)
        assertEquals(3.8610e-12, areaTest.getMmi(), 1e-18)
    }

    @Test
    fun `validar conversion desde metro con valores muy grandes`() {
        areaTest.setm(1000000.0)
        areaTest.cmt()
        assertEquals(100.0, areaTest.getMh(), delta)
        assertEquals(1.0e10, areaTest.getMcm(), 1.0)
        assertEquals(1.54999e9, areaTest.getMin(), 1.0e5)
        assertEquals(1.076e7, areaTest.getMft(), 1.0e3)
        assertEquals(1195599.4, areaTest.getMyd(), 1.0)
        assertEquals(0.3861, areaTest.getMmi(), delta)
    }

    // --- PRUEBAS PARA HECTAREA (cht) ---
    @Test
    fun `validar precision matematica en la conversion desde hectarea`() {
        areaTest.seth(1.0)
        areaTest.cht()
        assertEquals(10000.0, areaTest.getHm(), delta)
        assertEquals(100000000.0, areaTest.getHcm(), delta)
        assertEquals(15499969.0, areaTest.getHin(), 1.0)
        assertEquals(107639.104, areaTest.getHft(), 0.01)
        assertEquals(11959.9005, areaTest.getHyd(), delta)
        assertEquals(0.003861, areaTest.getHmi(), 0.000001)
    }

    @Test
    fun `validar conversion desde hectarea con valores negativos`() {
        areaTest.seth(-5.0)
        areaTest.cht()
        assertEquals(-50000.0, areaTest.getHm(), delta)
        assertEquals(-500000000.0, areaTest.getHcm(), delta)
        assertEquals(-77499845.0, areaTest.getHin(), 1.0)
        assertEquals(-538195.52, areaTest.getHft(), 0.1)
        assertEquals(-59799.5025, areaTest.getHyd(), delta)
        assertEquals(-0.019305, areaTest.getHmi(), 0.000001)
    }

    @Test
    fun `validar conversion desde hectarea con valores muy pequeños`() {
        areaTest.seth(0.0001)
        areaTest.cht()
        assertEquals(1.0, areaTest.getHm(), delta)
        assertEquals(10000.0, areaTest.getHcm(), delta)
        assertEquals(1549.9969, areaTest.getHin(), 0.01)
        assertEquals(10.7639, areaTest.getHft(), 0.001)
        assertEquals(1.19599, areaTest.getHyd(), 0.0001)
        assertEquals(3.861e-7, areaTest.getHmi(), 1e-10)
    }

    @Test
    fun `validar conversion desde hectarea con valores muy grandes`() {
        areaTest.seth(1000.0)
        areaTest.cht()
        assertEquals(1.0e7, areaTest.getHm(), delta)
        assertEquals(1.0e11, areaTest.getHcm(), 1.0)
        assertEquals(1.54999e10, areaTest.getHin(), 1.0e6)
        assertEquals(1.07639e8, areaTest.getHft(), 1.0e4)
        assertEquals(1.19599e7, areaTest.getHyd(), 10.0)
        assertEquals(3.861, areaTest.getHmi(), 0.001)
    }

    // --- PRUEBAS PARA CENTIMETRO (ccm) ---
    @Test
    fun `validar precision matematica en la conversion desde centimetro`() {
        areaTest.setcm(10000.0)
        areaTest.ccm()
        assertEquals(1.0, areaTest.getCmm(), delta)
        assertEquals(0.0001, areaTest.getCmh(), delta)
        assertEquals(1550.0, areaTest.getCmin(), 0.1)
        assertEquals(10.8, areaTest.getCmft(), 0.1)
        assertEquals(1.196, areaTest.getCmyd(), delta)
        assertEquals(3.861e-7, areaTest.getCmmi(), 1e-10)
    }

    @Test
    fun `validar conversion desde centimetro con valores negativos`() {
        areaTest.setcm(-100.0)
        areaTest.ccm()
        assertEquals(-0.01, areaTest.getCmm(), delta)
        assertEquals(-1.0e-6, areaTest.getCmh(), 1e-7)
        assertEquals(-15.5, areaTest.getCmin(), delta)
        assertEquals(-0.108, areaTest.getCmft(), delta)
        assertEquals(-0.01196, areaTest.getCmyd(), delta)
        assertEquals(-3.861e-9, areaTest.getCmmi(), 1e-10)
    }

    @Test
    fun `validar conversion desde centimetro con valores muy pequeños`() {
        areaTest.setcm(0.01)
        areaTest.ccm()
        assertEquals(1.0e-6, areaTest.getCmm(), 1e-7)
        assertEquals(1.0e-10, areaTest.getCmh(), 1e-11)
        assertEquals(0.00155, areaTest.getCmin(), 1e-5)
        assertEquals(1.08e-5, areaTest.getCmft(), 1e-7)
        assertEquals(1.196e-6, areaTest.getCmyd(), 1e-9)
        assertEquals(3.861e-13, areaTest.getCmmi(), 1e-15)
    }

    @Test
    fun `validar conversion desde centimetro con valores muy grandes`() {
        areaTest.setcm(100000000.0)
        areaTest.ccm()
        assertEquals(10000.0, areaTest.getCmm(), delta)
        assertEquals(1.0, areaTest.getCmh(), delta)
        assertEquals(1.55e7, areaTest.getCmin(), 1.0e4)
        assertEquals(108000.0, areaTest.getCmft(), 1.0)
        assertEquals(11960.0, areaTest.getCmyd(), 1.0)
        assertEquals(0.003861, areaTest.getCmmi(), 0.000001)
    }

    // --- PRUEBAS PARA PULGADA (cin) ---
    @Test
    fun `validar precision matematica en la conversion desde pulgada`() {
        areaTest.setin(1550.0)
        areaTest.cin()
        assertEquals(1.0, areaTest.getInm(), 0.01)
        assertEquals(0.0001, areaTest.getInh(), 0.00001)
        assertEquals(10000.0, areaTest.getIncm(), 0.1)
        assertEquals(10.763, areaTest.getInft(), 0.01)
        assertEquals(1.196, areaTest.getInyd(), 0.01)
        assertEquals(3.861e-7, areaTest.getInmi(), 1e-10)
    }

    @Test
    fun `validar conversion desde pulgada con valores negativos`() {
        areaTest.setin(-144.0)
        areaTest.cin()
        assertEquals(-0.0929, areaTest.getInm(), 0.001)
        assertEquals(-9.29e-6, areaTest.getInh(), 1e-7)
        assertEquals(-929.03, areaTest.getIncm(), 0.01)
        assertEquals(-1.0, areaTest.getInft(), delta)
        assertEquals(-0.1111, areaTest.getInyd(), 0.001)
        assertEquals(-3.587e-8, areaTest.getInmi(), 1e-10)
    }

    @Test
    fun `validar conversion desde pulgada con valores muy pequeños`() {
        areaTest.setin(0.0001)
        areaTest.cin()
        assertEquals(6.4516e-8, areaTest.getInm(), 1e-9)
        assertEquals(6.451e-12, areaTest.getInh(), 1e-13)
        assertEquals(0.00064516, areaTest.getIncm(), 1e-6)
        assertEquals(6.944e-7, areaTest.getInft(), 1e-9)
        assertEquals(7.716e-8, areaTest.getInyd(), 1e-10)
        assertEquals(2.491e-14, areaTest.getInmi(), 1e-16)
    }

    @Test
    fun `validar conversion desde pulgada con valores muy grandes`() {
        areaTest.setin(129600.0)
        areaTest.cin()
        assertEquals(83.61, areaTest.getInm(), 0.1)
        assertEquals(0.00836, areaTest.getInh(), 0.0001)
        assertEquals(836127.36, areaTest.getIncm(), 1.0)
        assertEquals(900.0, areaTest.getInft(), delta)
        assertEquals(100.0, areaTest.getInyd(), delta)
        assertEquals(3.228e-5, areaTest.getInmi(), 1e-7)
    }

    // --- PRUEBAS PARA PIES (cft) ---
    @Test
    fun `validar precision matematica en la conversion desde pies`() {
        areaTest.setft(10.7639)
        areaTest.cft()
        assertEquals(1.0, areaTest.getFtm(), delta)
        assertEquals(0.0001, areaTest.getFth(), delta)
        assertEquals(10000.0, areaTest.getFtcm(), 1.0)
        assertEquals(1550.0, areaTest.getFtin(), 1.0)
        assertEquals(1.196, areaTest.getFtyd(), 0.01)
        assertEquals(3.861e-7, areaTest.getFtmi(), 1e-10)
    }

    @Test
    fun `validar conversion desde pies con valores negativos`() {
        areaTest.setft(-9.0)
        areaTest.cft()
        assertEquals(-0.8361, areaTest.getFtm(), 0.001)
        assertEquals(-8.36e-5, areaTest.getFth(), 1e-6)
        assertEquals(-8361.27, areaTest.getFtcm(), 0.1)
        assertEquals(-1296.0, areaTest.getFtin(), delta)
        assertEquals(-1.0, areaTest.getFtyd(), delta)
        assertEquals(-3.228e-7, areaTest.getFtmi(), 1e-9)
    }

    @Test
    fun `validar conversion desde pies con valores muy pequeños`() {
        areaTest.setft(0.09)
        areaTest.cft()
        assertEquals(0.00836, areaTest.getFtm(), 0.0001)
        assertEquals(8.36e-7, areaTest.getFth(), 1e-8)
        assertEquals(83.6127, areaTest.getFtcm(), 0.01)
        assertEquals(12.96, areaTest.getFtin(), delta)
        assertEquals(0.01, areaTest.getFtyd(), delta)
        assertEquals(3.228e-9, areaTest.getFtmi(), 1e-11)
    }

    @Test
    fun `validar conversion desde pies con valores muy grandes`() {
        areaTest.setft(9000.0)
        areaTest.cft()
        assertEquals(836.127, areaTest.getFtm(), 0.1)
        assertEquals(0.08361, areaTest.getFth(), 0.001)
        assertEquals(8361273.6, areaTest.getFtcm(), 1.0)
        assertEquals(1296000.0, areaTest.getFtin(), 1.0)
        assertEquals(1000.0, areaTest.getFtyd(), delta)
        assertEquals(0.0003228, areaTest.getFtmi(), 1e-6)
    }

    // --- PRUEBAS PARA YARDA (cyd) ---
    @Test
    fun `validar precision matematica en la conversion desde yarda`() {
        areaTest.setyd(1.19599)
        areaTest.cyd()
        assertEquals(1.0, areaTest.getYdm(), delta)
        assertEquals(0.0001, areaTest.getYdh(), delta)
        assertEquals(10000.0, areaTest.getYdcm(), 1.0)
        assertEquals(1550.0, areaTest.getYdin(), 1.0)
        assertEquals(10.7639, areaTest.getYdft(), 0.01)
        assertEquals(3.861e-7, areaTest.getYdmi(), 1e-10)
    }

    @Test
    fun `validar conversion desde yarda con valores negativos`() {
        areaTest.setyd(-1.0)
        areaTest.cyd()
        assertEquals(-0.8361, areaTest.getYdm(), delta)
        assertEquals(-8.362e-5, areaTest.getYdh(), 1e-7)
        assertEquals(-8361.27, areaTest.getYdcm(), 0.1)
        assertEquals(-1296.0, areaTest.getYdin(), delta)
        assertEquals(-9.0, areaTest.getYdft(), delta)
        assertEquals(-3.228e-7, areaTest.getYdmi(), 1e-9)
    }

    @Test
    fun `validar conversion desde yarda con valores muy pequeños`() {
        areaTest.setyd(0.01)
        areaTest.cyd()
        assertEquals(0.008361, areaTest.getYdm(), 0.0001)
        assertEquals(8.36e-7, areaTest.getYdh(), 1e-8)
        assertEquals(83.6127, areaTest.getYdcm(), 0.01)
        assertEquals(12.96, areaTest.getYdin(), delta)
        assertEquals(0.09, areaTest.getYdft(), delta)
        assertEquals(3.228e-9, areaTest.getYdmi(), 1e-11)
    }

    @Test
    fun `validar conversion desde yarda con valores muy grandes`() {
        areaTest.setyd(1000.0)
        areaTest.cyd()
        assertEquals(836.1, areaTest.getYdm(), 0.1)
        assertEquals(0.0836, areaTest.getYdh(), 0.001)
        assertEquals(8361273.6, areaTest.getYdcm(), 1.0)
        assertEquals(1296000.0, areaTest.getYdin(), 1.0)
        assertEquals(9000.0, areaTest.getYdft(), delta)
        assertEquals(0.0003228, areaTest.getYdmi(), 1e-6)
    }

    // --- PRUEBAS PARA MILLA (cmi) ---
    @Test
    fun `validar precision matematica en la conversion desde milla`() {
        areaTest.setmi(1.0)
        areaTest.cmi()
        assertEquals(2590000.0, areaTest.getMim(), delta)
        assertEquals(258.998811, areaTest.getMih(), delta)
        assertEquals(2.59e10, areaTest.getMicm(), 1e7)
        assertEquals(4.0145e9, areaTest.getMiin(), 1e6)
        assertEquals(2.78784e7, areaTest.getMift(), 1e2)
        assertEquals(3097600.0, areaTest.getMiyd(), delta)
    }

    @Test
    fun `validar conversion desde milla con valores negativos`() {
        areaTest.setmi(-1.0)
        areaTest.cmi()
        assertEquals(-2590000.0, areaTest.getMim(), delta)
        assertEquals(-258.998811, areaTest.getMih(), delta)
        assertEquals(-2.59e10, areaTest.getMicm(), 1e7)
        assertEquals(-4.0145e9, areaTest.getMiin(), 1e6)
        assertEquals(-2.78784e7, areaTest.getMift(), 1e2)
        assertEquals(-3097600.0, areaTest.getMiyd(), delta)
    }

    @Test
    fun `validar conversion desde milla con valores muy pequeños`() {
        areaTest.setmi(0.001)
        areaTest.cmi()
        assertEquals(2590.0, areaTest.getMim(), delta)
        assertEquals(0.258998, areaTest.getMih(), delta)
        assertEquals(2.59e7, areaTest.getMicm(), 1e4)
        assertEquals(4014500.0, areaTest.getMiin(), 1.0)
        assertEquals(27878.4, areaTest.getMift(), 0.1)
        assertEquals(3097.6, areaTest.getMiyd(), delta)
    }

    @Test
    fun `validar conversion desde milla con valores muy grandes`() {
        areaTest.setmi(100.0)
        areaTest.cmi()
        assertEquals(2.59e8, areaTest.getMim(), 1.0e5)
        assertEquals(25899.8811, areaTest.getMih(), delta)
        assertEquals(2.59e12, areaTest.getMicm(), 1.0e9)
        assertEquals(4.0145e11, areaTest.getMiin(), 1.0e8)
        assertEquals(2.78784e9, areaTest.getMift(), 1.0e6)
        assertEquals(3.0976e8, areaTest.getMiyd(), 1.0)
    }
}
