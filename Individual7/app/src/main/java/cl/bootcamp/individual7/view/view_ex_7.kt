package cl.bootcamp.individual7.view

import android.media.Image
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cl.bootcamp.individual7.R
import cl.bootcamp.individual7.viewModels.ShowImageViewModel

@Composable
fun MainScreen(modifier: Modifier, viewModel: ShowImageViewModel) {

    Scaffold{
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(it)
                .background(color = Color.hsl(268F, 1F, 0.47F)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Welcome(it, viewModel)
            Space()
            Name(it, viewModel)
            Space()
            Btn(it,viewModel)
            Space()
            Img(it,viewModel)
            Space()
            Easter(it,viewModel)
        }


    }

}

@Composable
fun Welcome(paddingValues: PaddingValues, viewModel: ShowImageViewModel){

    Text(text = "Bienvenido a Compose!!",
        fontSize = 60.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        lineHeight = 60.sp,
        color = Color.hsl(174F, 0.97F, 0.43F)
    )

}

@Composable
fun Name(paddingValues: PaddingValues, viewModel: ShowImageViewModel){

    Text(text = "Javier",
        fontSize = 45.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        fontStyle = FontStyle.Italic,
        color = Color.hsl(180F, 0.99F, 0.27F)

    )

}

@Composable
fun Btn(paddingValues: PaddingValues, viewModel: ShowImageViewModel){
    val text_button by viewModel.text_button.observeAsState("")
    Button(onClick = { viewModel.toggleImageVisibility() },
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.hsl(0F, 0F, 0F),
            containerColor = Color.hsl(349F, 1F, 0.35F))
    ){
        Text(text = text_button,
            fontSize = 30.sp)
    }



}

@Composable
fun Img(paddingValues: PaddingValues, viewModel: ShowImageViewModel){
    val imageVisibility by viewModel.imageVisibility.observeAsState(false)
    val rainbow by viewModel.rainbow.collectAsState()
    if ( imageVisibility == true) {
        var rainbowColorsBrush = remember {
            Brush.sweepGradient(
                colors = rainbow
            )
        }
        val borderWidth = 4.dp
        Image(
            painter = painterResource(id = R.drawable.compose),
            contentDescription = stringResource(id = R.string.compose),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(350.dp)
                .border(
                    BorderStroke(borderWidth, rainbowColorsBrush),
                    CircleShape
                )
                .padding(borderWidth)
                .clip(CircleShape)
        )
    }
}

@Composable
fun Easter(paddingValues: PaddingValues, viewModel: ShowImageViewModel){
    val easter by viewModel.easter_text.observeAsState("")
    Text(text = easter,
        color = Color.White,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(16.dp)

        )
}


@Composable
fun Space(){
    Spacer(modifier = Modifier.height(16.dp))
}