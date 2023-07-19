package com.esrefnifteliyev.consolex.data.source

import com.esrefnifteliyev.consolex.data.firebase.FirebaseInterface
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class FirebaseDataSource(
    private val auth: FirebaseAuth
)  {

    suspend fun createUser(email:String,password:String) = withContext(Dispatchers.IO){
        auth.createUserWithEmailAndPassword(email,password)
    }

    suspend fun signInUser(email:String,password:String) = withContext(Dispatchers.IO){
        auth.signInWithEmailAndPassword(email, password)
    }

}