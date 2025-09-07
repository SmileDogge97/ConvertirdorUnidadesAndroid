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

class AreaCompose {
    @Composable
    @Preview(
        showBackground = true
    )
    fun areaUI() {
        Column(modifier = Modifier.padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            TituloArea()
            AreaInput()
            AreaOutput()
        }
    }

    @Composable
    fun AreaOutput() {
        renglonMetro()
        renglonHectarea()
        renglonCentimetro()
        renglonPulgada()
        renglonPie()
        renglonYarda()
        renglonMilla()
    }

    @Composable
    private fun renglonMilla() {
        var text by remember { mutableStateOf("") }
        Row(
            modifier = Modifier.Companion.padding(15.dp),
            verticalAlignment = Alignment.Companion.CenterVertically
        ) {

            Text(
                text = stringResource(R.string.area_milla),
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
    private fun renglonYarda() {
        var text by remember { mutableStateOf("") }
        Row(
            modifier = Modifier.Companion.padding(15.dp),
            verticalAlignment = Alignment.Companion.CenterVertically
        ) {

            Text(
                text = stringResource(R.string.area_yarda),
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
    private fun renglonPie() {
        var text by remember { mutableStateOf("") }
        Row(
            modifier = Modifier.Companion.padding(15.dp),
            verticalAlignment = Alignment.Companion.CenterVertically
        ) {

            Text(
                text = stringResource(R.string.area_pie),
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
    private fun renglonPulgada() {
        var text by remember { mutableStateOf("") }
        Row(
            modifier = Modifier.Companion.padding(15.dp),
            verticalAlignment = Alignment.Companion.CenterVertically
        ) {

            Text(
                text = stringResource(R.string.area_pulgada),
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
    private fun renglonCentimetro() {
        var text by remember { mutableStateOf("") }
        Row(
            modifier = Modifier.Companion.padding(15.dp),
            verticalAlignment = Alignment.Companion.CenterVertically
        ) {

            Text(
                text = stringResource(R.string.area_centimetro),
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
    private fun renglonHectarea() {
        var text by remember { mutableStateOf("") }
        Row(
            modifier = Modifier.Companion.padding(15.dp),
            verticalAlignment = Alignment.Companion.CenterVertically
        ) {

            Text(
                text = stringResource(R.string.area_hectarea),
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
    private fun renglonMetro() {
        var text by remember { mutableStateOf("") }
        Row(
            modifier = Modifier.Companion.padding(15.dp),
            verticalAlignment = Alignment.Companion.CenterVertically
        ) {

            Text(
                text = stringResource(R.string.area_metro),
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
    fun AreaInput() {
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
            menuArea()
        }
    }
    @Composable
    private fun menuArea() {
        var expanded by remember { mutableStateOf(false) }
        Box() {
            IconButton(onClick = { expanded = !expanded }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = stringResource(R.string.menu_area)
                )
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text(text = stringResource(R.string.area_metro)) },
                    onClick = { }
                )
                DropdownMenuItem(
                    text = { Text(text = stringResource(R.string.area_hectarea)) },
                    onClick = { }
                )
                DropdownMenuItem(
                    text = { Text(text = stringResource(R.string.area_centimetro)) },
                    onClick = { }
                )
                DropdownMenuItem(
                    text = { Text(text = stringResource(R.string.area_pulgada)) },
                    onClick = { }
                )
                DropdownMenuItem(
                    text = { Text(text = stringResource(R.string.area_pie)) },
                    onClick = { }
                )
                DropdownMenuItem(
                    text = { Text(text = stringResource(R.string.area_yarda)) },
                    onClick = { }
                )
                DropdownMenuItem(
                    text = { Text(text = stringResource(R.string.area_milla)) },
                    onClick = { }
                )
            }
        }
    }

    @Composable
    fun TituloArea() {
        Row(
            modifier = Modifier.Companion.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.titulo_area),
                modifier = Modifier.Companion.padding(all = 15.dp),
                textAlign = TextAlign.Companion.Center
            )
        }
    }
}