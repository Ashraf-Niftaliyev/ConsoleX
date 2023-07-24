package com.esrefnifteliyev.consolex.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("user_table")
data class UserModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String,
    var email: String,
    val password: String
)