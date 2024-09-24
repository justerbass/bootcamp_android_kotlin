package cl.bootcamp.individual9.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class Storewelcome (private val context: Context) {

     companion object{
         private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("sotreWelcome")
         val STORE_WELCOME = booleanPreferencesKey("store_welcome")
     }

    val getWelcome: Flow<Boolean> = context.dataStore.data
        .map {
            preferences ->
            preferences[STORE_WELCOME] ?: false
        }

    suspend fun saveWelcome(value: Boolean){
        context.dataStore.edit { preferences ->
            preferences[STORE_WELCOME] = value
        }
    }

}