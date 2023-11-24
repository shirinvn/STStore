package com.example.stsotre.data.remote

import com.example.stsotre.data.model.ResponseResult
import com.example.stsotre.data.model.home.AmazingItem
import com.example.stsotre.data.model.home.MainCategory
import com.example.stsotre.data.model.home.Slider
import retrofit2.Response
import retrofit2.http.GET

interface HomeApiInterface {

    @GET("v1/getSlider")
    suspend fun getSlider() : Response<ResponseResult<List<Slider>>>

    @GET("v1/getAmazingProducts")
    suspend fun getAmazingItems() : Response<ResponseResult<List<AmazingItem>>>


    @GET("v1/getSuperMarketAmazingProducts")
    suspend fun getSuperMarketAmazingItems() : Response<ResponseResult<List<AmazingItem>>>

    @GET("v1/get4Banners")
    suspend fun getProposalBanners() : Response<ResponseResult<List<Slider>>>


    @GET("v1/getCategories")
    suspend fun getCategories() : Response<ResponseResult<List<MainCategory>>>

    @GET("v1/getCenterBanner")
    suspend fun getCenterBanner() : Response<ResponseResult<List<Slider>>>


}