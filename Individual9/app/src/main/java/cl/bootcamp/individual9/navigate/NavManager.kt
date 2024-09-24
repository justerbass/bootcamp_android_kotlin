package cl.bootcamp.individual9.navigate

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.bootcamp.individual9.datastore.Storewelcome
import cl.bootcamp.individual9.view.InputPacient
import cl.bootcamp.individual9.view.MainScreen
import cl.bootcamp.individual9.view.ResultView
import cl.bootcamp.individual9.view.SplashScreen
import cl.bootcamp.individual9.viewmodel.ViewModelIMC
import cl.bootcamp.individual9.welcomeview.MainWellcome

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavManager(){

//    componentes para la navegacion
    val navControler = rememberNavController()
    val viewModelIMC: ViewModelIMC = viewModel()

//    componentes para el datastore
    val context = LocalContext.current
    val dataStore = Storewelcome(context)
    val storeWelcome = dataStore.getWelcome.collectAsState(initial = false)

    NavHost(navController = navControler, startDestination = "Splash") {

        composable("Splash"){
            SplashScreen(navControler, store = storeWelcome.value)
        }

        composable("Main"){
            MainScreen(navControler, viewModelIMC)
        }

        composable("Result"){
            ResultView(navControler, viewModelIMC)
        }

        composable("Welcome"){
            MainWellcome(modifier = Modifier, navController = navControler, store = dataStore)
        }

        composable("ListPacient"){
            InputPacient(navControler, viewModelIMC)
        }

    }

}