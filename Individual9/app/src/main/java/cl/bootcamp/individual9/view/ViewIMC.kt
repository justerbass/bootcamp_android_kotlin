package cl.bootcamp.individual9.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun MainScreen(){
    Scaffold { paddingValues ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(
                    Brush.linearGradient(
                        colors = listOf(
                            Color.hsl(210f, 0.1f, 0.7f),
                            Color.hsl(210f, 0.4f, 0.7f)
                        ), // Azul claro y gris claro
                        start = Offset(0f, 0f),
                        end = Offset(1000f, 1000f)
                    )
                )
        ){

        }
    }
}


