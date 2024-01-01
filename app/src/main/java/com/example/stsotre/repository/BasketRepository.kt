package com.example.stsotre.repository

import com.example.stsotre.data.db.CartDao
import com.example.stsotre.data.model.basket.CartItem
import com.example.stsotre.data.model.basket.CartStatus
import com.example.stsotre.data.model.category.SubCategory
import com.example.stsotre.data.model.home.StoreProduct
import com.example.stsotre.data.remote.BaseApiResponse
import com.example.stsotre.data.remote.BasketApiInterface
import com.example.stsotre.data.remote.CategoryApiInterface
import com.example.stsotre.data.remote.NetWorkResult
import javax.inject.Inject

class BasketRepository @Inject constructor(
    private val api: BasketApiInterface,
    private val cartDao:CartDao

) : BaseApiResponse() {
    val currentCartItems= cartDao.getAllItems(CartStatus.CURRENT_CART)
    val nextCartItems= cartDao.getAllItems(CartStatus.NEXT_CART)


suspend fun getSuggestedItem(): NetWorkResult<List<StoreProduct>> = safeApiCall {
    api.getSuggestedItem()
}


    suspend fun insertCartItem(cart: CartItem){
        cartDao.insertCartItem(cart = cart)
    }



    suspend fun removeFromCart(cart: CartItem){
        cartDao.removeFromCart(cart)
    }


    suspend fun changeCartItemStatus(id: String, newCartStatus:CartStatus){
        cartDao.changeStatusCart(id, newCartStatus )
    }

    suspend fun changeCartItemCount(id: String, newCount:Int){
        cartDao.changeCartCountItem(id, newCount )
    }

}
