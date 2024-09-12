package cl.bootcamp.individual9.component


import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.KeyboardType


@Composable
fun NumberField(
    name: String,
    onValueChange: (String) -> Unit,
    value: String
){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number ),
        singleLine = true,
        label = {Text(text = name)}
        )
}
