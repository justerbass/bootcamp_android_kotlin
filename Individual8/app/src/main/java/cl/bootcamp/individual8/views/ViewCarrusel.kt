package cl.bootcamp.individual8.views

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import cl.bootcamp.individual8.viewmodels.CarruselViewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import cl.bootcamp.individual8.R


@Composable
fun MainScreen(modifier: Modifier, viewModel: CarruselViewModel){
    val background_color by viewModel.background_color.observeAsState(Color.hsl(0F, 0F, 0F))
    Scaffold {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(it)
            .padding(16.dp)
            .background(background_color)
        , horizontalAlignment = Alignment.CenterHorizontally) {

            Welcome(viewModel)
            Space()
            Quest(viewModel)
            VersusButton(viewModel)
            HeroTitle(viewModel
            Space()
            ShowHero(viewModel)
            Space()
        }
    }
}

@Composable
fun Welcome(viewModel: CarruselViewModel){
    val textColor by viewModel.text_color.observeAsState(Color.hsl(174F, 0.97F, 0.43F))
    Text(text = stringResource(id = R.string.header_text),
        fontSize = 60.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        lineHeight = 60.sp,
        color = textColor
    )

}

@Composable
fun Quest(viewModel: CarruselViewModel){
    val textColor by viewModel.text_color.observeAsState(Color.hsl(174F, 0.97F, 0.43F))
    Text(text = stringResource(id = R.string.hero_quest),
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        color = textColor
    )
}

@Composable
fun HeroTitle(viewModel: CarruselViewModel) {
    val showTitle by viewModel.hero_text.observeAsState("")
    val textColor by viewModel.text_color.observeAsState(Color.hsl(174F, 0.97F, 0.43F))

    Text(text = showTitle,
        color = textColor,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold)

}

@Composable
fun VersusButton(viewModel: CarruselViewModel) {

    Box(
        modifier = Modifier
            .size(200.dp)
            .padding(16.dp)
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            // Primer media luna (lado izquierdo)
            val path1 = Path().apply {
                arcTo(
                    rect = Rect(Offset(0f, 0f), size),
                    startAngleDegrees = 90f,
                    sweepAngleDegrees = 180f,
                    forceMoveTo = true
                )
                lineTo(center.x, center.y)
                close()
            }
            drawPath(path1, color = Color.Red)

            // Segundo media luna (lado derecho)
            val path2 = Path().apply {
                arcTo(
                    rect = Rect(Offset(0f, 0f), size),
                    startAngleDegrees = 270f,
                    sweepAngleDegrees = 180f,
                    forceMoveTo = true
                )
                lineTo(center.x, center.y)
                close()
            }
            drawPath(path2, color = Color.Blue)
        }

        // Imagen del primer botón (lado izquierdo)
        Box(
            modifier = Modifier
                .clickable(
                    onClick = { viewModel.marvelToggle() },
                    indication = null,
                    interactionSource = remember {
                        MutableInteractionSource ()
                    }
                )
                .fillMaxHeight()
                .width(84.dp)
                .align(Alignment.CenterStart)

        ) {
            Image(
                bitmap = ImageBitmap.imageResource(id = R.drawable.marvel),
                contentDescription = stringResource(id = R.string.marvel),
                modifier = Modifier
                    .fillMaxSize()
//
            )
        }

        // Imagen del segundo botón (lado derecho)
        Box(
            modifier = Modifier
                .clickable (
                    onClick = { viewModel.dcToggle() },
                    indication = null,
                    interactionSource = remember {
                        MutableInteractionSource ()
                    }
                )
                .fillMaxHeight()
                .width(84.dp)
                .align(Alignment.CenterEnd)
        ) {
            Image(
                bitmap = ImageBitmap.imageResource(id = R.drawable.dc),
                contentDescription = stringResource(id = R.string.dc),
                modifier = Modifier
                    .fillMaxSize()
//
            )
        }
    }
}

data class MarvelHeroItem(val imageResId: Int, val contentDescription: String)
data class DCHeroItem(val imageResId: Int, val contentDescription: String)

@Composable
fun MarvelHero(){
    val heroes_marvel = listOf(
        MarvelHeroItem(R.drawable.marvel_hero_1, stringResource(id = R.string.marvel_hero_1)),
        MarvelHeroItem(R.drawable.marvel_hero_2, stringResource(id = R.string.marvel_hero_2)),
        MarvelHeroItem(R.drawable.marvel_hero_3, stringResource(id = R.string.marvel_hero_3)),
        MarvelHeroItem(R.drawable.marvel_hero_4, stringResource(id = R.string.marvel_hero_4)),
        MarvelHeroItem(R.drawable.marvel_hero_5, stringResource(id = R.string.marvel_hero_5)),
        MarvelHeroItem(R.drawable.marvel_hero_6, stringResource(id = R.string.marvel_hero_6)),
        MarvelHeroItem(R.drawable.marvel_hero_7, stringResource(id = R.string.marvel_hero_7)),
        MarvelHeroItem(R.drawable.marvel_hero_8, stringResource(id = R.string.marvel_hero_8)),
        MarvelHeroItem(R.drawable.marvel_hero_9, stringResource(id = R.string.marvel_hero_9)),
        MarvelHeroItem(R.drawable.marvel_hero_10, stringResource(id = R.string.marvel_hero_10))
    )

    LazyColumn {
        items(heroes_marvel){
            hero ->
            Image(
                painter = painterResource(id = hero.imageResId),
                contentDescription = hero.contentDescription,
                modifier = Modifier.size(300.dp).padding(5.dp)
            )
        }
    }
}

@Composable
fun DcHero(){
    val heroes_dc = listOf(
        DCHeroItem(R.drawable.dc_hero_1, stringResource(id = R.string.dc_hero_1)),
        DCHeroItem(R.drawable.dc_hero_2, stringResource(id = R.string.dc_hero_2)),
        DCHeroItem(R.drawable.dc_hero_3, stringResource(id = R.string.dc_hero_3)),
        DCHeroItem(R.drawable.dc_hero_4, stringResource(id = R.string.dc_hero_4)),
        DCHeroItem(R.drawable.dc_hero_5, stringResource(id = R.string.dc_hero_5)),
        DCHeroItem(R.drawable.dc_hero_6, stringResource(id = R.string.dc_hero_6)),
        DCHeroItem(R.drawable.dc_hero_7, stringResource(id = R.string.dc_hero_7)),
        DCHeroItem(R.drawable.dc_hero_8, stringResource(id = R.string.dc_hero_8)),
        DCHeroItem(R.drawable.dc_hero_9, stringResource(id = R.string.dc_hero_9)),
        DCHeroItem(R.drawable.dc_hero_10, stringResource(id = R.string.dc_hero_10))
    )
    LazyRow {
        items(heroes_dc){
            hero ->
            Image(
                painter = painterResource(id = hero.imageResId),
                contentDescription = hero.contentDescription,
                modifier = Modifier.size(300.dp).padding(5.dp)
            )

        }
    }
}

@Composable
fun ShowHero(viewModel: CarruselViewModel){
    if(viewModel.hero_text.value == "Marvel"){
        MarvelHero()
    }else if(viewModel.hero_text.value == "DC"){
        DcHero()
    }
}

@Composable
fun Space(){
    Spacer(modifier = Modifier.height(16.dp))

}