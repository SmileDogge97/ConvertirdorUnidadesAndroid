package com.aristidevs.convertirdorunidadesandroid.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardOptions
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
        Column(
            modifier = Modifier.padding(7.dp),
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
        Row(
            modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)
        ) {
            Column(
                modifier = Modifier.padding(end= 7.dp).fillMaxHeight()
            ) {
                val labelModifier = Modifier.weight(1f).wrapContentHeight(Alignment.CenterVertically).padding(top= 3.5.dp, bottom = 3.5.dp)
                Text(
                    text = stringResource(R.string.tiempo_segundo),
                    modifier = labelModifier
                )
                Text(
                    text = stringResource(R.string.tiempo_minuto),
                    modifier = labelModifier
                )
                Text(
                    text = stringResource(R.string.tiempo_hora),
                    modifier = labelModifier
                )
                Text(
                    text = stringResource(R.string.tiempo_dia),
                    modifier = labelModifier
                )
                Text(
                    text = stringResource(R.string.tiempo_anio),
                    modifier = labelModifier
                )
            }
            Column(
                modifier = Modifier.wrapContentHeight().fillMaxWidth()
            ) {
                val fieldModifier = Modifier.fillMaxWidth().padding(top= 3.5.dp, bottom = 3.5.dp)
                TextField(
                    value = state.salidaSegundo.toString(),
                    readOnly = true,
                    onValueChange = {  },
                    modifier = fieldModifier
                )
                TextField(
                    value = state.salidaMinuto.toString(),
                    readOnly = true,
                    onValueChange = { },
                    modifier = fieldModifier
                )
                TextField(
                    value = state.salidaHora.toString(),
                    readOnly = true,
                    onValueChange = { },
                    modifier = fieldModifier
                )
                TextField(
                    value = state.salidaDia.toString(),
                    readOnly = true,
                    onValueChange = { },
                    modifier = fieldModifier
                )
                TextField(
                    value = state.salidaAño.toString(),
                    readOnly = true,
                    onValueChange = { },
                    modifier = fieldModifier
                )
            }
        }
    }

    @Composable
    fun TiempoInput(
        value: String,
        onValueChange: (String) -> Unit,
        onUnidadChange: (UnidadTiempo) -> Unit
    ) {
        var entradaTiempo by remember { mutableStateOf(if(value.equals(0.0)) "" else value.toString()) }
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
        Box() {
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