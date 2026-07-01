package com.aristidevs.convertirdorunidadesandroid.presentation.vm

import androidx.lifecycle.ViewModel
import com.aristidevs.convertirdorunidadesandroid.domain.model.UnidadMasa
import com.aristidevs.convertirdorunidadesandroid.presentation.state.MasaIUEstado
import com.aristidevs.convertirdorunidadesandroid.transformador.Masa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class MasaViewModel : ViewModel() {
    private val _iuValorEstado = MutableStateFlow(MasaIUEstado())
    val iuEstado: StateFlow<MasaIUEstado> = _iuValorEstado.asStateFlow()

    private val transformador = Masa()

    fun CambioValor(nuevoValor: String){
        _iuValorEstado.update { it.copy(valorConvertible = nuevoValor.toDoubleOrNull()) }
        convertirPeso()
    }

    fun CambioUnidad(nuevaUnidad: UnidadMasa) {
        _iuValorEstado.update { it.copy(unidadDeConversion = nuevaUnidad) }
        convertirPeso()
    }

    private fun convertirPeso() {
        val valor = _iuValorEstado.value.valorConvertible ?: 0.0
        val unidad = _iuValorEstado.value.unidadDeConversion

        when (unidad){
            UnidadMasa.GRAMO -> {
                transformador.setGramo(valor)
                transformador.cgramo()
                _iuValorEstado.update { it.copy(
                    salidaGramo = valor,
                    salidaKilogramo = transformador.getGkg(),
                    salidaLibra = transformador.getGlib(),
                    salidaTonelada = transformador.getGtn()
                )}
            }
            UnidadMasa.KILOGRAMO -> {
                transformador.setKilogramo(valor)
                transformador.ckilogramo()
                _iuValorEstado.update { it.copy(
                    salidaGramo = transformador.getKgg(),
                    salidaKilogramo = valor,
                    salidaLibra = transformador.getKglb(),
                    salidaTonelada = transformador.getKgtn()
                )}
            }
            UnidadMasa.LIBRA -> {
                transformador.setLibra(valor)
                transformador.clibra()
                _iuValorEstado.update { it.copy(
                    salidaGramo = transformador.getLbg(),
                    salidaKilogramo = transformador.getLbkg(),
                    salidaLibra = valor,
                    salidaTonelada = transformador.getLbtn()
                )}
            }
            UnidadMasa.TONELADA -> {
                transformador.setTonelada(valor)
                transformador.ctonelada()
                _iuValorEstado.update { it.copy(
                    salidaGramo = transformador.getTng(),
                    salidaKilogramo = transformador.getTnkg(),
                    salidaLibra = transformador.getTnlb(),
                    salidaTonelada = valor
                )}
            }
            else -> {}
        }
    }
}