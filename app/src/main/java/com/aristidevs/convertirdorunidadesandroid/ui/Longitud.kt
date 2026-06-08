package com.aristidevs.convertirdorunidadesandroid.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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

class Longitud {

    @Composable
    @Preview(showBackground = true)
    fun longitudUI() {
        Column(
            modifier = Modifier.padding(7.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TituloLongitud()
            LongitudInput()
            Spacer(modifier = Modifier.padding(8.dp))
            LongitudOutput()
        }
    }

    @Composable
    fun LongitudOutput() {
        RenglonMetro()
        RenglonKilometro()
        RenglonCentimetro()
        RenglonPulgada()
        RenglonPie()
        RenglonYarda()
        RenglonMilla()
        RenglonMillaNautica()
        RenglonAnosLuz()
    }

    @Composable
    fun RenglonAnosLuz(){
        var text by remember { mutableStateOf("") }
        Row(
            modifier = Modifier.padding(7.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.longitud_anos_luz),
                modifier = Modifier.weight(2F)
            )
            TextField(
                value = stringResource(R.string.placeholder_cantidad),
                readOnly = true,
                onValueChange = { text = it },
                modifier = Modifier.weight(7F)
            )
        }
    }

    @Composable
    fun RenglonMillaNautica(){
        var text by remember { mutableStateOf("") }
        Row(
            modifier = Modifier.padding(7.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.longitud_milla_nautica),
                maxLines = 2,
                modifier = Modifier.weight(2F).padding(2.dp)
            )
            TextField(
                value = stringResource(R.string.placeholder_cantidad),
                readOnly = true,
                onValueChange = { text = it },
                modifier = Modifier.weight(7F)
            )
        }
    }

    @Composable
    fun RenglonMilla(){
        var text by remember { mutableStateOf("") }
        Row(
            modifier = Modifier.padding(7.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.longitud_milla),
                modifier = Modifier.weight(2F)
            )
            TextField(
                value = stringResource(R.string.placeholder_cantidad),
                readOnly = true,
                onValueChange = { text = it },
                modifier = Modifier.weight(7F)
            )
        }
    }

    @Composable
    fun RenglonYarda(){
        var text by remember { mutableStateOf("") }
        Row(
            modifier = Modifier.padding(7.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.longitud_yarda),
                modifier = Modifier.weight(2F)
            )
            TextField(
                value = stringResource(R.string.placeholder_cantidad),
                readOnly = true,
                onValueChange = { text = it },
                modifier = Modifier.weight(7F)
            )
        }
    }

    @Composable
    fun RenglonPie(){
        var text by remember { mutableStateOf("") }
        Row(
            modifier = Modifier.padding(7.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.longitud_pie),
                modifier = Modifier.weight(2F)
            )
            TextField(
                value = stringResource(R.string.placeholder_cantidad),
                readOnly = true,
                onValueChange = { text = it },
                modifier = Modifier.weight(7F)
            )
        }
    }

    @Composable
    fun RenglonPulgada(){
        var text by remember { mutableStateOf("") }
        Row(
            modifier = Modifier.padding(7.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.longitud_pulgada),
                modifier = Modifier.weight(2F)
            )
            TextField(
                value = stringResource(R.string.placeholder_cantidad),
                readOnly = true,
                onValueChange = { text = it },
                modifier = Modifier.weight(7F)
            )
        }
    }

    @Composable
    fun RenglonCentimetro(){
        var text by remember { mutableStateOf("") }
        Row(
            modifier = Modifier.padding(7.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.longitud_centimetro),
                modifier = Modifier.weight(2F)
            )
            TextField(
                value = stringResource(R.string.placeholder_cantidad),
                readOnly = true,
                onValueChange = { text = it },
                modifier = Modifier.weight(7F)
            )
        }
    }

    @Composable
    fun RenglonKilometro(){
        var text by remember { mutableStateOf("") }
        Row(
            modifier = Modifier.padding(7.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.longitud_kilometro),
                modifier = Modifier.weight(2F)
            )
            TextField(
                value = stringResource(R.string.placeholder_cantidad),
                readOnly = true,
                onValueChange = { text = it },
                modifier = Modifier.weight(7F)
            )
        }
    }

    @Composable
    fun RenglonMetro(){
        var text by remember { mutableStateOf("") }
        Row(
            modifier = Modifier.padding(7.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.longitud_metro),
                modifier = Modifier.weight(2F)
            )
            TextField(
                value = stringResource(R.string.placeholder_cantidad),
                readOnly = true,
                onValueChange = { text = it },
                modifier = Modifier.weight(7F)
            )
        }
    }

    @Composable
    fun LongitudInput(){
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            var text by remember { mutableStateOf("") }
            TextField(
                value = text,
                onValueChange = { text = it },
                placeholder = { Text(text = stringResource(R.string.placeholder_longitud)) }
            )
            menuLongitud()
        }
    }

    @Composable
    fun menuLongitud() {
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
                    onClick = { }
                )
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.longitud_kilometro)) },
                    onClick = { }
                )
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.longitud_centimetro)) },
                    onClick = {  }
                )
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.longitud_pulgada)) },
                    onClick = {  }
                )
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.longitud_pie)) },
                    onClick = {  }
                )
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.longitud_yarda)) },
                    onClick = {  }
                )
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.longitud_milla)) },
                    onClick = {  }
                )
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.longitud_milla_nautica)) },
                    onClick = {  }
                )
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.longitud_anos_luz)) },
                    onClick = {  }
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
}