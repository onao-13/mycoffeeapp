package com.example.mycoffee.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycoffee.model.Product
import com.example.mycoffee.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val repository: ProductRepository): ViewModel() {
    private val _productList = MutableStateFlow<List<Product>>(emptyList())
    val productList = _productList.asStateFlow()


    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllProducts().distinctUntilChanged()
                .collect { list ->
                    _productList.value = list
                }
        }
    }

    fun searchCoffeeByName(coffeeName: String) = viewModelScope.launch { repository.getCoffeeByName(coffeeName) }
    fun getAllProducts() = viewModelScope.launch { repository.getAllProducts() }
}