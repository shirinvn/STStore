package com.example.stsotre.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stsotre.data.model.home.AmazingItem
import com.example.stsotre.data.model.home.MainCategory
import com.example.stsotre.data.model.home.Slider
import com.example.stsotre.data.model.home.StoreProduct
import com.example.stsotre.data.remote.NetWorkResult
import com.example.stsotre.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {

    val slider = MutableStateFlow<NetWorkResult<List<Slider>>>(NetWorkResult.Loading())
    val amazingItems = MutableStateFlow<NetWorkResult<List<AmazingItem>>>(NetWorkResult.Loading())
    val superMarketItems = MutableStateFlow<NetWorkResult<List<AmazingItem>>>(NetWorkResult.Loading())
    val banners = MutableStateFlow<NetWorkResult<List<Slider>>>(NetWorkResult.Loading())
    val category = MutableStateFlow<NetWorkResult<List<MainCategory>>>(NetWorkResult.Loading())
    val centerBannerItems = MutableStateFlow<NetWorkResult<List<Slider>>>(NetWorkResult.Loading())
    val bestSellerItems = MutableStateFlow<NetWorkResult<List<StoreProduct>>>(NetWorkResult.Loading())
    val mostVisitedItems = MutableStateFlow<NetWorkResult<List<StoreProduct>>>(NetWorkResult.Loading())
    val mostFavoriteitems = MutableStateFlow<NetWorkResult<List<StoreProduct>>>(NetWorkResult.Loading())


  suspend fun getAllDataFromServer(){


      viewModelScope.launch {


      launch {
          slider.emit(repository.getSlider())
      }
          launch {
              amazingItems.emit(repository.getAmazingItems())

          }

          launch {
              superMarketItems.emit(repository.getSuperMarketAmazingProducts())

          }

          launch {
              banners.emit(repository.getProposalBanner())

          }


          launch {
              category.emit(repository.getCategories())

          }

          launch {
              centerBannerItems.emit(repository.getCenterBanner())

          }

          launch {
              bestSellerItems.emit(repository.getBestSellerItem())

          }

          launch {
              mostVisitedItems.emit(repository.getMostVisitedItem())

          }

          launch {
              mostFavoriteitems.emit(repository.getMostFavoriteProducts())

          }
      }
  }





}