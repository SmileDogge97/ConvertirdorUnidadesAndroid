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
import com.aristidevs.convertirdorunidadesandroid.domain.model.UnidadVelocidad
import com.aristidevs.convertirdorunidadesandroid.presentation.state.VelocidadIUEstado
import com.aristidevs.convertirdorunidadesandroid.presentation.vm.VelocidadViewModel

@Composable
    @Preview(showBackground = true)
    fun velocidadUI() {
        VelocidadCompose()
    }

    @Composable
    fun VelocidadCompose(viewModel: VelocidadViewModel = viewModel()){
        val iuState by viewModel.iuEstado.collectAsStateWithLifecycle()
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(7.dp)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TituloVelocidad()
            VelocidadInput(
                value = iuState.valorConvertible.toString(),
                onValueChange = { viewModel.CambioValor(it) },
                onUnidadChange = { viewModel.CambioUnidad(it) }
            )
            Spacer(modifier = Modifier.padding(8.dp))
            VelocidadOutput(iuState)
        }
    }
    @Composable
    fun VelocidadOutput(iuState: VelocidadIUEstado) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 7.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            VelocidadResultadoRow(
                label = stringResource(R.string.velocidad_m_s),
                valor = iuState.salidaMs.toString()
            )
            VelocidadResultadoRow(
                label = stringResource(R.string.velocidad_km_h),
                valor = iuState.salidaKmH.toString()
            )
            VelocidadResultadoRow(
                label = stringResource(R.string.velocidad_ft_s),
                valor = iuState.salidaFtS.toString()
            )
            VelocidadResultadoRow(
                label = stringResource(R.string.velocidad_mi_h),
                valor = iuState.salidaMiH.toString()
            )
            VelocidadResultadoRow(
                label = stringResource(R.string.velocidad_nudo),
                valor = iuState.salidaNudo.toString()
            )
        }
    }

    @Composable
    fun VelocidadResultadoRow(label: String, valor: String) {
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
    fun VelocidadInput(
        value: String,
        onValueChange: (String) -> Unit,
        onUnidadChange: (UnidadVelocidad) -> Unit
    ) {
        var entradaVelocidad by remember { mutableStateOf(if (value == "0.0") "" else value) }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            TextField(
                value = entradaVelocidad,
                onValueChange = { nuevoTexto ->
                    if (nuevoTexto.isEmpty() || nuevoTexto.matches(Regex("""^-?\d*\.?\d*$"""))) {
                        entradaVelocidad = nuevoTexto
                        val numero = nuevoTexto.toDoubleOrNull()
                        if (numero != null) {
                            onValueChange(numero.toString())
                        } else if (nuevoTexto.isEmpty() || nuevoTexto == "-") {
                            onValueChange((0.0).toString())
                        }
                    }
                },
                placeholder = { Text(text = stringResource(R.string.placeholder_velocidad)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
            )
            menuVelocidad(onUnidadChange)
        }
    }

    @Composable
    fun menuVelocidad(onUnidadChange: (UnidadVelocidad) -> Unit) {
        var expanded by remember { mutableStateOf(false) }
        Box {
            IconButton(onClick = { expanded = !expanded }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = stringResource(R.string.menu_velocidad)
                )
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.velocidad_m_s)) },
                    onClick = {
                        onUnidadChange(UnidadVelocidad.MS)
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.velocidad_km_h)) },
                    onClick = {
                        onUnidadChange(UnidadVelocidad.KMH)
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.velocidad_ft_s)) },
                    onClick = {
                        onUnidadChange(UnidadVelocidad.FTS)
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.velocidad_mi_h)) },
                    onClick = {
                        onUnidadChange(UnidadVelocidad.MIH)
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.velocidad_nudo)) },
                    onClick = {
                        onUnidadChange(UnidadVelocidad.NUDO)
                        expanded = false
                    }
                )
            }
        }
    }

    @Composable
    fun TituloVelocidad() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.titulo_velocidad),
                modifier = Modifier.padding(all = 15.dp),
                textAlign = TextAlign.Center
            )
        }
    }