package cl.bootcamp.spint5.viewmodel


import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import cl.bootcamp.spint5.R
import cl.bootcamp.spint5.datastore.DataStore
import cl.bootcamp.spint5.model.CardItem
import cl.bootcamp.spint5.model.ProductItem
import kotlinx.coroutines.launch

class ShoesTapViewModel(private val dataStore: DataStore, application: Application) : AndroidViewModel(application) {

//    lista de zapatos
    val shoes = listOf(
        ProductItem(
            R.drawable.shoe_1, R.string.title_shoe_1,
            R.string.description_shoe_1, 1000),
        ProductItem(
            R.drawable.shoe_2, R.string.title_shoe_2,
            R.string.description_shoe_2, 2000),
        ProductItem(
            R.drawable.shoe_3, R.string.title_shoe_3,
            R.string.description_shoe_3, 3000),
        ProductItem(
            R.drawable.shoe_4, R.string.title_shoe_4,
            R.string.description_shoe_4, 4000),
        ProductItem(
            R.drawable.shoe_5, R.string.title_shoe_5,
            R.string.description_shoe_5, 5000),
        ProductItem(
            R.drawable.shoe_6, R.string.title_shoe_6,
            R.string.description_shoe_6, 6000),
        ProductItem(
            R.drawable.shoe_7, R.string.title_shoe_7,
            R.string.description_shoe_7, 7000)
    )

    val sneakers = listOf(
        ProductItem(R.drawable.sneaker_1, R.string.title_sneaker_1,
            R.string.description_sneaker_1, 1000),
        ProductItem(R.drawable.sneaker_2, R.string.title_sneaker_2,
            R.string.description_sneaker_2, 2000),
        ProductItem(R.drawable.sneaker_3, R.string.title_sneaker_3,
            R.string.description_sneaker_3, 3000),
        ProductItem(R.drawable.sneaker_4, R.string.title_sneaker_4,
            R.string.description_sneaker_4, 4000),
        ProductItem(R.drawable.sneaker_5, R.string.title_sneaker_5,
            R.string.description_sneaker_5,5000),
        ProductItem(R.drawable.sneaker_6,  R.string.title_sneaker_6,
            R.string.description_sneaker_6, 6000),
        ProductItem(R.drawable.sneaker_7, R.string.title_sneaker_7,
            R.string.description_sneaker_7, 7000)
    )

    init {
        loadCart()
    }

//    seleccionar prducto
    private var _selectedItem = mutableStateOf<ProductItem?>(null)
    var selectedItem : MutableState<ProductItem?> = _selectedItem

    fun selectProduct(product: ProductItem){
        _selectedItem.value = product
    }

    private var _sizeSelected = mutableIntStateOf(0)
    var sizeSelected : MutableState<Int> = _sizeSelected

//    agregar carrito
    private var _cartItems = mutableListOf<CardItem>()
    var cartItems : MutableList<CardItem> = _cartItems



    fun addToCart(product: ProductItem, count: Int, size: Int) {
        if (count > 0 ){
            val itemAdded = _cartItems.find { it.product == product }
            if (itemAdded != null) {
                val addItem = itemAdded.copy(count = itemAdded.count + count)
                _cartItems[_cartItems.indexOf(itemAdded)] = addItem
            } else {
                _cartItems.add(CardItem(product, count, size))
            }
        }else if (count < 0){
            val itemAdded = _cartItems.find { it.product == product }
            if (itemAdded != null && itemAdded.count > 1) {
                val addItem = itemAdded.copy(count = itemAdded.count + count)
                _cartItems[_cartItems.indexOf(itemAdded)] = addItem
            } else
            {
                deleteItem(product)
            }
        }


        buy()

        viewModelScope.launch {
            dataStore.saveListCart(_cartItems)
        }
    }

    fun loadCart() {
        viewModelScope.launch {
            dataStore.getListCart.collect { list ->
                _cartItems.clear()
                _cartItems.addAll(list)
                buy()
            }

        }
    }


    fun deleteCart(){
        viewModelScope.launch {
                _cartItems.clear()
                dataStore.saveListCart(_cartItems)
                buy()
        }
    }


    fun deleteItem(product: ProductItem) {
        viewModelScope.launch {
            val itemToDelete = _cartItems.find { it.product == product }
            if (itemToDelete != null) {
                _cartItems.remove(itemToDelete)
                dataStore.saveListCart(_cartItems)
                buy()
            }
        }
    }


    var totalPrice by mutableIntStateOf(0)

    fun buy () {
        totalPrice = cartItems.sumOf { it.product.price * it.count }
    }
}