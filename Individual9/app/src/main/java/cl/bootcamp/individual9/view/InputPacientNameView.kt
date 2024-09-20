@file:OptIn(ExperimentalMaterial3Api::class)

package cl.bootcamp.individual9.view

import androidx.compose.animation.AnimatedContentTransitionScope.SlideDirection.Companion.Start
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAbsoluteAlignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cl.bootcamp.individual9.R
import cl.bootcamp.individual9.component.RegistrationPacient
import cl.bootcamp.individual9.component.Space
import cl.bootcamp.individual9.model.RegisterPacient
import cl.bootcamp.individual9.viewmodel.ViewModelIMC


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
            AddPacient(viewModelIMC)
            LazyColumn (modifier = Modifier.fillMaxSize()){
               items(viewModelIMC.listPacient){item ->
                   Space()
                   CardPacient(item = item, navController, viewModelIMC)
               }
           }
       }
    }
}

@Composable
fun AddPacient(viewModelIMC: ViewModelIMC){
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

    ShowRegister(viewModelIMC)
}

@Composable
fun ShowRegister(viewModelIMC: ViewModelIMC){
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
                    viewModelIMC.addNewPacient(state.namePacient)
                    viewModelIMC.closeRegister()
                    viewModelIMC.cleanRegister()
                }
            }
        )
    }
}


@Composable
fun CardPacient(
    item : RegisterPacient,
    navController: NavController,
    viewModelIMC: ViewModelIMC
){
    Column (modifier = Modifier
        .clickable { navController.navigate("Main")}
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
                Text(text = item.gender.uppercase(),
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
            Text(text = item.imc.toString(),
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
