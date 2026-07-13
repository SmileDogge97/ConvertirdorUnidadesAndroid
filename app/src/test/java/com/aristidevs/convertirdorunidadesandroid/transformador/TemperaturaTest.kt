package com.aristidevs.convertirdorunidadesandroid.transformador

import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class TemperaturaTest {

    lateinit var temperaturaTest: Temperatura

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        temperaturaTest = Temperatura()
    }

    //Celsius
    @Test
    fun `validar precision matemática en la conversión desde celsius`(){
        // GIVEN
        val valorCelsius = 25.0
        temperaturaTest.setCelsius(valorCelsius)

        // WHEN
        temperaturaTest.conversionCelsius()

        // THEN
        assertEquals(77.0, temperaturaTest.cf(), 0.001, "Error en conversión a Fahrenheit")
        assertEquals(298.15, temperaturaTest.ck(), 0.001, "Error en conversión a Kelvin")
        assertEquals(536.67, temperaturaTest.cr(), 0.001, "Error en conversión a Rankine")
    }

    @Test
    fun `validar conversión desde celsius con valores negativos`(){
        // GIVEN
        val valorCelsius = -275.0
        temperaturaTest.setCelsius(valorCelsius)

        // WHEN
        temperaturaTest.conversionCelsius()

        // THEN
        assertEquals(-463.0, temperaturaTest.cf(), 0.001, "Error en conversión de celsius negativos a Fahrenheit")
        assertEquals(-1.85, temperaturaTest.ck(), 0.001, "Error en conversión de celsius negativos a Kelvin")
        assertEquals(-3.33, temperaturaTest.cr(), 0.001, "Error en conversión de celsius negativos a Rankine")
    }

    @Test
    fun `validar conversión desde celsius con valores muy pequeños`(){
        // GIVEN
        val valorCelsius = 0.05
        temperaturaTest.setCelsius(valorCelsius)

        // WHEN
        temperaturaTest.conversionCelsius()

        // THEN
        assertEquals(32.09, temperaturaTest.cf(), 0.001, "Error en conversión de celsius negativos a Fahrenheit")
        assertEquals(273.2, temperaturaTest.ck(), 0.001, "Error en conversión de celsius negativos a Kelvin")
        assertEquals(491.76, temperaturaTest.cr(), 0.001, "Error en conversión de celsius negativos a Rankine")
    }

    @Test
    fun `validar conversión desde celsius con valores muy grandes`(){
        // GIVEN
        val valorCelsius = 35000.0
        temperaturaTest.setCelsius(valorCelsius)

        // WHEN
        temperaturaTest.conversionCelsius()

        // THEN
        assertEquals(63032.0, temperaturaTest.cf(), 0.001, "Error en conversión de celsius negativos a Fahrenheit")
        assertEquals(35273.15, temperaturaTest.ck(), 0.001, "Error en conversión de celsius negativos a Kelvin")
        assertEquals(63491.67, temperaturaTest.cr(), 0.001, "Error en conversión de celsius negativos a Rankine")
    }

    //Farenheit
    @Test
    fun `validar precision matemática en la conversión desde farenheit`(){
        // GIVEN
        val valorFarenheit = 25.0
        temperaturaTest.setFarenheit(valorFarenheit)

        // WHEN
        temperaturaTest.conversionFarenheit()

        // THEN
        assertEquals(-3.88888889, temperaturaTest.fc(), 0.001, "Error en conversión a Celsius")
        assertEquals(269.261111, temperaturaTest.fk(), 0.001, "Error en conversión a Kelvin")
        assertEquals(484.67, temperaturaTest.fr(), 0.001, "Error en conversión a Rankine")
    }

    @Test
    fun `validar conversión desde farenheit con valores negativos`(){
        // GIVEN
        val valorCelsius = -275.0
        temperaturaTest.setFarenheit(valorCelsius)

        // WHEN
        temperaturaTest.conversionFarenheit()

        // THEN
        assertEquals(-170.555556, temperaturaTest.fc(), 0.001, "Error en conversión de farenheit negativos a Celsius")
        assertEquals(102.594444, temperaturaTest.fk(), 0.001, "Error en conversión de farenheit negativos a Kelvin")
        assertEquals(184.67, temperaturaTest.fr(), 0.001, "Error en conversión de farenheit negativos a Rankine")
    }

    @Test
    fun `validar conversión desde farenheit con valores muy pequeños`(){
        // GIVEN
        val valorCelsius = 0.05
        temperaturaTest.setFarenheit(valorCelsius)

        // WHEN
        temperaturaTest.conversionFarenheit()

        // THEN
        assertEquals(-17.75, temperaturaTest.fc(), 0.001, "Error en conversión de farenheit negativos a Celsius")
        assertEquals(255.4, temperaturaTest.fk(), 0.001, "Error en conversión de farenheit negativos a Kelvin")
        assertEquals(459.72, temperaturaTest.fr(), 0.001, "Error en conversión de farenheit negativos a Rankine")
    }

    @Test
    fun `validar conversión desde farenheit con valores muy grandes`(){
        // GIVEN
        val valorCelsius = 35000.0
        temperaturaTest.setFarenheit(valorCelsius)

        // WHEN
        temperaturaTest.conversionFarenheit()

        // THEN
        assertEquals(19426.6667, temperaturaTest.fc(), 0.001, "Error en conversión de farenheit negativos a Celsius")
        assertEquals(19699.8167, temperaturaTest.fk(), 0.001, "Error en conversión de farenheit negativos a Kelvin")
        assertEquals(35459.67, temperaturaTest.fr(), 0.001, "Error en conversión de farenheit negativos a Rankine")
    }

    //Kelvin
    @Test
    fun `validar precision matemática en la conversión desde Kelvin`(){
        // GIVEN
        val valorKelvin = 25.0
        temperaturaTest.setKelvin(valorKelvin)

        // WHEN
        temperaturaTest.conversionKelvin()

        // THEN
        assertEquals(-248.15, temperaturaTest.kc(), 0.001, "Error en conversión a Celsius")
        assertEquals(-414.67, temperaturaTest.kf(), 0.001, "Error en conversión a Farenheit")
        assertEquals(45.0, temperaturaTest.kr(), 0.001, "Error en conversión a Rankine")
    }

    @Test
    fun `validar conversión desde Kelvin con valores negativos`(){
        // GIVEN
        val valorCelsius = -275.0
        temperaturaTest.setKelvin(valorCelsius)

        // WHEN
        temperaturaTest.conversionKelvin()

        // THEN
        assertEquals(-548.15, temperaturaTest.kc(), 0.001, "Error en conversión de kelvin negativos a Celsius")
        assertEquals(-954.67, temperaturaTest.kf(), 0.001, "Error en conversión de kelvin negativos a Farenheit")
        assertEquals(-495.0, temperaturaTest.kr(), 0.001, "Error en conversión de kelvin negativos a Rankine")
    }

    @Test
    fun `validar conversión desde kelvin con valores muy pequeños`(){
        // GIVEN
        val valorCelsius = 0.05
        temperaturaTest.setKelvin(valorCelsius)

        // WHEN
        temperaturaTest.conversionKelvin()

        // THEN
        assertEquals(-273.1, temperaturaTest.kc(), 0.001, "Error en conversión de kelvin negativos a Celsius")
        assertEquals(-459.58, temperaturaTest.kf(), 0.001, "Error en conversión de kelvin negativos a Farenheit")
        assertEquals(0.09, temperaturaTest.kr(), 0.001, "Error en conversión de kelvin negativos a Rankine")
    }

    @Test
    fun `validar conversión desde kelvin con valores muy grandes`(){
        // GIVEN
        val valorKelvin = 35000.0
        temperaturaTest.setKelvin(valorKelvin)

        // WHEN
        temperaturaTest.conversionKelvin()

        // THEN
        assertEquals(34726.85, temperaturaTest.kc(), 0.001, "Error en conversión de kelvin negativos a Celsius")
        assertEquals(62540.33, temperaturaTest.kf(), 0.001, "Error en conversión de kelvin negativos a Farenheit")
        assertEquals(63000.0, temperaturaTest.kr(), 0.001, "Error en conversión de kelvin negativos a Rankine")
    }

    //Rankine
    @Test
    fun `validar precision matemática en la conversión desde Rankine`(){
        // GIVEN
        val valorRankine = 25.0
        temperaturaTest.setRankine(valorRankine)

        // WHEN
        temperaturaTest.conversionRankine()

        // THEN
        assertEquals(-259.261111, temperaturaTest.rc(), 0.001, "Error en conversión a Celsius")
        assertEquals(-434.67, temperaturaTest.rf(), 0.001, "Error en conversión a Farenheit")
        assertEquals(13.8888889, temperaturaTest.rk(), 0.001, "Error en conversión a Kelvin")
    }

    @Test
    fun `validar conversión desde Rankine con valores negativos`(){
        // GIVEN
        val valorRankine = -275.0
        temperaturaTest.setRankine(valorRankine)

        // WHEN
        temperaturaTest.conversionRankine()

        // THEN
        assertEquals(-425.927778, temperaturaTest.rc(), 0.001, "Error en conversión de rankine negativos a Celsius")
        assertEquals(-734.67, temperaturaTest.rf(), 0.001, "Error en conversión de rankine negativos a Farenheit")
        assertEquals(-152.777778, temperaturaTest.rk(), 0.001, "Error en conversión de rankine negativos a Kelvin")
    }

    @Test
    fun `validar conversión desde rankine con valores muy pequeños`(){
        // GIVEN
        val valorRankine = 0.05
        temperaturaTest.setRankine(valorRankine)

        // WHEN
        temperaturaTest.conversionRankine()

        // THEN
        assertEquals(-273.122222, temperaturaTest.rc(), 0.001, "Error en conversión de rankine a Celsius")
        assertEquals(-459.62, temperaturaTest.rf(), 0.001, "Error en conversión de rankine a Farenheit")
        assertEquals(0.02777778, temperaturaTest.rk(), 0.001, "Error en conversión de rankine a Kelvin")
    }

    @Test
    fun `validar conversión desde Rankine con valores muy grandes`(){
        // GIVEN
        val valorRankine = 35000.0
        temperaturaTest.setRankine(valorRankine)

        // WHEN
        temperaturaTest.conversionRankine()

        // THEN
        assertEquals(19171.2944, temperaturaTest.rc(), 0.001, "Error en conversión de rankine a Celsius")
        assertEquals(34540.33, temperaturaTest.rf(), 0.001, "Error en conversión de rankine a Farenheit")
        assertEquals(19444.4444, temperaturaTest.rk(), 0.001, "Error en conversión de rankine a Kelvin")
    }

}