package com.aristidevs.convertirdorunidadesandroid.presentation.state

import com.aristidevs.convertirdorunidadesandroid.domain.model.UnidadLongitud

data class LongitudIUEstado(
    val valorConvertible : Double ?= 0.0,
    val unidadDeConversion : UnidadLongitud?= UnidadLongitud.METRO,
    val salidaMetro : Double ?= 0.0,
    val salidaKilometro : Double ?= 0.0,
    val salidaCentimetro : Double ?= 0.0,
    val salidaPulgada : Double ?= 0.0,
    val salidaPies : Double ?= 0.0,
    val salidaYardas : Double ?= 0.0,
    val salidaMillas : Double ?= 0.0,
    val salidaMillasNauticas : Double ?= 0.0,
    val salidaAñosLuz : Double ?= 0.0
)
