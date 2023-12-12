package com.example.stsotre.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.stsotre.data.model.basket.CartItem

@Dao
interface CartDao {

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCartItem(cart: CartItem)
}