package com.example.mycoffee.di

import android.content.Context
import androidx.room.Room
import com.example.mycoffee.dao.*
import com.example.mycoffee.data.*
import com.example.mycoffee.model.Refund
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object Database {

    //Product
    @Singleton
    @Provides
    fun productDAO(productDatabase: ProductDatabase): ProductDAO
        = productDatabase.productDAO()

    @Singleton
    @Provides
    fun productDB(@ApplicationContext context: Context): ProductDatabase
        = Room.databaseBuilder(
            context,
            ProductDatabase::class.java,
            "products"
        )
        .fallbackToDestructiveMigration()
        .build()

    //Order
    @Singleton
    @Provides
    fun orderDAO(orderDatabase: OrderDatabase): OrderDAO
        = orderDatabase.orderDAO()

    @Singleton
    @Provides
    fun orderDB(@ApplicationContext context: Context): OrderDatabase
        = Room.databaseBuilder(
            context,
            OrderDatabase::class.java,
            "orders"
        )
        .fallbackToDestructiveMigration()
        .build()

    //Basket
    @Singleton
    @Provides
    fun basketDAO(basketDatabase: BasketDatabase): BasketDAO
        = basketDatabase.basketDAO()

    @Singleton
    @Provides
    fun basketDB(@ApplicationContext context: Context): BasketDatabase
        = Room.databaseBuilder(
            context,
            BasketDatabase::class.java,
            "basket"
        )
        .fallbackToDestructiveMigration()
        .build()

    //Refund
    @Singleton
    @Provides
    fun refundDAO(refundDatabase: RefundDatabase): RefundDAO
        = refundDatabase.refundDAO()


    @Singleton
    @Provides
    fun refundDB(@ApplicationContext context: Context): RefundDatabase
        = Room.databaseBuilder(
            context,
            RefundDatabase::class.java,
            "refunds"
        )
        .fallbackToDestructiveMigration()
        .build()

    //Profile
    @Singleton
    @Provides
    fun profileDAO(profileDatabase: ProfileDatabase): ProfileDAO
        = profileDatabase.profileDAO()

    @Singleton
    @Provides
    fun profileDB(@ApplicationContext context: Context): ProfileDatabase
        = Room.databaseBuilder(
            context,
            ProfileDatabase::class.java,
            "profile"
        )
        .fallbackToDestructiveMigration()
        .build()
}