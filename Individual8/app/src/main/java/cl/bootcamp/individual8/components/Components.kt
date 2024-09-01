package cl.bootcamp.individual8.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CircularButtons() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color.Gray, shape = CircleShape)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Red, shape = CircleShape)
                    .clickable { /* Acción del primer botón */ },
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Botón 1", color = Color.White)
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Blue, shape = CircleShape)
                    .clickable { /* Acción del segundo botón */ },
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Botón 2", color = Color.White)
            }
        }
    }
}

