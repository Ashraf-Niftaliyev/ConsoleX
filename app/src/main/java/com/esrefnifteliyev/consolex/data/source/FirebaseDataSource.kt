package com.esrefnifteliyev.consolex.data.source

import com.esrefnifteliyev.consolex.data.firebase.FirebaseInterface
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class FirebaseDataSource(
    private val auth: FirebaseAuth
)  {


    
    suspend fun createUser(email:String,password:String,
       onSuccess: () -> Unit , onFail: (Exception) -> Unit,) = withContext(Dispatchers.IO){
        auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener {
                onSuccess()
        }.addOnFailureListener { exception ->
                onFail(exception)
        }
    }

    suspend fun signInUser(email:String,password:String,
      onSuccess: () -> Unit , onFail: (Exception) -> Unit,) = withContext(Dispatchers.IO){
        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
            onSuccess()
        }.addOnFailureListener { exception ->
            onFail(exception)
        }
    }

}