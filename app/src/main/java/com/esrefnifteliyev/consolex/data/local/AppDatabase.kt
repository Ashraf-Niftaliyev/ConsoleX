package com.esrefnifteliyev.consolex.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.esrefnifteliyev.consolex.data.local.model.UserModel

@Database(entities = [UserModel::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun getDao(): LocalDao
}