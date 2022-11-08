package com.example.mycoffee.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mycoffee.dao.ProductDAO
import com.example.mycoffee.model.Product

@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class ProductDatabase: RoomDatabase() {
    abstract fun productDAO(): ProductDAO
}