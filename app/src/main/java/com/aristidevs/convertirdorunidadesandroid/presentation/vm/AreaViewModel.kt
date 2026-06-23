package com.aristidevs.convertirdorunidadesandroid.presentation.vm

import androidx.lifecycle.ViewModel
import com.aristidevs.convertirdorunidadesandroid.domain.model.UnidadArea
import com.aristidevs.convertirdorunidadesandroid.domain.model.UnidadTemperatura
import com.aristidevs.convertirdorunidadesandroid.presentation.state.AreaIUEstado
import com.aristidevs.convertirdorunidadesandroid.transformador.Area
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AreaViewModel : ViewModel() {
    private val _iuValorEstado = MutableStateFlow(AreaIUEstado())
    val iuEstado: StateFlow<AreaIUEstado> = _iuValorEstado.asStateFlow()

    private val transformador = Area()

    fun CambioValor(nuevoValor: String){
        _iuValorEstado.update { it.copy(valorConvertible = nuevoValor.toDoubleOrNull()) }
        convertirArea()
    }

    fun CambioUnidad(nuevaUnidad: UnidadArea){
        _iuValorEstado.update { it.copy(unidadDeConversion = nuevaUnidad) }
        convertirArea()
    }

    private fun convertirArea(){
        val valor = _iuValorEstado.value.valorConvertible ?: 0.0
        val unidad = _iuValorEstado.value.unidadDeConversion

        when(unidad){
            UnidadArea.METRO -> {
                transformador.setm(valor)
                transformador.cmt()
                _iuValorEstado.update { it.copy(
                    salidaMetro = valor,
                    salidaHectarea = transformador.getMh(),
                    salidaCentimetro = transformador.getMcm(),
                    salidaPulgada = transformador.getMin(),
                    salidaPie = transformador.getMft(),
                    salidaYarda = transformador.getMyd(),
                    salidaMilla = transformador.getMmi()
                )}
            }
            UnidadArea.HECTAREA -> {
                transformador.seth(valor)
                transformador.cht()
                _iuValorEstado.update { it.copy(
                    salidaMetro = transformador.getHm(),
                    salidaHectarea = valor,
                    salidaCentimetro = transformador.getHcm(),
                    salidaPulgada = transformador.getHin(),
                    salidaPie = transformador.getHft(),
                    salidaYarda = transformador.getHyd(),
                    salidaMilla = transformador.getHmi()
                )}
            }
            UnidadArea.CENTIMETRO -> {
                transformador.setcm(valor)
                transformador.ccm()
                _iuValorEstado.update { it.copy(
                    salidaMetro = transformador.getCmm(),
                    salidaHectarea = transformador.getCmh(),
                    salidaCentimetro = valor,
                    salidaPulgada = transformador.getCmin(),
                    salidaPie = transformador.getCmft(),
                    salidaYarda = transformador.getCmyd(),
                    salidaMilla = transformador.getCmmi()
                )}
            }
            UnidadArea.PULGADA -> {
                transformador.setin(valor)
                transformador.cin()
                _iuValorEstado.update { it.copy(
                    salidaMetro = transformador.getInm(),
                    salidaHectarea = transformador.getInh(),
                    salidaCentimetro = transformador.getIncm(),
                    salidaPulgada = valor,
                    salidaPie = transformador.getInft(),
                    salidaYarda = transformador.getInyd(),
                    salidaMilla = transformador.getInmi()
                )}
            }
            UnidadArea.PIE -> {
                transformador.setft(valor)
                transformador.cft()
                _iuValorEstado.update { it.copy(
                    salidaMetro = transformador.getFtm(),
                    salidaHectarea = transformador.getFth(),
                    salidaCentimetro = transformador.getFtcm(),
                    salidaPulgada = transformador.getFtin(),
                    salidaPie = valor,
                    salidaYarda = transformador.getFtyd(),
                    salidaMilla = transformador.getFtmi()
                )}
            }
            UnidadArea.YARDA -> {
                transformador.setyd(valor)
                transformador.cyd()
                _iuValorEstado.update { it.copy(
                    salidaMetro = transformador.getYdm(),
                    salidaHectarea = transformador.getYdh(),
                    salidaCentimetro = transformador.getYdcm(),
                    salidaPulgada = transformador.getYdin(),
                    salidaPie = transformador.getYdft(),
                    salidaYarda = valor,
                    salidaMilla = transformador.getYdmi()
                )}
            }
            UnidadArea.MILLA -> {
                transformador.setmi(valor)
                transformador.cmi()
                _iuValorEstado.update { it.copy(
                    salidaMetro = transformador.getMim(),
                    salidaHectarea = transformador.getMih(),
                    salidaCentimetro = transformador.getMicm(),
                    salidaPulgada = transformador.getMiin(),
                    salidaPie = transformador.getMift(),
                    salidaYarda = transformador.getMiyd(),
                    salidaMilla = valor
                )}
            }
            else -> {}
        }

    }
}