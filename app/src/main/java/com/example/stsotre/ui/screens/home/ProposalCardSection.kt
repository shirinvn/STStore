package com.example.stsotre.ui.screens.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.stsotre.data.model.home.AmazingItem
import com.example.stsotre.data.model.home.Slider
import com.example.stsotre.data.remote.NetWorkResult
import com.example.stsotre.ui.theme.roundedShape
import com.example.stsotre.ui.theme.spacing
import com.example.stsotre.viewmodel.HomeViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProposalCardSection(viewModel: HomeViewModel= hiltViewModel()){


    var bannerList by remember {
        mutableStateOf<List<Slider>>(emptyList())
    }


    var loading by remember {
        mutableStateOf(false)
    }

    val bannerResult by viewModel.banners.collectAsState()

    when (bannerResult) {
        is NetWorkResult.Success -> {
            bannerList = bannerResult.data ?: emptyList()
            loading = false
        }

        is NetWorkResult.Error -> {
            loading = false
            Log.e("3636", "banner Section Error : ${bannerResult.message}")
        }

        is NetWorkResult.Loading -> {
            loading = true
        }
    }
    FlowRow (maxItemsInEachRow = 2,
        modifier = Modifier
            .fillMaxWidth()
            .height(290.dp)
            .padding(MaterialTheme.spacing.small)){
        for (item in bannerList){
            ProposalCardItem(item)
        }



    }

}

@Composable
fun ProposalCardItem(imgLink: Slider){

    Card(shape = MaterialTheme.roundedShape.semimedium,
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .height(140.dp)
            .padding(
                horizontal = MaterialTheme.spacing.small,
                vertical = MaterialTheme.spacing.small
            )) {
        Image(painter = rememberAsyncImagePainter(imgLink.image), contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds)

    }

}