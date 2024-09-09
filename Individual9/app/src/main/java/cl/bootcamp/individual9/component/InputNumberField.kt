package cl.bootcamp.individual9.component


import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.KeyboardType


@Composable
fun NumberField(name: String){

    OutlinedTextField(value = name,
        onValueChange = {},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number ),
        singleLine = true
        )
}