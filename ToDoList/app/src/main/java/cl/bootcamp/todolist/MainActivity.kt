package cl.bootcamp.todolist

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
import cl.bootcamp.todolist.ui.theme.ToDoListTheme
import cl.bootcamp.todolist.view.HomeView
import cl.bootcamp.todolist.viewModels.ListaProductosViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        val viewModel = ListaProductosViewModel()
        setContent {
            ToDoListTheme {
                HomeView(viewModel)
            }
        }
    }
}

