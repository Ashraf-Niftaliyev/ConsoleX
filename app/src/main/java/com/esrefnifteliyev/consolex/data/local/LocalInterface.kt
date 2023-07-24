package com.esrefnifteliyev.consolex.data.local

import com.esrefnifteliyev.consolex.data.local.model.UserModel

interface LocalInterface {

    suspend fun getAllUsers() : List<UserModel>

    suspend fun getAllUsersByEmail(email: String,password: String) : List<UserModel>

    suspend fun insertUser(userModel: UserModel)

    suspend fun deleteUser(userModel: UserModel)

}