package com.aristidevs.convertirdorunidadesandroid.UI

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aristidevs.convertirdorunidadesandroid.R

class TemperaturaCompose {

    @Composable
    @Preview(
        showBackground = true
    )
    fun temperaturaUI() {
        Column(modifier = Modifier.padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            tituloTemperatura()
            temperaturaInput()
            temperaturasOutput()
        }

    }

    @Composable
    fun tituloTemperatura() {
        Row(
            modifier = Modifier.Companion.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.titulo_temperatura),
                modifier = Modifier.Companion.padding(all = 15.dp),
                textAlign = TextAlign.Companion.Center
            )
        }
    }

    @Composable
    fun temperaturaInput() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Companion.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            var text by remember { mutableStateOf("") }
            TextField(
                value = text,
                onValueChange = { text = it },
                placeholder = { Text(text = stringResource(R.string.placeholder_temperatura)) }
            )
            menuTemperatura()
        }
    }

    @Composable
    fun temperaturasOutput() {
        renglonCelsius()
        renglonFahrenheit()
        renglonKelvin()
        renglonRankine()
    }

    @Composable
    private fun renglonCelsius() {
        var text by remember { mutableStateOf("") }
        Row(
            modifier = Modifier.Companion.padding(15.dp),
            verticalAlignment = Alignment.Companion.CenterVertically
        ) {

            Text(
                text = stringResource(R.string.temperatura_celsius),
                modifier = Modifier.Companion.weight(2F)
            )
            TextField(
                value = stringResource(R.string.placeholder_textfield_temperature),
                readOnly = true,
                onValueChange = { text = it },
                modifier = Modifier.Companion.weight(8F)
            )
        }
    }

    @Composable
    private fun renglonFahrenheit() {
        var text by remember { mutableStateOf("") }
        Row(
            modifier = Modifier.Companion.padding(15.dp),
            verticalAlignment = Alignment.Companion.CenterVertically
        ) {

            Text(
                text = stringResource(R.string.temperatura_farenheit),
                modifier = Modifier.Companion.weight(2F)
            )
            TextField(
                value = stringResource(R.string.placeholder_textfield_temperature),
                readOnly = true,
                onValueChange = { text = it },
                modifier = Modifier.Companion.weight(8F)
            )
        }
    }

    @Composable
    private fun renglonKelvin() {
        var text by remember { mutableStateOf("") }
        Row(
            modifier = Modifier.Companion.padding(15.dp),
            verticalAlignment = Alignment.Companion.CenterVertically
        ) {

            Text(
                text = stringResource(R.string.temperatura_kelvin),
                modifier = Modifier.Companion.weight(2F)
            )
            TextField(
                value = stringResource(R.string.placeholder_textfield_temperature),
                onValueChange = { text = it },
                readOnly = true,
                modifier = Modifier.Companion.weight(8F)
            )
        }
    }

    @Composable
    private fun renglonRankine() {
        var text by remember { mutableStateOf("") }
        Row(
            modifier = Modifier.Companion.padding(15.dp),
            verticalAlignment = Alignment.Companion.CenterVertically
        ) {

            Text(
                text = stringResource(R.string.temperatura_rankine),
                modifier = Modifier.Companion.weight(2F)
            )
            TextField(
                value = stringResource(R.string.placeholder_textfield_temperature),
                onValueChange = { text = it },
                readOnly = true,
                modifier = Modifier.Companion.weight(8F)
            )
        }
    }

    @Composable
    private fun menuTemperatura(){
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
                    onClick = { }
                )
                DropdownMenuItem(
                    text = { Text(text = stringResource(R.string.temperatura_farenheit)) },
                    onClick = { }
                )
                DropdownMenuItem(
                    text = { Text(text = stringResource(R.string.temperatura_kelvin)) },
                    onClick = { }
                )
                DropdownMenuItem(
                    text = { Text(text = stringResource(R.string.temperatura_rankine)) },
                    onClick = { }
                )
            }
        }
    }

}