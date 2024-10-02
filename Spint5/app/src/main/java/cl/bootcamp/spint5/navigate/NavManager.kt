package cl.bootcamp.spint5.navigate

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.bootcamp.spint5.datastore.DataStore
import cl.bootcamp.spint5.view.DescriptionScreen
import cl.bootcamp.spint5.view.MainScreen
import cl.bootcamp.spint5.view.cart
import cl.bootcamp.spint5.viewmodel.ShoesTapViewModel

@Composable
fun NavManager(viewModel: ShoesTapViewModel){
    val navController = rememberNavController()
//    val viewModel : ShoesTapViewModel = viewModel()

    val context = LocalContext.current
    val dataStore = DataStore(context)
    val soppingCart = dataStore.getListCart.collectAsState(initial = emptyList())

    NavHost(navController = navController, startDestination = "home"){
        composable("home"){
            MainScreen(viewModel, navController)
        }
        composable("description"){
            DescriptionScreen(navController, viewModel)
        }
        composable("cart"){
            cart(soppingCart, navController, viewModel)
        }
    }

}