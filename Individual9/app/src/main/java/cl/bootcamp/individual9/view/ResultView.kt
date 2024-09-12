package cl.bootcamp.individual9.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cl.bootcamp.individual9.component.Space
import cl.bootcamp.individual9.viewmodel.ViewModelIMC

@Composable
fun ResultView(navController: NavController){
    Scaffold {paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            ShowResult(viewModelIMC = ViewModelIMC())
            Space()
        }

    }
}


@Composable
fun ShowResult(viewModelIMC: ViewModelIMC){

    val result = viewModelIMC.calculateIMC()

    Text(text = "Tu IMC es: ${result}")
}
