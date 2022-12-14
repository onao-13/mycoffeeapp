package com.example.mycoffee.screens.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import com.example.mycoffee.components.*
import com.example.mycoffee.ui.theme.BackgroundColor
import com.example.mycoffee.ui.theme.MyCoffeeTheme

class CoffeeListActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { 
            val navController = rememberNavController()
            CoffeeListScreen(navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoffeeListScreen(navController: NavController) {
    Scaffold(
        topBar = { SearchTopBar() },
        containerColor = BackgroundColor,
        bottomBar = { NavigationMenu(navController) }
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(it),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Title(
                    "Виды кофе",
                    Modifier.padding(
                        start = 14.dp,
                        top = 20.dp
                    )
                )
            }
            items(6) {
                CoffeeTypesColumn()
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    MyCoffeeTheme {
        val navController = rememberNavController()
        CoffeeListScreen(navController)
    }
}