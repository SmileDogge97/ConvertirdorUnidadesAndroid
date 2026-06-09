package com.aristidevs.convertirdorunidadesandroid.transformador

class Masa {

    private var gramo = 0.0
    private var kilogramo = 0.0
    private var libra = 0.0
    private var tonelada = 0.0
    private var gkg = 0.0
    private var glib = 0.0
    private var gtn = 0.0
    private var kgg = 0.0
    private var kglb = 0.0
    private var kgtn = 0.0
    private var lbg = 0.0
    private var lbkg = 0.0
    private var lbtn = 0.0
    private var tng = 0.0
    private var tnkg = 0.0
    private var tnlb = 0.0


    fun Masa() {
        gramo = 0.0
        kilogramo = 0.0
        libra = 0.0
        tonelada = 0.0
        gkg = 0.0
        glib = 0.0
        gtn = 0.0
        kgg = 0.0
        kglb = 0.0
        kgtn = 0.0
        lbg = 0.0
        lbkg = 0.0
        lbtn = 0.0
        tng = 0.0
        tnkg = 0.0
        tnlb = 0.0
    }

    fun setGramo(gr: Double) {
        gramo = gr
    }

    fun setKilogramo(kg: Double) {
        kilogramo = kg
    }

    fun setLibra(lb: Double) {
        libra = lb
    }

    fun setTonelada(tn: Double) {
        tonelada = tn
    }

    fun cgramo() {
        gkg = gramo / 1000
        glib = gramo / 453.59
        gtn = gramo / (1000 * 1000)
    }

    fun ckilogramo() {
        kgg = kilogramo * 1000
        kglb = kilogramo / 0.4546
        kgtn = kilogramo / 1000
    }

    fun clibra() {
        lbg = libra * 453.59
        lbkg = libra * 0.4546
        lbtn = (libra * 0.4546) / 1000
    }

    fun ctonelada() {
        tng = tonelada * 1000 * 1000
        tnkg = tonelada * 1000
        tnlb = tonelada * 2204.62262
    }

    fun getGramo(): Double {
        return gramo
    }

    fun getKilogramo(): Double {
        return kilogramo
    }

    fun getLibra(): Double {
        return libra
    }

    fun getTonelada(): Double {
        return tonelada
    }

    fun getGkg(): Double {
        return gkg
    }

    fun getGlib(): Double {
        return glib
    }

    fun getGtn(): Double {
        return gtn
    }

    fun getKgg(): Double {
        return kgg
    }

    fun getKglb(): Double {
        return kglb
    }

    fun getKgtn(): Double {
        return kgtn
    }

    fun getLbg(): Double {
        return lbg
    }

    fun getLbkg(): Double {
        return lbkg
    }

    fun getLbtn(): Double {
        return lbtn
    }

    fun getTng(): Double {
        return tng
    }

    fun getTnkg(): Double {
        return tnkg
    }

    fun getTnlb(): Double {
        return tnlb
    }
}