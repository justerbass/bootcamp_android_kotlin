package cl.bootcamp.individual9.welcomeview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cl.bootcamp.individual9.component.Space
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
    Box (modifier = modifier.background(
        Brush.linearGradient(
        colors = listOf(
            Color.hsl(210f, 0.1f, 0.7f),
            Color.hsl(210f, 0.4f, 0.7f)
        ),
        start = Offset(0f, 0f),
        end = Offset(1000f, 1000f)
    ))
        ){
        Column (horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()) {
            HorizontalPager(state = pagerState) {page ->
                Column (modifier = Modifier
                    .padding(60.dp)
                    .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    LoaderData(
                        modifier = Modifier
                            .size(300.dp)
                            .fillMaxWidth()
                            .align(alignment = Alignment.CenterHorizontally)
                        ,
                        image = item[page].image
                    )
                    Text(text = item[page].title,
                        modifier = Modifier.padding(top = 50.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 35.sp
                    )
                    Text(text = item[page].description,
                        modifier = Modifier.padding(top = 25.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 25.sp
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(125.dp))
            
            PageIndicator(
                size = item.size,
                currentPage = pagerState.currentPage,
            )

        }
        Box(modifier = Modifier
            .align(Alignment.BottomCenter)
            ){
            BtnFinish(
                currentPage = pagerState.currentPage,
                navController = navController,
                store = store
            )
        }
    }
}