package cl.bootcamp.individual9.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import cl.bootcamp.individual9.model.RegisterPacient

class ViewModelIMC :ViewModel(){

    var state by mutableStateOf(RegisterPacient())
        private set

    var listPacient = mutableListOf<RegisterPacient>()

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

}


