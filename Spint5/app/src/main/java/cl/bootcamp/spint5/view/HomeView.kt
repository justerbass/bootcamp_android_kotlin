package cl.bootcamp.spint5.view


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

import cl.bootcamp.spint5.R
import cl.bootcamp.spint5.component.ShoeCard
import cl.bootcamp.spint5.component.TitleNameList
import cl.bootcamp.spint5.model.ProductItem


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(){

    Scaffold (topBar = {
        CenterAlignedTopAppBar(
            title = { Text(
                text = stringResource(id = R.string.name_store),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                color = Color.White)
                    },
            colors = TopAppBarDefaults.topAppBarColors(Color.hsl(210f, 0.5f, 0.2f)),

        )

    }
    )

    {
        paddingValues ->


        Column(modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(Color.hsl(210f, 0.1f, 0.7f)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TitleNameList(title = "Zapatos")
            space()
            Shoe()
            space()
            TitleNameList(title = "Zapatillas")
            space()
            Sneaker()
        }
    }
}

@Composable
fun space(){
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun Shoe() {
    val shoes = listOf(
        ProductItem(R.drawable.shoe_1, stringResource(id = R.string.title_shoe_1),
            null, 1000),
        ProductItem(R.drawable.shoe_2, stringResource(id = R.string.title_shoe_2),
            null, 2000),
        ProductItem(R.drawable.shoe_3, stringResource(id = R.string.title_shoe_3),
            null, 3000),
        ProductItem(R.drawable.shoe_4, stringResource(id = R.string.title_shoe_4),
            null, 4000),
        ProductItem(R.drawable.shoe_5, stringResource(id = R.string.title_shoe_5),
            null, 5000),
        ProductItem(R.drawable.shoe_6, stringResource(id = R.string.title_shoe_6),
            null, 6000),
        ProductItem(R.drawable.shoe_7, stringResource(id = R.string.title_shoe_7),
            null, 7000)
    )

    LazyRow {
        items(shoes) { shoe ->
            ShoeCard(
                img = painterResource(id = shoe.imageResID),
                title = shoe.title,
                description = shoe.contentDescription,
                price = shoe.price
            ) {}
        }
    }
}


@Composable
fun Sneaker(){
 val sneakers = listOf(
     ProductItem(R.drawable.sneaker_1, stringResource(id = R.string.title_sneaker_1),
         null, 1000),
     ProductItem(R.drawable.sneaker_2, stringResource(id = R.string.title_sneaker_2),
         null, 2000),
     ProductItem(R.drawable.sneaker_3, stringResource(id = R.string.title_sneaker_3),
         null, 3000),
     ProductItem(R.drawable.sneaker_4, stringResource(id = R.string.title_sneaker_4),
         null, 4000),
     ProductItem(R.drawable.sneaker_5, stringResource(id = R.string.title_sneaker_5),
         null,5000),
     ProductItem(R.drawable.sneaker_6, stringResource(id = R.string.title_sneaker_6),
         null, 6000),
     ProductItem(R.drawable.sneaker_7, stringResource(id = R.string.title_sneaker_7),
         null, 7000)
     )

    LazyRow {
        items(sneakers){
            sneaker ->

            ShoeCard(
                img = painterResource(id = sneaker.imageResID),
                title = sneaker.title,
                description = sneaker.contentDescription,
                price = sneaker.price) {}
            }
        }
}


//hasta aqui llegamos

