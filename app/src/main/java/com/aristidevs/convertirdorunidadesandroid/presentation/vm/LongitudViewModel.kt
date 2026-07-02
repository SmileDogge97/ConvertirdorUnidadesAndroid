package com.aristidevs.convertirdorunidadesandroid.presentation.vm

import androidx.lifecycle.ViewModel
import com.aristidevs.convertirdorunidadesandroid.domain.model.UnidadLongitud
import com.aristidevs.convertirdorunidadesandroid.presentation.state.LongitudIUEstado
import com.aristidevs.convertirdorunidadesandroid.transformador.Longitud
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LongitudViewModel : ViewModel() {
    private val _iuValorEstado = MutableStateFlow(LongitudIUEstado())
    val iuEstado : StateFlow<LongitudIUEstado> = _iuValorEstado.asStateFlow()

    private val transformador = Longitud()

    fun CambioValor(nuevoValor: String){
        _iuValorEstado.update { it.copy(valorConvertible = nuevoValor.toDoubleOrNull()) }
        convertirLongitud()
    }

    fun CambioUnidad(nuevaUnidad: UnidadLongitud){
        _iuValorEstado.update { it.copy(unidadDeConversion = nuevaUnidad) }
        convertirLongitud()
    }

    private fun convertirLongitud(){
        val valor = _iuValorEstado.value.valorConvertible ?: 0.0
        val unidad = _iuValorEstado.value.unidadDeConversion

        when(unidad){
            UnidadLongitud.METRO -> {
                transformador.setMetro(valor)
                transformador.cMetro()
                _iuValorEstado.update { it.copy(
                    salidaMetro = valor,
                    salidaKilometro = transformador.getMkm(),
                    salidaCentimetro = transformador.getMcm(),
                    salidaPulgada = transformador.getMin(),
                    salidaPies = transformador.getMft(),
                    salidaYardas = transformador.getMyd(),
                    salidaMillas = transformador.getMmi(),
                    salidaMillasNauticas = transformador.getMmina(),
                    salidaAñosLuz = transformador.getMal()
                )}
            }
            UnidadLongitud.KILOMETRO -> {
                transformador.setKilometro(valor)
                transformador.cKilometro()
                _iuValorEstado.update { it.copy(
                salidaMetro = transformador.getKmm(),
                salidaKilometro = valor,
                salidaCentimetro = transformador.getKmcm(),
                salidaPulgada = transformador.getKmin(),
                salidaPies = transformador.getKmft(),
                salidaYardas = transformador.getKmyd(),
                salidaMillas = transformador.getKmmi(),
                salidaMillasNauticas = transformador.getKmmina(),
                salidaAñosLuz = transformador.getKmal()
                )}
            }
            UnidadLongitud.CENTIMETRO -> {
                transformador.setCentimetro(valor)
                transformador.cCentimetro()
                _iuValorEstado.update { it.copy(
                    salidaMetro = transformador.getCmm(),
                    salidaKilometro = transformador.getCmkm(),
                    salidaCentimetro = valor,
                    salidaPulgada = transformador.getCmin(),
                    salidaPies = transformador.getCmft(),
                    salidaYardas = transformador.getCmyd(),
                    salidaMillas = transformador.getCmmi(),
                    salidaMillasNauticas = transformador.getCmmina(),
                    salidaAñosLuz = transformador.getCmal()
                )}
            }
            UnidadLongitud.PULGADA -> {
                transformador.setPulgada(valor)
                transformador.cPulgada()
                _iuValorEstado.update { it.copy(
                    salidaMetro = transformador.getInm(),
                    salidaKilometro = transformador.getInkm(),
                    salidaCentimetro = transformador.getIncm(),
                    salidaPulgada = valor,
                    salidaPies = transformador.getInft(),
                    salidaYardas = transformador.getInyd(),
                    salidaMillas = transformador.getInmi(),
                    salidaMillasNauticas = transformador.getInmina(),
                    salidaAñosLuz = transformador.getInal()
                )}
            }
            UnidadLongitud.PIE -> {
                transformador.setPie(valor)
                transformador.cPie()
                _iuValorEstado.update { it.copy(
                    salidaMetro = transformador.getFtm(),
                    salidaKilometro = transformador.getFtkm(),
                    salidaCentimetro = transformador.getFtcm(),
                    salidaPulgada = transformador.getFtin(),
                    salidaPies = valor,
                    salidaYardas = transformador.getFtyd(),
                    salidaMillas = transformador.getFtmi(),
                    salidaMillasNauticas = transformador.getFtmina(),
                    salidaAñosLuz = transformador.getFtal()
                )}
            }
            UnidadLongitud.YARDA -> {
                transformador.setYarda(valor)
                transformador.cYarda()
                _iuValorEstado.update { it.copy(
                    salidaMetro = transformador.getYdm(),
                    salidaKilometro = transformador.getYdkm(),
                    salidaCentimetro = transformador.getYdcm(),
                    salidaPulgada = transformador.getYdin(),
                    salidaPies = transformador.getYdft(),
                    salidaYardas = valor,
                    salidaMillas = transformador.getYdmi(),
                    salidaMillasNauticas = transformador.getYdmina(),
                    salidaAñosLuz = transformador.getYdal()
                )}
            }
            UnidadLongitud.MILLA -> {
                transformador.setMilla(valor)
                transformador.cMilla()
                _iuValorEstado.update { it.copy(
                    salidaMetro = transformador.getMim(),
                    salidaKilometro = valor,
                    salidaCentimetro = transformador.getMicm(),
                    salidaPulgada = transformador.getMiin(),
                    salidaPies = transformador.getMift(),
                    salidaYardas = transformador.getMiyd(),
                    salidaMillas = valor,
                    salidaMillasNauticas = transformador.getMimina(),
                    salidaAñosLuz = transformador.getMial()
                )}
            }
            UnidadLongitud.MILLA_NAUTICA -> {
                transformador.setMillaNautica(valor)
                transformador.cMillaNautica()
                _iuValorEstado.update { it.copy(
                    salidaMetro = transformador.getMnm(),
                    salidaKilometro = transformador.getMnkm(),
                    salidaCentimetro = transformador.getMncm(),
                    salidaPulgada = transformador.getMnin(),
                    salidaPies = transformador.getMnft(),
                    salidaYardas = transformador.getMnyd(),
                    salidaMillas = transformador.getMnmi(),
                    salidaMillasNauticas = valor,
                    salidaAñosLuz = transformador.getMnal()
                )}
            }
            UnidadLongitud.AÑO_LUZ -> {
                transformador.setAñoLuz(valor)
                transformador.cAñoluz()
                _iuValorEstado.update { it.copy(
                    salidaMetro = transformador.getAlm(),
                    salidaKilometro = transformador.getAlkm(),
                    salidaCentimetro = transformador.getAlcm(),
                    salidaPulgada = transformador.getAlin(),
                    salidaPies = transformador.getAlft(),
                    salidaYardas = transformador.getAlyd(),
                    salidaMillas = transformador.getAlmi(),
                    salidaMillasNauticas = transformador.getAlmina(),
                    salidaAñosLuz = valor
                )}
            }
            else -> {}
        }
    }
}