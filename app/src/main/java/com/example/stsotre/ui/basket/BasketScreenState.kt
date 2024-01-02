package com.example.stsotre.ui.basket

sealed class BasketScreenState<out T>{
    object Loading: BasketScreenState<Nothing>()
    data class Success<T>(val data:T) : BasketScreenState<T>()
    data class Error<T>(val error:Exception) : BasketScreenState<Nothing>()
}
