package com.example.mycoffee.screens.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mycoffee.components.*
import com.example.mycoffee.ui.theme.BackgroundColor
import com.example.mycoffee.ui.theme.MyCoffeeTheme

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
fun StockScreen(navController: NavController) {
    val showBuyingPanel = remember { mutableStateOf(false) }

    var panelHeight by remember { mutableStateOf(0.55f) }
    if (panelHeight >= 0.55f) panelHeight = 0.55f
    if (panelHeight <= 0.05f) showBuyingPanel.value = false
    val height = if (panelHeight <= 0.55f) panelHeight else 0.55f

    Scaffold(
        topBar = { SearchBagNotificationTopBar(navController) },
        containerColor = BackgroundColor,
        bottomBar = {
            if (!showBuyingPanel.value) {
                panelHeight = 0.55f

                NavigationMenu(navController)
            } else {
                BuyingPanel(
                    navController,
                    rememberScrollableState { delta ->
                        panelHeight -= delta / 2000f
                        delta
                    },
                    height
                )
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
                CoffeeCardRow(
                    Modifier.padding(start = 14.dp, end = 14.dp),
                    4,
                    navController
                ) {
                    showBuyingPanel.value = true
                }
            }
            item {
                Title("Попробуй так же")
            }
            items(6) {
                MiniCoffeeCardsColumn(
                    navController = navController
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
                    4
                )
            }
        }
    }
}

@Preview(widthDp = 400, heightDp = 1300)
@Composable
private fun StockScreenPreview() {
    MyCoffeeTheme {
        val navController = rememberNavController()
        StockScreen(navController)
    }
}