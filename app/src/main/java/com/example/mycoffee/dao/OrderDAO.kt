package com.example.mycoffee.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.mycoffee.model.Order
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderDAO {

    @Query("SELECT * FROM orders")
    fun getAllOrders(): Flow<List<Order>>

    @Query("SELECT * FROM orders WHERE id = :id")
    suspend fun getOrderById(id: Int): Order
}