package com.example.mycoffee.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycoffee.model.BasketProduct
import com.example.mycoffee.repository.BasketRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BasketViewModel @Inject constructor(private val repository: BasketRepository): ViewModel() {
    private val _basketProductList = MutableStateFlow<List<BasketProduct>>(emptyList())
    val basketList = _basketProductList.asStateFlow()

    private var _count = MutableStateFlow<Int>(0)
    val productsCountInBasket = _count.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllProductsInBasket().distinctUntilChanged()
                .collect { list ->
                    _basketProductList.value = list
                    _count.value += 1
                }
        }
    }

    fun getAllProducts() = viewModelScope.launch { repository.getAllProductsInBasket() }
    fun addToBasket(product: BasketProduct) = viewModelScope.launch { repository.addToBasket(product) }
    fun removeFromBasket(product: BasketProduct) = viewModelScope.launch { repository.removeProductFromBasket(product) }
}