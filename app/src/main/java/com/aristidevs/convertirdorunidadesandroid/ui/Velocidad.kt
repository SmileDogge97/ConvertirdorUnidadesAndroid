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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.contentValuesOf
import com.aristidevs.convertirdorunidadesandroid.R

class Velocidad {

    @Composable
    @Preview(showBackground = true)
    fun velocidadUI() {
        Column(
            modifier = Modifier.padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TituloVelocidad()
            VelocidadInput()
            VelocidadOutput()
        }
    }

    @Composable
    fun VelocidadOutput(){
        RenglonMetros()
        RenglonKilometros()
        RenglonPies()
        RenglonMillas()
        RenglonNudos()
    }

    @Composable
    fun RenglonNudos(){
        var text by remember { mutableStateOf("") }
        Row(
            modifier = Modifier.padding(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.velocidad_nudo),
                modifier = Modifier.Companion.weight(2F)
            )
            TextField(
                value = stringResource(R.string.placeholder_cantidad),
                readOnly = true,
                onValueChange = { text = it},
                modifier = Modifier.Companion.weight(7F)
            )
        }
    }

    @Composable
    fun RenglonMillas(){
        var text by remember { mutableStateOf("") }
        Row(
            modifier = Modifier.padding(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.velocidad_mi_h),
                modifier = Modifier.Companion.weight(2F)
            )
            TextField(
                value = stringResource(R.string.placeholder_cantidad),
                readOnly = true,
                onValueChange = { text = it},
                modifier = Modifier.Companion.weight(7F)
            )
        }
    }

    @Composable
    fun RenglonPies(){
        var text by remember { mutableStateOf("") }
        Row(
            modifier = Modifier.padding(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.velocidad_ft_s),
                modifier = Modifier.Companion.weight(2F)
            )
            TextField(
                value = stringResource(R.string.placeholder_cantidad),
                readOnly = true,
                onValueChange = { text = it},
                modifier = Modifier.Companion.weight(7F)
            )
        }
    }

    @Composable
    fun RenglonKilometros(){
        var text by remember { mutableStateOf("") }
        Row(
            modifier = Modifier.padding(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.velocidad_km_h),
                modifier = Modifier.Companion.weight(2F)
            )
            TextField(
                value = stringResource(R.string.placeholder_cantidad),
                readOnly = true,
                onValueChange = { text = it},
                modifier = Modifier.Companion.weight(7F)
            )
        }
    }

    @Composable
    fun RenglonMetros(){
        var text by remember { mutableStateOf("") }
        Row(
            modifier = Modifier.padding(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.velocidad_m_s),
                modifier = Modifier.Companion.weight(2F)
            )
            TextField(
                value = stringResource(R.string.placeholder_cantidad),
                readOnly = true,
                onValueChange = { text = it},
                modifier = Modifier.Companion.weight(7F)
            )
        }
    }

    @Composable
    fun VelocidadInput() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            var text by remember { mutableStateOf("") }
            TextField(
                value = text,
                onValueChange = { text = it },
                placeholder = { Text(text = stringResource(R.string.placeholder_velocidad)) }
            )
            menuVelocidad()
        }
    }

    @Composable
    fun menuVelocidad() {
        var expanded by remember { mutableStateOf(false) }
        Box() {
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
                    onClick = { }
                )
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.velocidad_km_h)) },
                    onClick = { }
                )
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.velocidad_ft_s)) },
                    onClick = { }
                )
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.velocidad_mi_h)) },
                    onClick = { }
                )
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.velocidad_nudo)) },
                    onClick = { }
                )
            }
        }
    }

    @Composable
    fun TituloVelocidad() {
        Row(
            modifier = Modifier.Companion.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.titulo_velocidad),
                modifier = Modifier.Companion.padding(all = 15.dp),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
        }
    }
}