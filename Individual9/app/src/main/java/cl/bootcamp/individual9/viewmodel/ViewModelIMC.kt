package cl.bootcamp.individual9.viewmodel


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

class ViewModelIMC {


    private var _age = mutableStateOf("")
    var age: MutableState<String> = _age

    private var _weight = mutableStateOf("")
    var weight: MutableState<String> = _weight

    private var _height = mutableStateOf("")
    var height: MutableState<String> = _height

    fun calculateIMC(): Double {
        val weight = weight.value.toDoubleOrNull() ?: 0.0
        val height = height.value.toDoubleOrNull() ?: 0.0
        return weight / (height * height)
    }
}



//
//    @Composable
//    fun Pantalla(modifier: Modifier = Modifier) {
//        var peso by remember { mutableStateOf("") }
//        var altura by remember { mutableStateOf("") }
//        var edad by remember { mutableStateOf("") }
//        var result by remember { mutableStateOf("") }
//
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            TextTitulo()
//            Spacio()
//            MultiBtn()
//            Spacio()
//            TexEdad(edad) { edad = it }
//            Spacio()
//            TexPeso(peso) { peso = it }
//            Spacio()
//            TexAltura(altura) { altura = it }
//            BtnCalcular {
//                result = Calculo(peso, altura).toString()
//            }
//            Spacio()
//            TexResult(result)
//        }
//    }
//
//
//
//    @Composable
//    fun BtnCalcular(onClick: () -> Unit) {
//
//        Button(
//            onClick = onClick,
//            colors = ButtonDefaults.buttonColors(
//                contentColor = Color.White,
//                containerColor = Color.hsl(241f, 0.43f, 0.27f)
//            ),
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(40.dp)
//
//        )
//        {
//            Text(
//                text = stringResource(id = R.string.calcular),
//
//                )
//        }
//
//    }
//
//
//
//
//
//    @Composable
//    fun TexEdad(edad: String, onEdadChange: (String) -> Unit) {
//        OutlinedTextField(
//            value = edad,
//            onValueChange = onEdadChange,
//            placeholder = { Text(text = stringResource(id = R.string.edad)) }
//        )
//    }
//
//
//    @Composable
//    fun TexPeso(peso: String, onPesoChange: (String) -> Unit) {
//        OutlinedTextField(
//            value = peso,
//            onValueChange = onPesoChange,
//            placeholder = { Text(text = stringResource(id = R.string.peso)) }
//        )
//    }
//
//
//    @Composable
//    fun TexAltura(altura: String, onAlturaChange: (String) -> Unit) {
//
//
//        OutlinedTextField(
//            value = altura,
//            onValueChange = onAlturaChange,
//            placeholder = { Text(text = stringResource(id = R.string.altura)) }
//        )
//    }
//
//
//    @Composable
//    fun TexResult(result: String) {
//        Text(
//            text = result,
//            fontSize = 40.sp,
//            fontWeight = FontWeight.ExtraBold,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(20.dp),
//            textAlign = TextAlign.Center
//        )
//    }
//    fun Calculo(peso: String, altura: String): Float {
//        val pesoD = peso.toDoubleOrNull() ?: 0.0
//        val alturaD = altura.toDoubleOrNull() ?: 0.0
//        var resultimc =  (pesoD / (alturaD * alturaD)*10000).toFloat()
//        return kotlin.math.round(resultimc)
//    }
//}