package cl.bootcamp.spint5.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import cl.bootcamp.spint5.model.CardItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStore(private val context: Context) {

    companion object {
        private val Context.dataStore : DataStore<Preferences> by preferencesDataStore("ListCart")

        val LIST_CART = stringPreferencesKey("list_cart")
    }


    suspend fun saveListCart(list: List<CardItem>) {
        context.dataStore.edit { preferences ->
            val json = Gson().toJson(list)
            preferences[LIST_CART] = json
        }
    }


    val getListCart: Flow<List<CardItem>> = context.dataStore.data
        .map { preferences ->
            val cartJson = preferences[LIST_CART] ?: ""
            if (cartJson.isNotEmpty()) {
                val type = object : TypeToken<List<CardItem>>() {}.type
                Gson().fromJson(cartJson, type)
            } else {
                emptyList()
            }
        }


}

