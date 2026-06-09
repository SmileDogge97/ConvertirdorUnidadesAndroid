package com.aristidevs.convertirdorunidadesandroid.transformador

class Tiempo {
    private var segundo = 0.0
    private var minuto = 0.0
    private var hora = 0.0
    private var dia = 0.0
    private var año = 0.0
    private var sm = 0.0
    private var sh = 0.0
    private var sd = 0.0
    private var sa = 0.0
    private var ms = 0.0
    private var mh = 0.0
    private var md = 0.0
    private var ma = 0.0
    private var hs = 0.0
    private var hm = 0.0
    private var hd = 0.0
    private var ha = 0.0
    private var ds = 0.0
    private var dm = 0.0
    private var dh = 0.0
    private var da = 0.0
    private var `as` = 0.0
    private var am = 0.0
    private var ah = 0.0
    private var ad = 0.0

    fun Tiempo() {
        segundo = 0.0
        minuto = 0.0
        hora = 0.0
        dia = 0.0
        año = 0.0
        sm = 0.0
        sh = 0.0
        sd = 0.0
        sa = 0.0
        ms = 0.0
        mh = 0.0
        md = 0.0
        ma = 0.0
        hs = 0.0
        hm = 0.0
        hd = 0.0
        ha = 0.0
        ds = 0.0
        dm = 0.0
        dh = 0.0
        da = 0.0
        `as` = 0.0
        am = 0.0
        ah = 0.0
        ad = 0.0
    }

    fun setSegundo(s: Double) {
        segundo = s
    }

    fun setMinuto(m: Double) {
        minuto = m
    }

    fun setHora(h: Double) {
        hora = h
    }

    fun setDia(d: Double) {
        dia = d
    }

    fun setAño(a: Double) {
        año = a
    }

    fun cSegundo() {
        sm = segundo / 60
        sh = segundo / 3600
        sd = segundo / 86400
        sa = segundo / 31560000
    }

    fun cMinuto() {
        ms = minuto * (60 / 1)
        mh = minuto / 60
        md = minuto / 1440
        ma = minuto / 526000
    }

    fun cHora() {
        hs = hora * (3600 / 1)
        hm = hora * (60 / 1)
        hd = hora / 24
        ha = hora / 8760
    }

    fun cDía() {
        ds = dia * (86400 / 1)
        dm = dia * (1440 / 1)
        dh = dia * (24 / 1)
        da = dia / 365
    }

    fun cAño() {
        `as` = año * (31560000 / 1)
        am = año * (525600 / 1)
        ah = año * (8760 / 1)
        ad = año * (365 / 1)
    }

    fun s(): Double {
        return segundo
    }

    fun m(): Double {
        return minuto
    }

    fun h(): Double {
        return hora
    }

    fun d(): Double {
        return dia
    }

    fun a(): Double {
        return año
    }

    fun sm(): Double {
        return sm
    }

    fun sh(): Double {
        return sh
    }

    fun sd(): Double {
        return sd
    }

    fun sa(): Double {
        return sa
    }

    fun ms(): Double {
        return ms
    }

    fun mh(): Double {
        return mh
    }

    fun md(): Double {
        return md
    }

    fun ma(): Double {
        return ma
    }

    fun hs(): Double {
        return hs
    }

    fun hm(): Double {
        return hm
    }

    fun hd(): Double {
        return hd
    }

    fun ha(): Double {
        return ha
    }

    fun ds(): Double {
        return ds
    }

    fun dm(): Double {
        return dm
    }

    fun dh(): Double {
        return dh
    }

    fun da(): Double {
        return da
    }

    fun `as`(): Double {
        return `as`
    }

    fun am(): Double {
        return am
    }

    fun ah(): Double {
        return ah
    }

    fun ad(): Double {
        return ad
    }
}