package com.example.mycoffee.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mycoffee.dao.BasketDAO
import com.example.mycoffee.model.BasketProduct

@Database(entities = [BasketProduct::class], version = 1, exportSchema = false)
abstract class BasketDatabase: RoomDatabase() {
    abstract fun basketDAO(): BasketDAO
}