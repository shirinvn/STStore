package com.example.stsotre.di

import com.example.stsotre.data.db.CartDao
import com.example.stsotre.data.db.DigitKalaDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object CartDaoModule {
    @Provides
    @Singleton
    fun provideCartDao(
        dataBase: DigitKalaDataBase
    ): CartDao= dataBase.cartDao()
}