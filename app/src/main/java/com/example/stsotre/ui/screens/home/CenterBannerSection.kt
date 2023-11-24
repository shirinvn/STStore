package com.example.stsotre.ui.screens.home

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.stsotre.data.model.home.Slider
import com.example.stsotre.data.remote.NetWorkResult
import com.example.stsotre.ui.component.CenterBannerItem
import com.example.stsotre.viewmodel.HomeViewModel

@Composable
fun CenterBannerSection(
    bannerNumber:Int,
    viewModel: HomeViewModel = hiltViewModel()
){



    var centerBannerList by remember {
        mutableStateOf<List<Slider>>(emptyList())
    }


    var loading by remember {
        mutableStateOf(false)
    }

    val centerBannerResult by viewModel.centerBannerItems.collectAsState()

    when (centerBannerResult) {
        is NetWorkResult.Success -> {
            centerBannerList = centerBannerResult.data ?: emptyList()
            loading = false
        }

        is NetWorkResult.Error -> {
            loading = false
            Log.e("3636", "center banner Item Error : ${centerBannerResult.message}")
        }

        is NetWorkResult.Loading -> {
            loading = true
        }
    }

    if (centerBannerList.isNotEmpty()){
        CenterBannerItem(imgUrl = centerBannerList[bannerNumber - 1].image)
        
    }
  }

