package cl.bootcamp.individual9.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ViewModelIMC :ViewModel(){


    private var _age = mutableStateOf("")
    var age: MutableState<String> = _age

    private var _weight = mutableStateOf("")
    var weight: MutableState<String> = _weight

    private var _height = mutableStateOf("")
    var height: MutableState<String> = _height

    private var _alertempty = mutableStateOf(false)
    var alertempty: MutableState<Boolean> = _alertempty

    fun calculateIMC(): Double {
        val weight = weight.value.toDoubleOrNull() ?: 0.0
        val height = height.value.toDoubleOrNull() ?: 0.0

        val heightInMeters = height / 100.0

        return if (weight > 0 && heightInMeters > 0) {
            weight / (heightInMeters * heightInMeters)
        } else {
            Double.NaN
        }

    }
}


