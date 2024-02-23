package com.example.stsotre.viewmodel

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stsotre.data.model.basket.CartDetails
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
import com.example.stsotre.ui.basket.BasketScreenState
import com.example.stsotre.util.DigitHelper.applyDiscount
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class BasketViewModel @Inject constructor(private val repository: BasketRepository) : ViewModel() {

    val suggestedList = MutableStateFlow<NetWorkResult<List<StoreProduct>>>(NetWorkResult.Loading())
    val cartDetails = MutableStateFlow(CartDetails(0,0,0,0))


    private val _currentCartItems: MutableStateFlow<BasketScreenState<List<CartItem>>>
    =MutableStateFlow(BasketScreenState.Loading)
    val currentCartItem: StateFlow<BasketScreenState<List<CartItem>>> = _currentCartItems
 private val _nextCartItems: MutableStateFlow<BasketScreenState<List<CartItem>>>
    =MutableStateFlow(BasketScreenState.Loading)
    val nextCartItems: StateFlow<BasketScreenState<List<CartItem>>> = _nextCartItems


    val currentCartItemCount = repository.currentCartItemsCount
    val nextCartItemCount = repository.nextCartItemsCount
    init {
        viewModelScope.launch (Dispatchers.IO){
            launch {
                repository.currentCartItems.collectLatest {
                    _currentCartItems.emit(BasketScreenState.Success(it))
                }
            }
            launch {
                repository.currentCartItems.collectLatest {cartItems ->
                    calculateCartDetails(cartItems)
                }
            }

            launch {
                repository.nextCartItems.collectLatest { nextCartItems->
                    _nextCartItems.emit(BasketScreenState.Success(nextCartItems))
                }
            }

        }
    }


    private fun  calculateCartDetails(items: List<CartItem>){
        var totalCount=0
      var totalPrice=0L
        var totalDicount= 0L
        var payablePrice= 0L

        items.forEach{item->
            totalPrice += item.price * item.count
            totalDicount += applyDiscount(item.price, item.discountPercent)
            totalDicount += item.count
        }
        payablePrice = totalPrice - totalDicount
        cartDetails.value= CartDetails(totalCount,totalPrice, totalDicount, payablePrice)
    }
    fun getSuggestedItems() {
        viewModelScope.launch {
            suggestedList.emit(repository.getSuggestedItems())
        }
    }


    fun insertCartItem(item: CartItem) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertCartItem(item)
        }
    }


    fun removeCartItem(item: CartItem) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.removeFromCart(item)
        }
    }

    fun changeCartItemCount(id: String, newCount: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.changeCartItemCount(id, newCount)
        }
    }

    fun changeCartItemStatus(id: String, newStatus: CartStatus) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.changeCartItemStatus(id, newStatus)
        }
    }


}
