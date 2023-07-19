package com.esrefnifteliyev.consolex.data.di.modules

import com.esrefnifteliyev.consolex.data.firebase.FirebaseInterface
import com.esrefnifteliyev.consolex.data.source.FirebaseDataSource
import com.esrefnifteliyev.consolex.domain.repository.FirebaseRepository
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {

    @Provides
    @Singleton
    fun provideFirebaseAuth() = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideFirebaseDataSource(
        auth: FirebaseAuth
    ) = FirebaseDataSource(auth)

    @Provides
    @Singleton
    fun provideFirebaseRepository(fds: FirebaseDataSource) = FirebaseRepository(fds) as FirebaseInterface

}