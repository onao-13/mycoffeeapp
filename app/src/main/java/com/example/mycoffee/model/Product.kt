package com.example.mycoffee.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product(

    @PrimaryKey
    val id: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "price")
    val price: Int,

    /* TODO: ADD COFFEE CATEGORY */
//    @ColumnInfo(name = "category")
//    val category: CoffeeCategory,

    @ColumnInfo(name = "description")
    val description: String
)