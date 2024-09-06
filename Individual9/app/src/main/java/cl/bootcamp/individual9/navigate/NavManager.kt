package cl.bootcamp.individual9.navigate

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.bootcamp.individual9.view.MainScreen
import cl.bootcamp.individual9.view.SplashScreen

@Composable
fun NavManager(){
    val context = LocalContext.current
    val navControler = rememberNavController()
    NavHost(navController = navControler, startDestination = "Splash") {

        composable("Splash"){
            SplashScreen(navControler)
        }
        composable("Main"){
            MainScreen()
    }
    }

}