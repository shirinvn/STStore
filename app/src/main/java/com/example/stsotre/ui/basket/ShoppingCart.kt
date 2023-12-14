package com.example.stsotre.ui.basket

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.stsotre.data.model.basket.CartItem
import com.example.stsotre.viewmodel.BasketViewModel
import kotlinx.coroutines.flow.collectLatest


@Composable
fun ShoppingCart(

    viewModel: BasketViewModel = hiltViewModel()
){
    val currentCartItem = remember {
        mutableStateOf(emptyList<CartItem>())
    }
    LaunchedEffect(key1 = true){
        viewModel.currentCartItem.collectLatest { list->
            currentCartItem.value =list
        }
    }

    LazyColumn(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(bottom = 60.dp)){

        if (currentCartItem.value.isEmpty()){
            item{
                 EmptyBasketShopping()
            }
            item { SuggestListSection() }
        }else{
            items(currentCartItem.value){item->
                CartItemCard(item = item)
            }
        }


    }
}