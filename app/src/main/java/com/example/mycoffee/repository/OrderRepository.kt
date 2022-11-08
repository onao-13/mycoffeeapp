package com.example.mycoffee.repository

import com.example.mycoffee.dao.OrderDAO
import com.example.mycoffee.model.Order
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OrderRepository @Inject constructor(private val orderDAO: OrderDAO) {
    fun getAllOrders(): Flow<List<Order>> = orderDAO.getAllOrders()
    suspend fun getOrderById(id: Int): Order = orderDAO.getOrderById(id)
}