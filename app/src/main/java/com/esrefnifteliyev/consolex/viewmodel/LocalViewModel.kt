package com.esrefnifteliyev.consolex.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.esrefnifteliyev.consolex.data.local.LocalInterface
import com.esrefnifteliyev.consolex.data.local.model.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocalViewModel @Inject constructor(
   private val localRepo: LocalInterface
): BaseViewModel(){

    private val _userLiveData = MutableLiveData<List<UserModel>>()
    val userLiveData get() = _userLiveData


    fun getAllData(email: String,password: String){
        viewModelScope.launch {
          _userLiveData.value = localRepo.getAllUsersByEmail(email, password)
        }
    }

    fun insertData(userModel: UserModel){
        viewModelScope.launch {
            localRepo.insertUser(userModel)
        }
    }

    fun deleteData(userModel: UserModel){
        viewModelScope.launch {
            localRepo.deleteUser(userModel)
        }
    }

}