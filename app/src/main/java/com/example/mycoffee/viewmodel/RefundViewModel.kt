package com.example.mycoffee.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycoffee.model.Refund
import com.example.mycoffee.repository.RefundRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RefundViewModel @Inject constructor(private val repository: RefundRepository): ViewModel() {
    private val _refundList = MutableStateFlow<List<Refund>>(emptyList())
    val refundList = _refundList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllRefunds().distinctUntilChanged()
                .collect { list ->
                    _refundList.value = list
                }
        }
    }

    fun getAllRefunds() = viewModelScope.launch { repository.getAllRefunds() }
}