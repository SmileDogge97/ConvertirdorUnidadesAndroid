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
import com.aristidevs.convertirdorunidadesandroid.domain.model.UnidadMasa
import com.aristidevs.convertirdorunidadesandroid.presentation.state.MasaIUEstado
import com.aristidevs.convertirdorunidadesandroid.presentation.vm.MasaViewModel


@Composable
    @Preview(showBackground = true)
    fun masaUI() {
        PesoCompose()
    }

@Composable
fun PesoCompose(viewModel: MasaViewModel = viewModel()){
    val iuState by viewModel.iuEstado.collectAsStateWithLifecycle()
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(7.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TituloPeso()
        PesoInput(
            value = iuState.valorConvertible.toString(),
            onValueChange = { viewModel.CambioValor(it) },
            onUnidadChange = { viewModel.CambioUnidad(it)}
        )
        Spacer(modifier = Modifier.padding(8.dp))
        PesoOutput(iuState)
    }
}

    @Composable
    fun PesoOutput(state: MasaIUEstado) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 7.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            PesoResultadoRow(
                label = stringResource(R.string.peso_gramo),
                valor = state.salidaGramo.toString()
            )
            PesoResultadoRow(
                label = stringResource(R.string.peso_kilogramo),
                valor = state.salidaKilogramo.toString()
            )
            PesoResultadoRow(
                label = stringResource(R.string.peso_libra),
                valor = state.salidaLibra.toString()
            )
            PesoResultadoRow(
                label = stringResource(R.string.peso_tonelada),
                valor = state.salidaTonelada.toString()
            )
        }
    }

    @Composable
    fun PesoResultadoRow(label: String, valor: String) {
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
    fun PesoInput(
        value: String,
        onValueChange: (String) -> Unit,
        onUnidadChange: (UnidadMasa) -> Unit
    ){
        var entradaPeso by remember { mutableStateOf(if(value == "0.0") "" else value) }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            TextField(
                value = entradaPeso,
                onValueChange = { nuevoTexto ->
                    if (nuevoTexto.isEmpty() || nuevoTexto.matches(Regex("""^-?\d*\.?\d*$"""))) {
                        entradaPeso = nuevoTexto
                        val numero = nuevoTexto.toDoubleOrNull()
                        if (numero != null) {
                            onValueChange(numero.toString())
                        } else if (nuevoTexto.isEmpty() || nuevoTexto == "-"){
                            onValueChange((0.0).toString())
                        }
                    }
                },
                placeholder = { Text(text = stringResource(R.string.placeholder_peso)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
            )
            menuPeso(onUnidadChange)
        }
    }

    @Composable
    fun menuPeso(onUnidadChange: (UnidadMasa) -> Unit) {
        var expanded by remember { mutableStateOf(false) }
        Box {
            IconButton(onClick = {expanded = !expanded }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = stringResource(R.string.menu_peso)
                )
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.peso_gramo)) },
                    onClick = {
                        onUnidadChange(UnidadMasa.GRAMO)
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.peso_kilogramo)) },
                    onClick = {
                        onUnidadChange(UnidadMasa.KILOGRAMO)
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.peso_libra)) },
                    onClick = {
                        onUnidadChange(UnidadMasa.LIBRA)
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.peso_tonelada)) },
                    onClick = {
                        onUnidadChange(UnidadMasa.TONELADA)
                        expanded = false
                    }
                )
            }
        }
    }

    @Composable
    fun TituloPeso() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text = stringResource(R.string.titulo_peso),
                modifier = Modifier.padding(all = 15.dp),
                textAlign = TextAlign.Center
            )
        }
    }