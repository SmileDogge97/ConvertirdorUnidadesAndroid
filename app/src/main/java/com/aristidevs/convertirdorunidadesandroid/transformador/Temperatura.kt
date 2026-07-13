package com.aristidevs.convertirdorunidadesandroid.transformador

class Temperatura {
    private var celsius = 0.0
    private var kelvin = 0.0
    private var farenheit = 0.0
    private var rankine = 0.0
    private var cf = 0.0
    private var ck = 0.0
    private var cr = 0.0
    private var fc = 0.0
    private var fk = 0.0
    private var fr = 0.0
    private var kc = 0.0
    private var kf = 0.0
    private var kr = 0.0
    private var rc = 0.0
    private var rf = 0.0
    private var rk = 0.0

    fun Temperatura() {
        celsius = 0.0
        kelvin = 0.0
        farenheit = 0.0
        rankine = 0.0
        cf = 0.0
        ck = 0.0
        cr = 0.0
        fc = 0.0
        fk = 0.0
        fr = 0.0
        kc = 0.0
        kf = 0.0
        kr = 0.0
        rc = 0.0
        rf = 0.0
        rk = 0.0
    }

    fun setCelsius(c: Double) {
        celsius = c
    }

    fun setKelvin(k: Double) {
        kelvin = k
    }

    fun setFarenheit(f: Double) {
        farenheit = f
    }

    fun setRankine(r: Double) {
        rankine = r
    }

    fun conversionCelsius() {
        cf = ((9 * celsius) / 5) + 32
        ck = celsius + 273.15
        cr = celsius * 1.8000 + 491.67
    }

    fun conversionFarenheit() {
        fc = (5 * (farenheit - 32)) / 9
        fk = ((5 * (farenheit - 32)) / 9) + 273.15
        fr = (farenheit - 32) + 491.67
    }

    fun conversionKelvin() {
        kc = kelvin - 273.15
        kf = ((9 * (kelvin - 273.15)) / 5) + 32
        kr = (kelvin - 273.15) * 1.8000 + 491.67
    }

    fun conversionRankine() {
        rc = (rankine - 491.67) / 1.79999999
        rf = (rankine - 491.67) + 32
        rk = rankine * 0.55555556
    }

    fun getc(): Double {
        return celsius
    }

    fun getf(): Double {
        return farenheit
    }

    fun getk(): Double {
        return kelvin
    }

    fun getr(): Double {
        return rankine
    }

    fun cf(): Double {
        return cf
    }

    fun ck(): Double {
        return ck
    }

    fun cr(): Double {
        return cr
    }

    fun fc(): Double {
        return fc
    }

    fun fk(): Double {
        return fk
    }

    fun fr(): Double {
        return fr
    }

    fun kc(): Double {
        return kc
    }

    fun kf(): Double {
        return kf
    }

    fun kr(): Double {
        return kr
    }

    fun rc(): Double {
        return rc
    }

    fun rf(): Double {
        return rf
    }

    fun rk(): Double {
        return rk
    } /* public double setCelsius() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/


}