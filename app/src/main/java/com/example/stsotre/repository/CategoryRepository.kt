package com.example.stsotre.repository

import com.example.stsotre.data.model.category.SubCategory
import com.example.stsotre.data.remote.BaseApiResponse
import com.example.stsotre.data.remote.CategoryApiInterface
import com.example.stsotre.data.remote.NetWorkResult
import javax.inject.Inject

class CategoryRepository @Inject constructor(private val api: CategoryApiInterface) : BaseApiResponse(){


    suspend fun getSubCategory(): NetWorkResult<SubCategory> =
        safeApiCall {
            api.getSubCategory()
        }


}