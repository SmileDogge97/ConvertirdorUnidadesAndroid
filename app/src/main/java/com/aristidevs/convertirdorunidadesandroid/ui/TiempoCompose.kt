package com.aristidevs.convertirdorunidadesandroid.ui

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

class TiempoCompose {

    @Composable
    @Preview(showBackground = true)
    fun tiempoUI() {
        Column(modifier = Modifier.padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            TituloTiempo()
            TiempoInput()
            TiempoOutput()
        }
    }

    @Composable
    fun TiempoOutput() {
        RenglonSegundo()
        RenglonMinuto()
        RenglonHora()
        RenglonDia()
        RenglonAño()
    }

    @Composable
    fun RenglonAño() {
        var text by remember { mutableStateOf("") }
        Row(
            modifier = Modifier.Companion.padding(15.dp),
            verticalAlignment = Alignment.Companion.CenterVertically
        ) {

            Text(
                text = stringResource(R.string.tiempo_año),
                modifier = Modifier.Companion.weight(2F)
            )
            TextField(
                value = stringResource(R.string.placeholder_cantidad),
                readOnly = true,
                onValueChange = { text = it },
                modifier = Modifier.Companion.weight(7F)
            )
        }
    }

    @Composable
    fun RenglonDia() {
        var text by remember { mutableStateOf("") }
        Row(
            modifier = Modifier.Companion.padding(15.dp),
            verticalAlignment = Alignment.Companion.CenterVertically
        ) {

            Text(
                text = stringResource(R.string.tiempo_dia),
                modifier = Modifier.Companion.weight(2F)
            )
            TextField(
                value = stringResource(R.string.placeholder_cantidad),
                readOnly = true,
                onValueChange = { text = it },
                modifier = Modifier.Companion.weight(7F)
            )
        }
    }

    @Composable
    fun RenglonHora() {
        var text by remember { mutableStateOf("") }
        Row(
            modifier = Modifier.Companion.padding(15.dp),
            verticalAlignment = Alignment.Companion.CenterVertically
        ) {

            Text(
                text = stringResource(R.string.tiempo_hora),
                modifier = Modifier.Companion.weight(2F)
            )
            TextField(
                value = stringResource(R.string.placeholder_cantidad),
                readOnly = true,
                onValueChange = { text = it },
                modifier = Modifier.Companion.weight(7F)
            )
        }
    }

    @Composable
    fun RenglonMinuto() {
        var text by remember { mutableStateOf("") }
        Row(
            modifier = Modifier.Companion.padding(15.dp),
            verticalAlignment = Alignment.Companion.CenterVertically
        ) {

            Text(
                text = stringResource(R.string.tiempo_minuto),
                modifier = Modifier.Companion.weight(2F)
            )
            TextField(
                value = stringResource(R.string.placeholder_cantidad),
                readOnly = true,
                onValueChange = { text = it },
                modifier = Modifier.Companion.weight(7F)
            )
        }
    }

    @Composable
    fun RenglonSegundo() {
        var text by remember { mutableStateOf("") }
        Row(
            modifier = Modifier.Companion.padding(15.dp),
            verticalAlignment = Alignment.Companion.CenterVertically
        ) {

            Text(
                text = stringResource(R.string.tiempo_segundo),
                modifier = Modifier.Companion.weight(2F)
            )
            TextField(
                value = stringResource(R.string.placeholder_cantidad),
                readOnly = true,
                onValueChange = { text = it },
                modifier = Modifier.Companion.weight(7F)
            )
        }
    }

    @Composable
    fun TiempoInput() {
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            var text by remember { mutableStateOf("") }
            TextField(
                value = text,
                onValueChange = { text = it },
                placeholder = { Text(text = stringResource(R.string.placeholder_area)) }
            )
            menuTiempo()
        }
    }

    @Composable
    private fun menuTiempo() {
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
                    onClick = { }
                )
                DropdownMenuItem(
                    text = { Text(text = stringResource(R.string.tiempo_minuto)) },
                    onClick = { }
                )
                DropdownMenuItem(
                    text = { Text(text = stringResource(R.string.tiempo_hora)) },
                    onClick = { }
                )
                DropdownMenuItem(
                    text = { Text(text = stringResource(R.string.tiempo_dia)) },
                    onClick = { }
                )
                DropdownMenuItem(
                    text = { Text(text = stringResource(R.string.tiempo_año)) },
                    onClick = { }
                )
            }
        }
    }

    @Composable
    fun TituloTiempo() {
        @Composable
        fun TituloVolumen() {
            Row(
                modifier = Modifier.Companion.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.titulo_tiempo),
                    modifier = Modifier.Companion.padding(all = 15.dp),
                    textAlign = TextAlign.Companion.Center
                )
            }
        }
    }
}