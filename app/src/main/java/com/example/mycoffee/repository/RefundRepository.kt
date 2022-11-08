package com.example.mycoffee.repository

import com.example.mycoffee.dao.RefundDAO
import com.example.mycoffee.model.Refund
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RefundRepository @Inject constructor(private val refundDAO: RefundDAO) {
    fun getAllRefunds(): Flow<List<Refund>> = refundDAO.getAllProducts()
}