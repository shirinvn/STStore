package com.example.stsotre.ui.screens.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.stsotre.R
import com.example.stsotre.data.model.home.AmazingItem
import com.example.stsotre.data.remote.NetWorkResult
import com.example.stsotre.ui.theme.DigiKalaLightGreen
import com.example.stsotre.ui.theme.DigiKalaRed
import com.example.stsotre.viewmodel.HomeViewModel

@Composable
fun SuperMarketOfferSectoin(viewModel: HomeViewModel = hiltViewModel()){

    var supermarketItemList by remember {
        mutableStateOf<List<AmazingItem>>(emptyList())
    }


    var loading by remember {
        mutableStateOf(false)
    }

    val superMarketItemResult by viewModel.superMarketItems.collectAsState()

    when (superMarketItemResult) {
        is NetWorkResult.Success -> {
            supermarketItemList = superMarketItemResult.data ?: emptyList()
            loading = false
        }

        is NetWorkResult.Error -> {
            loading = false
            Log.e("3636", "superMarketOffer Section Error : ${superMarketItemResult.message}")
        }

        is NetWorkResult.Loading -> {
            loading = true
        }
    }

    Column(modifier = Modifier
        .fillMaxWidth()
        .background(MaterialTheme.colors.DigiKalaLightGreen)) {

        LazyRow(modifier =  Modifier.background(MaterialTheme.colors.DigiKalaRed)){

            item {

                AmazingOfferCard(R.drawable.supermarketamazings, R.drawable.fresh)
            }


            items(supermarketItemList){item->

                AmazingItem(item = item)
            }
            item {
                AmazingShowMoreItem()

            }



        }



    }



}