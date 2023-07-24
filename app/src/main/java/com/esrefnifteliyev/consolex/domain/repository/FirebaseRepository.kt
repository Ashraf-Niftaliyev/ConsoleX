package com.esrefnifteliyev.consolex.domain.repository

import com.esrefnifteliyev.consolex.data.firebase.FirebaseInterface
import com.esrefnifteliyev.consolex.data.source.FirebaseDataSource
import com.google.firebase.auth.FirebaseAuth


class FirebaseRepository(private val fds: FirebaseDataSource) : FirebaseInterface{

    override suspend fun createUser(email: String, password: String,onSuccess: () -> Unit , onFail: (Exception) -> Unit,) {
        fds.createUser(email, password,onSuccess,onFail)
    }

    override suspend fun singInUser(email: String, password: String,onSuccess: () -> Unit , onFail: (Exception) -> Unit,) {
        fds.signInUser(email, password,onSuccess,onFail)
    }


}