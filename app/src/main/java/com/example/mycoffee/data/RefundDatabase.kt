package com.example.mycoffee.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mycoffee.dao.RefundDAO
import com.example.mycoffee.model.Refund

@Database(entities = [Refund::class], version = 1, exportSchema = false)
abstract class RefundDatabase: RoomDatabase() {
    abstract fun refundDAO(): RefundDAO
}