package com.esrefnifteliyev.consolex.data.source

import com.esrefnifteliyev.consolex.data.local.LocalDao
import com.esrefnifteliyev.consolex.data.local.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalDataSource(private val dao: LocalDao) {

    suspend fun getAllUsers() : List<UserModel> = withContext(Dispatchers.IO){
       dao.getAllUsers()
    }

    suspend fun getAllUsersByEmail(email: String,password: String) : List<UserModel> = withContext(Dispatchers.IO){
        dao.getAllUsersByEmail(email,password)
    }

    suspend fun insertUser(userModel: UserModel) = withContext(Dispatchers.IO){
        dao.insertUser(userModel)
    }

    suspend fun deleteUser(userModel: UserModel) = withContext(Dispatchers.IO){
        dao.deleteUser(userModel)
    }

}