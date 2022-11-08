package com.example.mycoffee.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orders")
data class Order(

    @PrimaryKey
    val id: Int,
    val price: Int,
    val status: String
)