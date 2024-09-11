package cl.bootcamp.spint5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import cl.bootcamp.spint5.ui.theme.Spint5Theme
import cl.bootcamp.spint5.view.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Spint5Theme {
                MainScreen()
            }
        }
    }
}

