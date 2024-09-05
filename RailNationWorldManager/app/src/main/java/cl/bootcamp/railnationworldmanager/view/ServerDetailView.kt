package cl.bootcamp.railnationworldmanager.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cl.bootcamp.railnationworldmanager.model.Server


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServerDetailView(server: Server){
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("detalles de " + server.name) })
        },
            content = {
                paddingValues ->
                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(text = "id: ${server.id}")
                    Text(text = "name: ${server.name}")
                }
            }
    )
}