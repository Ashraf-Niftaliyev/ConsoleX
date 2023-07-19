package com.esrefnifteliyev.consolex.viewmodel

import androidx.lifecycle.viewModelScope
import com.esrefnifteliyev.consolex.data.firebase.FirebaseInterface
import com.esrefnifteliyev.consolex.domain.repository.FirebaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val firebaseRepo : FirebaseInterface
) : BaseViewModel() {


     fun createUser(email:String,password:String){
        viewModelScope.launch {
            firebaseRepo.createUser(email, password)
        }
    }

    fun signIn(email:String,password:String){
        viewModelScope.launch {
            firebaseRepo.singInUser(email,password)
        }
    }

}