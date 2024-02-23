package com.example.stsotre.data.model.basket

data class CartDetails(
    val totalCount : Int,
    val totalPrice: Long,
    val totalDisCount:Long,
    val payablePrice: Long
)
