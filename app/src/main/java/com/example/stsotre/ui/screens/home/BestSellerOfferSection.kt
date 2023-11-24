package com.example.stsotre.ui.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.stsotre.R
import com.example.stsotre.data.model.home.Slider
import com.example.stsotre.data.model.home.StoreProduct
import com.example.stsotre.data.remote.NetWorkResult
import com.example.stsotre.ui.theme.darkText
import com.example.stsotre.ui.theme.spacing
import com.example.stsotre.util.DigitHelper.digitByLocate
import com.example.stsotre.viewmodel.HomeViewModel

@Composable
fun BestSellerOfferSection (
    viewModel: HomeViewModel= hiltViewModel()
){

    var bestSellerOfferList by remember {
        mutableStateOf<List<StoreProduct>>(emptyList())
    }


    var loading by remember {
        mutableStateOf(false)
    }

    val bestSellerOffersResult by viewModel.bestSellerItems.collectAsState()

    when (bestSellerOffersResult) {
        is NetWorkResult.Success -> {
            bestSellerOfferList = bestSellerOffersResult.data ?: emptyList()
            loading = false
        }

        is NetWorkResult.Error -> {
            loading = false
            Log.e("3636", "best seller offers Item Error : ${bestSellerOffersResult.message}")
        }

        is NetWorkResult.Loading -> {
            loading = true
        }
    }


    Column( modifier = Modifier
        .fillMaxSize()
        .padding(MaterialTheme.spacing.small)) {
        Text(text = stringResource(id = R.string.best_selling_product),
            modifier = Modifier.fillMaxWidth()
                ,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.SemiBold,
            color= MaterialTheme.colors.darkText
        )

        LazyHorizontalGrid(rows = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.padding(MaterialTheme.spacing.medium).height(250.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
            ){
            itemsIndexed(bestSellerOfferList){ index, item ->

                ProductHorizontalCart(
                    name = item.name,
                    id = digitByLocate((index +1 ).toString()),
                    imgUrl = item.image
                )


            }
        }

    }

}