package cl.bootcamp.individual9.welcomeview


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
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
            stringResource(id = R.string.wellcome_1)
        )
    )
    items.add(
        WelcomeData(
            R.raw.anim_2,
            "Perfiles",
            stringResource(id = R.string.wellcome_2)
        )
    )
    items.add(
        WelcomeData(
            R.raw.anim_3,
            "Ventajas",
            stringResource(id = R.string.wellcome_3)
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
        modifier = Modifier.fillMaxSize(),
        navController = navController,
        store = store
    )
}