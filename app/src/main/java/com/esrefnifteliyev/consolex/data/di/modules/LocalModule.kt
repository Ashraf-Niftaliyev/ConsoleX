package com.esrefnifteliyev.consolex.data.di.modules

import android.content.Context
import androidx.room.Room
import com.esrefnifteliyev.consolex.data.local.AppDatabase
import com.esrefnifteliyev.consolex.data.local.LocalDao
import com.esrefnifteliyev.consolex.data.local.LocalInterface
import com.esrefnifteliyev.consolex.data.source.LocalDataSource
import com.esrefnifteliyev.consolex.domain.repository.LocalRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context,AppDatabase::class.java,"app_database")
        .fallbackToDestructiveMigration()
        .build()
        .getDao()

    @Provides
    @Singleton
    fun provideDataSource(dao: LocalDao) = LocalDataSource(dao)

    @Provides
    @Singleton
    fun provideRepository(ds: LocalDataSource) = LocalRepository(ds) as LocalInterface


}