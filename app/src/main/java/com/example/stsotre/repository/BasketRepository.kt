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
    private val dao: CartDao
) : BaseApiResponse() {

    val currentCartItems = dao.getAllItems(CartStatus.CURRENT_CART)
    val nextCartItems = dao.getAllItems(CartStatus.NEXT_CART)

    val currentCartItemsCount = dao.getCartItemsCount(CartStatus.CURRENT_CART)
    val nextCartItemsCount = dao.getCartItemsCount(CartStatus.NEXT_CART)


    suspend fun getSuggestedItems(): NetWorkResult<List<StoreProduct>> =
        safeApiCall {
            api.getSuggestedItem()
        }


    suspend fun insertCartItem(cart: CartItem) {
        dao.insertCartItem(cart)
    }

    suspend fun removeFromCart(cart: CartItem) {
        dao.removeFromCart(cart)
    }

    suspend fun changeCartItemStatus(id: String, newStatus: CartStatus) {
        dao.changeStatusCart(id, newStatus)
    }

    suspend fun changeCartItemCount(id: String, newCount: Int) {
        dao.changeCartCountItem(id, newCount)
    }


}
