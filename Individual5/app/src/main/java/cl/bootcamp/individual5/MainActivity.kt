package cl.bootcamp.individual5

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
import cl.bootcamp.individual5.ui.theme.Individual5Theme
import java.lang.NumberFormatException

fun main() {
    while (true) {
        try {
            println("seleccione ejercicio: 1 o 2")
            println("1. ejercicio nuevo")
            println("2. ejercicio viejo")
            var ejercicio = readln().toInt()
            when (ejercicio) {
                1 -> new()
                2 -> old()
            }
        }catch (e: NumberFormatException){
            println("seleccion no valida")
        }

        println("quiere dejar de ver estos ejercicios? (si/no)")
        var respuesta = readln().lowercase()
        if (respuesta == "si") {
            break
        }

    }
}