package com.aristidevs.convertirdorunidadesandroid.presentation.state

import com.aristidevs.convertirdorunidadesandroid.domain.model.UnidadVelocidad

data class VelocidadIUEstado(
    val valorConvertible: Double ?= 0.0,
    val unidadDeConversion: UnidadVelocidad?= UnidadVelocidad.MS,
    val salidaMs: Double ?= 0.0,
    val salidaKmH: Double ?= 0.0,
    val salidaFtS: Double ?= 0.0,
    val salidaMiH: Double ?= 0.0,
    val salidaNudo: Double ?= 0.0
)
