package com.esrefnifteliyev.consolex.data.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

interface FirebaseInterface{

 suspend fun createUser(email : String, password: String)


 suspend fun singInUser(email: String,password: String)


}