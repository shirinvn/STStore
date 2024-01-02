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
import com.example.stsotre.data.model.basket.CartStatus
import com.example.stsotre.viewmodel.BasketViewModel
import kotlinx.coroutines.flow.collectLatest



@Composable
fun ShoppingCart(
    viewModel: BasketViewModel = hiltViewModel()
) {

    val currentCartItems = remember {
        mutableStateOf(emptyList<CartItem>())
    }

    LaunchedEffect(true) {
        viewModel.currentCartItems.collectLatest { list ->
            currentCartItems.value = list
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(bottom = 60.dp),
    ) {

        if (currentCartItems.value.isEmpty()) {
            item { EmptyBasketShopping() }
            item { SuggestListSection() }
        } else {

            items(currentCartItems.value) { item ->
                CartItemCard(item , CartStatus.CURRENT_CART)
            }
            item { SuggestListSection() }


        }


    }

}
