package com.example.mycoffee.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mycoffee.model.BasketProduct
import kotlinx.coroutines.flow.Flow

@Dao
interface BasketDAO {

    @Query("SELECT * FROM basket")
    fun getAllProductsInBasket(): Flow<List<BasketProduct>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToBasket(product: BasketProduct)

    @Delete
    suspend fun removeProductFromBasket(product: BasketProduct)
}
