package com.example.mycoffee.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycoffee.model.Order
import com.example.mycoffee.repository.OrderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(private val repository: OrderRepository): ViewModel() {
    private val _orderList = MutableStateFlow<List<Order>>(emptyList())
    val orderList = _orderList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllOrders().distinctUntilChanged()
                .collect { list ->
                    _orderList.value = list
                }
        }
    }

    fun getProductById(id: Int) = viewModelScope.launch { repository.getOrderById(id) }
}