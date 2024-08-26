package cl.bootcamp.individual2

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
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.tooling.preview.Preview
import cl.bootcamp.individual2.ui.theme.Individual2Theme


fun main() {

while (true) {
    try {
        println("Ingerese la edad del comprador al parque de diversiones:")
        var edad: Int = readln().toInt()

        if (edad > 0 && edad < 100) {

            println("ingrese dia de la semana:")
            var dia: String = readln()
            dia = dia.lowercase()

            var semana =
                listOf("lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo")
            if (!semana.contains(dia)) {
                println("dia invalido")
            } else {
                var precio: Int
                var entrada: Int = 0

                when {
                    edad < 4 -> {
                        entrada = 0
                    }

                    edad in 4..15 -> {
                        entrada = 15000
                    }

                    edad in 16..60 -> {
                        precio = 30000
                        if (dia == "lunes" || dia == "martes") {
                            entrada = precio - 5000
                        } else {
                            entrada = precio
                        }
                    }

                    edad > 60 -> {
                        entrada = 20000
                    }
                }

                println("el precio de la entrada es: $entrada clp")
                break
            }
        } else {
            println("edad invalida")
        }

    } catch (e: NumberFormatException) {
        println("edad invalida")
    }
}

}

