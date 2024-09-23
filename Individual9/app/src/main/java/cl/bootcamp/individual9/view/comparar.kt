package cl.bootcamp.individual9.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import cl.bootcamp.individual9.R
import cl.bootcamp.individual9.component.Alert
import cl.bootcamp.individual9.component.NumberField
import cl.bootcamp.individual9.component.RegistrationPacient
import cl.bootcamp.individual9.component.Space
import cl.bootcamp.individual9.model.RegisterPacient
import cl.bootcamp.individual9.viewmodel.ViewModelIMC
import kotlin.random.Random


//CODIGO PROFE

//InputPacientNameView
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun InputPacient(navController: NavController, viewModelIMC: ViewModelIMC){
//    Scaffold (topBar = {
//        CenterAlignedTopAppBar(title = {
//            Text(text = stringResource(id = R.string.title_list_pacient))
//        },
//            colors = TopAppBarDefaults.topAppBarColors(Color.Transparent)
//        )
//    },
//        containerColor = Color.Transparent,
//        modifier = Modifier.background(
//            Brush.linearGradient(
//                colors = listOf(
//                    Color.hsl(210f, 0.1f, 0.7f),
//                    Color.hsl(210f, 0.4f, 0.7f)
//                ),
//                start = Offset(0f, 0f),
//                end = Offset(1000f, 1000f)
//            )
//        )
//
//    ){paddingValues ->
//        Column (modifier = Modifier
//            .padding(paddingValues)
//            .fillMaxSize()
//            .padding(15.dp),
//            horizontalAlignment = Alignment.CenterHorizontally
//        )
//        {
//            AddPacient(viewModelIMC,navController)
//            LazyColumn (modifier = Modifier.fillMaxSize()){
//                items(viewModelIMC.listPacient){item ->
//                    println("Mostrando paciente: ${item.namePacient}")
//                    Space()
//                    CardPacient(item = item, navController, viewModelIMC)
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun AddPacient(viewModelIMC: ViewModelIMC, navController: NavController){
//    IconButton(onClick = { viewModelIMC.openRegister()
//    },
//        modifier = Modifier
//            .scale(2.5f)
//            .padding(20.dp),
//
//        ) {
//        Icon(imageVector = Icons.Filled.AccountCircle,
//            contentDescription = "add",
//            tint = Color.hsl(120f, 0.3f, 0.5f),)
//    }
//
//
//    ShowRegister(viewModelIMC, navController)
//}
//
//@Composable
//fun ShowRegister(viewModelIMC: ViewModelIMC, navController: NavController){
//    val state = viewModelIMC.state
//
//    if(state.showModal){
//        println("Mostrar modal para agregar paciente")
//        RegistrationPacient(
//            title = stringResource(id = R.string.add_pacient),
//            confirmText = stringResource(id = R.string.confirm_register),
////            viewModelIMC = viewModelIMC,
//            onText = {
//                OutlinedTextField(
//                    //value= viewModelIMC.state.namePacient,
//                    value = state.namePacient,
//                    onValueChange = { viewModelIMC.onValue(it, "namePacient") },//aca se captura el nombre
//                    singleLine = true,
//                    modifier = Modifier.fillMaxWidth(),
//                    label = { Text(text = stringResource(id = R.string.hint_register)) }
//                )
//            },
//            onDismissClick = { viewModelIMC.closeRegister() },
//            onConfirmClick = {
//                println("Intentando agregar paciente con nombre: ${state.namePacient}")
//                if (state.namePacient.isNotBlank()) {
//                    //Se asigna a la var estatica (companion object) el nombre escrito
//                    ViewModelIMC.nombre  = state.namePacient
//                    //viewModelIMC.addNewPacient(state.namePacient)
//                    viewModelIMC.closeRegister()
//                    viewModelIMC.cleanRegister()
//                    navController.navigate("Main")
//                }
//            }
//        )
//    }
//}
//
//
//@Composable
//fun CardPacient(
//    item : RegisterPacient,
//    navController: NavController,
//    viewModelIMC: ViewModelIMC
//){
//    Column (modifier = Modifier
//        .clickable { navController.navigate("Main")}
//        .border(2.dp, Color.hsl(210f, 0.6f, 0.5f), shape = RoundedCornerShape(10.dp))
//    ){
//        Row (modifier = Modifier
//            .fillMaxWidth()
//            .padding(10.dp),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.SpaceBetween){
//            Row (
//                modifier = Modifier.padding(10.dp, 0.dp)
//            ){
//                Icon(imageVector = Icons.Filled.Face,
//                    contentDescription = null,
//                    tint = viewModelIMC.generateRandomColor(),
//                    modifier = Modifier.padding(10.dp))
//                Text(text = item.namePacient.uppercase(),
//                    fontSize = 20.sp,
//                    fontWeight = FontWeight.Bold,
//                    modifier = Modifier.padding(10.dp))
//                println("Displaying pacient name: ${item.namePacient}")
//            }
//            Row (modifier = Modifier.padding(10.dp, 0.dp)){
//
//                Text(text = item.gender,
//                    fontSize = 20.sp,
//                    fontWeight = FontWeight.Bold,
//                    modifier = Modifier.padding(10.dp))
//
//            }
//        }
//        Row (modifier = Modifier
//            .fillMaxWidth()
//            .padding(20.dp, 0.dp, 0.dp, 20.dp),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.SpaceBetween){
//            Text(text = item.imc.toString(),
//                fontSize = 20.sp,
//                fontWeight = FontWeight.Bold,
//                modifier = Modifier.padding(10.dp))
//
//            //Text(text = item.clasification,
//            //  fontSize = 20.sp,
//            //fontWeight = FontWeight.Bold,
//            //modifier = Modifier.padding(10.dp)
//            //)
//        }
//    }
//
//
//}

//ViewIMC

//
//@Composable
//fun MainScreen(navController: NavController, viewModelIMC: ViewModelIMC){
//    //variables nuevas para acceder al estado
//    val state = viewModelIMC.state
//    Scaffold (
//        containerColor = Color.Transparent,
//        modifier = Modifier.background(
//            Brush.linearGradient(
//                colors = listOf(
//                    Color.hsl(210f, 0.1f, 0.7f),
//                    Color.hsl(210f, 0.4f, 0.7f)
//                ),
//                start = Offset(0f, 0f),
//                end = Offset(1000f, 1000f)
//            )
//        )
//    ){ paddingValues ->
//        Column (
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(paddingValues)
//                .background(Color.Transparent)
//            ,
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ){
//            Name(viewModelIMC)
//            Space()
//            HeaderText()
//            Space()
//            Gender(viewModelIMC)
//            Space()
//            NumberField(name = "Edad", onValueChange = { viewModelIMC.ageIn.value = it }, value = viewModelIMC.ageIn.value)
//            Space()
//            NumberField(name = "Peso (Kg)", onValueChange = { viewModelIMC.weight.value = it }, value = viewModelIMC.weight.value)
//            Space()
//            NumberField(name = "Altura (cm)", onValueChange = { viewModelIMC.height.value = it }, value = viewModelIMC.height.value)
//            Space()
//            ButtonCalc(navController)
//
//        }
//    }
//}
//
//@Composable
//fun HeaderText(){
//    Text(text = stringResource(id = R.string.title),
//        fontSize = 30.sp
//    )
//}
//
//@Composable
//fun ButtonCalc(navController: NavController){
//
//
//    Button(onClick = {
//        navController.navigate("Result")
//    },
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(10.dp), colors = ButtonDefaults.buttonColors(
//            contentColor = Color.hsl(210f, 0.1f, 0.9f),
//            containerColor = Color.hsl(210f, 0.6f, 0.5f)
//        )) {
//        Text(text = stringResource(id = R.string.content_btn),
//            fontSize = 30.sp)
//    }
//}
//
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun Gender(viewModelIMC: ViewModelIMC){
//    val genderSelected = remember { mutableStateListOf<String>() }
//    val genderOptions = listOf(
//        stringResource(id = R.string.men),
//        stringResource(id = R.string.women)
//    )
//
//    MultiChoiceSegmentedButtonRow {
//        genderOptions.forEach { gender ->
//
//            SegmentedButton(
//                checked = gender in viewModelIMC.genderIn.value,
//                onCheckedChange =
//
//                if (genderSelected.isEmpty()){
//                    { genderSelected.add(gender)
//                        viewModelIMC.genderIn.value = gender}
//                } else {
//                    {
//                        if (gender in genderSelected) {
//                            genderSelected.remove(gender)
//                            viewModelIMC.genderIn.value = ""
//
//                        } else {
//                            genderSelected.clear()
//                            genderSelected.add(gender)
//                            viewModelIMC.genderIn.value = gender
//
//                        }
//                    }
//
//                }
//
//                ,
//
//                shape = SegmentedButtonDefaults.itemShape(index = genderOptions.indexOf(gender), count = genderOptions.size),
//                colors = SegmentedButtonDefaults.colors(
//                    activeContainerColor = Color.hsl(210f, 0.6f, 0.5f),
//                    inactiveContainerColor = Color.Transparent,
//                    activeContentColor = Color.hsl(210f, 0.1f, 0.9f),
//                    inactiveContentColor = Color.hsl(0f, 0f, 0f)
//
//                )
//            )
//            {
//                Text(text = gender)
//            }
//        }
//    }
//}
//
//@Composable
//fun Name(viewModelIMC: ViewModelIMC){
//    println("Nombre del paciente: ${viewModelIMC.state.namePacient}")
//    Text(text = viewModelIMC.state.namePacient,
//        fontSize = 30.sp)
//}


//ResultView
//
//@Composable
//fun ResultView(navController: NavController, viewModelIMC: ViewModelIMC){
//    val result = viewModelIMC.calculateIMC()
//
//    val colorResult = when {
//        result < 18.5 -> Color.hsl(210f,0.6f,0.7f)
//        result in 18.5..24.9 -> Color.hsl(120f,0.4f,0.7f)
//        result in 25.0..29.9 -> Color.hsl(60f,0.4f,0.7f)
//        result in 30.0..34.9 -> Color.hsl(30f,0.4f,0.7f)
//        result in 35.0..39.9 -> Color.hsl(0f,0.4f,0.7f)
//        result >= 40 -> Color.hsl(330f,0.4f,0.7f)
//        else -> Color.hsl(210f, 0.4f, 0.7f)
//    }
//
//    Scaffold (
//        containerColor = Color.Transparent,
//        modifier = Modifier.background(
//            Brush.linearGradient(
//                colors = listOf(
//                    Color.hsl(210f, 0.1f, 0.7f),
//                    colorResult
//                ),
//                start = Offset(0f, 0f),
//                end = Offset(1000f, 1000f)
//            )
//        )){paddingValues ->
//        Column(modifier = Modifier
//            .padding(paddingValues)
//            .fillMaxSize()
//            .background(Color.Transparent)
//            ,
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center)
//        {
//            ShowResult(viewModelIMC, navController)
//            Space()
//            ButtonSave(navController, viewModelIMC)
//        }
//
//    }
//}
//
//
//@Composable
//fun ShowResult(viewModelIMC: ViewModelIMC, navController: NavController){
//    val result = viewModelIMC.calculateIMC()
//
//    val type = when{
//        result < 18.5 -> stringResource(id = R.string.clasification_1)
//        result in 18.5..24.9 -> stringResource(id = R.string.clasification_2)
//        result in 25.0..29.9 -> stringResource(id = R.string.clasification_3)
//        result in 30.0..34.9 -> stringResource(id = R.string.clasification_4)
//        result in 35.0..39.9 -> stringResource(id = R.string.clasification_5)
//        result >= 40 -> stringResource(id = R.string.clasification_6)
//        else -> ""
//    }
//
//    if (!result.isNaN()){
//        val resultText ="Tu IMC es: \n${String.format("%.2f", result)} \n$type "
//        Text(text = resultText,
//            fontSize = 30.sp,
//            textAlign = TextAlign.Center,
//            lineHeight = 40.sp,
//            fontWeight = FontWeight.Bold
//        )
//        viewModelIMC.state.imc = result
//    }
//    else{
//        viewModelIMC.alertempty.value = true
//        ShowAlert(viewModelIMC, navController)
//    }
//
//}
//
//@Composable
//fun ShowAlert(viewModelIMC: ViewModelIMC, navController: NavController){
//
//    if (viewModelIMC.alertempty.value) {
//        Alert(
//            title = stringResource(id = R.string.alert_title),
//            msg = stringResource(id = R.string.alert_msg),
//            confirmText = stringResource(id = R.string.alert_confirm),
//            onDismissClick = {
//                viewModelIMC.alertempty.value = false
//                navController.navigate("Main")
//            },
//            onConfirmClick = {
//                viewModelIMC.alertempty.value = false
//                navController.navigate("Main")
//            })
//    }
//}
//
//@Composable
//fun ButtonSave(navController: NavController, viewModelIMC: ViewModelIMC){
//    val result = viewModelIMC.calculateIMC()
//    if (!result.isNaN()){
//        Button(onClick = {
//            //Se llama a la var estatica (companion object) para recuperar el nombre
//            viewModelIMC.state.namePacient = ViewModelIMC.nombre
//            //Se guarda el paciente nuevo al presionar el boton
//            viewModelIMC.addNewPacient("")//agregada hasta aqui
//            navController.navigate("ListPacient")
//            //viewModelIMC.addResult()
//        },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(10.dp), colors = ButtonDefaults.buttonColors(
//                contentColor = Color.hsl(210f, 0.1f, 0.9f),
//                containerColor = Color.hsl(210f, 0.6f, 0.5f)
//            )) {
//            Text(text = stringResource(id = R.string.save_btn),
//                fontSize = 30.sp)
//        }
//    }
//
//}

//ViewModelIMC
//
//class ViewModelIMC : ViewModel(){
//
//    //  Calcular IMC
//    private var _genderIn = mutableStateOf("")
//    var genderIn: MutableState<String> = _genderIn
//
//    private var _ageIn = mutableStateOf("")
//    var ageIn: MutableState<String> = _ageIn
//
//    private var _weight = mutableStateOf("")
//    var weight: MutableState<String> = _weight
//
//    private var _height = mutableStateOf("")
//    var height: MutableState<String> = _height
//
//    private var _alertempty = mutableStateOf(false)
//    var alertempty: MutableState<Boolean> = _alertempty
//
//
//    fun calculateIMC(): Double {
//        val weight = weight.value.toDoubleOrNull() ?: 0.0
//        val height = height.value.toDoubleOrNull() ?: 0.0
//
//        val heightInMeters = height / 100.0
//
//
//        return if (weight > 0 && heightInMeters > 0
//            && ageIn.value.isNotEmpty() && ageIn.value.isNotBlank()
//            && genderIn.value.isNotEmpty() && genderIn.value.isNotBlank()
//        ) {
//            weight / (heightInMeters * heightInMeters)
//        }else{
//            Double.NaN
//        }
//
//
//    }
//
//    //    agregar pacientes
//    var state by mutableStateOf(RegisterPacient())
//        private set
//
//    var listPacient = mutableStateListOf<RegisterPacient>()
//
//    fun openRegister(){
//        state = state.copy(showModal = true)
//    }
//
//    fun closeRegister(){
//        state = state.copy(showModal = false)
//    }
//
//    fun cleanRegister(){
//        state = state.copy(namePacient = "")
//        ageIn.value = ""
//        genderIn.value = ""
//        weight.value = ""
//        height.value = ""
//    }
//
//    fun onValue(value: String, text: String){
//        when(text){
//            "namePacient" -> state = state.copy(namePacient = value) //aca habian llaves
//            "age" -> ageIn.value = value
//            "gender" -> genderIn.value = value
//            "weight" -> weight.value = value
//            "height" -> height.value = value
//        }
//    }
//
//    fun addNewPacient(name: String){
//
//        //vamos a poner los cálculos para cada paciente
//        val age = ageIn.value.toIntOrNull() ?: return
//        val weightVal = weight.value.toDoubleOrNull() ?: return
//        val heightVal = height.value.toDoubleOrNull() ?: return
//        val imcResult = calculateIMC()
//        if (imcResult.isNaN()) return
//        val newPacient = state.copy(
//            id = listPacient.size +1,
//            namePacient = state.namePacient,
//            age = age,
//            gender = genderIn.value,
//            weight = weightVal,
//            height = heightVal,
//            imc = imcResult,
//        )
//        listPacient.add(newPacient)
//
//        println("Paciente agregado: $newPacient")
//        println("Total de pacientes: ${listPacient.size}")
//
//        cleanRegister()
//        closeRegister()
//
//    }
//
//
//    fun generateRandomColor() :Color{
//        val hue =  (0..360).random().toFloat()
//        val saturation = Random.nextFloat()
//        val lightness = Random.nextFloat()
//        return Color.hsl(hue, saturation, lightness)
//    }
//
//
//    // Agregar resultados a la card de pacientes
//
//    fun addResult(){
//        state = state.copy(
//            age = ageIn.value.toInt(),
//            gender = genderIn.value,
//            namePacient = state.namePacient
//
//        )
//    }
//    //El companion object son var estaticas que mantienen su valor
////se llaman con el nombre de la clase EJ: ViewModelIMC.nombre
//    companion object {
//        var nombre: String = "" //
//    }
//
//}

//ModelIMC

//CODIGO PROFE
//
//data class RegisterPacient(
//    var id: Int = 0,
//    //var name: String = "",
//    var showModal: Boolean = false,
//    var namePacient: String = "",
//    var gender: String = "",
//    var age: Int = 0,
//    var imc: Double = 0.0,
//    //var clasification: String = "",
//    val weight: Double = 0.0,
//    val height: Double = 0.0
//    //guardar mas datos en la data class
//)

