package com.example.mycoffee.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.mycoffee.model.Refund
import kotlinx.coroutines.flow.Flow

@Dao
interface RefundDAO {

    @Query("SELECT * FROM refunds")
    fun getAllProducts(): Flow<List<Refund>>
}