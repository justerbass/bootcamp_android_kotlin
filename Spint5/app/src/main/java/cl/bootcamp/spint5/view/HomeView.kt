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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import cl.bootcamp.spint5.R
import cl.bootcamp.spint5.component.ShoeCard
import cl.bootcamp.spint5.component.TitleNameList
import cl.bootcamp.spint5.component.space
import cl.bootcamp.spint5.model.ProductItem
import cl.bootcamp.spint5.viewmodel.ShoesTapViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: ShoesTapViewModel, navController: NavController){

    Scaffold (topBar = {
        CenterAlignedTopAppBar(
            title = { Text(
                text = stringResource(id = R.string.name_store),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                color = Color.White,
                fontWeight = FontWeight.Bold)
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
            TitleNameList(title = stringResource(id = R.string.title_name_list_1))
            space()
            Shoe(viewModel, navController)
            space()
            TitleNameList(title = stringResource(id = R.string.title_name_list_2))
            space()
            Sneaker(viewModel, navController)
        }
    }
}



@Composable
fun Shoe(viewModel: ShoesTapViewModel, navController: NavController) {

    LazyRow {
        items(viewModel.shoes) {
            shoe ->
            ShoeCard(
                img = painterResource(id = shoe.imageResID),
                title = stringResource(id = shoe.title),
                description = shoe.contentDescription?.let { stringResource(id = it) },
                price = shoe.price,
                onClick = {
                    navController.navigate("description")
                    viewModel.selectProduct(shoe)
                }
            )
        }
    }
}



@Composable
fun Sneaker(viewModel: ShoesTapViewModel, navController: NavController){

    LazyRow {
        items(viewModel.sneakers){
            sneaker ->
            ShoeCard(
                img = painterResource(id = sneaker.imageResID),
                title = stringResource(id = sneaker.title),
                description = sneaker.contentDescription?.let { stringResource(id = it) },
                price = sneaker.price ,
                onClick = {
                    navController.navigate("description")
                    viewModel.selectProduct(sneaker)
                })
            }
        }
}


//hasta aqui llegamos

