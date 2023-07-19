package com.esrefnifteliyev.consolex.domain.repository

import com.esrefnifteliyev.consolex.data.firebase.FirebaseInterface
import com.esrefnifteliyev.consolex.data.source.FirebaseDataSource
import com.google.firebase.auth.FirebaseAuth


class FirebaseRepository(private val fds: FirebaseDataSource) : FirebaseInterface{

    override suspend fun createUser(email: String, password: String) {
        fds.createUser(email, password)
    }

    override suspend fun singInUser(email: String, password: String) {
        fds.signInUser(email, password)
    }


}