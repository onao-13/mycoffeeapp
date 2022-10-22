package com.example.mycoffee.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mycoffee.R
import com.example.mycoffee.screens.main.CoffeeListScreen
import com.example.mycoffee.screens.main.ProfileScreen
import com.example.mycoffee.screens.main.StockScreen
import com.example.mycoffee.system.Screen
import com.example.mycoffee.ui.theme.Light

sealed class BottomNavScreens(
    val route: String,
    val title: String,
    val icon: Int
) {
    object Stock : BottomNavScreens(Screen.Stock.toString(), "Главная", R.drawable.home_24)
    object CoffeeList : BottomNavScreens(Screen.CoffeeList.toString(), "Поиск", R.drawable.seacrh_24)
    object Profile : BottomNavScreens(Screen.Profile.toString(), "Профиль", R.drawable.profile_24)
}

@Composable
fun NavigationMenu(navController: NavController) {
    val items = listOf(
        BottomNavScreens.Stock,
        BottomNavScreens.CoffeeList,
        BottomNavScreens.Profile
    )

    NavigationBar(containerColor = Light) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        items.forEach { screen ->
            NavigationBarItem (
                icon = { Icon(painter = painterResource(screen.icon), contentDescription = "navbar icon") },
                label = { Text(screen.title) },
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route)
                }
            )
        }
    }
}