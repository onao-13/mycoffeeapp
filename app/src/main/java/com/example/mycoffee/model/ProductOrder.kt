package com.example.mycoffee.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_order")
data class ProductOrder(

    @PrimaryKey
    val id: Int,
    val name: String,

    @ColumnInfo(name = "order_id")
    val orderId: Int
)