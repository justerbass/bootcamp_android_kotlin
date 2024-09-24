package cl.bootcamp.individual9.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import cl.bootcamp.individual9.R
import cl.bootcamp.individual9.datastore.Storewelcome
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController, store: Boolean){

    var screnn by remember { mutableStateOf("") }

    screnn = if (store) "ListPacient"
    else "Welcome"


    LaunchedEffect(key1 = true){
        delay(3000)

        navController.navigate(screnn){
            popUpTo(0)
        }

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