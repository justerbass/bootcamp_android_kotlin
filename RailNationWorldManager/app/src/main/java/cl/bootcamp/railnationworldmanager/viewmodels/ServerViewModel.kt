package cl.bootcamp.railnationworldmanager.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import cl.bootcamp.railnationworldmanager.model.Server

class ServerViewModel: ViewModel() {
    private val _servers = mutableStateOf(
        listOf(
            Server(1, "server 1"),
            Server(2, "server 2"),
            Server(3, "server 3")
        )
    )
    val servers : State<List<Server>> = _servers

    fun addServer(name:String){
        val newServer = Server(_servers.value.size + 1, name = name)
        _servers.value = _servers.value + newServer

    }

}