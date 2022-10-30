package com.example.mycoffee.screens.profile_categories

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.example.mycoffee.components.CoffeeTypesColumn
import com.example.mycoffee.components.SecondaryTopBar
import com.example.mycoffee.ui.theme.BackgroundColor
import com.example.mycoffee.ui.theme.MyCoffeeTheme
import com.example.mycoffee.ui.theme.Secondary

class FavoritesActivity(): ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            FavoritesScreen(navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoritesScreen(navController: NavController) {
    Scaffold(
        topBar = { SecondaryTopBar("Избранное", navController) },
        containerColor = BackgroundColor,
        contentColor = Secondary
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .padding(top = 20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(6) {
                CoffeeTypesColumn()
            }
        }
    }
}

@Preview(widthDp = 375, heightDp = 812)
@Composable
private fun Preview() {
    MyCoffeeTheme {
        val navController = rememberNavController()
        FavoritesScreen(navController)
    }
}