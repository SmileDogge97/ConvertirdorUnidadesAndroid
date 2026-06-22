package com.aristidevs.convertirdorunidadesandroid.presentation.state

import androidx.compose.ui.res.stringResource
import androidx.core.R
import com.aristidevs.convertirdorunidadesandroid.domain.model.UnidadTemperatura

data class TemperaturaUiState(
    val valorConvertible: Double ?= 0.0,
    val unidadDeConversion: UnidadTemperatura ?= UnidadTemperatura.CELSIUS,
    val salidaCelsius: Double ?= 0.0,
    val salidaKelvin: Double ?= 0.0,
    val salidaFarenheit: Double ?= 0.0,
    val salidaRankine: Double ?= 0.0
)
