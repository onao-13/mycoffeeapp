package com.example.mycoffee.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mycoffee.dao.OrderDAO
import com.example.mycoffee.model.Order

@Database(entities = [Order::class], version = 1, exportSchema = false)
abstract class OrderDatabase: RoomDatabase() {
    abstract fun orderDAO(): OrderDAO
}