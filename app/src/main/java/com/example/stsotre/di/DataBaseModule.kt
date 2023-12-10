package com.example.stsotre.di

import android.content.Context
import androidx.room.Room
import com.example.stsotre.data.db.DigiKalaDataBase
import com.example.stsotre.util.Constants.DIGI_KALA_DB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {
    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context = context,
        DigiKalaDataBase::class.java,
        DIGI_KALA_DB
    ).build()
}
