package com.example.mycoffee.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.mycoffee.model.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDAO {

    @Query("SELECT * FROM products")
    fun getAllProducts(): Flow<List<Product>>

    @Query("SELECT * FROM products WHERE id = :id")
    suspend fun getProductById(id: Int): Product

    @Query("SELECT * FROM products WHERE name = :coffeeName")
    suspend fun getCoffeeByName(coffeeName: String): Product
}