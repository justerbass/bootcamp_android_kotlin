package cl.bootcamp.spint5.component

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

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
        title = { Text(text = title) },
        text = { Text(text = msg) },
        confirmButton = {
            TextButton(onClick = onConfirmClick) {
                Text(text = confirmText)
            }
        }
    )


}