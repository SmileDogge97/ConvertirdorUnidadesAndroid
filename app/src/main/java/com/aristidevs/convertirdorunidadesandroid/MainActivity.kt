package com.aristidevs.convertirdorunidadesandroid

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import com.aristidevs.convertirdorunidadesandroid.ui.theme.ConvertirdorUnidadesAndroidTheme

class MainActivity : ComponentActivity() {
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
}

@Composable
fun Fondo(name: String, modifier: Modifier = Modifier) {

}

@Composable
fun menu(){
    DropdownMenu(
        expanded = false,
        onDismissRequest = {false},
        modifier = Modifier.fillMaxWidth()
    ) {

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