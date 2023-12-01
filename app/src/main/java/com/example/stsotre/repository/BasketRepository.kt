package com.example.stsotre.repository

import com.example.stsotre.data.model.category.SubCategory
import com.example.stsotre.data.model.home.StoreProduct
import com.example.stsotre.data.remote.BaseApiResponse
import com.example.stsotre.data.remote.BasketApiInterface
import com.example.stsotre.data.remote.CategoryApiInterface
import com.example.stsotre.data.remote.NetWorkResult
import javax.inject.Inject

class BasketRepository @Inject constructor(private val api: BasketApiInterface) : BaseApiResponse() {

suspend fun getSuggestedItem(): NetWorkResult<List<StoreProduct>> = safeApiCall {
    api.getSuggestedItem()
}

}
