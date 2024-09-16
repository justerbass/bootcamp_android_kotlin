package cl.bootcamp.individual9.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.navOptions
import cl.bootcamp.individual9.R
import cl.bootcamp.individual9.component.Alert
import cl.bootcamp.individual9.component.Space
import cl.bootcamp.individual9.viewmodel.ViewModelIMC

@Composable
fun ResultView(navController: NavController, viewModelIMC: ViewModelIMC){
    Scaffold {paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            ,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center)
        {
            ShowResult(viewModelIMC, navController)
            Space()
        }

    }
}


@Composable
fun ShowResult(viewModelIMC: ViewModelIMC, navController: NavController){
    var result = viewModelIMC.calculateIMC()

    if (!result.isNaN()){
    val resultText ="Tu IMC es: ${String.format("%.2f", result)}"
    Text(text = resultText)}
    else{
        viewModelIMC.alertempty.value = true
        ShowAlert(viewModelIMC, navController)
    }

}

@Composable
fun ShowAlert(viewModelIMC: ViewModelIMC, navController: NavController){

    if (viewModelIMC.alertempty.value) {
        Alert(
            title = stringResource(id = R.string.alert_title),
            msg = stringResource(id = R.string.alert_msg),
            confirmText = stringResource(id = R.string.alert_confirm),
            onDismissClick = {
                viewModelIMC.alertempty.value = false
                navController.navigate("Main")
            },
            onConfirmClick = {
                viewModelIMC.alertempty.value = false
                navController.navigate("Main")
            })
    }
}

