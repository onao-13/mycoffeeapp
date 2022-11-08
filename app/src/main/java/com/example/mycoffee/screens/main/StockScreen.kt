package com.example.mycoffee.screens.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import com.example.mycoffee.components.*
import com.example.mycoffee.model.Product
import com.example.mycoffee.system.Screen
import com.example.mycoffee.system.SendProductData
import com.example.mycoffee.ui.theme.BackgroundColor
import com.example.mycoffee.ui.theme.MyCoffeeTheme
import com.example.mycoffee.viewmodel.BasketViewModel
import com.example.mycoffee.viewmodel.OrderViewModel
import com.example.mycoffee.viewmodel.ProductViewModel

class StockActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCoffeeTheme {
                val navController = rememberNavController()
                StockScreen(navController)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StockScreen(
    navController: NavController,
    productViewModel: ProductViewModel = viewModel(),
    orderViewModel: OrderViewModel = viewModel(),
    basketViewModel: BasketViewModel = viewModel()
) {
    // Panel params
    val showBuyingPanel = remember { mutableStateOf(false) }

    var panelHeight by remember { mutableStateOf(0.55f) }
    if (panelHeight >= 0.55f) panelHeight = 0.55f
    if (panelHeight <= 0.05f) showBuyingPanel.value = false
    val height = if (panelHeight <= 0.55f) panelHeight else 0.55f

    // Product list
    val productData = productViewModel.productList.collectAsState().value
    val orderData = orderViewModel.orderList.collectAsState().value

    val productManager = SendProductData<Product>(Product(0, "", 0, ""))

    //Basket count
    val count = basketViewModel.productsCountInBasket.collectAsState().value

    Scaffold(
        topBar = { SearchBagNotificationTopBar(navController, count) },
        containerColor = BackgroundColor,
        bottomBar = {
            if (!showBuyingPanel.value) {
                panelHeight = 0.55f

                NavigationMenu(navController)
            } else {
                BuyingPanel(
                    rememberScrollableState { delta ->
                        panelHeight -= delta / 2000f
                        delta
                    },
                    height,
                    productManager.getProductData(),
                    basketViewModel
                ) {
                    showBuyingPanel.value = false
                }
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Title(
                    "Горячие предложения",
                    Modifier.padding(top = 20.dp)
                )
            }
            item {
                BannerRow(
                    Modifier.padding(start = 14.dp, end = 14.dp),
                    6,
                    navController
                )
            }
            item {
                Title("Популярное у нас")
            }
            item {
                LazyRow(
                    modifier = Modifier.padding(start = 14.dp, end = 14.dp),
                    horizontalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    items(productData) { product ->
                        CoffeeCard(
                            openBuyingPanel = {
                                productManager.sendProductData(product)
                                showBuyingPanel.value = true
                            },
                            name = product.name,
                            description = product.description
                        ) {
                            navController.navigate(Screen.CoffeeDetail.id(product.id)) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                }
            }
            item {
                Title("Попробуй так же")
            }
            items(productData) { product ->
                MiniCoffeeCardsColumn(
                    navController, product
                ) {
                    showBuyingPanel.value = true
                }
            }
            item {
                Title("Твои заказы")
            }
            item {
                OrderCardRow(
                    Modifier.padding(
                        start = 14.dp,
                        bottom = 20.dp,
                        end = 14.dp
                    ),
                    orderData
                )
            }
        }
    }
}