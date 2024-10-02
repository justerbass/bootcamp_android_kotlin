package cl.bootcamp.spint5.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cl.bootcamp.spint5.component.ShoeCardItem
import cl.bootcamp.spint5.component.space
import cl.bootcamp.spint5.datastore.DataStore
import cl.bootcamp.spint5.model.CardItem
import cl.bootcamp.spint5.viewmodel.ShoesTapViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun cart(soppingCart: State<List<CardItem>>, navController: NavController, viewModel: ShoesTapViewModel) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("home") }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = "Regresar",
                            tint = Color.White
                        )
                    }
                },
                title = {
                    Text(
                        text = "carrito de compra",
                        color = Color.White
                    )
                },
                actions = {
                    IconButton(onClick = { viewModel.deleteCart() }) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Vaciar carrito",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(Color.hsl(210f, 0.5f, 0.2f))
            )
        }){paddingValues ->
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.hsl(210f, 0.1f, 0.7f))
            ){
                    itemCartToBuy(soppingCart, viewModel, paddingValues)
                    space()
                    buyItem(viewModel)

            }
        }
}

@Composable
fun itemCartToBuy(soppingCart: State<List<CardItem>>, viewModel: ShoesTapViewModel, paddingValues: PaddingValues){
    LazyColumn(modifier = Modifier
        .padding(paddingValues)
        .fillMaxSize()
    ) {

        items(soppingCart.value.size) { index ->
            val cardItem = soppingCart.value[index]
            ShoeCardItem(
                img = painterResource(id = cardItem.product.imageResID),
                title = stringResource(id = cardItem.product.title),
                quantity = cardItem.count,
                price = cardItem.product.price,
                cliKUp = { viewModel.addToCart(cardItem.product, 1, cardItem.size) },
                cliKDown = { viewModel.addToCart(cardItem.product, -1, cardItem.size) },
                clikDelete = { viewModel.deleteItem(cardItem.product) })
        }


    }
}

@Composable
fun buyItem(viewModel: ShoesTapViewModel){
    Column(
        modifier = Modifier
            .fillMaxWidth()
   ,
        verticalArrangement = Arrangement.Bottom
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Box(modifier = Modifier.background(Color.hsl(210f, 0.1f, 0.7f))){
           Row(modifier = Modifier.fillMaxWidth().padding(20.dp, 0.dp, 20.dp, 30.dp),
               horizontalArrangement = Arrangement.SpaceBetween,
               verticalAlignment = Alignment.CenterVertically) {

               Text(text ="$ " + viewModel.totalPrice.toString(),
                   fontSize = 25.sp,
                   fontWeight = FontWeight.Bold)

               Button(onClick = {
                   viewModel.deleteCart()
               }) {
                   Text(text = "comprar",
                       fontSize = 25.sp,
                       fontWeight = FontWeight.Bold)
               }
           }
        }

    }
}


