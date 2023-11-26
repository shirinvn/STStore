package com.example.stsotre.di

import com.example.stsotre.data.remote.CategoryApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object CategoryApiInterfaceModule {

    @Provides
    @Singleton
    fun provideHomeApiService (retrofit: Retrofit): CategoryApiInterface =
        retrofit.create(CategoryApiInterface::class.java)






}