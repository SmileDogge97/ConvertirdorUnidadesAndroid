package com.aristidevs.convertirdorunidadesandroid.presentation.vm

import androidx.lifecycle.ViewModel
import com.aristidevs.convertirdorunidadesandroid.domain.model.UnidadVelocidad
import com.aristidevs.convertirdorunidadesandroid.presentation.state.VelocidadIUEstado
import com.aristidevs.convertirdorunidadesandroid.transformador.Velocidad
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class VelocidadViewModel : ViewModel() {
    private val _iuValorEstado = MutableStateFlow(VelocidadIUEstado())
    val iuEstado: StateFlow<VelocidadIUEstado> = _iuValorEstado.asStateFlow()
    private val transformador = Velocidad()

    fun CambioValor(nuevoValor: String){
        _iuValorEstado.update { it.copy(valorConvertible = nuevoValor.toDoubleOrNull()) }
        convertirVelocidad()
    }

    fun CambioUnidad(nuevaUnidad: UnidadVelocidad) {
        _iuValorEstado.update { it.copy(unidadDeConversion = nuevaUnidad) }
        convertirVelocidad()
    }

    private fun convertirVelocidad() {
        val valor = _iuValorEstado.value.valorConvertible ?: 0.0
        val unidad = _iuValorEstado.value.unidadDeConversion
        when (unidad){
        UnidadVelocidad.MS -> {
            transformador.setms(valor)
            transformador.cms()
            _iuValorEstado.update { it.copy(
                salidaMs = valor,
                salidaKmH = transformador.mk(),
                salidaFtS = transformador.mf(),
                salidaMiH = transformador.mmi(),
                salidaNudo = transformador.mn()
            )}
        }
        UnidadVelocidad.KMH -> {
            transformador.setkmh(valor)
            transformador.ckmh()
            _iuValorEstado.update { it.copy(
                salidaMs = transformador.km(),
                salidaKmH = valor,
                salidaFtS = transformador.kf(),
                salidaMiH = transformador.kmi(),
                salidaNudo = transformador.kn()
            )}
        }
        UnidadVelocidad.FTS -> {
            transformador.setfts(valor)
            transformador.cfts()
            _iuValorEstado.update { it.copy(
                salidaMs = transformador.fm(),
                salidaKmH = transformador.fk(),
                salidaFtS = valor,
                salidaMiH = transformador.fmi(),
                salidaNudo = transformador.fn()
            ) }
        }
        UnidadVelocidad.MIH -> {
            transformador.setmih(valor)
            transformador.cmih()
            _iuValorEstado.update { it.copy(
                salidaMs = transformador.mim(),
                salidaKmH = transformador.mik(),
                salidaFtS = transformador.mif(),
                salidaMiH = valor,
                salidaNudo = transformador.min()
            )}
        }
        UnidadVelocidad.NUDO -> {
            transformador.setnudo(valor)
            transformador.cnudo()
            _iuValorEstado.update { it.copy(
                salidaMs = transformador.nm(),
                salidaKmH = transformador.nk(),
                salidaFtS = transformador.nf(),
                salidaMiH = transformador.nmi(),
                salidaNudo = valor
            )}
        }
            else -> {}
        }
    }
}