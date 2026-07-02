package com.aristidevs.convertirdorunidadesandroid.transformador

class Longitud {
    private var metro = 0.0
    private var kilometro = 0.0
    private var centimetro = 0.0
    private var pulgada = 0.0
    private var pie = 0.0
    private var yarda = 0.0
    private var milla = 0.0
    private var millaNautica = 0.0
    private var añoLuz = 0.0

    private var mkm = 0.0
    private var mcm: Double = 0.0
    private var min: Double = 0.0
    private var mft: Double = 0.0
    private var myd: Double = 0.0
    private var mmi: Double = 0.0
    private var mmina: Double = 0.0
    private var mal: Double = 0.0
    private var kmm = 0.0
    private var kmcm: Double = 0.0
    private var kmin: Double = 0.0
    private var kmft: Double = 0.0
    private var kmyd: Double = 0.0
    private var kmmi: Double = 0.0
    private var kmmina: Double = 0.0
    private var kmal: Double = 0.0
    private var cmm = 0.0
    private var cmkm: Double = 0.0
    private var cmin: Double = 0.0
    private var cmft: Double = 0.0
    private var cmyd: Double = 0.0
    private var cmmi: Double = 0.0
    private var cmmina: Double = 0.0
    private var cmal: Double = 0.0
    private var inm = 0.0
    private var inkm: Double = 0.0
    private var incm: Double = 0.0
    private var inft: Double = 0.0
    private var inyd: Double = 0.0
    private var inmi: Double = 0.0
    private var inmina: Double = 0.0
    private var inal: Double = 0.0
    private var ftm = 0.0
    private var ftkm: Double = 0.0
    private var ftcm: Double = 0.0
    private var ftin: Double = 0.0
    private var ftyd: Double = 0.0
    private var ftmi: Double = 0.0
    private var ftmina: Double = 0.0
    private var ftal: Double = 0.0
    private var ydm = 0.0
    private var ydkm: Double = 0.0
    private var ydcm: Double = 0.0
    private var ydin: Double = 0.0
    private var ydft: Double = 0.0
    private var ydmi: Double = 0.0
    private var ydmina: Double = 0.0
    private var ydal: Double = 0.0
    private var mim = 0.0
    private var mikm: Double = 0.0
    private var micm: Double = 0.0
    private var miin: Double = 0.0
    private var mift: Double = 0.0
    private var miyd: Double = 0.0
    private var mimina: Double = 0.0
    private var mial: Double = 0.0
    private var mnm = 0.0
    private var mnkm: Double = 0.0
    private var mncm: Double = 0.0
    private var mnin: Double = 0.0
    private var mnft: Double = 0.0
    private var mnyd: Double = 0.0
    private var mnmi: Double = 0.0
    private var mnal: Double = 0.0
    private var alm = 0.0
    private var alkm: Double = 0.0
    private var alcm: Double = 0.0
    private var alin: Double = 0.0
    private var alft: Double = 0.0
    private var alyd: Double = 0.0
    private var almi: Double = 0.0
    private var almina: Double = 0.0

