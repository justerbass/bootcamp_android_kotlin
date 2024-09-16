package cl.bootcamp.individual9.component


import androidx.compose.foundation.background
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun Alert (
    title: String,
    msg: String,
    confirmText: String,
    onDismissClick: () -> Unit,
    onConfirmClick: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismissClick,
        title = { Text(text = title, fontWeight = FontWeight.Bold,) },
        text = { Text(text = msg,
            fontSize = 20.sp
                )},
        confirmButton = {
            TextButton(onClick = onConfirmClick) {
                Text(text = confirmText,
                    fontSize = 25.sp
                    )
            }
        },
        modifier = Modifier.background( Brush.linearGradient(
            colors = listOf(
                Color.hsl(210f, 0.1f, 0.7f),
                Color.hsl(210f, 0.4f, 0.7f)
            ),
            start = Offset(0f, 0f),
            end = Offset(500f, 500f)
        )),
        containerColor = Color.Transparent,
        textContentColor = Color.White,
        titleContentColor = Color.White

    )
}

