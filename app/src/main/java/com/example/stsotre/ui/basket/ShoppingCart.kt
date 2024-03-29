package com.example.stsotre.ui.basket

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.stsotre.R
import com.example.stsotre.data.model.basket.CartItem
import com.example.stsotre.data.model.basket.CartStatus
import com.example.stsotre.ui.theme.darkText
import com.example.stsotre.ui.theme.spacing
import com.example.stsotre.viewmodel.BasketViewModel
import kotlinx.coroutines.flow.collectLatest



@Composable
fun ShoppingCart(
    viewModel: BasketViewModel = hiltViewModel()
) {

    val cartDetail = viewModel.cartDetails.collectAsState()


    val currentCartItemState:BasketScreenState<List<CartItem>
            > by viewModel.currentCartItem.collectAsState(BasketScreenState.Loading)


    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter)
    {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(bottom = 60.dp),
        ) {

            when(currentCartItemState){
                is BasketScreenState.Success -> {

                    if ((currentCartItemState as BasketScreenState.Success<List<CartItem>>).data.isEmpty()) {
                        item { EmptyBasketShopping() }
                        item { SuggestListSection() }
                    } else {

                        items((currentCartItemState as BasketScreenState.Success<List<CartItem>>).data) { item ->
                            CartItemCard(item , CartStatus.CURRENT_CART)
                        }
                        item{
                            CartPriceDetailSection(
                                cartDetail.value
                            )
                        }
                        //  item { SuggestListSection() }
                    }
                }

                is BasketScreenState.Loading -> {
                    item {
                        Column(modifier = Modifier
                            .fillMaxWidth()
                            .height(LocalConfiguration.current.screenHeightDp.dp - 60.dp)
                            .padding(vertical = MaterialTheme.spacing.small),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center) {

                            Text(text = stringResource(id = R.string.please_wait),
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.h5,
                                color = MaterialTheme.colors.darkText
                            )






                        }
                    }

                }
                is BasketScreenState.Error<*> -> {

                }
            }





        }

        Row (modifier = Modifier.fillMaxWidth()
            .align(Alignment.BottomCenter)
            .padding(bottom = 60.dp)){
            BuyProcessContinue()

        }

    }


}
