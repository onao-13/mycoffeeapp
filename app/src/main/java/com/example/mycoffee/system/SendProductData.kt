package com.example.mycoffee.system

import android.util.Log

class SendProductData<T>(t: T) {
    private var product: T = t

    fun sendProductData(product: T) {
        this.product = product
        Log.d("sendProductData", product.toString())
    }

    fun getProductData(): T {
        Log.d("getProductData", product.toString())
        return product
    }
}