    fun Longitud() {
        metro = 0.0
        kilometro = 0.0
        centimetro = 0.0
        pulgada = 0.0
        pie = 0.0
        yarda = 0.0
        milla = 0.0
        millaNautica = 0.0
        añoLuz = 0.0
        mkm = 0.0
        mcm = 0.0
        min = 0.0
        mft = 0.0
        myd = 0.0
        mmi = 0.0
        mmina = 0.0
        mal = 0.0
        kmm = 0.0
        kmcm = 0.0
        kmin = 0.0
        kmft = 0.0
        kmyd = 0.0
        kmmi = 0.0
        kmmina = 0.0
        kmal = 0.0
        cmm = 0.0
        cmkm = 0.0
        cmin = 0.0
        cmft = 0.0
        cmyd = 0.0
        cmmi = 0.0
        cmmina = 0.0
        cmal = 0.0
        inm = 0.0
        inkm = 0.0
        incm = 0.0
        inft = 0.0
        inyd = 0.0
        inmi = 0.0
        inmina = 0.0
        inal = 0.0
        ftm = 0.0
        ftkm = 0.0
        ftcm = 0.0
        ftin = 0.0
        ftyd = 0.0
        ftmi = 0.0
        ftmina = 0.0
        ftal = 0.0
        ydm = 0.0
        ydkm = 0.0
        ydcm = 0.0
        ydin = 0.0
        ydft = 0.0
        ydmi = 0.0
        ydmina = 0.0
        ydal = 0.0
        mim = 0.0
        mikm = 0.0
        micm = 0.0
        miin = 0.0
        mift = 0.0
        miyd = 0.0
        mimina = 0.0
        mial = 0.0
        mnm = 0.0
        mnkm = 0.0
        mncm = 0.0
        mnin = 0.0
        mnft = 0.0
        mnyd = 0.0
        mnmi = 0.0
        mnal = 0.0
        alm = 0.0
        alkm = 0.0
        alcm = 0.0
        alin = 0.0
        alft = 0.0
        alyd = 0.0
        almi = 0.0
        almina = 0.0
    }


    fun setMetro(metro: Double) {
        this.metro = metro
    }

    fun setKilometro(kilometro: Double) {
        this.kilometro = kilometro
    }

    fun setCentimetro(centimetro: Double) {
        this.centimetro = centimetro
    }

    fun setPulgada(pulgada: Double) {
        this.pulgada = pulgada
    }

    fun setPie(pie: Double) {
        this.pie = pie
    }

    fun setYarda(yarda: Double) {
        this.yarda = yarda
    }

    fun setMilla(milla: Double) {
        this.milla = milla
    }

    fun setMillaNautica(millaNautica: Double) {
        this.millaNautica = millaNautica
    }

    fun setAñoLuz(añoLuz: Double) {
        this.añoLuz = añoLuz
    }

    fun cMetro() {
        mkm = metro / 1000
        mcm = metro * 100
        min = metro * 39.37
        mft = metro * 3.281
        myd = metro * 1.0936
        mmi = metro / 1609.34
        mmina = metro / 1852
        mal = metro.toLong() * 0.00000000000000010570
    }

    fun cKilometro() {
        kmm = kilometro * 1000
        kmcm = kilometro * 100000
        kmin = kilometro * 39370.07
        kmft = kilometro * 3280.8399
        kmyd = kilometro * 1093.6133
        kmmi = kilometro * 0.6214
        kmmina = kilometro / 1.852
        kmal = kilometro.toLong() * 0.00000000000010570
    }

    fun cCentimetro() {
        cmm = centimetro / 100
        cmkm = centimetro / 100000
        cmin = centimetro / 2.5
        cmft = centimetro / 30.48
        cmyd = centimetro / 91.44
        cmmi = centimetro / 160934.4
        cmmina = centimetro / 185200
        cmal = centimetro * 0.0000000000000000010570
    }

    fun cPulgada() {
        inm = pulgada / 39.37
        inkm = pulgada / 39370.07
        incm = pulgada * 2.54
        inft = pulgada / 12
        inyd = pulgada * 0.02777778
        inmi = pulgada / 63360
        inmina = pulgada / 72913.38
        inal = pulgada.toLong() / (39.37 * 9461000000000000L)
    }

    fun cPie() {
        ftm = pie * 0.3048
        ftkm = pie * 0.0003048
        ftcm = pie / 0.032808
        ftin = pie * 12.000
        ftyd = pie / 3
        ftmi = pie / 5280
        ftmina = pie * 0.00016458
        ftal = pie * 0.000000000000000032217
    }

    fun cYarda() {
        ydm = yarda * 0.9144
        ydkm = yarda / 1093.61
        ydcm = yarda * 91.44
        ydin = yarda * 36
        ydft = yarda * 3
        ydmi = yarda / 1760
        ydmina = yarda * 0.00049374
        ydal = yarda * 0.000000000000000096652
    }

    fun cMilla() {
        mim = milla * 1609.34
        mikm = milla * 1.609344
        micm = milla * 160934.4
        miin = milla * 63360
        mift = milla * 5280
        miyd = milla * 1760
        mimina = milla * 0.86897624
        mial = milla * 0.00000000000017011
    }

