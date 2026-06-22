package com.aristidevs.convertirdorunidadesandroid.UI

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import com.aristidevs.convertirdorunidadesandroid.domain.model.UnidadTemperatura
import com.aristidevs.convertirdorunidadesandroid.presentation.state.TemperaturaUiState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aristidevs.convertirdorunidadesandroid.R
import com.aristidevs.convertirdorunidadesandroid.presentation.vm.TemperaturaViewModel


    @Composable
    @Preview(
        showBackground = true
    )
    fun temperaturaUI() {
        TemperaturaCompose()
    }

    @Composable
    fun TemperaturaCompose(viewModel: TemperaturaViewModel = viewModel()){
        val iuState by viewModel.uiState.collectAsStateWithLifecycle()
        Column(modifier = Modifier.padding(7.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            tituloTemperatura()
            temperaturaInput(
                value = iuState.valorConvertible.toString(),
                onValueChange = { viewModel.onValorChange(it) },
                onUnidadChange = { viewModel.onUnidadChange(it) }
            )
            Spacer(modifier = Modifier.padding(8.dp))
            temperaturasOutput(iuState)
        }
    }

    @Composable
    fun tituloTemperatura() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.titulo_temperatura),
                modifier = Modifier.padding(all = 15.dp),
                textAlign = TextAlign.Center
            )
        }
    }

    @Composable
    fun temperaturaInput(
        value: String,
        onValueChange: (String) -> Unit,
        onUnidadChange: (UnidadTemperatura) -> Unit
    ) {

        // Estado local para manejar el texto y permitir borrar/puntos decimales
        var entradaTemperatura by remember { mutableStateOf(if(value.equals(0.0)) "" else value.toString()) }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            TextField(
                value = entradaTemperatura,
                onValueChange = { nuevoTexto ->
                    // FILTRO: Solo permite números, un solo punto decimal y un signo menos al inicio
                    if (nuevoTexto.isEmpty() || nuevoTexto.matches(Regex("""^-?\d*\.?\d*$"""))) {
                        entradaTemperatura = nuevoTexto

                        // Solo enviamos al ViewModel si es un número convertible
                        val numero = nuevoTexto.toDoubleOrNull()
                        if (numero != null) {
                            onValueChange(numero.toString())
                        } else if (nuevoTexto.isEmpty() || nuevoTexto == "-") {
                            onValueChange((0.0).toString()) // Valor por defecto si está vacío o solo tiene el menos
                        }
                    }
                },
                placeholder = { Text(text = stringResource(R.string.placeholder_temperatura)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
            )
            menuTemperatura(onUnidadChange)
        }
    }

    @Composable
    fun temperaturasOutput(state: TemperaturaUiState) {
        Row(
            modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)
        ) {
            Column(
                modifier = Modifier.padding(end= 7.dp).fillMaxHeight()
            ) {
                val labelModifier = Modifier.weight(1f).wrapContentHeight(Alignment.CenterVertically).padding(top= 3.5.dp, bottom = 3.5.dp)
                Text(
                    text = stringResource(R.string.temperatura_celsius),
                    modifier = labelModifier
                )
                Text(
                    text = stringResource(R.string.temperatura_farenheit),
                    modifier = labelModifier
                )
                Text(
                    text = stringResource(R.string.temperatura_kelvin),
                    modifier = labelModifier
                )
                Text(
                    text = stringResource(R.string.temperatura_rankine),
                    modifier = labelModifier
                )
            }
            Column(
                modifier = Modifier.wrapContentHeight().fillMaxWidth()
            ) {
                val fieldModifier = Modifier.fillMaxWidth().padding(top= 3.5.dp, bottom = 3.5.dp)
                TextField(
                    value = state.salidaCelsius.toString(),
                    readOnly = true,
                    onValueChange = { },
                    modifier = fieldModifier
                )
                TextField(
                    value = state.salidaFarenheit.toString(),
                    readOnly = true,
                    onValueChange = { },
                    modifier = fieldModifier
                )
                TextField(
                    value = state.salidaKelvin.toString(),
                    onValueChange = { },
                    readOnly = true,
                    modifier = fieldModifier
                )
                TextField(
                    value = state.salidaRankine.toString(),
                    onValueChange = { },
                    readOnly = true,
                    modifier = fieldModifier
                )
            }
        }

    }

    @Composable
    private fun menuTemperatura(onUnidadChange: (UnidadTemperatura) -> Unit){
        var expanded by remember { mutableStateOf(false) }
        Box() {
            IconButton(onClick = { expanded = !expanded }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = stringResource(R.string.menu_temperatura)
                )
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text(text = stringResource(R.string.temperatura_celsius)) },
                    onClick = { 
                        onUnidadChange(UnidadTemperatura.CELSIUS)
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text(text = stringResource(R.string.temperatura_farenheit)) },
                    onClick = { 
                        onUnidadChange(UnidadTemperatura.FAHRENHEIT)
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text(text = stringResource(R.string.temperatura_kelvin)) },
                    onClick = { 
                        onUnidadChange(UnidadTemperatura.KELVIN)
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text(text = stringResource(R.string.temperatura_rankine)) },
                    onClick = { 
                        onUnidadChange(UnidadTemperatura.RANKINE)
                        expanded = false
                    }
                )
            }
        }
    }
