package cl.bootcamp.spint5

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cl.bootcamp.spint5.datastore.DataStore
import cl.bootcamp.spint5.viewmodel.ShoesTapViewModel

class ShoesTapViewModelFactory(
    private val dataStore: DataStore,
    private val application: Application
) : ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShoesTapViewModel::class.java)) {
            return ShoesTapViewModel(dataStore, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }

}