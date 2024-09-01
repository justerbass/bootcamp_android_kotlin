package cl.bootcamp.individual7.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ShowImageViewModel : ViewModel(){

    private val _text_button = MutableLiveData("Mostrar Logo")
    val text_button: LiveData<String> = _text_button

    private val _imageVisibility = MutableLiveData(false)
    val imageVisibility: LiveData<Boolean> = _imageVisibility

    private val _easter_text = MutableLiveData("")
    val easter_text: LiveData<String> = _easter_text

    private val _rainbow = MutableStateFlow(
        listOf(
                Color(0xFF9575CD),
                Color(0xFFBA68C8),
                Color(0xFFE57373),
                Color(0xFFFFB74D),
                Color(0xFFFFF176),
                Color(0xFFAED581),
                Color(0xFF4DD0E1),
                Color(0xFF9575CD)
                )
    )
    val rainbow: StateFlow<List<Color>> = _rainbow

    fun toggleImageVisibility() {

        if (_text_button.value == "Mostrar Logo") {
            _text_button.value = "Ocultar Logo"
        }else{
            _text_button.value = "Mostrar Logo"
        }


        if(_imageVisibility.value == true){
            _imageVisibility.value = false
        }else{
            _imageVisibility.value = true
        }

        _rainbow.value = _rainbow.value.shuffled()

        if(_easter_text.value == ""){
            _easter_text.value = "profe trate de buscar el easter egg y me comenta si lo encontro"
        }else{
            _easter_text.value = ""

        }

    }
}