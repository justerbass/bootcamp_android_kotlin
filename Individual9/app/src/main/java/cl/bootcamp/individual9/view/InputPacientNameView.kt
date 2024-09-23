@file:OptIn(ExperimentalMaterial3Api::class)

package cl.bootcamp.individual9.view


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cl.bootcamp.individual9.R
import cl.bootcamp.individual9.component.RegistrationPacient
import cl.bootcamp.individual9.component.Space
import cl.bootcamp.individual9.model.RegisterPacient
import cl.bootcamp.individual9.viewmodel.ViewModelIMC


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputPacient(navController: NavController, viewModelIMC: ViewModelIMC){
    Scaffold (topBar = {
        CenterAlignedTopAppBar(title = {
            Text(text = stringResource(id = R.string.title_list_pacient))
        },
            colors = TopAppBarDefaults.topAppBarColors(Color.Transparent)
            )
    },
        containerColor = Color.Transparent,
        modifier = Modifier.background(
            Brush.linearGradient(
                colors = listOf(
                    Color.hsl(210f, 0.1f, 0.7f),
                    Color.hsl(210f, 0.4f, 0.7f)
                ),
                start = Offset(0f, 0f),
                end = Offset(1000f, 1000f)
            )
        )

    ){paddingValues ->
       Column (modifier = Modifier
           .padding(paddingValues)
           .fillMaxSize()
           .padding(15.dp),
           horizontalAlignment = Alignment.CenterHorizontally
       )
           {
            AddPacient(viewModelIMC, navController)
            LazyColumn (modifier = Modifier.fillMaxSize()){
               items(viewModelIMC.listPacient){item ->
                   Space()
                   CardPacient(item = item, viewModelIMC)
               }
           }
       }
    }
}

@Composable
fun AddPacient(viewModelIMC: ViewModelIMC, navController: NavController){
    IconButton(onClick = { viewModelIMC.openRegister()
    },
        modifier = Modifier
            .scale(2.5f)
            .padding(20.dp),

    ) {
        Icon(imageVector = Icons.Filled.AccountCircle,
            contentDescription = "add",
            tint = Color.hsl(120f, 0.3f, 0.5f),)
    }

    ShowRegister(viewModelIMC, navController)
}

@Composable
fun ShowRegister(viewModelIMC: ViewModelIMC, navController: NavController){
    val state = viewModelIMC.state

    if(state.showModal){
        RegistrationPacient(
            title = stringResource(id = R.string.add_pacient),
            confirmText = stringResource(id = R.string.confirm_register),
            onText = {
                OutlinedTextField(
                    value = state.namePacient,
                    onValueChange = { viewModelIMC.onValue(it, "namePacient") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = stringResource(id = R.string.hint_register))}
                )
            },
            onDismissClick = { viewModelIMC.closeRegister() },
            onConfirmClick = {
                if (state.namePacient.isNotBlank()) {
                    ViewModelIMC.nameIn = state.namePacient
                    viewModelIMC.closeRegister()
                    viewModelIMC.cleanRegister()
                    navController.navigate("Main")
                }
            }
        )
    }
}


@Composable
fun CardPacient(
    item : RegisterPacient,
    viewModelIMC: ViewModelIMC
){
    Column (modifier = Modifier
        .border(2.dp, Color.hsl(210f, 0.6f, 0.5f), shape = RoundedCornerShape(10.dp))
    ){
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween){
            Row (
                modifier = Modifier.padding(10.dp, 0.dp)
            ){
                Icon(imageVector = Icons.Filled.Face,
                    contentDescription = null,
                    tint = viewModelIMC.generateRandomColor(),
                    modifier = Modifier.padding(10.dp))
                Text(text = item.name.uppercase(),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp))
                Text(text = item.age.toString() + " años",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp))
            }
            Row (modifier = Modifier.padding(10.dp, 0.dp)){

                Text(text = item.gender,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp))

            }
        }
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp, 0.dp, 0.dp, 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween){
            Text(text = "IMC : ${String.format("%.2f", item.imc)}",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp))

            Text(text = item.clasification,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )
        }
    }


}
