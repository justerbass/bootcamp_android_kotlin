package cl.bootcamp.railnationworldmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cl.bootcamp.railnationworldmanager.model.Server
import cl.bootcamp.railnationworldmanager.model.User
import cl.bootcamp.railnationworldmanager.ui.theme.RailNationWorldManagerTheme
import cl.bootcamp.railnationworldmanager.view.HomeView
import cl.bootcamp.railnationworldmanager.view.ServerDetailView
import cl.bootcamp.railnationworldmanager.view.ServerListView
import cl.bootcamp.railnationworldmanager.viewmodels.ServerViewModel
import cl.bootcamp.railnationworldmanager.viewmodels.TrainManagerHomeView

class MainActivity : ComponentActivity() {
    private val userViewModel : TrainManagerHomeView by viewModels()
    private val serverViewModel : ServerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val users = listOf(
            User(1, getString(R.string.user_1)),
            User(2, getString(R.string.user_2))
        )
        userViewModel.setUser(users)

        setContent {
            var currentView by remember { mutableStateOf("home") }
            var selectedUser by remember { mutableStateOf<User?>(null) }
            var selectedServer by remember { mutableStateOf<Server?>(null) }

            when (currentView) {
                "home" -> HomeView(userViewModel = userViewModel, onUserSelected = { user ->
                    selectedUser = user
                    currentView = "serverList"

            })
                "serverList" -> ServerListView(user = selectedUser!!, serverViewModel = serverViewModel, onServerSelected = { server ->
                    selectedServer = server
                    currentView = "serverDetail"
                })
                "serverDetail" -> ServerDetailView(server = selectedServer!!)
        }
    }
}}

