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

class VolumenCompose {

    @Composable
    @Preview(
        showBackground = true
    )
    fun VolumenUI() {
        Column(modifier = Modifier.padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            TituloVolumen()
            VolumenInput()
            VolumenOutput()
        }
    }

    @Composable
    fun VolumenOutput() {
        RenglonCentimetro()
        RenglonMetro()
        RenglonPie()
        RenglonPulgada()
        RenglonLitro()
        RenglonGalon()
    }

    @Composable
    fun RenglonGalon() {
        var text by remember { mutableStateOf("") }
        Row(
            modifier = Modifier.Companion.padding(15.dp),
            verticalAlignment = Alignment.Companion.CenterVertically
        ) {

            Text(
                text = stringResource(R.string.volumen_galon),
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
    fun RenglonLitro() {
        var text by remember { mutableStateOf("") }
        Row(
            modifier = Modifier.Companion.padding(15.dp),
            verticalAlignment = Alignment.Companion.CenterVertically
        ) {

            Text(
                text = stringResource(R.string.volumen_galon),
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
    fun RenglonPulgada() {
        var text by remember { mutableStateOf("") }
        Row(
            modifier = Modifier.Companion.padding(15.dp),
            verticalAlignment = Alignment.Companion.CenterVertically
        ) {

            Text(
                text = stringResource(R.string.volumen_pulgada),
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
    fun RenglonPie() {
        var text by remember { mutableStateOf("") }
        Row(
            modifier = Modifier.Companion.padding(15.dp),
            verticalAlignment = Alignment.Companion.CenterVertically
        ) {

            Text(
                text = stringResource(R.string.volumen_pie),
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
    fun RenglonMetro() {
        var text by remember { mutableStateOf("") }
        Row(
            modifier = Modifier.Companion.padding(15.dp),
            verticalAlignment = Alignment.Companion.CenterVertically
        ) {

            Text(
                text = stringResource(R.string.volumen_metro),
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
    fun RenglonCentimetro() {
        var text by remember { mutableStateOf("") }
        Row(
            modifier = Modifier.Companion.padding(15.dp),
            verticalAlignment = Alignment.Companion.CenterVertically
        ) {

            Text(
                text = stringResource(R.string.volumen_centimetro),
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
    fun VolumenInput() {
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
            menuVolumen()
        }
    }

    @Composable
    private fun menuVolumen() {
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
                    onClick = { }
                )
                DropdownMenuItem(
                    text = { Text(text = stringResource(R.string.volumen_metro)) },
                    onClick = { }
                )
                DropdownMenuItem(
                    text = { Text(text = stringResource(R.string.volumen_pie)) },
                    onClick = { }
                )
                DropdownMenuItem(
                    text = { Text(text = stringResource(R.string.volumen_pulgada)) },
                    onClick = { }
                )
                DropdownMenuItem(
                    text = { Text(text = stringResource(R.string.volumen_litro)) },
                    onClick = { }
                )
                DropdownMenuItem(
                    text = { Text(text = stringResource(R.string.volumen_galon)) },
                    onClick = { }
                )
            }
        }
    }

    @Composable
    fun TituloVolumen() {
        Row(
            modifier = Modifier.Companion.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.titulo_volumen),
                modifier = Modifier.Companion.padding(all = 15.dp),
                textAlign = TextAlign.Companion.Center
            )
        }
    }
}