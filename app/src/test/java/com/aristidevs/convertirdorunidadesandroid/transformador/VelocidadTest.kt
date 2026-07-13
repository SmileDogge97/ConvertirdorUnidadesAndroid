package com.aristidevs.convertirdorunidadesandroid.transformador

import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class VelocidadTest {

    private lateinit var velocidadTest: Velocidad
    private val delta = 0.001

    @Before
    fun onBefore() {
        velocidadTest = Velocidad()
    }

    // --- PRUEBAS PARA METROS/SEGUNDO (cms) ---
    @Test
    fun `validar precision matematica en la conversion desde ms`() {
        velocidadTest.setms(10.0)
        velocidadTest.cms()
        assertEquals(36.0, velocidadTest.mk(), delta)
        assertEquals(32.8, velocidadTest.mf(), delta)
        assertEquals(22.369, velocidadTest.mmi(), 0.01)
        assertEquals(19.44, velocidadTest.mn(), 0.01)
    }

    @Test
    fun `validar conversion desde ms con valores negativos`() {
        velocidadTest.setms(-10.0)
        velocidadTest.cms()
        assertEquals(-36.0, velocidadTest.mk(), delta)
        assertEquals(-32.8, velocidadTest.mf(), delta)
        assertEquals(-22.369, velocidadTest.mmi(), 0.01)
        assertEquals(-19.44, velocidadTest.mn(), 0.01)
    }

    @Test
    fun `validar conversion desde ms con valores muy pequeños`() {
        velocidadTest.setms(0.01)
        velocidadTest.cms()
        assertEquals(0.036, velocidadTest.mk(), delta)
        assertEquals(0.0328, velocidadTest.mf(), delta)
        assertEquals(0.0223, velocidadTest.mmi(), 0.001)
        assertEquals(0.0194, velocidadTest.mn(), 0.001)
    }

    @Test
    fun `validar conversion desde ms con valores muy grandes`() {
        velocidadTest.setms(1000.0)
        velocidadTest.cms()
        assertEquals(3600.0, velocidadTest.mk(), delta)
        assertEquals(3280.0, velocidadTest.mf(), delta)
        assertEquals(2236.936, velocidadTest.mmi(), delta)
        assertEquals(1944.012, velocidadTest.mn(), 0.1)
    }

    // --- PRUEBAS PARA KILOMETROS/HORA (ckmh) ---
    @Test
    fun `validar precision matematica en la conversion desde kmh`() {
        velocidadTest.setkmh(100.0)
        velocidadTest.ckmh()
        assertEquals(27.78, velocidadTest.km(), delta)
        assertEquals(91.1, velocidadTest.kf(), delta)
        assertEquals(62.1, velocidadTest.kmi(), delta)
        assertEquals(54.004, velocidadTest.kn(), 0.01)
    }

    @Test
    fun `validar conversion desde kmh con valores negativos`() {
        velocidadTest.setkmh(-100.0)
        velocidadTest.ckmh()
        assertEquals(-27.78, velocidadTest.km(), delta)
        assertEquals(-91.1, velocidadTest.kf(), delta)
        assertEquals(-62.1, velocidadTest.kmi(), delta)
        assertEquals(-54.004, velocidadTest.kn(), 0.01)
    }

    @Test
    fun `validar conversion desde kmh con valores muy pequeños`() {
        velocidadTest.setkmh(0.1)
        velocidadTest.ckmh()
        assertEquals(0.02778, velocidadTest.km(), delta)
        assertEquals(0.0911, velocidadTest.kf(), delta)
        assertEquals(0.0621, velocidadTest.kmi(), delta)
        assertEquals(0.0540, velocidadTest.kn(), 0.001)
    }

    @Test
    fun `validar conversion desde kmh con valores muy grandes`() {
        velocidadTest.setkmh(10000.0)
        velocidadTest.ckmh()
        assertEquals(2778.0, velocidadTest.km(), delta)
        assertEquals(9110.0, velocidadTest.kf(), delta)
        assertEquals(6210.0, velocidadTest.kmi(), delta)
        assertEquals(5400.46, velocidadTest.kn(), 0.1)
    }

    // --- PRUEBAS PARA PIES/SEGUNDO (cfts) ---
    @Test
    fun `validar precision matematica en la conversion desde fts`() {
        velocidadTest.setfts(10.0)
        velocidadTest.cfts()
        assertEquals(3.048, velocidadTest.fm(), delta)
        assertEquals(10.9728, velocidadTest.fk(), delta)
        assertEquals(6.818, velocidadTest.fmi(), 0.001)
        assertEquals(5.924, velocidadTest.fn(), 0.01)
    }

    @Test
    fun `validar conversion desde fts con valores negativos`() {
        velocidadTest.setfts(-10.0)
        velocidadTest.cfts()
        assertEquals(-3.048, velocidadTest.fm(), delta)
        assertEquals(-10.9728, velocidadTest.fk(), delta)
        assertEquals(-6.818, velocidadTest.fmi(), 0.001)
        assertEquals(-5.924, velocidadTest.fn(), 0.01)
    }

    @Test
    fun `validar conversion desde fts con valores muy pequeños`() {
        velocidadTest.setfts(0.1)
        velocidadTest.cfts()
        assertEquals(0.03048, velocidadTest.fm(), delta)
        assertEquals(0.1097, velocidadTest.fk(), delta)
        assertEquals(0.0681, velocidadTest.fmi(), 0.001)
        assertEquals(0.0592, velocidadTest.fn(), 0.001)
    }

    @Test
    fun `validar conversion desde fts con valores muy grandes`() {
        velocidadTest.setfts(1000.0)
        velocidadTest.cfts()
        assertEquals(304.8, velocidadTest.fm(), delta)
        assertEquals(1097.28, velocidadTest.fk(), delta)
        assertEquals(681.818, velocidadTest.fmi(), 0.1)
        assertEquals(592.48, velocidadTest.fn(), 0.1)
    }

    // --- PRUEBAS PARA MILLAS/HORA (cmih) ---
    @Test
    fun `validar precision matematica en la conversion desde mih`() {
        velocidadTest.setmih(60.0)
        velocidadTest.cmih()
        assertEquals(26.82, velocidadTest.mim(), delta)
        assertEquals(96.54, velocidadTest.mik(), delta)
        assertEquals(87.96, velocidadTest.mif(), delta)
        assertEquals(52.138, velocidadTest.min(), 0.01)
    }

    @Test
    fun `validar conversion desde mih con valores negativos`() {
        velocidadTest.setmih(-60.0)
        velocidadTest.cmih()
        assertEquals(-26.82, velocidadTest.mim(), delta)
        assertEquals(-96.54, velocidadTest.mik(), delta)
        assertEquals(-87.96, velocidadTest.mif(), delta)
        assertEquals(-52.138, velocidadTest.min(), 0.01)
    }

    @Test
    fun `validar conversion desde mih con valores muy pequeños`() {
        velocidadTest.setmih(0.1)
        velocidadTest.cmih()
        assertEquals(0.0447, velocidadTest.mim(), delta)
        assertEquals(0.1609, velocidadTest.mik(), delta)
        assertEquals(0.1466, velocidadTest.mif(), delta)
        assertEquals(0.0868, velocidadTest.min(), 0.001)
    }

    @Test
    fun `validar conversion desde mih con valores muy grandes`() {
        velocidadTest.setmih(1000.0)
        velocidadTest.cmih()
        assertEquals(447.0, velocidadTest.mim(), delta)
        assertEquals(1609.0, velocidadTest.mik(), delta)
        assertEquals(1466.0, velocidadTest.mif(), delta)
        assertEquals(868.97, velocidadTest.min(), 0.1)
    }

    // --- PRUEBAS PARA NUDO (cnudo) ---
    @Test
    fun `validar precision matematica en la conversion desde nudo`() {
        velocidadTest.setnudo(10.0)
        velocidadTest.cnudo()
        assertEquals(5.144, velocidadTest.nm(), delta)
        assertEquals(18.52, velocidadTest.nk(), delta)
        assertEquals(16.878, velocidadTest.nf(), delta)
        assertEquals(11.507, velocidadTest.nmi(), delta)
    }

    @Test
    fun `validar conversion desde nudo con valores negativos`() {
        velocidadTest.setnudo(-10.0)
        velocidadTest.cnudo()
        assertEquals(-5.144, velocidadTest.nm(), delta)
        assertEquals(-18.52, velocidadTest.nk(), delta)
        assertEquals(-16.878, velocidadTest.nf(), delta)
        assertEquals(-11.507, velocidadTest.nmi(), delta)
    }

    @Test
    fun `validar conversion desde nudo con valores muy pequeños`() {
        velocidadTest.setnudo(0.1)
        velocidadTest.cnudo()
        assertEquals(0.0514, velocidadTest.nm(), delta)
        assertEquals(0.1852, velocidadTest.nk(), delta)
        assertEquals(0.1687, velocidadTest.nf(), delta)
        assertEquals(0.1150, velocidadTest.nmi(), delta)
    }

    @Test
    fun `validar conversion desde nudo con valores muy grandes`() {
        velocidadTest.setnudo(100.0)
        velocidadTest.cnudo()
        assertEquals(51.44, velocidadTest.nm(), delta)
        assertEquals(185.2, velocidadTest.nk(), delta)
        assertEquals(168.78, velocidadTest.nf(), delta)
        assertEquals(115.077945, velocidadTest.nmi(), delta)
    }
}
