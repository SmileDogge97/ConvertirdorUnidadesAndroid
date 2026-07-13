package com.aristidevs.convertirdorunidadesandroid.transformador

import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class LongitudTest {

    private lateinit var longitudTest: Longitud
    private val delta = 0.001

    @Before
    fun onBefore() {
        longitudTest = Longitud()
    }

    // --- PRUEBAS PARA METRO (cMetro) ---
    @Test
    fun `validar precision matematica en la conversion desde metro`() {
        longitudTest.setMetro(1000.0)
        longitudTest.cMetro()
        assertEquals(1.0, longitudTest.getMkm(), delta)
        assertEquals(100000.0, longitudTest.getMcm(), delta)
        assertEquals(39370.0, longitudTest.getMin(), delta)
        assertEquals(3281.0, longitudTest.getMft(), delta)
        assertEquals(1093.6, longitudTest.getMyd(), delta)
        assertEquals(0.62137, longitudTest.getMmi(), 0.0001)
        assertEquals(0.53995, longitudTest.getMmina(), 0.0001)
        assertEquals(1.057E-13, longitudTest.getMal(), 1e-15)
    }

    @Test
    fun `validar conversion desde metro con valores negativos`() {
        longitudTest.setMetro(-1000.0)
        longitudTest.cMetro()
        assertEquals(-1.0, longitudTest.getMkm(), delta)
        assertEquals(-100000.0, longitudTest.getMcm(), delta)
        assertEquals(-39370.0, longitudTest.getMin(), delta)
        assertEquals(-3281.0, longitudTest.getMft(), delta)
        assertEquals(-1093.6, longitudTest.getMyd(), delta)
        assertEquals(-0.62137, longitudTest.getMmi(), 0.0001)
        assertEquals(-0.53995, longitudTest.getMmina(), 0.0001)
        assertEquals(-1.057E-13, longitudTest.getMal(), 1e-15)
    }

    @Test
    fun `validar conversion desde metro con valores muy pequeños`() {
        longitudTest.setMetro(0.01)
        longitudTest.cMetro()
        assertEquals(1e-5, longitudTest.getMkm(), 1e-6)
        assertEquals(1.0, longitudTest.getMcm(), delta)
        assertEquals(0.3937, longitudTest.getMin(), delta)
        assertEquals(0.03281, longitudTest.getMft(), delta)
        assertEquals(0.010936, longitudTest.getMyd(), delta)
        assertEquals(6.2137e-6, longitudTest.getMmi(), 1e-7)
        assertEquals(5.399e-6, longitudTest.getMmina(), 1e-7)
        assertEquals(0.0, longitudTest.getMal(), delta)
    }

    @Test
    fun `validar conversion desde metro con valores muy grandes`() {
        longitudTest.setMetro(1000000.0)
        longitudTest.cMetro()
        assertEquals(1000.0, longitudTest.getMkm(), delta)
        assertEquals(1e8, longitudTest.getMcm(), delta)
        assertEquals(39370000.0, longitudTest.getMin(), delta)
        assertEquals(3281000.0, longitudTest.getMft(), delta)
        assertEquals(1093600.0, longitudTest.getMyd(), delta)
        assertEquals(621.37, longitudTest.getMmi(), 0.1)
        assertEquals(539.95, longitudTest.getMmina(), 0.1)
        assertEquals(1.057e-10, longitudTest.getMal(), 1e-12)
    }

    // --- PRUEBAS PARA KILOMETRO (cKilometro) ---
    @Test
    fun `validar precision matematica en la conversion desde kilometro`() {
        longitudTest.setKilometro(1.0)
        longitudTest.cKilometro()
        assertEquals(1000.0, longitudTest.getKmm(), delta)
        assertEquals(100000.0, longitudTest.getKmcm(), delta)
        assertEquals(39370.07, longitudTest.getKmin(), delta)
        assertEquals(3280.8399, longitudTest.getKmft(), delta)
        assertEquals(1093.6133, longitudTest.getKmyd(), delta)
        assertEquals(0.6214, longitudTest.getKmmi(), delta)
        assertEquals(0.53995, longitudTest.getKmmina(), 0.001)
        assertEquals(1.057E-13, longitudTest.getKmal(), 1e-15)
    }

    @Test
    fun `validar conversion desde kilometro con valores negativos`() {
        longitudTest.setKilometro(-1.0)
        longitudTest.cKilometro()
        assertEquals(-1000.0, longitudTest.getKmm(), delta)
        assertEquals(-100000.0, longitudTest.getKmcm(), delta)
        assertEquals(-39370.07, longitudTest.getKmin(), delta)
        assertEquals(-3280.8399, longitudTest.getKmft(), delta)
        assertEquals(-1093.6133, longitudTest.getKmyd(), delta)
        assertEquals(-0.6214, longitudTest.getKmmi(), delta)
        assertEquals(-0.53995, longitudTest.getKmmina(), 0.001)
        assertEquals(-1.057E-13, longitudTest.getKmal(), 1e-15)
    }

    @Test
    fun `validar conversion desde kilometro con valores muy pequeños`() {
        longitudTest.setKilometro(0.001)
        longitudTest.cKilometro()
        assertEquals(1.0, longitudTest.getKmm(), delta)
        assertEquals(100.0, longitudTest.getKmcm(), delta)
        assertEquals(39.37, longitudTest.getKmin(), 0.1)
        assertEquals(3.2808, longitudTest.getKmft(), delta)
        assertEquals(1.0936, longitudTest.getKmyd(), delta)
        assertEquals(0.0006214, longitudTest.getKmmi(), 1e-7)
        assertEquals(0.0005399, longitudTest.getKmmina(), 1e-7)
        assertEquals(1.0570E-16, longitudTest.getKmal(), 1e-18)
    }

    @Test
    fun `validar conversion desde kilometro con valores muy grandes`() {
        longitudTest.setKilometro(1000.0)
        longitudTest.cKilometro()
        assertEquals(1000000.0, longitudTest.getKmm(), delta)
        assertEquals(1e8, longitudTest.getKmcm(), delta)
        assertEquals(39370070.0, longitudTest.getKmin(), delta)
        assertEquals(3280839.9, longitudTest.getKmft(), delta)
        assertEquals(1093613.3, longitudTest.getKmyd(), delta)
        assertEquals(621.4, longitudTest.getKmmi(), delta)
        assertEquals(539.95, longitudTest.getKmmina(), 0.1)
        assertEquals(1.0570e-10, longitudTest.getKmal(), 1e-12)
    }

    // --- PRUEBAS PARA CENTIMETRO (cCentimetro) ---
    @Test
    fun `validar precision matematica en la conversion desde centimetro`() {
        longitudTest.setCentimetro(100.0)
        longitudTest.cCentimetro()
        assertEquals(1.0, longitudTest.getCmm(), delta)
        assertEquals(0.001, longitudTest.getCmkm(), delta)
        assertEquals(40.0, longitudTest.getCmin(), delta)
        assertEquals(3.2808, longitudTest.getCmft(), delta)
        assertEquals(1.0936, longitudTest.getCmyd(), delta)
        assertEquals(0.0006213, longitudTest.getCmmi(), 0.0001)
        assertEquals(0.0005399, longitudTest.getCmmina(), 0.0001)
        assertEquals(1.057E-16, longitudTest.getCmal(), 1e-18)
    }

    @Test
    fun `validar conversion desde centimetro con valores negativos`() {
        longitudTest.setCentimetro(-100.0)
        longitudTest.cCentimetro()
        assertEquals(-1.0, longitudTest.getCmm(), delta)
        assertEquals(-0.001, longitudTest.getCmkm(), delta)
        assertEquals(-40.0, longitudTest.getCmin(), delta)
        assertEquals(-3.2808, longitudTest.getCmft(), delta)
        assertEquals(-1.0936, longitudTest.getCmyd(), delta)
        assertEquals(-0.0006213, longitudTest.getCmmi(), 0.0001)
        assertEquals(-0.0005399, longitudTest.getCmmina(), 0.0001)
        assertEquals(-1.057E-16, longitudTest.getCmal(), 1e-18)
    }

    @Test
    fun `validar conversion desde centimetro con valores muy pequeños`() {
        longitudTest.setCentimetro(0.1)
        longitudTest.cCentimetro()
        assertEquals(0.001, longitudTest.getCmm(), delta)
        assertEquals(1e-6, longitudTest.getCmkm(), 1e-7)
        assertEquals(0.04, longitudTest.getCmin(), delta)
        assertEquals(0.00328, longitudTest.getCmft(), delta)
        assertEquals(0.00109, longitudTest.getCmyd(), delta)
        assertEquals(6.213e-7, longitudTest.getCmmi(), 1e-8)
        assertEquals(5.399e-7, longitudTest.getCmmina(), 1e-8)
        assertEquals(1.057e-19, longitudTest.getCmal(), 1e-21)
    }

    @Test
    fun `validar conversion desde centimetro con valores muy grandes`() {
        longitudTest.setCentimetro(100000.0)
        longitudTest.cCentimetro()
        assertEquals(1000.0, longitudTest.getCmm(), delta)
        assertEquals(1.0, longitudTest.getCmkm(), delta)
        assertEquals(40000.0, longitudTest.getCmin(), delta)
        assertEquals(3280.8, longitudTest.getCmft(), 1.0)
        assertEquals(1093.6133, longitudTest.getCmyd(), delta)
        assertEquals(0.62137, longitudTest.getCmmi(), 0.01)
        assertEquals(0.53995, longitudTest.getCmmina(), 0.01)
        assertEquals(1.057e-13, longitudTest.getCmal(), 1e-15)
    }

    // --- PRUEBAS PARA PULGADA (cPulgada) ---
    @Test
    fun `validar precision matematica en la conversion desde pulgada`() {
        longitudTest.setPulgada(39.37)
        longitudTest.cPulgada()
        assertEquals(1.0, longitudTest.getInm(), delta)
        assertEquals(0.001, longitudTest.getInkm(), delta)
        assertEquals(99.9998, longitudTest.getIncm(), delta)
        assertEquals(3.2808, longitudTest.getInft(), delta)
        assertEquals(1.0936, longitudTest.getInyd(), delta)
        assertEquals(0.0006213, longitudTest.getInmi(), 0.0001)
        assertEquals(0.0005399, longitudTest.getInmina(), 0.0001)
        assertEquals(1.057E-16, longitudTest.getInal(), 1e-18)
    }

    @Test
    fun `validar conversion desde pulgada con valores negativos`() {
        longitudTest.setPulgada(-39.37)
        longitudTest.cPulgada()
        assertEquals(-1.0, longitudTest.getInm(), delta)
        assertEquals(-0.001, longitudTest.getInkm(), delta)
        assertEquals(-99.9998, longitudTest.getIncm(), delta)
        assertEquals(-3.2808, longitudTest.getInft(), delta)
        assertEquals(-1.0936, longitudTest.getInyd(), delta)
        assertEquals(-0.0006213, longitudTest.getInmi(), 0.0001)
        assertEquals(-0.0005399, longitudTest.getInmina(), 0.0001)
        assertEquals(-1.057E-16, longitudTest.getInal(), 1e-18)
    }

    @Test
    fun `validar conversion desde pulgada con valores muy pequeños`() {
        longitudTest.setPulgada(0.1)
        longitudTest.cPulgada()
        assertEquals(0.00254, longitudTest.getInm(), delta)
        assertEquals(2.54e-6, longitudTest.getInkm(), 1e-7)
        assertEquals(0.254, longitudTest.getIncm(), delta)
        assertEquals(0.00833, longitudTest.getInft(), delta)
        assertEquals(0.00277, longitudTest.getInyd(), delta)
        assertEquals(1.578e-6, longitudTest.getInmi(), 1e-8)
        assertEquals(1.371e-6, longitudTest.getInmina(), 1e-8)
        assertEquals(0.0, longitudTest.getInal(), delta)
    }

    @Test
    fun `validar conversion desde pulgada con valores muy grandes`() {
        longitudTest.setPulgada(39370.0)
        longitudTest.cPulgada()
        assertEquals(1000.0, longitudTest.getInm(), delta)
        assertEquals(1.0, longitudTest.getInkm(), delta)
        assertEquals(99999.8, longitudTest.getIncm(), 1.0)
        assertEquals(3280.8, longitudTest.getInft(), 1.0)
        assertEquals(1093.61111, longitudTest.getInyd(), delta)
        assertEquals(0.621, longitudTest.getInmi(), 0.01)
        assertEquals(0.539, longitudTest.getInmina(), 0.01)
        assertEquals(1.057e-13, longitudTest.getInal(), 1e-15)
    }

    // --- PRUEBAS PARA PIE (cPie) ---
    @Test
    fun `validar precision matematica en la conversion desde pie`() {
        longitudTest.setPie(3.2808)
        longitudTest.cPie()
        assertEquals(1.0, longitudTest.getFtm(), delta)
        assertEquals(0.001, longitudTest.getFtkm(), delta)
        assertEquals(100.0, longitudTest.getFtcm(), delta)
        assertEquals(39.3696, longitudTest.getFtin(), delta)
        assertEquals(1.0936, longitudTest.getFtyd(), delta)
        assertEquals(0.0006213, longitudTest.getFtmi(), 0.0001)
        assertEquals(0.0005399, longitudTest.getFtmina(), 0.0001)
        assertEquals(1.057E-16, longitudTest.getFtal(), 1e-18)
    }

    @Test
    fun `validar conversion desde pie con valores negativos`() {
        longitudTest.setPie(-3.2808)
        longitudTest.cPie()
        assertEquals(-1.0, longitudTest.getFtm(), delta)
        assertEquals(-0.001, longitudTest.getFtkm(), delta)
        assertEquals(-100.0, longitudTest.getFtcm(), delta)
        assertEquals(-39.3696, longitudTest.getFtin(), delta)
        assertEquals(-1.0936, longitudTest.getFtyd(), delta)
        assertEquals(-0.0006213, longitudTest.getFtmi(), 0.0001)
        assertEquals(-0.0005399, longitudTest.getFtmina(), 0.0001)
        assertEquals(-1.057E-16, longitudTest.getFtal(), 1e-18)
    }

    @Test
    fun `validar conversion desde pie con valores muy pequeños`() {
        longitudTest.setPie(0.1)
        longitudTest.cPie()
        assertEquals(0.03048, longitudTest.getFtm(), delta)
        assertEquals(3.048e-5, longitudTest.getFtkm(), 1e-6)
        assertEquals(3.048, longitudTest.getFtcm(), delta)
        assertEquals(1.2, longitudTest.getFtin(), delta)
        assertEquals(0.0333, longitudTest.getFtyd(), delta)
        assertEquals(1.893e-5, longitudTest.getFtmi(), 1e-7)
        assertEquals(1.645e-5, longitudTest.getFtmina(), 1e-7)
        assertEquals(3.22e-18, longitudTest.getFtal(), 1e-20)
    }

    @Test
    fun `validar conversion desde pie con valores muy grandes`() {
        longitudTest.setPie(3280.8)
        longitudTest.cPie()
        assertEquals(999.9878, longitudTest.getFtm(), delta)
        assertEquals(0.9999, longitudTest.getFtkm(), delta)
        assertEquals(99999.9, longitudTest.getFtcm(), 1.0)
        assertEquals(39369.6, longitudTest.getFtin(), 1.0)
        assertEquals(1093.6, longitudTest.getFtyd(), delta)
        assertEquals(0.6213, longitudTest.getFtmi(), 0.01)
        assertEquals(0.5399, longitudTest.getFtmina(), 0.01)
        assertEquals(1.057e-13, longitudTest.getFtal(), 1e-15)
    }

    // --- PRUEBAS PARA YARDA (cYarda) ---
    @Test
    fun `validar precision matematica en la conversion desde yarda`() {
        longitudTest.setYarda(1.0936)
        longitudTest.cYarda()
        assertEquals(1.0, longitudTest.getYdm(), delta)
        assertEquals(0.0009, longitudTest.getYdkm(), delta)
        assertEquals(99.998, longitudTest.getYdcm(), 0.01)
        assertEquals(39.3696, longitudTest.getYdin(), delta)
        assertEquals(3.2808, longitudTest.getYdft(), delta)
        assertEquals(0.0006213, longitudTest.getYdmi(), 0.0001)
        assertEquals(0.0005399, longitudTest.getYdmina(), 0.0001)
        assertEquals(1.057E-16, longitudTest.getYdal(), 1e-18)
    }

    @Test
    fun `validar conversion desde yarda con valores negativos`() {
        longitudTest.setYarda(-1.0936)
        longitudTest.cYarda()
        assertEquals(-1.0, longitudTest.getYdm(), delta)
        assertEquals(-0.0009, longitudTest.getYdkm(), delta)
        assertEquals(-99.998, longitudTest.getYdcm(), 0.01)
        assertEquals(-39.3696, longitudTest.getYdin(), delta)
        assertEquals(-3.2808, longitudTest.getYdft(), delta)
        assertEquals(-0.0006213, longitudTest.getYdmi(), 0.0001)
        assertEquals(-0.0005399, longitudTest.getYdmina(), 0.0001)
        assertEquals(-1.057E-16, longitudTest.getYdal(), 1e-18)
    }

    @Test
    fun `validar conversion desde yarda con valores muy pequeños`() {
        longitudTest.setYarda(0.1)
        longitudTest.cYarda()
        assertEquals(0.09144, longitudTest.getYdm(), delta)
        assertEquals(9.144e-5, longitudTest.getYdkm(), 1e-6)
        assertEquals(9.144, longitudTest.getYdcm(), delta)
        assertEquals(3.6, longitudTest.getYdin(), delta)
        assertEquals(0.3, longitudTest.getYdft(), delta)
        assertEquals(5.681e-5, longitudTest.getYdmi(), 1e-7)
        assertEquals(4.937e-5, longitudTest.getYdmina(), 1e-7)
        assertEquals(9.665e-18, longitudTest.getYdal(), 1e-20)
    }

    @Test
    fun `validar conversion desde yarda con valores muy grandes`() {
        longitudTest.setYarda(1093.6)
        longitudTest.cYarda()
        assertEquals(999.9878, longitudTest.getYdm(), delta)
        assertEquals(0.9999, longitudTest.getYdkm(), delta)
        assertEquals(99998.7, longitudTest.getYdcm(), 1.0)
        assertEquals(39369.6, longitudTest.getYdin(), 1.0)
        assertEquals(3280.8, longitudTest.getYdft(), 1.0)
        assertEquals(0.6213, longitudTest.getYdmi(), 0.01)
        assertEquals(0.5399, longitudTest.getYdmina(), 0.01)
        assertEquals(1.057e-13, longitudTest.getYdal(), 1e-15)
    }

    // --- PRUEBAS PARA MILLA (cMilla) ---
    @Test
    fun `validar precision matematica en la conversion desde milla`() {
        longitudTest.setMilla(1.0)
        longitudTest.cMilla()
        assertEquals(1609.34, longitudTest.getMim(), delta)
        assertEquals(1.6093, longitudTest.getMikm(), delta)
        assertEquals(160934.4, longitudTest.getMicm(), delta)
        assertEquals(63360.0, longitudTest.getMiin(), delta)
        assertEquals(5280.0, longitudTest.getMift(), delta)
        assertEquals(1760.0, longitudTest.getMiyd(), delta)
        assertEquals(0.86897, longitudTest.getMimina(), 0.0001)
        assertEquals(1.7011E-13, longitudTest.getMial(), 1e-15)
    }

    @Test
    fun `validar conversion desde milla con valores negativos`() {
        longitudTest.setMilla(-1.0)
        longitudTest.cMilla()
        assertEquals(-1609.34, longitudTest.getMim(), delta)
        assertEquals(-1.6093, longitudTest.getMikm(), delta)
        assertEquals(-160934.4, longitudTest.getMicm(), delta)
        assertEquals(-63360.0, longitudTest.getMiin(), delta)
        assertEquals(-5280.0, longitudTest.getMift(), delta)
        assertEquals(-1760.0, longitudTest.getMiyd(), delta)
        assertEquals(-0.86897, longitudTest.getMimina(), 0.0001)
        assertEquals(-1.7011E-13, longitudTest.getMial(), 1e-15)
    }

    @Test
    fun `validar conversion desde milla con valores muy pequeños`() {
        longitudTest.setMilla(0.001)
        longitudTest.cMilla()
        assertEquals(1.609, longitudTest.getMim(), delta)
        assertEquals(0.001609, longitudTest.getMikm(), delta)
        assertEquals(160.934, longitudTest.getMicm(), delta)
        assertEquals(63.36, longitudTest.getMiin(), delta)
        assertEquals(5.28, longitudTest.getMift(), delta)
        assertEquals(1.76, longitudTest.getMiyd(), delta)
        assertEquals(0.000868, longitudTest.getMimina(), 0.0001)
        assertEquals(1.701e-16, longitudTest.getMial(), 1e-18)
    }

    @Test
    fun `validar conversion desde milla con valores muy grandes`() {
        longitudTest.setMilla(100.0)
        longitudTest.cMilla()
        assertEquals(160934.0, longitudTest.getMim(), 1.0)
        assertEquals(160.934, longitudTest.getMikm(), delta)
        assertEquals(16093440.0, longitudTest.getMicm(), 10.0)
        assertEquals(6336000.0, longitudTest.getMiin(), 1.0)
        assertEquals(528000.0, longitudTest.getMift(), 1.0)
        assertEquals(176000.0, longitudTest.getMiyd(), 1.0)
        assertEquals(86.897, longitudTest.getMimina(), 0.1)
        assertEquals(1.7011e-11, longitudTest.getMial(), 1e-13)
    }

    // --- PRUEBAS PARA MILLA NAUTICA (cMillaNautica) ---
    @Test
    fun `validar precision matematica en la conversion desde milla nautica`() {
        longitudTest.setMillaNautica(1.0)
        longitudTest.cMillaNautica()
        assertEquals(1852.0, longitudTest.getMnm(), delta)
        assertEquals(1.852, longitudTest.getMnkm(), delta)
        assertEquals(185200.0, longitudTest.getMncm(), delta)
        assertEquals(72913.3858, longitudTest.getMnin(), delta)
        assertEquals(6076.11549, longitudTest.getMnft(), delta)
        assertEquals(2025.37, longitudTest.getMnyd(), delta)
        assertEquals(1.152, longitudTest.getMnmi(), delta)
        assertEquals(1.9576E-13, longitudTest.getMnal(), 1e-15)
    }

    @Test
    fun `validar conversion desde milla nautica con valores negativos`() {
        longitudTest.setMillaNautica(-1.0)
        longitudTest.cMillaNautica()
        assertEquals(-1852.0, longitudTest.getMnm(), delta)
        assertEquals(-1.852, longitudTest.getMnkm(), delta)
        assertEquals(-185200.0, longitudTest.getMncm(), delta)
        assertEquals(-72913.3858, longitudTest.getMnin(), delta)
        assertEquals(-6076.11549, longitudTest.getMnft(), delta)
        assertEquals(-2025.37, longitudTest.getMnyd(), delta)
        assertEquals(-1.152, longitudTest.getMnmi(), delta)
        assertEquals(-1.9576E-13, longitudTest.getMnal(), 1e-15)
    }

    @Test
    fun `validar conversion desde milla nautica con valores muy pequeños`() {
        longitudTest.setMillaNautica(0.001)
        longitudTest.cMillaNautica()
        assertEquals(1.852, longitudTest.getMnm(), delta)
        assertEquals(0.001852, longitudTest.getMnkm(), delta)
        assertEquals(185.2, longitudTest.getMncm(), delta)
        assertEquals(72.913, longitudTest.getMnin(), delta)
        assertEquals(6.076, longitudTest.getMnft(), delta)
        assertEquals(2.025, longitudTest.getMnyd(), delta)
        assertEquals(0.001152, longitudTest.getMnmi(), 1e-6)
        assertEquals(1.957e-16, longitudTest.getMnal(), 1e-18)
    }

    @Test
    fun `validar conversion desde milla nautica con valores muy grandes`() {
        longitudTest.setMillaNautica(100.0)
        longitudTest.cMillaNautica()
        assertEquals(185200.0, longitudTest.getMnm(), delta)
        assertEquals(185.2, longitudTest.getMnkm(), delta)
        assertEquals(18520000.0, longitudTest.getMncm(), 10.0)
        assertEquals(7291338.58, longitudTest.getMnin(), 1.0)
        assertEquals(607611.549, longitudTest.getMnft(), 1.0)
        assertEquals(202537.0, longitudTest.getMnyd(), 1.0)
        assertEquals(115.2, longitudTest.getMnmi(), delta)
        assertEquals(1.9576e-11, longitudTest.getMnal(), 1e-13)
    }

    // --- PRUEBAS PARA AÑO LUZ (cAñoluz) ---
    @Test
    fun `validar precision matematica en la conversion desde año luz`() {
        longitudTest.setAñoLuz(1.0)
        longitudTest.cAñoluz()
        assertEquals(9.4607E15, longitudTest.getAlm(), 1e12)
        assertEquals(9.4607E12, longitudTest.getAlkm(), 1e9)
        assertEquals(9.4607E17, longitudTest.getAlcm(), 1e14)
        assertEquals(3.7247E17, longitudTest.getAlin(), 1e14)
        assertEquals(3.1039E16, longitudTest.getAlft(), 1e13)
        assertEquals(1.0346E16, longitudTest.getAlyd(), 1e12)
        assertEquals(5.8786E12, longitudTest.getAlmi(), 1e9)
        assertEquals(5108385916074.99, longitudTest.getAlmina(), 0.01)
    }

    @Test
    fun `validar conversion desde año luz con valores negativos`() {
        longitudTest.setAñoLuz(-1.0)
        longitudTest.cAñoluz()
        assertEquals(-9.4607E15, longitudTest.getAlm(), 1e12)
        assertEquals(-9.4607E+12, longitudTest.getAlkm(), 1e9)
        assertEquals(-9.4607E17, longitudTest.getAlcm(), 1e14)
        assertEquals(-3.7247E17, longitudTest.getAlin(), 1e14)
        assertEquals(-3.1039E16, longitudTest.getAlft(), 1e13)
        assertEquals(-1.0346E16, longitudTest.getAlyd(), 1e12)
        assertEquals(-5.8786E12, longitudTest.getAlmi(), 1e9)
        assertEquals(-5108385916074.99, longitudTest.getAlmina(), 0.01)
    }

    @Test
    fun `validar conversion desde año luz con valores muy pequeños`() {
        longitudTest.setAñoLuz(1e-6)
        longitudTest.cAñoluz()
        assertEquals(9.4607e9, longitudTest.getAlm(), 1e6)
        assertEquals(9.4607E+6, longitudTest.getAlkm(), 10.0)
        assertEquals(9.4607e11, longitudTest.getAlcm(), 1e8)
        assertEquals(3.7247e11, longitudTest.getAlin(), 1e8)
        assertEquals(3.1039e10, longitudTest.getAlft(), 1e7)
        assertEquals(1.0346e10, longitudTest.getAlyd(), 1e7)
        assertEquals(5878600.0, longitudTest.getAlmi(), 10.0)
        assertEquals(5108385.9, longitudTest.getAlmina(), 1.0)
    }

    @Test
    fun `validar conversion desde año luz con valores muy grandes`() {
        longitudTest.setAñoLuz(100.0)
        longitudTest.cAñoluz()
        assertEquals(9.4607E17, longitudTest.getAlm(), 1e14)
        assertEquals(9.4607E14, longitudTest.getAlkm(), 1e11)
        assertEquals(9.4607E19, longitudTest.getAlcm(), 1e16)
        assertEquals(3.7247E19, longitudTest.getAlin(), 1e16)
        assertEquals(3.1039E18, longitudTest.getAlft(), 1e15)
        assertEquals(1.0346E18, longitudTest.getAlyd(), 1e14)
        assertEquals(5.8786E14, longitudTest.getAlmi(), 1e11)
        assertEquals(5.10838e14, longitudTest.getAlmina(), 1e11)
    }
}
