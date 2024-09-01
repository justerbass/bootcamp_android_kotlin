package cl.bootcamp.individual8.views

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
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
import cl.bootcamp.individual8.R


@Composable
fun MainScreen(modifier: Modifier, viewModel: CarruselViewModel){
    Scaffold {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(it)
            .padding(16.dp)
        , horizontalAlignment = Alignment.CenterHorizontally) {

            VersusButton()
            Space()
            DcHero()
            Space()
            MarvelHero()

        }
    }
}


@Composable
fun VersusButton() {
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
                .clickable { /* Acción del primer botón */ }
                .fillMaxHeight()
                .width(84.dp)
                .align(Alignment.CenterStart)
        ) {
            Image(
                bitmap = ImageBitmap.imageResource(id = R.drawable.marvel), // Reemplaza con tu recurso de imagen
                contentDescription = "Imagen 1",
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        // Escalar imagen si es necesario
                        scaleX = 1f
                        scaleY = 1f
                    }
            )
        }

        // Imagen del segundo botón (lado derecho)
        Box(
            modifier = Modifier
                .clickable { /* Acción del segundo botón */ }
                .fillMaxHeight()
                .width(84.dp)
                .align(Alignment.CenterEnd)
        ) {
            Image(
                bitmap = ImageBitmap.imageResource(id = R.drawable.dc), // Reemplaza con tu recurso de imagen
                contentDescription = "Imagen 2",
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        // Escalar imagen si es necesario
                        scaleX = 1f
                        scaleY = 1f
                    }
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
            )
        }
    }
}

@Composable
fun Space(){
    Spacer(modifier = Modifier.height(16.dp))

}