package com.example.mycoffee.screens.topbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mycoffee.components.*
import com.example.mycoffee.ui.theme.BackgroundColor
import com.example.mycoffee.ui.theme.MyCoffeeTheme
import com.example.mycoffee.ui.theme.Secondary

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
fun BasketScreen(navController: NavController) {
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
            Basket(Modifier.padding(top = 60.dp))
            Divider(
                Modifier.fillMaxWidth(0.3f),
                2.dp,
                Color.Black
            )
            TotalPriceBar()
        }
    }
}

@Preview(widthDp = 375, heightDp = 812)
@Composable
private fun Preview() {
    MyCoffeeTheme {
        val navController = rememberNavController()
        BasketScreen(navController)
    }
}