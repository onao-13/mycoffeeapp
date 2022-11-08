package com.example.mycoffee.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "refunds")
data class Refund(

    @PrimaryKey
    val id: Int,

    @ColumnInfo(name = "data")
    val data: String,

    @ColumnInfo(name = "price")
    val price: Int,
)
