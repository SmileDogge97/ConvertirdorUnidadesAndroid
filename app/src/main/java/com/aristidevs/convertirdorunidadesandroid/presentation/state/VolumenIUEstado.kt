package com.aristidevs.convertirdorunidadesandroid.presentation.state

import com.aristidevs.convertirdorunidadesandroid.domain.model.UnidadVolumen

data class VolumenIUEstado(
    val valorConvertible: Double ?= 0.0,
    val unidadDeConversion: UnidadVolumen?= UnidadVolumen.CENTIMETRO,
    val salidaCentimetro: Double ?= 0.0,
    val salidaMetro: Double ?= 0.0,
    val salidaPie: Double ?= 0.0,
    val salidaPulgada: Double ?= 0.0,
    val salidaLitro: Double ?= 0.0,
    val salidaGalon: Double ?= 0.0
)