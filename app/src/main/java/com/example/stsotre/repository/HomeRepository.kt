package com.example.stsotre.repository

import com.example.stsotre.data.model.home.AmazingItem
import com.example.stsotre.data.model.home.MainCategory
import com.example.stsotre.data.model.home.Slider
import com.example.stsotre.data.model.home.StoreProduct
import com.example.stsotre.data.remote.BaseApiResponse
import com.example.stsotre.data.remote.HomeApiInterface
import com.example.stsotre.data.remote.NetWorkResult
import javax.inject.Inject

class HomeRepository @Inject constructor(private val api: HomeApiInterface) : BaseApiResponse(){


    suspend fun getSlider(): NetWorkResult<List<Slider>> =
        safeApiCall {
            api.getSlider()
        }


    suspend fun getAmazingItems(): NetWorkResult<List<AmazingItem>> =
        safeApiCall {
            api.getAmazingItems()
        }


    suspend fun getSuperMarketAmazingProducts(): NetWorkResult<List<AmazingItem>> =
        safeApiCall {
            api.getSuperMarketAmazingItems()
        }


    suspend fun getProposalBanner(): NetWorkResult<List<Slider>> =
        safeApiCall {
            api.getProposalBanners()
        }

    suspend fun getCategories(): NetWorkResult<List<MainCategory>> =
        safeApiCall {
            api.getCategories()
        }

    suspend fun getCenterBanner(): NetWorkResult<List<Slider>> =
        safeApiCall {
            api.getCenterBanner()
        }
    suspend fun getBestSellerItem(): NetWorkResult<List<StoreProduct>> =
        safeApiCall {
            api.getBestSellerItem()
        }
    suspend fun getMostVisitedItem(): NetWorkResult<List<StoreProduct>> =
        safeApiCall {
            api.getMostVisitedItems()
        }
}