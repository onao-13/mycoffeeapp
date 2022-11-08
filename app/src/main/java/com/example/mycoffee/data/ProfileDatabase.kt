package com.example.mycoffee.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mycoffee.dao.ProfileDAO
import com.example.mycoffee.model.Profile

@Database(entities = [Profile::class], version = 1, exportSchema = false)
abstract class ProfileDatabase: RoomDatabase() {
    abstract fun profileDAO(): ProfileDAO
}