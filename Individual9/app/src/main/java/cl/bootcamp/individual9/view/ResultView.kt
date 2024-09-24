package cl.bootcamp.individual9.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cl.bootcamp.individual9.R
import cl.bootcamp.individual9.component.Alert
import cl.bootcamp.individual9.component.Space
import cl.bootcamp.individual9.viewmodel.ViewModelIMC

@Composable
fun ResultView(navController: NavController, viewModelIMC: ViewModelIMC){
    val result = viewModelIMC.calculateIMC()

    val colorResult = when {
        result < 18.5 -> Color.hsl(210f,0.6f,0.7f)
        result in 18.5..24.9 -> Color.hsl(120f,0.4f,0.7f)
        result in 25.0..29.9 -> Color.hsl(60f,0.4f,0.7f)
        result in 30.0..34.9 -> Color.hsl(30f,0.4f,0.7f)
        result in 35.0..39.9 -> Color.hsl(0f,0.4f,0.7f)
        result >= 40 -> Color.hsl(330f,0.4f,0.7f)
        else -> Color.hsl(210f, 0.4f, 0.7f)
    }

    Scaffold (
        containerColor = Color.Transparent,
        modifier = Modifier.background(
        Brush.linearGradient(
            colors = listOf(
                Color.hsl(210f, 0.1f, 0.7f),
                colorResult
            ),
            start = Offset(0f, 0f),
            end = Offset(1000f, 1000f)
        )
    )){paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(Color.Transparent)
            ,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center)
        {
            ShowResult(viewModelIMC, navController)
            Space()
            ButtonSave(navController, viewModelIMC)
        }

    }
}


@Composable
fun ShowResult(viewModelIMC: ViewModelIMC, navController: NavController){
    val result = viewModelIMC.calculateIMC()

    val type = when{
        result < 18.5 -> stringResource(id = R.string.clasification_1)
        result in 18.5..24.9 -> stringResource(id = R.string.clasification_2)
        result in 25.0..29.9 -> stringResource(id = R.string.clasification_3)
        result in 30.0..34.9 -> stringResource(id = R.string.clasification_4)
        result in 35.0..39.9 -> stringResource(id = R.string.clasification_5)
        result >= 40 -> stringResource(id = R.string.clasification_6)
        else -> ""
    }

    if (!result.isNaN()){
        val resultText ="Tu IMC es: \n${String.format("%.2f", result)} \n$type "
        Text(text = resultText,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            lineHeight = 40.sp,
            fontWeight = FontWeight.Bold
        )
            viewModelIMC.state.clasification = type
            viewModelIMC.state.imc = result
    }
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

@Composable
fun ButtonSave(navController: NavController, viewModelIMC: ViewModelIMC){
    val result = viewModelIMC.calculateIMC()
    if (!result.isNaN()){
        Button(onClick = {
            viewModelIMC.state.name = ViewModelIMC.nameIn
            viewModelIMC.addNewPacient("")
            navController.navigate("ListPacient")
            viewModelIMC.addResult()
        },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp), colors = ButtonDefaults.buttonColors(
                contentColor = Color.hsl(210f, 0.1f, 0.9f),
                containerColor = Color.hsl(210f, 0.6f, 0.5f)
            )) {
            Text(text = stringResource(id = R.string.save_btn),
                fontSize = 30.sp)
        }
    }

}

