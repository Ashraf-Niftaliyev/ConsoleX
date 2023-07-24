package com.esrefnifteliyev.consolex.domain.repository

import com.esrefnifteliyev.consolex.data.local.LocalInterface
import com.esrefnifteliyev.consolex.data.local.model.UserModel
import com.esrefnifteliyev.consolex.data.source.LocalDataSource
import com.google.firebase.firestore.auth.User
import kotlinx.coroutines.withContext

class LocalRepository(private val ds: LocalDataSource) : LocalInterface {

    override suspend fun getAllUsers(): List<UserModel> =
        ds.getAllUsers()


    override suspend fun getAllUsersByEmail(email: String, password: String): List<UserModel> =
        ds.getAllUsersByEmail(email, password)


    override suspend fun insertUser(userModel: UserModel) =
        ds.insertUser(userModel)


    override suspend fun deleteUser(userModel: UserModel) =
        ds.deleteUser(userModel)


}