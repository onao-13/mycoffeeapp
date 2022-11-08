package com.example.mycoffee.screens.topbar

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mycoffee.components.*
import com.example.mycoffee.model.BasketProduct
import com.example.mycoffee.system.SendProductData
import com.example.mycoffee.ui.theme.BackgroundColor
import com.example.mycoffee.ui.theme.Secondary
import com.example.mycoffee.viewmodel.BasketViewModel

class BasketActivity(): ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            BasketScreen(navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasketScreen(
    navController: NavController,
    basketViewModel: BasketViewModel = viewModel()
) {

    val basketData = basketViewModel.basketList.collectAsState().value
    var totalPrice = 0
    basketData.forEach { totalPrice += it.price }

    Scaffold(
        topBar = { SecondaryTopBar("Моя корзина", navController) },
        bottomBar = {
            SecondaryBottomBar("Оформить заказ", navController)
        },
        containerColor = BackgroundColor,
        contentColor = Secondary
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Basket(
                modifier = Modifier.padding(top = 60.dp),
                basketProductData = basketData,
            ) { product ->
                basketViewModel.removeFromBasket(product)
            }
            Divider(
                Modifier.fillMaxWidth(0.3f),
                2.dp,
                Color.Black
            )
            TotalPriceBar(totalPrice)
        }
    }
}