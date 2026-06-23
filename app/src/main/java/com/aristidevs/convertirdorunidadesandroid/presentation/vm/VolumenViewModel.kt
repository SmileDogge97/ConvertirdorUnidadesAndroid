package com.aristidevs.convertirdorunidadesandroid.presentation.vm

import androidx.lifecycle.ViewModel
import com.aristidevs.convertirdorunidadesandroid.domain.model.UnidadVolumen
import com.aristidevs.convertirdorunidadesandroid.presentation.state.VolumenIUEstado
import com.aristidevs.convertirdorunidadesandroid.transformador.Volumen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class VolumenViewModel : ViewModel() {
    private val _iuValorEstado = MutableStateFlow(VolumenIUEstado())
    val iuEstado: StateFlow<VolumenIUEstado> = _iuValorEstado.asStateFlow()

    private val transformador = Volumen()

    fun CambioValor(nuevoValor: String){
        _iuValorEstado.update { it.copy(valorConvertible = nuevoValor.toDoubleOrNull()) }
        convertirVolumen()
    }

    fun CambioUnidad(nuevaUnidad: UnidadVolumen){
        _iuValorEstado.update { it.copy(unidadDeConversion = nuevaUnidad) }
        convertirVolumen()
    }

    fun convertirVolumen(){
        val valor = _iuValorEstado.value.valorConvertible ?: 0.0
        val unidad = _iuValorEstado.value.unidadDeConversion

        when(unidad) {
            UnidadVolumen.CENTIMETRO -> {
                transformador.setCentimetro(valor)
                transformador.ccm()
                _iuValorEstado.update { it.copy(
                    salidaCentimetro = valor,
                    salidaMetro = transformador.getCmm(),
                    salidaPie = transformador.getCmft(),
                    salidaPulgada = transformador.getCmin(),
                    salidaLitro = transformador.getCmlt(),
                    salidaGalon = transformador.getCmg()
                )}
            }
            UnidadVolumen.METRO -> {
                transformador.setMetro(valor)
                transformador.cm()
                _iuValorEstado.update { it.copy(
                    salidaCentimetro = transformador.getMcm(),
                    salidaMetro = valor,
                    salidaPie = transformador.getMft(),
                    salidaPulgada = transformador.getMin(),
                    salidaLitro = transformador.getMlt(),
                    salidaGalon = transformador.getMg()
                )}
            }
            UnidadVolumen.PIE -> {
                transformador.setPie(valor)
                transformador.cft()
                _iuValorEstado.update { it.copy(
                    salidaCentimetro = transformador.getFtcm(),
                    salidaMetro = transformador.getFtm(),
                    salidaPie = valor,
                    salidaPulgada = transformador.getFtin(),
                    salidaLitro = transformador.getFtlt(),
                    salidaGalon = transformador.getFtg()
                )}
            }
            UnidadVolumen.PULGADA -> {
                transformador.setPulgada(valor)
                transformador.cin()
                _iuValorEstado.update { it.copy(
                    salidaCentimetro = transformador.getIncm(),
                    salidaMetro = transformador.getInm(),
                    salidaPie = transformador.getInft(),
                    salidaPulgada = valor,
                    salidaLitro = transformador.getInlt(),
                    salidaGalon = transformador.getIng()
                )}
            }
            UnidadVolumen.LITRO -> {
                transformador.setLitro(valor)
                transformador.clt()
                _iuValorEstado.update { it.copy(
                    salidaCentimetro = transformador.getLtcm(),
                    salidaMetro = transformador.getLtm(),
                    salidaPie = transformador.getLtft(),
                    salidaPulgada = transformador.getLtin(),
                    salidaLitro = valor,
                    salidaGalon = transformador.getLtg()
                )}
            }
            UnidadVolumen.GALON -> {
                transformador.setGalon(valor)
                transformador.cg()
                _iuValorEstado.update { it.copy(
                    salidaCentimetro = transformador.getGcm(),
                    salidaMetro = transformador.getGm(),
                    salidaPie = transformador.getGft(),
                    salidaPulgada = transformador.getGin(),
                    salidaLitro = transformador.getGlt(),
                    salidaGalon = valor
                )}
            }
            else -> {}
        }
    }
}