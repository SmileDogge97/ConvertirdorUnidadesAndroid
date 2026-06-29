package com.aristidevs.convertirdorunidadesandroid.presentation.vm

import androidx.lifecycle.ViewModel
import com.aristidevs.convertirdorunidadesandroid.domain.model.UnidadTiempo
import com.aristidevs.convertirdorunidadesandroid.presentation.state.TiempoIUEstado
import kotlinx.coroutines.flow.MutableStateFlow
import com.aristidevs.convertirdorunidadesandroid.transformador.Tiempo
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TiempoViewModel : ViewModel() {
    private val _iuValorEstado = MutableStateFlow(TiempoIUEstado())
    val iuEstado: StateFlow<TiempoIUEstado> = _iuValorEstado.asStateFlow()

    private val transformador = Tiempo()

    fun CambioValor(nuevoValor: String) {
        _iuValorEstado.update { it.copy(valorConvertible = nuevoValor.toDoubleOrNull()) }
        convertirTiempo()
    }

    fun CambioUnidad(nuevaUnidad: UnidadTiempo) {
        _iuValorEstado.update { it.copy(unidadDeConversion = nuevaUnidad) }
        convertirTiempo()
    }

    private fun convertirTiempo(){
        val valor = _iuValorEstado.value.valorConvertible ?: 0.0
        val unidad = _iuValorEstado.value.unidadDeConversion

        when(unidad){
            UnidadTiempo.SEGUNDO -> {
                transformador.setSegundo(valor)
                transformador.cSegundo()
                _iuValorEstado.update { it.copy(
                    salidaSegundo = valor,
                    salidaMinuto = transformador.sm(),
                    salidaHora = transformador.sh(),
                    salidaDia = transformador.sd(),
                    salidaAño = transformador.sa()
                ) }
            }
            UnidadTiempo.MINUTO -> {
                transformador.setMinuto(valor)
                transformador.cMinuto()
                _iuValorEstado.update { it.copy(
                    salidaSegundo = transformador.ms(),
                    salidaMinuto = valor,
                    salidaHora = transformador.mh(),
                    salidaDia = transformador.md(),
                    salidaAño = transformador.ma()
                )}
            }
            UnidadTiempo.HORA -> {
                transformador.setHora(valor)
                transformador.cHora()
                _iuValorEstado.update { it.copy(
                    salidaSegundo = transformador.hs(),
                    salidaMinuto = transformador.hm(),
                    salidaHora = valor,
                    salidaDia = transformador.hd(),
                    salidaAño = transformador.ha()
                ) }
            }
            UnidadTiempo.DIA -> {
                transformador.setDia(valor)
                transformador.cDía()
                _iuValorEstado.update { it.copy(
                    salidaSegundo = transformador.ds(),
                    salidaMinuto = transformador.dm(),
                    salidaHora = transformador.dh(),
                    salidaDia = valor,
                    salidaAño = transformador.da()
                ) }
            }
            UnidadTiempo.AÑO -> {
                transformador.setAño(valor)
                transformador.cAño()
                _iuValorEstado.update {
                    it.copy(
                        salidaSegundo = transformador.`as`(),
                        salidaMinuto = transformador.am(),
                        salidaHora = transformador.ah(),
                        salidaDia = transformador.ad(),
                        salidaAño = valor
                    )
                }
            }
            else -> {}
        }
    }
}