package com.example.mycoffee.repository

import com.example.mycoffee.dao.BasketDAO
import com.example.mycoffee.model.BasketProduct
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BasketRepository @Inject constructor(private val basketDAO: BasketDAO) {
    fun getAllProductsInBasket(): Flow<List<BasketProduct>> = basketDAO.getAllProductsInBasket()
    suspend fun addToBasket(product: BasketProduct) = basketDAO.addToBasket(product)
    suspend fun removeProductFromBasket(product: BasketProduct) = basketDAO.removeProductFromBasket(product)
}