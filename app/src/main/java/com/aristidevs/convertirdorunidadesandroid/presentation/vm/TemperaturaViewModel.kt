package com.aristidevs.convertirdorunidadesandroid.presentation.vm

import androidx.lifecycle.ViewModel
import com.aristidevs.convertirdorunidadesandroid.domain.model.UnidadTemperatura
import com.aristidevs.convertirdorunidadesandroid.presentation.state.TemperaturaIUEstado
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

import com.aristidevs.convertirdorunidadesandroid.transformador.Temperatura

class TemperaturaViewModel : ViewModel() {
    private val _iuValorEstado = MutableStateFlow(TemperaturaIUEstado())
    val iuEstado: StateFlow<TemperaturaIUEstado> = _iuValorEstado.asStateFlow()

    private val transformador = Temperatura()

    fun CambioValor(nuevoValor: String) {
        _iuValorEstado.update { it.copy(valorConvertible = nuevoValor.toDoubleOrNull()) }
        convertirTemperatura()
    }

    fun CambioUnidad(nuevaUnidad: UnidadTemperatura) {
        _iuValorEstado.update { it.copy(unidadDeConversion = nuevaUnidad) }
        convertirTemperatura()
    }

    private fun convertirTemperatura() {
        val valor = _iuValorEstado.value.valorConvertible ?: 0.0
        val unidad = _iuValorEstado.value.unidadDeConversion

        // Configuramos el transformador según la unidad seleccionada
        when (unidad) {
            UnidadTemperatura.CELSIUS -> {
                transformador.setCelsius(valor)
                transformador.conversionCelsius()
                _iuValorEstado.update { it.copy(
                    salidaCelsius = valor,
                    salidaKelvin = transformador.ck(),
                    salidaFarenheit = transformador.cf(),
                    salidaRankine = transformador.cr()
                )}
            }
            UnidadTemperatura.FAHRENHEIT -> {
                transformador.setFarenheit(valor)
                transformador.conversionFarenheit()
                _iuValorEstado.update { it.copy(
                    salidaCelsius = transformador.fc(),
                    salidaKelvin = transformador.fk(),
                    salidaFarenheit = valor,
                    salidaRankine = transformador.fr()
                )}
            }
            UnidadTemperatura.KELVIN -> {
                transformador.setKelvin(valor)
                transformador.conversionKelvin()
                _iuValorEstado.update { it.copy(
                    salidaCelsius = transformador.kc(),
                    salidaKelvin = valor,
                    salidaFarenheit = transformador.kf(),
                    salidaRankine = transformador.kr()
                )}
            }
            UnidadTemperatura.RANKINE -> {
                transformador.setRankine(valor)
                transformador.conversionRankine()
                _iuValorEstado.update { it.copy(
                    salidaCelsius = transformador.rc(),
                    salidaKelvin = transformador.rk(),
                    salidaFarenheit = transformador.rf(),
                    salidaRankine = valor
                )}
            }
            else -> {}
        }
    }
}