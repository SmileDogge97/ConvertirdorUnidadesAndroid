package com.aristidevs.convertirdorunidadesandroid.transformador

class Area {
    private var metro = 0.0
    private var hectarea = 0.0
    private var centimetro = 0.0
    private var pulgada = 0.0
    private var pies = 0.0
    private var yarda = 0.0
    private var milla = 0.0
    private var mh = 0.0
    private var mcm = 0.0
    private var min = 0.0
    private var mft = 0.0
    private var myd = 0.0
    private var mmi = 0.0
    private var hm = 0.0
    private var hcm = 0.0
    private var hin = 0.0
    private var hft = 0.0
    private var hyd = 0.0
    private var hmi = 0.0
    private var cmm = 0.0
    private var cmh = 0.0
    private var cmin = 0.0
    private var cmft = 0.0
    private var cmyd = 0.0
    private var cmmi = 0.0
    private var inm = 0.0
    private var inh = 0.0
    private var incm = 0.0
    private var inft = 0.0
    private var inyd = 0.0
    private var inmi = 0.0
    private var ftm = 0.0
    private var fth = 0.0
    private var ftcm = 0.0
    private var ftin = 0.0
    private var ftyd = 0.0
    private var ftmi = 0.0
    private var ydm = 0.0
    private var ydh = 0.0
    private var ydcm = 0.0
    private var ydin = 0.0
    private var ydft = 0.0
    private var ydmi = 0.0
    private var mim = 0.0
    private var mih = 0.0
    private var micm = 0.0
    private var miin = 0.0
    private var mift = 0.0
    private var miyd = 0.0


    fun Area() {
        metro = 0.0
        hectarea = 0.0
        centimetro = 0.0
        pulgada = 0.0
        pies = 0.0
        yarda = 0.0
        milla = 0.0
        mh = 0.0
        mcm = 0.0
        min = 0.0
        mft = 0.0
        myd = 0.0
        mmi = 0.0
        hm = 0.0
        hcm = 0.0
        hin = 0.0
        hft = 0.0
        hyd = 0.0
        hmi = 0.0
        cmm = 0.0
        cmh = 0.0
        cmin = 0.0
        cmft = 0.0
        cmyd = 0.0
        cmmi = 0.0
        inm = 0.0
        inh = 0.0
        incm = 0.0
        inft = 0.0
        inyd = 0.0
        inmi = 0.0
        ftm = 0.0
        fth = 0.0
        ftcm = 0.0
        ftin = 0.0
        ftyd = 0.0
        ftmi = 0.0
        ydm = 0.0
        ydh = 0.0
        ydcm = 0.0
        ydin = 0.0
        ydft = 0.0
        ydmi = 0.0
        mim = 0.0
        mih = 0.0
        micm = 0.0
        miin = 0.0
        mift = 0.0
        miyd = 0.0
    }

    fun setm(mt: Double) {
        metro = mt
    }

    fun seth(ht: Double) {
        hectarea = ht
    }

    fun setcm(cm: Double) {
        centimetro = cm
    }

    fun setin(`in`: Double) {
        pulgada = `in`
    }

    fun setft(ft: Double) {
        pies = ft
    }

    fun setyd(yd: Double) {
        yarda = yd
    }

    fun setmi(mi: Double) {
        milla = mi
    }

    fun cmt() {
        mh = metro / 10000
        mcm = metro * (10000 / 1)
        min = metro * ((39.37 / 1) * (39.37 / 1))
        mft = metro * (10.76 / 1)
        myd = metro * (1 / 0.8364)
        mmi = (metro * 0.00062137) * (metro * 0.00062137)
    }

    fun cht() {
        hm = hectarea * (10000 / 1)
        hcm = hectarea * (10000 / 1) * (10000 / 1)
        hin = hectarea * (10000 / 1) * ((39.37 / 1) * (39.37 / 1))
        hft = hectarea * 107640
        hyd = hectarea * 11960
        hmi = (hectarea * 2.471) / 640
    }

