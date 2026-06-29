package com.aristidevs.convertirdorunidadesandroid.transformador

class Volumen {
    private var centimetro = 0.0
    private var metro = 0.0
    private var pie = 0.0
    private var pulgada = 0.0
    private var litro = 0.0
    private var galon = 0.0
    private var cmm = 0.0
    private var cmft = 0.0
    private var cmin = 0.0
    private var cmlt = 0.0
    private var cmg = 0.0
    private var mcm = 0.0
    private var mft = 0.0
    private var min = 0.0
    private var mlt = 0.0
    private var mg = 0.0
    private var ftcm = 0.0
    private var ftm = 0.0
    private var ftin = 0.0
    private var ftlt = 0.0
    private var ftg = 0.0
    private var incm = 0.0
    private var inm = 0.0
    private var inft = 0.0
    private var inlt = 0.0
    private var ing = 0.0
    private var ltcm = 0.0
    private var ltm = 0.0
    private var ltft = 0.0
    private var ltin = 0.0
    private var ltg = 0.0
    private var gcm = 0.0
    private var gm = 0.0
    private var gft = 0.0
    private var gin = 0.0
    private var glt = 0.0


    fun Volumen() {
        centimetro = 0.0
        metro = 0.0
        pie = 0.0
        pulgada = 0.0
        litro = 0.0
        galon = 0.0
        cmm = 0.0
        cmft = 0.0
        cmin = 0.0
        cmlt = 0.0
        cmg = 0.0
        mcm = 0.0
        mft = 0.0
        min = 0.0
        mlt = 0.0
        mg = 0.0
        ftcm = 0.0
        ftm = 0.0
        ftin = 0.0
        ftlt = 0.0
        ftg = 0.0
        incm = 0.0
        inm = 0.0
        inft = 0.0
        inlt = 0.0
        ing = 0.0
        ltcm = 0.0
        ltm = 0.0
        ltft = 0.0
        ltin = 0.0
        ltg = 0.0
        gcm = 0.0
        gm = 0.0
        gft = 0.0
        gin = 0.0
        glt = 0.0
    }

    fun setCentimetro(cm: Double) {
        centimetro = cm
    }

    fun setMetro(m: Double) {
        metro = m
    }

    fun setPie(ft: Double) {
        pie = ft
    }

    fun setPulgada(`in`: Double) {
        pulgada = `in`
    }

    fun setLitro(lt: Double) {
        litro = lt
    }

    fun setGalon(g: Double) {
        galon = g
    }

    fun ccm() {
        cmm = centimetro * 0.000001
        cmft = centimetro / 28316.8466
        cmin = centimetro * 0.06102374
        cmlt = centimetro / 1000
        cmg = centimetro / 3785.41
    }

    fun cm() {
        mcm = metro * 1000000
        mft = metro * 35.3
        min = metro * 61023.74
        mlt = metro * 1000
        mg = metro * 264.17
    }

    fun cft() {
        ftcm = pie * 28316.84
        ftm = pie * 0.0283
        ftin = pie * 1728
        ftlt = pie * 28.3
        ftg = pie * 7.48
    }

    fun cin() {
        incm = pulgada * 16.387064
        inm = pulgada / 61000
        inft = pulgada / 1728
        inlt = pulgada * 0.01638706
        ing = pulgada / 231
    }

    fun clt() {
        ltcm = litro * 1000
        ltm = litro / 1000
        ltft = litro / 28.3168466
        ltin = litro * 61.023
        ltg = litro * 0.26417205
    }

    fun cg() {
        gcm = galon * 3785.41
        gm = galon * 0.0037
        gft = galon * 0.13368056
        gin = galon * 231
        glt = galon * 3.785
    }

    fun getGalon(): Double {
        return galon
    }

    fun getLitro(): Double {
        return litro
    }

    fun getPulgada(): Double {
        return pulgada
    }

    fun getPie(): Double {
        return pie
    }

    fun getMetro(): Double {
        return metro
    }

    fun getCentimetro(): Double {
        return centimetro
    }

    fun getCmm(): Double {
        return cmm
    }

    fun getCmft(): Double {
        return cmft
    }

    fun getCmin(): Double {
        return cmin
    }

    fun getCmlt(): Double {
        return cmlt
    }

    fun getCmg(): Double {
        return cmg
    }

    fun getMcm(): Double {
        return mcm
    }

    fun getMft(): Double {
        return mft
    }

    fun getMin(): Double {
        return min
    }

    fun getMlt(): Double {
        return mlt
    }

    fun getMg(): Double {
        return mg
    }

    fun getFtcm(): Double {
        return ftcm
    }

    fun getFtm(): Double {
        return ftm
    }

    fun getFtin(): Double {
        return ftin
    }

    fun getFtlt(): Double {
        return ftlt
    }

    fun getFtg(): Double {
        return ftg
    }

    fun getIncm(): Double {
        return incm
    }

    fun getInm(): Double {
        return inm
    }

    fun getInft(): Double {
        return inft
    }

    fun getInlt(): Double {
        return inlt
    }

    fun getIng(): Double {
        return ing
    }

    fun getLtcm(): Double {
        return ltcm
    }

    fun getLtm(): Double {
        return ltm
    }

    fun getLtft(): Double {
        return ltft
    }

    fun getLtin(): Double {
        return ltin
    }

    fun getLtg(): Double {
        return ltg
    }

    fun getGcm(): Double {
        return gcm
    }

    fun getGm(): Double {
        return gm
    }

    fun getGft(): Double {
        return gft
    }

    fun getGin(): Double {
        return gin
    }

    fun getGlt(): Double {
        return glt
    }
}