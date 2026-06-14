package com.aristidevs.convertirdorunidadesandroid

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aristidevs.convertirdorunidadesandroid.UI.AreaCompose
import com.aristidevs.convertirdorunidadesandroid.UI.TemperaturaCompose
import com.aristidevs.convertirdorunidadesandroid.UI.VolumenCompose
import com.aristidevs.convertirdorunidadesandroid.ui.LongitudCompose
import com.aristidevs.convertirdorunidadesandroid.ui.PesoCompose
import com.aristidevs.convertirdorunidadesandroid.ui.TiempoCompose
import com.aristidevs.convertirdorunidadesandroid.ui.VelocidadCompose
import com.aristidevs.convertirdorunidadesandroid.ui.theme.ConvertirdorUnidadesAndroidTheme
import kotlinx.serialization.Serializable

// 1. Las rutas deben ser objetos globales y serializables para Type-Safe Navigation
@Serializable object Temperatura
@Serializable object Area
@Serializable object Volumen
@Serializable object Tiempo
@Serializable object Velocidad
@Serializable object Peso
@Serializable object Longitud

val monserratFamily = FontFamily(
    Font(R.font.montserrat, FontWeight.Normal),
    Font(R.font.montserrat_italic, FontWeight.Light)
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConvertirdorUnidadesAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // 2. Pasamos el modificador con el padding del Scaffold
                    Fondo(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Fondo(modifier: Modifier = Modifier) {
    // 3. El navController se recuerda dentro de la composición, no en la Activity
    val navController = rememberNavController()
    
    Column(modifier = modifier.padding(16.dp)) {
        Encabezado(navController)
        
        // 4. NavHost correcto de androidx.navigation.compose
        NavHost(navController = navController, startDestination = Temperatura) {
            composable<Temperatura> { TemperaturaCompose() }
            composable<Area> { AreaCompose() }
            composable<Volumen> { VolumenCompose() }
            composable<Tiempo> { TiempoCompose() }
            composable<Velocidad> { VelocidadCompose() }
            composable<Peso> { PesoCompose() }
            composable<Longitud> { LongitudCompose() }
        }
    }
}

@Composable
fun Encabezado(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(){
            Text(
                text = "CONVERSION",
                fontFamily = monserratFamily,
                fontWeight = FontWeight.Bold
            )
        }

        MenuDesplegable(navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuDesplegable(navController: NavHostController) {
    var expandido by remember { mutableStateOf(false) }
    val opciones = listOf(
        "Temperatura" to Temperatura,
        "Área" to Area,
        "Volumen" to Volumen,
        "Tiempo" to Tiempo,
        "Velocidad" to Velocidad,
        "Masa" to Peso,
        "Longitud" to Longitud
    )
    var unidadSeleccionada by remember { mutableStateOf(opciones[0]) }

    Box {
        ExposedDropdownMenuBox(
            expanded = expandido,
            onExpandedChange = { expandido = it }
        ) {
            OutlinedTextField(
                value = unidadSeleccionada.first,
                onValueChange = {},
                readOnly = true,
                label = { Text(text = "Unidad") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandido)
                },
                modifier = Modifier
                    .menuAnchor()
                    .width(IntrinsicSize.Min) // Se ajusta al contenido mínimo necesario
            )
            // El menú que se despliega
            ExposedDropdownMenu(
                expanded = expandido,
                onDismissRequest = { expandido = false }
            ) {
                opciones.forEach { unidad ->
                    DropdownMenuItem(
                        text = { Text(unidad.first) },
                        onClick = {
                            unidadSeleccionada = unidad
                            expandido = false
                            navController.navigate(unidad.second) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                    )
                }
            }
        }
    }
}

@Preview(
    widthDp = 474,
    heightDp = 997,
    name = "Pantalla de mi Xiaomi Redmi note 8",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.NONE,
    showSystemUi = true
)
@Preview(
    showBackground = true,
    device = "spec:parent=pixel_9", name = "Pixel 9",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.NONE,
    showSystemUi = true,
)
@PreviewScreenSizes
@Composable
fun GreetingPreview() {
    ConvertirdorUnidadesAndroidTheme {
        Fondo()
    }
}
