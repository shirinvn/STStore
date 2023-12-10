package com.example.stsotre.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.stsotre.data.model.basket.CartItem


@Database(entities = [CartItem::class], version = 1, exportSchema = false)

abstract class DigiKalaDataBase: RoomDatabase() {
    abstract fun cartDao ( ): CartDao
}