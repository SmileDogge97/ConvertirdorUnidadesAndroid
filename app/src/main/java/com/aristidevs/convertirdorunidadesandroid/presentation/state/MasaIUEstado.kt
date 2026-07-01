package com.aristidevs.convertirdorunidadesandroid.presentation.state

import com.aristidevs.convertirdorunidadesandroid.domain.model.UnidadMasa

data class MasaIUEstado(
    val valorConvertible: Double ?= 0.0,
    val unidadDeConversion: UnidadMasa ?= UnidadMasa.GRAMO,
    val salidaGramo: Double ?= 0.0,
    val salidaKilogramo: Double ?= 0.0,
    val salidaLibra: Double ?= 0.0,
    val salidaTonelada: Double ?= 0.0
)
