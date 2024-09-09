package cl.bootcamp.individual9.component


import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType


@Composable
fun NumberField(name: String){
    var inNumVal by remember { mutableStateOf("") }
    OutlinedTextField(value = inNumVal,
        onValueChange = {newVal -> inNumVal = newVal},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number ),
        singleLine = true,
        placeholder = {Text(text = name)}
        )
}