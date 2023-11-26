package com.example.stsotre.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stsotre.data.model.category.SubCategory
import com.example.stsotre.data.model.home.AmazingItem
import com.example.stsotre.data.model.home.MainCategory
import com.example.stsotre.data.model.home.Slider
import com.example.stsotre.data.model.home.StoreProduct
import com.example.stsotre.data.remote.CategoryApiInterface
import com.example.stsotre.data.remote.NetWorkResult
import com.example.stsotre.repository.CategoryRepository
import com.example.stsotre.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val repository: CategoryRepository) : ViewModel() {

    val subCategory = MutableStateFlow<NetWorkResult<SubCategory>>(NetWorkResult.Loading())
  suspend fun getAllDataFromServer() {


      viewModelScope.launch {


          launch {
              subCategory.emit(repository.getSubCategory())
          }
      }

  }
}