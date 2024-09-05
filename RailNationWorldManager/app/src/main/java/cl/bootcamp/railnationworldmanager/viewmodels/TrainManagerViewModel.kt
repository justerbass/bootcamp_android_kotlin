package cl.bootcamp.railnationworldmanager.viewmodels

import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import cl.bootcamp.railnationworldmanager.model.User

class TrainManagerHomeView : ViewModel(){
    private val _user = mutableStateOf(listOf<User>())
    val users : State<List<User>> = _user

    fun setUser(user: List<User>) {
        _user.value = user
    }
}