    fun ccm() {
        cmm = centimetro / 10000
        cmh = centimetro / 100000000
        cmin = centimetro * (0.155 / 1)
        cmft = centimetro * (0.00108 / 1)
        cmyd = centimetro / (10000 * 0.8361)
        cmmi = centimetro * 0.000000000038610
    }

    fun cin() {
        inm = pulgada * ((1 / 39.37) * (1 / 39.37))
        inh = pulgada / 15500031
        incm = pulgada * (6.452 / 1)
        inft = pulgada / 144
        inyd = pulgada / 1296
        inmi = pulgada * 0.00000000024910
    }

    fun cft() {
        ftm = pies * (1 / 10.76)
        fth = pies * (1 / 107639.104)
        ftcm = pies * ((30.48 / 1) * (30.48 / 1))
        ftin = pies * (144 / 1)
        ftyd = pies / 9
        ftmi = pies * 0.000000035870
    }

    fun cyd() {
        ydm = yarda * (0.8361 / 1)
        ydh = yarda * (1 / 11959.9005)
        ydcm = yarda / 0.00011960
        ydin = yarda * (1296 / 1)
        ydft = yarda * (9 / 1)
        ydmi = yarda / 3097600
    }

    fun cmi() {
        mim = milla * (2589988.11 / 1)
        mih = milla * (1 / 0.003861)
        micm = (milla.toLong() * (25900000000L / 1)).toDouble()
        miin = (milla.toLong() * (4014489600L / 1)).toDouble()
        mift = milla * ((5280 / 1) * (5280 / 1))
        miyd = milla * (3097600 / 1)
    }

    fun getMetro(): Double {
        return metro
    }

    fun getHectarea(): Double {
        return hectarea
    }

    fun getCentimetro(): Double {
        return centimetro
    }

    fun getPulgada(): Double {
        return pulgada
    }

    fun getPies(): Double {
        return pies
    }

    fun getYarda(): Double {
        return yarda
    }

    fun getMilla(): Double {
        return milla
    }

    fun getMh(): Double {
        return mh
    }

    fun getMcm(): Double {
        return mcm
    }

    fun getMin(): Double {
        return min
    }

    fun getMft(): Double {
        return mft
    }

    fun getMyd(): Double {
        return myd
    }

    fun getMmi(): Double {
        return mmi
    }

    fun getHm(): Double {
        return hm
    }

    fun getHcm(): Double {
        return hcm
    }

    fun getHin(): Double {
        return hin
    }

    fun getHft(): Double {
        return hft
    }

    fun getHyd(): Double {
        return hyd
    }

    fun getHmi(): Double {
        return hmi
    }

    fun getCmm(): Double {
        return cmm
    }

    fun getCmh(): Double {
        return cmh
    }

    fun getCmin(): Double {
        return cmin
    }

    fun getCmft(): Double {
        return cmft
    }

    fun getCmyd(): Double {
        return cmyd
    }

    fun getCmmi(): Double {
        return cmmi
    }

    fun getInm(): Double {
        return inm
    }

    fun getInh(): Double {
        return inh
    }

    fun getIncm(): Double {
        return incm
    }

    fun getInft(): Double {
        return inft
    }

    fun getInyd(): Double {
        return inyd
    }

    fun getInmi(): Double {
        return inmi
    }

    fun getFtm(): Double {
        return ftm
    }

    fun getFth(): Double {
        return fth
    }

    fun getFtcm(): Double {
        return ftcm
    }

    fun getFtin(): Double {
        return ftin
    }

    fun getFtyd(): Double {
        return ftyd
    }

    fun getFtmi(): Double {
        return ftmi
    }

    fun getYdm(): Double {
        return ydm
    }

    fun getYdh(): Double {
        return ydh
    }

    fun getYdcm(): Double {
        return ydcm
    }

    fun getYdin(): Double {
        return ydin
    }

    fun getYdft(): Double {
        return ydft
    }

    fun getYdmi(): Double {
        return ydmi
    }

    fun getMim(): Double {
        return mim
    }

    fun getMih(): Double {
        return mih
    }

    fun getMicm(): Double {
        return micm
    }

    fun getMiin(): Double {
        return miin
    }

    fun getMift(): Double {
        return mift
    }

    fun getMiyd(): Double {
        return miyd
    }
}