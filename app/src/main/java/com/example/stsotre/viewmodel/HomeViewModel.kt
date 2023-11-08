package com.example.stsotre.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stsotre.data.model.home.AmazingItem
import com.example.stsotre.data.model.home.Slider
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
      }
  }





}