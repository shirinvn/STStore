package com.example.stsotre.ui.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.stsotre.data.model.home.StoreProduct
import com.example.stsotre.data.remote.NetWorkResult
import com.example.stsotre.viewmodel.HomeViewModel

@Composable
fun MostDicountedSection (
    viewModel: HomeViewModel = hiltViewModel()
){

    var mostDicountedlist by remember {
        mutableStateOf<List<StoreProduct>>(emptyList())
    }


    var loading by remember {
        mutableStateOf(false)
    }

    val mostDicountedResult by viewModel.mostDiscountedItems.collectAsState()

    when (mostDicountedResult) {
        is NetWorkResult.Success -> {
            mostDicountedlist = mostDicountedResult.data ?: emptyList()
            loading = false
        }

        is NetWorkResult.Error -> {
            loading = false
            Log.e("3636", "most discount Item Error : ${mostDicountedResult.message}")
        }

        is NetWorkResult.Loading -> {
            loading = true
        }
    }



}