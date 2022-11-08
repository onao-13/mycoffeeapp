package com.example.mycoffee.repository

import com.example.mycoffee.dao.ProductDAO
import com.example.mycoffee.model.Product
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductRepository @Inject constructor(private val productDAO: ProductDAO) {
    fun getAllProducts(): Flow<List<Product>> = productDAO.getAllProducts()
    suspend fun getProductById(id: Int): Product = productDAO.getProductById(id)
    suspend fun getCoffeeByName(coffeeName: String): Product = productDAO.getCoffeeByName(coffeeName)
}