package com.example.mycoffee.screens.profile_categories

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mycoffee.components.OrderCard
import com.example.mycoffee.components.SecondaryTopBar
import com.example.mycoffee.ui.theme.Light
import com.example.mycoffee.ui.theme.MyCoffeeTheme
import com.example.mycoffee.ui.theme.Secondary

class OrdersActivity(): ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            OrdersScreen(navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrdersScreen(navController: NavController) {
    Scaffold(
        topBar = {
            SecondaryTopBar(
            "Мои заказы",
                navController
            )
        },
        contentColor = Secondary,
        containerColor = Light
    ) {
        LazyColumn(
            modifier = Modifier.padding(it),
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            item {
                Spacer(Modifier.padding(top = 10.dp))
            }
            items(6) {
                OrderCard(
                    "Кофе",
                    "145",
                    "Тип кофе"
                )
            }
        }
    }
}

@Preview(widthDp = 375, heightDp = 812)
@Composable
private fun Preview() {
    MyCoffeeTheme {
        val navController = rememberNavController()
        OrdersScreen(navController)
    }
}