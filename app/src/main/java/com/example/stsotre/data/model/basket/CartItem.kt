package com.example.stsotre.data.model.basket

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.stsotre.util.Constants.SHOPPING_CART_TABLE

@Entity(tableName = SHOPPING_CART_TABLE)
data class CartItem(
    @PrimaryKey
    val itemId: String,
    val name: String,
    val seller: String,
    val price: Long,
    val discountPercent: Int,
    val image: String,
    val count : Int,
    val cartStatus: CartStatus
)
