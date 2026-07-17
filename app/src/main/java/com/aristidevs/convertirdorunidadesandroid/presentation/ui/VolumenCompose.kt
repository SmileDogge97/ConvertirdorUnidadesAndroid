package com.aristidevs.convertirdorunidadesandroid.UI

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
import com.aristidevs.convertirdorunidadesandroid.domain.model.UnidadVolumen
import com.aristidevs.convertirdorunidadesandroid.presentation.state.VolumenIUEstado
import com.aristidevs.convertirdorunidadesandroid.presentation.vm.VolumenViewModel


@Composable
    @Preview(
        showBackground = true
    )
    fun volumenUI() {
        VolumenCompose()
    }

@Composable
fun VolumenCompose(viewModel: VolumenViewModel = viewModel()){
    val iuState by viewModel.iuEstado.collectAsStateWithLifecycle()
    val scrollState = rememberScrollState()
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(7.dp)
        .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally) {
        TituloVolumen()
        VolumenInput(
            value = iuState.valorConvertible.toString(),
            onValueChange = { viewModel.CambioValor(it) },
            onUnidadChange = { viewModel.CambioUnidad(it) }
        )
        Spacer(modifier = Modifier.padding(8.dp))
        VolumenOutput(iuState)
    }
}

    @Composable
    fun VolumenOutput(state: VolumenIUEstado) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 7.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            VolumenResultadoRow(
                label = stringResource(R.string.volumen_centimetro),
                valor = state.salidaCentimetro.toString()
            )
            VolumenResultadoRow(
                label = stringResource(R.string.volumen_metro),
                valor = state.salidaMetro.toString()
            )
            VolumenResultadoRow(
                label = stringResource(R.string.volumen_pie),
                valor = state.salidaPie.toString()
            )
            VolumenResultadoRow(
                label = stringResource(R.string.volumen_pulgada),
                valor = state.salidaPulgada.toString()
            )
            VolumenResultadoRow(
                label = stringResource(R.string.volumen_litro),
                valor = state.salidaLitro.toString()
            )
            VolumenResultadoRow(
                label = stringResource(R.string.volumen_galon),
                valor = state.salidaGalon.toString()
            )
        }
    }

    @Composable
    fun VolumenResultadoRow(label: String, valor: String) {
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
    fun VolumenInput(
        value: String,
        onValueChange: (String) -> Unit,
        onUnidadChange: (UnidadVolumen) -> Unit
    ) {
        var entradaVolumen by remember { mutableStateOf(if(value == "0.0") "" else value) }

        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            TextField(
                value = entradaVolumen,
                onValueChange = { nuevoTexto ->
                    if (nuevoTexto.isEmpty() || nuevoTexto.matches(Regex("""^-?\d*\.?\d*$"""))){
                        entradaVolumen = nuevoTexto

                        val numero = nuevoTexto.toDoubleOrNull()
                        if (numero != null){
                            onValueChange(numero.toString())
                        } else if (nuevoTexto.isEmpty() || nuevoTexto == "-"){
                            onValueChange((0.0).toString())
                        }
                    }
                },
                placeholder = { Text(text = stringResource(R.string.placeholder_volumen)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
            )
            menuVolumen(onUnidadChange)
        }
    }

    @Composable
    private fun menuVolumen(onUnidadChange: (UnidadVolumen) -> Unit) {
        var expanded by remember { mutableStateOf(false) }
        Box {
            IconButton(onClick = { expanded = !expanded }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = stringResource(R.string.menu_volumen)
                )
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text(text = stringResource(R.string.volumen_centimetro)) },
                    onClick = {
                        onUnidadChange(UnidadVolumen.CENTIMETRO)
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text(text = stringResource(R.string.volumen_metro)) },
                    onClick = {
                        onUnidadChange(UnidadVolumen.METRO)
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text(text = stringResource(R.string.volumen_pie)) },
                    onClick = {
                        onUnidadChange(UnidadVolumen.PIE)
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text(text = stringResource(R.string.volumen_pulgada)) },
                    onClick = {
                        onUnidadChange(UnidadVolumen.PULGADA)
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text(text = stringResource(R.string.volumen_litro)) },
                    onClick = {
                        onUnidadChange(UnidadVolumen.LITRO)
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text(text = stringResource(R.string.volumen_galon)) },
                    onClick = {
                        onUnidadChange(UnidadVolumen.GALON)
                        expanded = false
                    }
                )
            }
        }
    }

    @Composable
    fun TituloVolumen() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.titulo_volumen),
                modifier = Modifier.padding(all = 15.dp),
                textAlign = TextAlign.Center
            )
        }
    }