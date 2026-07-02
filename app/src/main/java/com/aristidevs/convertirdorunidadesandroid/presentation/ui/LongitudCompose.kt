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
import com.aristidevs.convertirdorunidadesandroid.domain.model.UnidadLongitud
import com.aristidevs.convertirdorunidadesandroid.presentation.state.LongitudIUEstado
import com.aristidevs.convertirdorunidadesandroid.presentation.vm.LongitudViewModel


@Composable
    @Preview(showBackground = true)
    fun longitudUI() {
        LongitudCompose()
    }

    @Composable
    fun LongitudCompose(viewModel : LongitudViewModel = viewModel()) {
        val iuState by viewModel.iuEstado.collectAsStateWithLifecycle()
        Column(
            modifier = Modifier.padding(7.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            TituloLongitud()
            LongitudInput(
                value = iuState.valorConvertible.toString(),
                onValueChange = { viewModel.CambioValor(it) },
                onUnidadChange = { viewModel.CambioUnidad(it) }
            )
            Spacer(modifier = Modifier.padding(8.dp))
            LongitudOutput(iuState)
        }
    }

    @Composable
    fun LongitudOutput(state : LongitudIUEstado) {
        Row(
            modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)
        ) {
            Column(
                modifier = Modifier.padding(end= 7.dp).fillMaxHeight()
            ) {
                val labelModifier = Modifier.weight(1f).wrapContentHeight(Alignment.CenterVertically).padding(top= 3.5.dp, bottom = 3.5.dp)
                Text(
                    text = stringResource(R.string.longitud_metro),
                    modifier = labelModifier
                )
                Text(
                    text = stringResource(R.string.longitud_kilometro),
                    modifier = labelModifier
                )
                Text(
                    text = stringResource(R.string.longitud_centimetro),
                    modifier = labelModifier
                )
                Text(
                    text = stringResource(R.string.longitud_pulgada),
                    modifier = labelModifier
                )
                Text(
                    text = stringResource(R.string.longitud_pie),
                    modifier = labelModifier
                )
                Text(
                    text = stringResource(R.string.longitud_yarda),
                    modifier = labelModifier
                )
                Text(
                    text = stringResource(R.string.longitud_milla),
                    modifier = labelModifier
                )
                Text(
                    text = stringResource(R.string.longitud_milla_nautica),
                    maxLines = 2,
                    modifier = labelModifier
                )
                Text(
                    text = stringResource(R.string.longitud_anos_luz),
                    modifier = labelModifier
                )
            }
            Column(
                modifier = Modifier.wrapContentHeight().fillMaxWidth()
            ) {
                val fieldModifier = Modifier.fillMaxWidth().padding(top = 3.5.dp, bottom = 3.5.dp)
                TextField(
                    value = state.salidaMetro.toString(),
                    readOnly = true,
                    onValueChange = { },
                    modifier = fieldModifier
                )
                TextField(
                    value = state.salidaKilometro.toString(),
                    readOnly = true,
                    onValueChange = { },
                    modifier = fieldModifier
                )
                TextField(
                    value = state.salidaCentimetro.toString(),
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
                    value = state.salidaPies.toString(),
                    readOnly = true,
                    onValueChange = { },
                    modifier = fieldModifier
                )
                TextField(
                    value = state.salidaYardas.toString(),
                    readOnly = true,
                    onValueChange = { },
                    modifier = fieldModifier
                )
                TextField(
                    value = state.salidaMillas.toString(),
                    readOnly = true,
                    onValueChange = { },
                    modifier = fieldModifier
                )
                TextField(
                    value = state.salidaMillasNauticas.toString(),
                    readOnly = true,
                    onValueChange = { },
                    modifier = fieldModifier
                )
                TextField(
                    value = state.salidaAñosLuz.toString(),
                    readOnly = true,
                    onValueChange = { },
                    modifier = fieldModifier
                )
            }
        }
    }


    @Composable
    fun LongitudInput(
        value: String,
        onValueChange: (String) -> Unit,
        onUnidadChange: (UnidadLongitud) -> Unit
    ){
        var entradaLongitud by remember { mutableStateOf(if(value.equals(0.0)) "" else value.toString()) }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            TextField(
                value = entradaLongitud,
                onValueChange = { nuevoTexto ->
                    if (nuevoTexto.isEmpty() || nuevoTexto.matches(Regex("""^-?\d*\.?\d*$"""))) {
                        entradaLongitud = nuevoTexto
                        val numero = nuevoTexto.toDoubleOrNull()
                        if (numero != null) {
                            onValueChange(numero.toString())
                        } else if (nuevoTexto.isEmpty() || nuevoTexto == "-"){
                            onValueChange((0.0).toString())
                        }
                    }
                },
                placeholder = { Text(text = stringResource(R.string.placeholder_longitud)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
            )
            menuLongitud(onUnidadChange)
        }
    }

    @Composable
    fun menuLongitud(onUnidadChange: (UnidadLongitud) -> Unit) {
        var expanded by remember { mutableStateOf(false) }
        Box() {
            IconButton(onClick = {expanded = !expanded }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = stringResource(R.string.menu_longitud)
                )
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.longitud_metro)) },
                    onClick = {
                        onUnidadChange(UnidadLongitud.METRO)
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.longitud_kilometro)) },
                    onClick = {
                        onUnidadChange(UnidadLongitud.KILOMETRO)
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.longitud_centimetro)) },
                    onClick = {
                        onUnidadChange(UnidadLongitud.CENTIMETRO)
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.longitud_pulgada)) },
                    onClick = {
                        onUnidadChange(UnidadLongitud.PULGADA)
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.longitud_pie)) },
                    onClick = {
                        onUnidadChange(UnidadLongitud.PIE)
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.longitud_yarda)) },
                    onClick = {
                        onUnidadChange(UnidadLongitud.YARDA)
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.longitud_milla)) },
                    onClick = {
                        onUnidadChange(UnidadLongitud.MILLA)
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.longitud_milla_nautica)) },
                    onClick = {
                        onUnidadChange(UnidadLongitud.MILLA_NAUTICA)
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.longitud_anos_luz)) },
                    onClick = {
                        onUnidadChange(UnidadLongitud.AÑO_LUZ)
                        expanded = false
                    }
                )
            }
        }
    }

    @Composable
    fun TituloLongitud() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text = stringResource(R.string.titulo_longitud),
                modifier = Modifier.padding(all = 15.dp),
                textAlign = TextAlign.Center
            )
        }
    }