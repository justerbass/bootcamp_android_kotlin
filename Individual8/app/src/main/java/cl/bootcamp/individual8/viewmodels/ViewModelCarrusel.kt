package cl.bootcamp.individual8.viewmodels

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CarruselViewModel: ViewModel(){
    private val _hero_text = MutableLiveData("")
    val hero_text: LiveData<String> = _hero_text

    private val _background_color = MutableLiveData(Color.hsl(0F, 0F, 0F))
    val background_color: LiveData<Color> = _background_color

    private val _text_color = MutableLiveData(Color.hsl(174F, 0.97F, 0.43F))
    val text_color: LiveData<Color> = _text_color



    fun marvelToggle(){
        if (_hero_text.value != "Marvel"){
            _hero_text.value = "Marvel"
            _background_color.value = Color.hsl(0F, 1F, 0.5F)
            _text_color.value = Color.hsl(1F, 1F, 1F)
        }
    }

    fun dcToggle(){
        if (_hero_text.value != "DC"){
            _hero_text.value = "DC"
            _background_color.value = Color.hsl(240F, 1F, 0.5F)
            _text_color.value = Color.hsl(220F, 0.898F, 0.614F)


        }

    }
}