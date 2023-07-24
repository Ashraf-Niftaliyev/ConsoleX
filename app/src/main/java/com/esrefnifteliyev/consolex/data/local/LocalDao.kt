package com.esrefnifteliyev.consolex.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.esrefnifteliyev.consolex.data.local.model.UserModel

@Dao
interface LocalDao {

    @Query("SELECT * FROM user_table")
    suspend fun getAllUsers() : List<UserModel>

    @Query("SELECT * FROM user_table WHERE email= :e and password= :p")
    suspend fun getAllUsersByEmail(e: String,p: String) : List<UserModel>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(user: UserModel)

    @Delete
    suspend fun deleteUser(user: UserModel)

}