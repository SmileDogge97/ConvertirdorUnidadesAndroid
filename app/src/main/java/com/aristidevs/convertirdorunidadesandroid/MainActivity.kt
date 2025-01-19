package com.aristidevs.convertirdorunidadesandroid

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aristidevs.convertirdorunidadesandroid.ui.theme.ConvertirdorUnidadesAndroidTheme
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {

    val monserratFamily = FontFamily(
        Font(R.font.montserrat, FontWeight.Normal),
        Font(R.font.montserrat_italic, FontWeight.Light)
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConvertirdorUnidadesAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Fondo(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

@Composable
fun Fondo(name: String, modifier: Modifier = Modifier) {
    Column(modifier= Modifier.padding(16.dp)) {
        Encabezado()
        Box(Modifier.fillMaxHeight().verticalScroll(rememberScrollState())){

        }
    }
}

@Composable
fun Encabezado() {
    Row(
        Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "CONVERSION",
            modifier = Modifier.weight(1f), fontFamily = monserratFamily, fontWeight = FontWeight.Bold
        )
        menu()
    }
}

@Composable
fun menu(){
    var expanded by remember { mutableStateOf(false) }
    Box(){
        IconButton(onClick = {expanded = !expanded}) {
            Icon(Icons.Default.MoreVert, contentDescription = "More Options")
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {false},
            modifier = Modifier.fillMaxWidth()
        ) {
            DropdownMenuItem(
                text = { Text("Temperatura") },
                onClick = { expanded = false }
            )
            DropdownMenuItem(
                text = { Text("Area") },
                onClick = { expanded = false }
            )
            DropdownMenuItem(
                text = { Text("Volumen") },
                onClick = { expanded = false }
            )
            DropdownMenuItem(
                text = { Text("Tiempo") },
                onClick = { expanded = false }
            )
            DropdownMenuItem(
                text = { Text("Velocidad") },
                onClick = { expanded = false }
            )
            DropdownMenuItem(
                text = { Text("Masa") },
                onClick = { expanded = false }
            )
            DropdownMenuItem(
                text = { Text("Longitud") },
                onClick = { expanded = false }
            )
        }
    }

}

@Preview(showBackground = true,
    device = "spec:parent=pixel_9", name = "Pixel 9",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.NONE,
    showSystemUi = true,
)
@Composable
fun GreetingPreview() {
    ConvertirdorUnidadesAndroidTheme {
        Fondo("Android")
    }
}
}