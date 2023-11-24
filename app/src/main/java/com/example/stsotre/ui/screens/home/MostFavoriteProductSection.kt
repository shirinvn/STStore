package com.example.stsotre.ui.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.stsotre.R
import com.example.stsotre.data.model.home.StoreProduct
import com.example.stsotre.data.remote.NetWorkResult
import com.example.stsotre.ui.theme.darkText
import com.example.stsotre.ui.theme.spacing
import com.example.stsotre.viewmodel.HomeViewModel

@Composable
fun MostFavoriteProductSection (
    viewModel: HomeViewModel = hiltViewModel()
){


    var mostFavoritItem by remember {
        mutableStateOf<List<StoreProduct>>(emptyList())
    }


    var loading by remember {
        mutableStateOf(false)
    }

    val mostFavoriteResult by viewModel.mostFavoriteitems.collectAsState()

    when (mostFavoriteResult) {
        is NetWorkResult.Success -> {
            mostFavoritItem = mostFavoriteResult.data ?: emptyList()
            loading = false
        }

        is NetWorkResult.Error -> {
            loading = false
            Log.e("3636", "most favorite Item Error : ${mostFavoriteResult.message}")
        }

        is NetWorkResult.Loading -> {
            loading = true
        }
    }
    Column (modifier = Modifier
        .fillMaxSize()
        .padding(MaterialTheme.spacing.small)){
        Row (modifier = Modifier
            .padding(bottom = MaterialTheme.spacing.extraSmall)
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
            ,
            horizontalArrangement = Arrangement.SpaceBetween){

            Text(text = stringResource(id = R.string.favorite_Product),
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.h3,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colors.darkText
            )

            Text(text = stringResource(id = R.string.see_all),
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colors.darkText
            )

        }

        LazyRow{
            items(mostFavoritItem){item ->
                MostFavoriteProductOffer(item)
            }
            item {
                MostFavoriteProductShowMore()
            }
        }

    }

}