    fun cMillaNautica() {
        mnm = millaNautica * 1852
        mnkm = millaNautica * 1.852
        mncm = millaNautica * 185200
        mnin = millaNautica * 72913.3858
        mnft = millaNautica * 6076.11549
        mnyd = millaNautica * 2025.37
        mnmi = millaNautica * 1.152
        mnal = millaNautica * 0.00000000000019576
    }

    fun cAñoluz() {
        alm = añoLuz / 0.00000000000000010570
        alkm = añoLuz / 0.00000000000010570
        alcm = añoLuz / 0.0000000000000000010570
        alin = añoLuz * 372470000000000000L
        alft = añoLuz * 31039000000000000L
        alyd = añoLuz * 10346000000000000L
        almi = añoLuz * 5878600000000L
        almina = añoLuz * 5108385916074.99
    }

    fun getMetro(): Double {
        return metro
    }

    fun getKilometro(): Double {
        return kilometro
    }

    fun getCentimetro(): Double {
        return centimetro
    }

    fun getPulgada(): Double {
        return pulgada
    }

    fun getPie(): Double {
        return pie
    }

    fun getYarda(): Double {
        return yarda
    }

    fun getMilla(): Double {
        return milla
    }

    fun getMillaNautica(): Double {
        return millaNautica
    }

    fun getAñoLuz(): Double {
        return añoLuz
    }

    fun getMkm(): Double {
        return mkm
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

    fun getMmina(): Double {
        return mmina
    }

    fun getMal(): Double {
        return mal
    }

    fun getKmm(): Double {
        return kmm
    }

    fun getKmcm(): Double {
        return kmcm
    }

    fun getKmin(): Double {
        return kmin
    }

    fun getKmft(): Double {
        return kmft
    }

    fun getKmyd(): Double {
        return kmyd
    }

    fun getKmmi(): Double {
        return kmmi
    }

    fun getKmmina(): Double {
        return kmmina
    }

    fun getKmal(): Double {
        return kmal
    }

    fun getCmm(): Double {
        return cmm
    }

    fun getCmkm(): Double {
        return cmkm
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

    fun getCmmina(): Double {
        return cmmina
    }

    fun getCmal(): Double {
        return cmal
    }

    fun getInm(): Double {
        return inm
    }

    fun getInkm(): Double {
        return inkm
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

    fun getInmina(): Double {
        return inmina
    }

    fun getInal(): Double {
        return inal
    }

    fun getFtm(): Double {
        return ftm
    }

    fun getFtkm(): Double {
        return ftkm
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

    fun getFtmina(): Double {
        return ftmina
    }

    fun getFtal(): Double {
        return ftal
    }

    fun getYdm(): Double {
        return ydm
    }

    fun getYdkm(): Double {
        return ydkm
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

    fun getYdmina(): Double {
        return ydmina
    }

    fun getYdal(): Double {
        return ydal
    }

    fun getMim(): Double {
        return mim
    }

    fun getMikm(): Double {
        return mikm
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

    fun getMimina(): Double {
        return mimina
    }

    fun getMial(): Double {
        return mial
    }

    fun getMnm(): Double {
        return mnm
    }

    fun getMnkm(): Double {
        return mnkm
    }

    fun getMncm(): Double {
        return mncm
    }

    fun getMnin(): Double {
        return mnin
    }

    fun getMnft(): Double {
        return mnft
    }

    fun getMnyd(): Double {
        return mnyd
    }

    fun getMnmi(): Double {
        return mnmi
    }

    fun getMnal(): Double {
        return mnal
    }

    fun getAlm(): Double {
        return alm
    }

    fun getAlkm(): Double {
        return alkm
    }

    fun getAlcm(): Double {
        return alcm
    }

    fun getAlin(): Double {
        return alin
    }

    fun getAlft(): Double {
        return alft
    }

    fun getAlyd(): Double {
        return alyd
    }

    fun getAlmi(): Double {
        return almi
    }

    fun getAlmina(): Double {
        return almina
    }
}