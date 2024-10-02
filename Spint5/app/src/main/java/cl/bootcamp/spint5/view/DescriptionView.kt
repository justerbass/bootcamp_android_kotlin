package cl.bootcamp.spint5.view


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import cl.bootcamp.spint5.R
import cl.bootcamp.spint5.viewmodel.ShoesTapViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DescriptionScreen(navController: NavController, viewModel: ShoesTapViewModel){
    Scaffold (
        topBar = { CenterAlignedTopAppBar(
            navigationIcon = {IconButton(onClick = { navController.navigate("home") }) {
                Icon(imageVector = Icons.AutoMirrored.Default.ArrowBack,
                    contentDescription = "Regresar",
                    tint = Color.White)
            }},
            title = { Text(
                text = viewModel.selectedItem.value?.title?.let { stringResource(it) } ?:"",
                color = Color.White)},
            colors = TopAppBarDefaults.topAppBarColors(Color.hsl(210f, 0.5f, 0.2f))
        ) }
    ) {
        paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(Color.hsl(210f, 0.1f, 0.7f)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly) {

            Imagen(viewModel)
            Descripcion(viewModel)
            Multiboton(viewModel)
            precio(viewModel)
            Boton(viewModel, navController)
        }
    }
}

@Composable
fun Imagen(viewModel: ShoesTapViewModel){
    viewModel.selectedItem.value?.let { painterResource(id = it.imageResID) }?.let {
        Image(painter = it,
        contentDescription = null)
    }
}

@Composable
fun Descripcion(viewModel: ShoesTapViewModel){
    Text(text = viewModel.selectedItem.value?.contentDescription?.let { stringResource(it) } ?: "",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold)
}

@Composable
fun Boton(viewModel: ShoesTapViewModel, navController: NavController){
    OutlinedButton(onClick = {
        viewModel.selectedItem.value?.let { viewModel.addToCart(it, 1, viewModel.sizeSelected.value)
        navController.navigate("cart")}
    })
    {
        Text(text = "Agregar al carrito")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Multiboton(viewModel: ShoesTapViewModel){

    val tallaElegida = remember {
        mutableStateListOf<Int>()
    }

    val opcionesTalla = listOf(36,38,40,42,44)


    MultiChoiceSegmentedButtonRow {

        opcionesTalla.forEach {item ->
        SegmentedButton(
            checked = item in tallaElegida,
            onCheckedChange = if (tallaElegida.isEmpty()){
                { tallaElegida.add(item)
                    viewModel.sizeSelected.value = item
                    }
            } else {
                {
                    if (item in tallaElegida) {
                        tallaElegida.remove(item)
                        viewModel.sizeSelected.value = 0

                    } else {
                        tallaElegida.clear()
                        tallaElegida.add(item)
                        viewModel.sizeSelected.value = item
                    }
                }

            },
            shape = SegmentedButtonDefaults.itemShape(index = opcionesTalla.indexOf(item), count = 1 ),
            modifier = Modifier.padding(horizontal = 5.dp),
            colors = SegmentedButtonDefaults.colors(
                activeContainerColor = Color.hsl(210f, 0.5f, 0.2f),
                inactiveContainerColor = Color.Transparent,
                activeContentColor = Color.hsl(210f, 0.1f, 0.9f),
                inactiveContentColor = Color.hsl(0f, 0f, 0f)
            )
        ){
            Text(text = item.toString())
        }
        }
    }
}

@Composable
fun precio(viewModel: ShoesTapViewModel){
    Text(text = viewModel.selectedItem.value?.price.toString(),
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp)
}


