package com.aristidevs.convertirdorunidadesandroid.transformador

class Velocidad {
    private var ms = 0.0
    private var kmh = 0.0
    private var fts = 0.0
    private var mih = 0.0
    private var nudo = 0.0
    private var mk = 0.0
    private var mf = 0.0
    private var mmi = 0.0
    private var mn = 0.0
    private var km = 0.0
    private var kf = 0.0
    private var kmi = 0.0
    private var kn = 0.0
    private var fm = 0.0
    private var fk = 0.0
    private var fmi = 0.0
    private var fn = 0.0
    private var mim = 0.0
    private var mik = 0.0
    private var mif = 0.0
    private var min = 0.0
    private var nm = 0.0
    private var nk = 0.0
    private var nf = 0.0
    private var nmi = 0.0

    fun Rapidez() {
        ms = 0.0
        kmh = 0.0
        fts = 0.0
        mih = 0.0
        nudo = 0.0
        mk = 0.0
        mf = 0.0
        mmi = 0.0
        mn = 0.0
        km = 0.0
        kf = 0.0
        kmi = 0.0
        kn = 0.0
        fm = 0.0
        fk = 0.0
        fmi = 0.0
        fn = 0.0
        mim = 0.0
        mik = 0.0
        mif = 0.0
        min = 0.0
        nm = 0.0
        nk = 0.0
        nf = 0.0
        nmi = 0.0
    }

    fun setms(m: Double) {
        ms = m
    }

    fun setkmh(k: Double) {
        kmh = k
    }

    fun setfts(f: Double) {
        fts = f
    }

    fun setmih(mi: Double) {
        this.mih = mi
    }

    fun setnudo(n: Double) {
        this.nudo = n
    }

    fun cms() {
        mk = ms * (3.60 / 1)
        mf = ms * (3.28 / 1)
        mmi = ms * (2.236936 / 1)
        mn = ms * (1 / 0.5144)
    }

    fun ckmh() {
        km = kmh * (0.2778 / 1)
        kf = kmh * (0.911 / 1)
        kmi = kmh * (0.621 / 1)
        kn = kmh * (0.2778 / 1) * (1 / 0.5144)
    }

    fun cfts() {
        fm = fts * (0.3048 / 1)
        fk = fts * (1.10 / 1)
        fmi = fts * (0.682 / 1)
        fn = fts * (0.3048 / 1) * (1 / 0.5144)
    }

    fun cmih() {
        mim = mih * (0.4470 / 1)
        mik = mih * (1.609 / 1)
        mif = mih * (1.466 / 1)
        min = mih * (0.4470 / 1) * (1 / 0.51)
    }

    fun cnudo() {
        nm = nudo * (0.5144 / 1)
        nk = nudo * (0.5144 / 1) * (1 / 0.2778)
        nf = nudo * (0.5144 / 1) * (1 / 0.3048)
        nmi = nudo * (0.5144 / 1) * (1 / 0.4470)
    }

    fun ms(): Double {
        return ms
    }

    fun kmh(): Double {
        return kmh
    }

    fun fts(): Double {
        return fts
    }

    fun mih(): Double {
        return mih
    }

    fun nudo(): Double {
        return nudo
    }

    fun mk(): Double {
        return mk
    }

    fun mf(): Double {
        return mf
    }

    fun mmi(): Double {
        return mmi
    }

    fun mn(): Double {
        return mn
    }

    fun km(): Double {
        return km
    }

    fun kf(): Double {
        return kf
    }

    fun kmi(): Double {
        return kmi
    }

    fun kn(): Double {
        return kn
    }

    fun fm(): Double {
        return fm
    }

    fun fk(): Double {
        return fk
    }

    fun fmi(): Double {
        return fmi
    }

    fun fn(): Double {
        return fn
    }

    fun mim(): Double {
        return mim
    }

    fun mik(): Double {
        return mik
    }

    fun mif(): Double {
        return mif
    }

    fun min(): Double {
        return min
    }

    fun nm(): Double {
        return nm
    }

    fun nk(): Double {
        return nk
    }

    fun nf(): Double {
        return nf
    }

    fun nmi(): Double {
        return nmi
    }
}