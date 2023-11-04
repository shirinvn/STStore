package com.example.stsotre.di

import android.content.Context
import com.example.stsotre.data.datastore.DataStoreRepository
import com.example.stsotre.data.datastore.DataStoreRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module

@InstallIn(SingletonComponent::class)
object DataSotreModule {

    @Singleton
    @Provides
    fun provideDataStoreRepository(
        @ApplicationContext context:Context
    ):DataStoreRepository= DataStoreRepositoryImp(context)
}