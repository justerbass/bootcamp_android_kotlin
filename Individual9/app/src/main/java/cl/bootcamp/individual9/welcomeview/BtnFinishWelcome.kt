package cl.bootcamp.individual9.welcomeview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cl.bootcamp.individual9.datastore.Storewelcome
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun BtnFinish(currentPage: Int, navController: NavController, store: Storewelcome){
    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 20.dp),
        horizontalArrangement = if(currentPage != 2) Arrangement.SpaceBetween else Arrangement.Center
    ){
        if (currentPage == 2){
            OutlinedButton(onClick = {
                CoroutineScope(Dispatchers.IO).launch {
                    store.saveWelcome(true)
                }
                navController.navigate("ListPacient")
            }) {
                Text(text = "Vamos!!!")
            }
        }
    }
}