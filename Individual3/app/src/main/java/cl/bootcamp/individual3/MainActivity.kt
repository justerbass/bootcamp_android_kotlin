package cl.bootcamp.individual3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cl.bootcamp.individual3.ui.theme.Individual3Theme
import cl.bootcamp.individual3.new
import cl.bootcamp.individual3.old

fun main() {
    while (true) {
        try {
            println("seleccione ejercicio: 1 o 2")
            var ejercicio = readln().toInt()
            when (ejercicio) {
                1 -> new()
                2 -> old()
            }
        }catch (e: NumberFormatException){
            println("seleccion no valida")
        }

        println("quiere dejar de ver estos ejercicios?")
        var respuesta = readln()
        if (respuesta == "si") {
            break
        }

    }
}


