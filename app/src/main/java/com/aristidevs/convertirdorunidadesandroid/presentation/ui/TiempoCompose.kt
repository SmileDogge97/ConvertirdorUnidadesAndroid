package com.aristidevs.convertirdorunidadesandroid.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aristidevs.convertirdorunidadesandroid.R
import com.aristidevs.convertirdorunidadesandroid.domain.model.UnidadTiempo
import com.aristidevs.convertirdorunidadesandroid.presentation.state.TemperaturaIUEstado
import com.aristidevs.convertirdorunidadesandroid.presentation.state.TiempoIUEstado
import com.aristidevs.convertirdorunidadesandroid.presentation.vm.TemperaturaViewModel
import com.aristidevs.convertirdorunidadesandroid.presentation.vm.TiempoViewModel


@Composable
    @Preview(showBackground = true)
    fun tiempoUI() {
        TiempoCompose()
    }

    @Composable
    fun TiempoCompose(viewModel: TiempoViewModel = viewModel()) {
        val iuState by viewModel.iuEstado.collectAsStateWithLifecycle()
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(7.dp)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TituloTiempo()
            TiempoInput(
                value = iuState.valorConvertible.toString(),
                onValueChange = { viewModel.CambioValor(it) },
                onUnidadChange = { viewModel.CambioUnidad(it) }
            )
            Spacer(modifier = Modifier.padding(8.dp))
            TiempoOutput(iuState)
        }
    }

    @Composable
    fun TiempoOutput(state: TiempoIUEstado) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 7.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            TiempoResultadoRow(
                label = stringResource(R.string.tiempo_segundo),
                valor = state.salidaSegundo.toString()
            )
            TiempoResultadoRow(
                label = stringResource(R.string.tiempo_minuto),
                valor = state.salidaMinuto.toString()
            )
            TiempoResultadoRow(
                label = stringResource(R.string.tiempo_hora),
                valor = state.salidaHora.toString()
            )
            TiempoResultadoRow(
                label = stringResource(R.string.tiempo_dia),
                valor = state.salidaDia.toString()
            )
            TiempoResultadoRow(
                label = stringResource(R.string.tiempo_anio),
                valor = state.salidaAño.toString()
            )
        }
    }

    @Composable
    fun TiempoResultadoRow(label: String, valor: String) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = label,
                modifier = Modifier.weight(0.25f),
                textAlign = TextAlign.Start
            )
            TextField(
                value = valor,
                readOnly = true,
                onValueChange = { },
                modifier = Modifier.weight(0.75f)
            )
        }
    }

    @Composable
    fun TiempoInput(
        value: String,
        onValueChange: (String) -> Unit,
        onUnidadChange: (UnidadTiempo) -> Unit
    ) {
        var entradaTiempo by remember { mutableStateOf(if(value == "0.0") "" else value) }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            TextField(
                value = entradaTiempo,
                onValueChange = { nuevoTexto ->
                    if (nuevoTexto.isEmpty() || nuevoTexto.matches(Regex("""^-?\d*\.?\d*$"""))){
                        entradaTiempo = nuevoTexto

                        val numero = nuevoTexto.toDoubleOrNull()
                        if (numero != null){
                            onValueChange(numero.toString())
                        } else if(nuevoTexto.isEmpty() || nuevoTexto == "-"){
                            onValueChange((0.0).toString())
                        }
                    }
                },
                placeholder = { Text(text = stringResource(R.string.placeholder_tiempo)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
            )
            menuTiempo(onUnidadChange)
        }
    }

    @Composable
    private fun menuTiempo(onUnidadChange: (UnidadTiempo) -> Unit) {
        var expanded by remember { mutableStateOf(false) }
        Box {
            IconButton(onClick = { expanded = !expanded }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = stringResource(R.string.menu_tiempo)
                )
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text(text = stringResource(R.string.tiempo_segundo)) },
                    onClick = {
                        onUnidadChange(UnidadTiempo.SEGUNDO)
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text(text = stringResource(R.string.tiempo_minuto)) },
                    onClick = {
                        onUnidadChange(UnidadTiempo.MINUTO)
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text(text = stringResource(R.string.tiempo_hora)) },
                    onClick = {
                        onUnidadChange(UnidadTiempo.HORA)
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text(text = stringResource(R.string.tiempo_dia)) },
                    onClick = {
                        onUnidadChange(UnidadTiempo.DIA)
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text(text = stringResource(R.string.tiempo_anio)) },
                    onClick = {
                        onUnidadChange(UnidadTiempo.AÑO)
                        expanded = false
                    }
                )
            }
        }
    }

    @Composable
    fun TituloTiempo() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.titulo_tiempo),
                modifier = Modifier.padding(all = 15.dp),
                textAlign = TextAlign.Center
            )
        }
    }