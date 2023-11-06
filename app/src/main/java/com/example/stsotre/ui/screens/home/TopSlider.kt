package com.example.stsotre.ui.screens.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.stsotre.data.model.home.Slider
import com.example.stsotre.data.remote.NetWorkResult
import com.example.stsotre.viewmodel.HomeViewModel
import kotlinx.coroutines.flow.collectLatest


@Composable
fun TopSlider(viewModel: HomeViewModel = hiltViewModel()){



    var list by remember {
        mutableStateOf<List<Slider>>(emptyList())
    }


    var loading by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = true){
        viewModel.slider.collectLatest { result ->
            when (result){
                is NetWorkResult.Success ->{

                    result.data?.let {
                    list= it
                        Log.e("36666666636", list[0].image)

                    }
                    loading= false
                }
                is NetWorkResult.Error -> {
                    loading = false
                    Log.e("3636", "Top Slider error: ${result.message}")


                }
                is NetWorkResult.Loading ->{

                }
            }
        }
    }
}
