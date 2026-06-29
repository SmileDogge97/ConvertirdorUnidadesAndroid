package com.aristidevs.convertirdorunidadesandroid.presentation.state

import com.aristidevs.convertirdorunidadesandroid.domain.model.UnidadTiempo

data class TiempoIUEstado(
    val valorConvertible: Double ?= 0.0,
    val unidadDeConversion: UnidadTiempo ?= UnidadTiempo.SEGUNDO,
    val salidaSegundo: Double ?= 0.0,
    val salidaMinuto: Double ?= 0.0,
    val salidaHora: Double ?= 0.0,
    val salidaDia: Double ?= 0.0,
    val salidaAño: Double ?= 0.0
)
