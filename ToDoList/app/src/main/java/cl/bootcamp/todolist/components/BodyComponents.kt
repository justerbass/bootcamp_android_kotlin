package cl.bootcamp.todolist.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun AddButton(text: String,
              onClick: () -> Unit)
{
    Button(onClick = onClick)
        {
        Text(text = text)
    }

}

@Composable
fun Modal(
    title:String
,
    onDismssClick: () -> Unit,
    onConfirmClick: @Composable () -> Unit,
    onText: @Composable () -> Unit){

    AlertDialog(
        title = { Text(text = title)},
        shape = RoundedCornerShape(10.dp),
        onDismissRequest = onDismssClick,
        text = onText,
        confirmButton = onConfirmClick
    )
}