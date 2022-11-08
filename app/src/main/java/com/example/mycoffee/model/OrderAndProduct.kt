package com.example.mycoffee.model

import androidx.room.Embedded
import androidx.room.Relation

data class OrderAndProduct(

    @Embedded
    val order: Order,

    @Relation(
        parentColumn = "id",
        entityColumn = "id"
    )
    val products: ProductOrder
)