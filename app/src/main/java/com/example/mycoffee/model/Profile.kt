package com.example.mycoffee.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profile")
data class Profile(

    @PrimaryKey
    val id: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "number")
    val number: String,

    @ColumnInfo(name = "password")
    val password: String
)