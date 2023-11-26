package com.example.stsotre.data.remote

import com.example.stsotre.data.model.ResponseResult
import com.example.stsotre.data.model.category.SubCategory
import com.example.stsotre.data.model.home.AmazingItem
import com.example.stsotre.data.model.home.MainCategory
import com.example.stsotre.data.model.home.Slider
import com.example.stsotre.data.model.home.StoreProduct
import retrofit2.Response
import retrofit2.http.GET

interface CategoryApiInterface {

    @GET("v1/getSubCategories")
    suspend fun getSubCategory() : Response<ResponseResult<SubCategory>>

}