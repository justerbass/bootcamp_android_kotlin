package cl.bootcamp.spint5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import cl.bootcamp.spint5.datastore.DataStore
import cl.bootcamp.spint5.navigate.NavManager
import cl.bootcamp.spint5.ui.theme.Spint5Theme

import cl.bootcamp.spint5.viewmodel.ShoesTapViewModel

class MainActivity : ComponentActivity() {
    private lateinit var shoesTapViewModel: ShoesTapViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val dataStore = DataStore(this.applicationContext)
        val factory = ShoesTapViewModelFactory(dataStore, application)
        shoesTapViewModel = ViewModelProvider(this, factory).get(ShoesTapViewModel::class.java)
        setContent {
            Spint5Theme {
                NavManager(viewModel = shoesTapViewModel)
            }
        }
    }
}

