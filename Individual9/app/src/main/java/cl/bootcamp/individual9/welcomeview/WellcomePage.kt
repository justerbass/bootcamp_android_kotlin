package cl.bootcamp.individual9.welcomeview

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cl.bootcamp.individual9.datastore.Storewelcome
import cl.bootcamp.individual9.model.WelcomeData
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun WelcomePager(
    item: List<WelcomeData>,
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    navController: NavController,
    store: Storewelcome
){
    Box (modifier = modifier){
        Column (horizontalAlignment = Alignment.CenterHorizontally) {
            HorizontalPager(state = pagerState) {page ->
                Column (modifier = Modifier
                    .padding(60.dp)
                    .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    LoaderData(
                        modifier = Modifier
                            .size(200.dp)
                            .fillMaxWidth()
                            .align(alignment = Alignment.CenterHorizontally)
                        ,
                        image = item[page].image
                    )
                    Text(text = item[page].title,
                        modifier = Modifier.padding(top = 5.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp
                    )
                    Text(text = item[page].description,
                        modifier = Modifier.padding(top = 5.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp
                    )
                }
            }
            PageIndicator(
                size = item.size,
                currentPage = pagerState.currentPage
            )
        }
        Box(modifier = Modifier.align(Alignment.BottomCenter)){
            BtnFinish(
                currentPage = pagerState.currentPage,
                navController = navController,
                store = store
            )
        }
    }
}