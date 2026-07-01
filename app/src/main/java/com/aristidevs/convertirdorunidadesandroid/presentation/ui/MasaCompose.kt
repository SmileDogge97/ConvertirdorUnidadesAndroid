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
    Column(
        modifier = Modifier.padding(7.dp),
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
        Row(
            modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)
        ) {
            Column(
                modifier = Modifier.padding(end= 7.dp).fillMaxHeight()
            ) {
                val labelModifier = Modifier.weight(1f).wrapContentHeight(Alignment.CenterVertically).padding(top= 3.5.dp, bottom = 3.5.dp)
                Text(
                    text = stringResource(R.string.peso_gramo),
                    modifier = labelModifier
                )
                Text(
                    text = stringResource(R.string.peso_kilogramo),
                    modifier = labelModifier
                )
                Text(
                    text = stringResource(R.string.peso_libra),
                    modifier = labelModifier
                )
                Text(
                    text = stringResource(R.string.peso_tonelada),
                    modifier = labelModifier
                )
            }
            Column(
                modifier = Modifier.wrapContentHeight().fillMaxWidth()
            ) {
                val fieldModifier = Modifier.fillMaxWidth().padding(top= 3.5.dp, bottom = 3.5.dp)
                TextField(
                    value = state.salidaGramo.toString(),
                    readOnly = true,
                    onValueChange = { },
                    modifier = fieldModifier
                )
                TextField(
                    value = state.salidaKilogramo.toString(),
                    readOnly = true,
                    onValueChange = { },
                    modifier = fieldModifier
                )
                TextField(
                    value = state.salidaLibra.toString(),
                    readOnly = true,
                    onValueChange = { },
                    modifier = fieldModifier
                )
                TextField(
                    value = state.salidaTonelada.toString(),
                    readOnly = true,
                    onValueChange = { },
                    modifier = fieldModifier
                )
            }
        }
    }


    @Composable
    fun PesoInput(
        value: String,
        onValueChange: (String) -> Unit,
        onUnidadChange: (UnidadMasa) -> Unit
    ){
        var entradaPeso by remember { mutableStateOf(if(value.equals(0.0)) "" else value.toString()) }
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
        Box() {
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