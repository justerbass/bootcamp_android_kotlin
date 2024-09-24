package cl.bootcamp.individual9.welcomeview

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import cl.bootcamp.individual9.R
import cl.bootcamp.individual9.datastore.Storewelcome
import cl.bootcamp.individual9.model.WelcomeData
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainWellcome(modifier: Modifier, navController: NavController, store: Storewelcome){
    val items = ArrayList<WelcomeData>()

    items.add(
        WelcomeData(
            R.raw.anim_1,
            "Bienvenido",
            "Esta es una calculadora de IMC"
        )
    )
    items.add(
        WelcomeData(
            R.raw.anim_2,
            "Bienvenido",
            "Esta es una calculadora de IMC"
        )
    )
    items.add(
        WelcomeData(
            R.raw.anim_3,
            "Bienvenido",
            "Esta es una calculadora de IMC"
        )
    )

    val pagerState = rememberPagerState(
        pageCount = items.size,
        initialOffscreenLimit = 2,
        infiniteLoop = false,
        initialPage = 0
    )

    WelcomePager(
        item = items,
        pagerState = pagerState,
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        navController = navController,
        store = store
    )
}