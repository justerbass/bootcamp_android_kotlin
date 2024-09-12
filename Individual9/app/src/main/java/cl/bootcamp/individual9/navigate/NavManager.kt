package cl.bootcamp.individual9.navigate

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.bootcamp.individual9.view.MainScreen
import cl.bootcamp.individual9.view.ResultView
import cl.bootcamp.individual9.view.SplashScreen
import cl.bootcamp.individual9.viewmodel.ViewModelIMC

@Composable
fun NavManager(){

    val navControler = rememberNavController()
    val viewModelIMC: ViewModelIMC = viewModel()

    NavHost(navController = navControler, startDestination = "Splash") {

        composable("Splash"){
            SplashScreen(navControler)
        }

        composable("Main"){
            MainScreen(navControler, viewModelIMC)
        }

        composable("Result"){
            ResultView(navControler, viewModelIMC)
        }
    }

}