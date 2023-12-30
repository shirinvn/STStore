package com.example.stsotre.viewmodel

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stsotre.data.model.basket.CartItem
import com.example.stsotre.data.model.basket.CartStatus
import com.example.stsotre.data.model.category.SubCategory
import com.example.stsotre.data.model.home.AmazingItem
import com.example.stsotre.data.model.home.MainCategory
import com.example.stsotre.data.model.home.Slider
import com.example.stsotre.data.model.home.StoreProduct
import com.example.stsotre.data.remote.CategoryApiInterface
import com.example.stsotre.data.remote.NetWorkResult
import com.example.stsotre.repository.BasketRepository
import com.example.stsotre.repository.CategoryRepository
import com.example.stsotre.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BasketViewModel @Inject constructor(private val repository: BasketRepository) : ViewModel() {

    val suggestedList = MutableStateFlow<NetWorkResult<List<StoreProduct>>>(NetWorkResult.Loading())

    val currentCartItem : Flow<List<CartItem>> = repository.currentCartItems
     fun getSuggestedItems(){
        viewModelScope.launch {
            suggestedList.emit(repository.getSuggestedItem())
        }

    }


    fun insertCartItem(cart : CartItem){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertCartItem(cart = cart)
        }
    }


    fun removeCartItem(item : CartItem){
        viewModelScope.launch(Dispatchers.IO) {
            repository.removeFromCart(item)
        }
    }



    fun changeCartItemCount(id :String , newStatus: Int){

        viewModelScope.launch(Dispatchers.IO) {
            repository.changeCartItemCount(id, newStatus)
        }
    }

    fun changeCartItemStatus(id :String , newStatus: CartStatus){

        viewModelScope.launch(Dispatchers.IO) {
            repository.changeCartItemStatus(id, newStatus)
        }
    }


}