package cl.bootcamp.railnationworldmanager.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cl.bootcamp.railnationworldmanager.model.Server
import cl.bootcamp.railnationworldmanager.model.User
import cl.bootcamp.railnationworldmanager.viewmodels.ServerViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServerListView(user: User, serverViewModel: ServerViewModel, onServerSelected: (Server) -> Unit){
    val servers by serverViewModel.servers

    Scaffold (
        topBar = {
            TopAppBar(title = {Text("servidores de " + user.name)})
        },
        content = {
            paddingValues ->
            Column (
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                servers.forEach { server ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .clickable { onServerSelected(server) }

                        ){
                        Row (
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                            ){
                            Text(text = server.name)
                        }
                    }
                }
            }
        }
    )
}