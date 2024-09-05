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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import cl.bootcamp.railnationworldmanager.R
import cl.bootcamp.railnationworldmanager.model.User
import cl.bootcamp.railnationworldmanager.viewmodels.TrainManagerHomeView


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(userViewModel: TrainManagerHomeView,
             onUserSelected: (User) -> Unit){
    val users by userViewModel.users
    Scaffold (topBar = {
        TopAppBar(title = {Text(stringResource(id = R.string.select_user)).toString()})},
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                users.forEach { user ->
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable { onUserSelected(user) }
                    ){
                        Row (
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(text = user.name)
                        }
                    }
                }
            }
        }
    )
}
