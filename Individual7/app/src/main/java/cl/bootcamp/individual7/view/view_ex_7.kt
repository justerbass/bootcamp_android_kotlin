package cl.bootcamp.individual7.view

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    Button(onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.hsl(0F, 0F, 0F),
            containerColor = Color.hsl(349F, 1F, 0.35F))
    ){
        Text(text = "Mostrar Logo")
    }



}

@Composable
fun Img(paddingValues: PaddingValues, viewModel: ShowImageViewModel){
    Image(
        painter = painterResource(id = R.drawable.compose),
        contentDescription = stringResource(id = R.string.compose)
    )
}


@Composable
fun Space(){
    Spacer(modifier = Modifier.height(16.dp))
}