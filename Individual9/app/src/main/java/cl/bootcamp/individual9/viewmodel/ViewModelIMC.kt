package cl.bootcamp.individual9.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.core.util.toRange
import androidx.lifecycle.ViewModel
import cl.bootcamp.individual9.model.RegisterPacient
import kotlin.random.Random

class ViewModelIMC :ViewModel(){


//  Calcular IMC
    private var _genderIn = mutableStateOf("")
    var genderIn: MutableState<String> = _genderIn

    private var _ageIn = mutableStateOf("")
    var ageIn: MutableState<String> = _ageIn

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


        return if (weight > 0 && heightInMeters > 0
            && ageIn.value.isNotEmpty() && ageIn.value.isNotBlank()
            && genderIn.value.isNotEmpty() && genderIn.value.isNotBlank()
            ) {
            weight / (heightInMeters * heightInMeters)
        }else{
            Double.NaN
        }


    }

//    agregar pacientes
    var state by mutableStateOf(RegisterPacient())
        private set

    var listPacient = mutableStateListOf<RegisterPacient>()

    fun openRegister(){
        state = state.copy(showModal = true)
    }

    fun closeRegister(){
        state = state.copy(showModal = false)
    }

    fun cleanRegister(){
        state = state.copy(namePacient = "")
    }

    fun onValue(value: String, text: String){
        when(text){
            "namePacient" -> state = state.copy(namePacient = value)
        }
    }

    fun addNewPacient(name: String){
        val newPacient = state.copy(
            id = listPacient.size +1,
            name = name
        )
        listPacient += newPacient
    }

    fun generateRandomColor() :Color{
        val hue =  (0..360).random().toFloat()
        val saturation = Random.nextFloat()
        val lightness = Random.nextFloat()
        return Color.hsl(hue, saturation, lightness)
    }


    // Agregar resultados a la card de pacientes

    fun addResult(){
        state = state.copy(
            age = ageIn.value.toInt(),
            gender = genderIn.value
            )
    }

}





