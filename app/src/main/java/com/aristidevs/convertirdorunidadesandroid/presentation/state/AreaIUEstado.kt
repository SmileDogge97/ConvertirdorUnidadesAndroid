package com.aristidevs.convertirdorunidadesandroid.presentation.state

import com.aristidevs.convertirdorunidadesandroid.domain.model.UnidadArea

data class AreaIUEstado(
    val valorConvertible: Double ?= 0.0,
    val unidadDeConversion: UnidadArea ?= UnidadArea.METRO,
    val salidaMetro: Double ?= 0.0,
    val salidaHectarea: Double ?= 0.0,
    val salidaCentimetro: Double ?= 0.0,
    val salidaPulgada: Double ?= 0.0,
    val salidaPie: Double ?= 0.0,
    val salidaYarda: Double ?= 0.0,
    val salidaMilla: Double ?= 0.0
)
