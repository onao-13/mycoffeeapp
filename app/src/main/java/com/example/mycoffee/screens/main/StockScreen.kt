package com.example.mycoffee.screens.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
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
    Scaffold(
        topBar = { SearchBagNotificationTopBar() },
        containerColor = BackgroundColor,
        bottomBar = { NavigationMenu(navController) }
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .padding(top = 20.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Title("Горячие предложения")
            }
            item {
                BannerRow(Modifier.padding(start = 14.dp, end = 14.dp), 6)
            }
            item {
                Title("Популярное у нас")
            }
            item {
                CoffeeCardRow(Modifier.padding(start = 14.dp, end = 14.dp), 4)
            }
            item {
                Title("Попробуй так же")
            }
            items(6) {
                MiniCoffeeCardsColumn()
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
                    ), 4)
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