package cl.bootcamp.individual9.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import cl.bootcamp.individual9.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController){

    LaunchedEffect(key1 = true){
        delay(3000)
        navController.navigate("ListPacient")

    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Image(painter = painterResource(id = R.drawable.imc_splash),
            contentDescription = "Splash",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
                )
    }
}