package cl.bootcamp.individual9.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cl.bootcamp.individual9.component.Space
import cl.bootcamp.individual9.viewmodel.ViewModelIMC

@Composable
fun ResultView(navController: NavController, viewModelIMC: ViewModelIMC){
    Scaffold {paddingValues ->
        Column(modifier = Modifier.padding(paddingValues).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center)
        {
            ShowResult(viewModelIMC)
            Space()
        }

    }
}


@Composable
fun ShowResult(viewModelIMC: ViewModelIMC){

    val result = viewModelIMC.calculateIMC()
    val resultText =
        if (!result.isNaN()) {
        "Tu IMC es: ${String.format("%.2f", result)}"
    } else {
        "No se puede calcular el IMC"
    }

    Text(text = resultText)

}
