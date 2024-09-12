package cl.bootcamp.individual9.viewmodel


import android.util.Log
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


    fun calculateIMC(): Double {
        val weight = weight.value.toDoubleOrNull() ?: 0.0
        val height = height.value.toDoubleOrNull() ?: 0.0


        Log.d("ViewModelIMC", "Weight: $weight, Height: $height")
        val heightInMeters = height / 100.0
        return if (weight > 0 && heightInMeters > 0) {
            weight / (heightInMeters * heightInMeters)
        } else {
            Double.NaN
        }

    }
}


