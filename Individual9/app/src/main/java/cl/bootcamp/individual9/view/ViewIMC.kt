package cl.bootcamp.individual9.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonColors
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cl.bootcamp.individual9.R
import cl.bootcamp.individual9.component.NumberField


@Composable
fun MainScreen(){
    Scaffold { paddingValues ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(
                    Brush.linearGradient(
                        colors = listOf(
                            Color.hsl(210f, 0.1f, 0.7f),
                            Color.hsl(210f, 0.4f, 0.7f)
                        ), // Azul claro y gris claro
                        start = Offset(0f, 0f),
                        end = Offset(1000f, 1000f)
                    )
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            HeaderText()
            Space()
            Gender()
            Space()
            NumberField(name = "Edad")
            Space()
            NumberField(name = "Peso (Kg)")
            Space()
            NumberField(name = "Altura (cm)")
            Space()
            ButtonCalc()

        }
    }
}


@Composable
fun Space(){
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun HeaderText(){
    Text(text = stringResource(id = R.string.title),
        fontSize = 30.sp
    )
}

@Composable
fun ButtonCalc(){
    Button(onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor =Color.hsl(210f, 0.1f, 0.9f),
            containerColor = Color.hsl(210f, 0.6f, 0.5f)
        )

        ) {
        Text(text = stringResource(id = R.string.content_btn),
            fontSize = 30.sp)
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Gender(){
    val genderSelected = remember { mutableStateListOf<String>() }
    val genderOptions = listOf(
        stringResource(id = R.string.men),
        stringResource(id = R.string.women)
    )

    MultiChoiceSegmentedButtonRow {
        genderOptions.forEach { gender ->

            SegmentedButton(
                checked = gender in genderSelected,
                onCheckedChange =
                if (genderSelected.isEmpty()){
                    { genderSelected.add(gender) }
                } else{
                    { if (gender in genderSelected){
                            genderSelected.remove(gender)
                        }else{
                    genderSelected.clear()
                    genderSelected.add(gender)}}

                },

                shape = SegmentedButtonDefaults.itemShape(index = genderOptions.indexOf(gender), count = genderOptions.size),
                colors = SegmentedButtonDefaults.colors(
                    activeContainerColor = Color.hsl(210f, 0.6f, 0.5f),
                    inactiveContainerColor = Color.Transparent,
                    activeContentColor = Color.hsl(210f, 0.1f, 0.9f),
                    inactiveContentColor = Color.hsl(0f, 0f, 0f)

                )
            )
            {
                Text(text = gender)
            }
        }
    }
}

