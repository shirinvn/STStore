package com.example.stsotre.ui.basket

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.stsotre.R
import com.example.stsotre.data.model.home.MainCategory
import com.example.stsotre.data.model.home.StoreProduct
import com.example.stsotre.data.remote.NetWorkResult
import com.example.stsotre.ui.screens.home.MostDiscountedCard
import com.example.stsotre.ui.theme.darkText
import com.example.stsotre.ui.theme.searchBarBg
import com.example.stsotre.ui.theme.spacing
import com.example.stsotre.viewmodel.BasketViewModel


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SuggestListSection (viewModel: BasketViewModel = hiltViewModel()){


    viewModel.getSuggestedItems()
    var suggestedList by remember {
        mutableStateOf<List<StoreProduct>>(emptyList())
    }


    var loading by remember {
        mutableStateOf(false)
    }

    val suggestedResult by viewModel.suggestedList.collectAsState()

    when (suggestedResult) {
        is NetWorkResult.Success -> {
            suggestedList = suggestedResult.data ?: emptyList()
            loading = false
        }

        is NetWorkResult.Error -> {
            loading = false
            Log.e("3636", "banner Section Error : ${suggestedResult.message}")
        }

        is NetWorkResult.Loading -> {
            loading = true
        }
    }

    Spacer(modifier = Modifier
        .fillMaxWidth()
        .height(MaterialTheme.spacing.small)
        .background(MaterialTheme.colors.searchBarBg))


    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(MaterialTheme.spacing.small),
        text = stringResource(id = R.string.most_discounted_products),
        textAlign = TextAlign.Right,
        style = MaterialTheme.typography.h3,
        fontWeight = FontWeight.SemiBold,
        color = MaterialTheme.colors.darkText,
    )

    FlowRow(
        maxItemsInEachRow = 2,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.Start
    ) {

        for (item in suggestedList) {
            MostDiscountedCard(item)
        }

    }
}