package cl.bootcamp.todolist.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import cl.bootcamp.todolist.model.ProductoState

class ListaProductosViewModel: ViewModel() {

    var state by mutableStateOf(ProductoState())
        private set

    var listaProdtos by mutableStateOf(listOf<ProductoState>())

    fun onValue(value : String, text: String){
        when(text){
            "nombrePoducto" -> state = state.copy(nombreProducto = value)
            "cantidadProducto" -> state = state.copy(cantidadProducto = value)
        }
    }

    fun agregarProducto(nombre: String, cantidad: String){
        val nuevoProducto = state.copy(
            id = listaProdtos.size + 1,
            nombre = nombre,
            cantidad = cantidad.toInt()
        )

        listaProdtos += nuevoProducto

    }

    fun limpiar(){
        state = state.copy(nombreProducto = "")
        state = state.copy(cantidadProducto = "")
    }

    fun abrirModal(){
        state = state.copy(mostrarModal = true)
    }

    fun cerrarModal(){
        state = state.copy(mostrarModal = false)
    }
}
