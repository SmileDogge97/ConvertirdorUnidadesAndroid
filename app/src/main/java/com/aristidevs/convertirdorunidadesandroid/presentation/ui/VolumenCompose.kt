package com.aristidevs.convertirdorunidadesandroid.UI

import android.graphics.Paint
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
    Column(modifier = Modifier.padding(7.dp),
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
        Row(
            modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)
        ) {
            Column(modifier = Modifier.padding(end = 7.dp).fillMaxHeight()) {
                val labelModifier = Modifier.weight(1f).wrapContentHeight(Alignment.CenterVertically).padding(top = 3.5.dp, bottom = 3.5.dp)
                Text(
                    text = stringResource(R.string.volumen_centimetro),
                    modifier = labelModifier
                )
                Text(
                    text = stringResource(R.string.volumen_metro),
                    modifier = labelModifier
                )
                Text(
                    text = stringResource(R.string.volumen_pie),
                    modifier = labelModifier
                )
                Text(
                    text = stringResource(R.string.volumen_pulgada),
                    modifier = labelModifier
                )
                Text(
                    text = stringResource(R.string.volumen_litro),
                    modifier = labelModifier
                )
                Text(
                    text = stringResource(R.string.volumen_galon),
                    modifier = labelModifier
                )
            }
            Column(modifier = Modifier.wrapContentHeight().fillMaxWidth()) {
                val fieldModifier = Modifier.fillMaxWidth().padding(top = 3.5.dp, bottom = 3.5.dp)
                TextField(
                    value = state.salidaCentimetro.toString(),
                    readOnly = true,
                    onValueChange = { },
                    modifier = fieldModifier
                )
                TextField(
                    value = state.salidaMetro.toString(),
                    readOnly = true,
                    onValueChange = { },
                    modifier = fieldModifier
                )
                TextField(
                    value = state.salidaPie.toString(),
                    readOnly = true,
                    onValueChange = { },
                    modifier = fieldModifier
                )
                TextField(
                    value = state.salidaPulgada.toString(),
                    readOnly = true,
                    onValueChange = { },
                    modifier = fieldModifier
                )
                TextField(
                    value = state.salidaLitro.toString(),
                    readOnly = true,
                    onValueChange = { },
                    modifier = fieldModifier
                )
                TextField(
                    value = state.salidaGalon.toString(),
                    readOnly = true,
                    onValueChange = { },
                    modifier = fieldModifier
                )
            }
        }
    }


    @Composable
    fun VolumenInput(
        value: String,
        onValueChange: (String) -> Unit,
        onUnidadChange: (UnidadVolumen) -> Unit
    ) {
        var entradaVolumen by remember { mutableStateOf(if(value.equals(0.0)) "" else value.toString()) }

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
        Box() {
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