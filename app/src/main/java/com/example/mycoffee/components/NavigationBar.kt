package com.example.mycoffee.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mycoffee.R
import com.example.mycoffee.system.Screen
import com.example.mycoffee.ui.theme.Light
import com.example.mycoffee.ui.theme.Main
import com.example.mycoffee.ui.theme.Secondary

sealed class BottomNavScreens(
    val route: String,
    val title: String,
    val icon: Int
) {
    object Stock : BottomNavScreens(Screen.Stock.route, "Главная", R.drawable.home_24)
    object CoffeeList : BottomNavScreens(Screen.CoffeeList.route, "Поиск", R.drawable.seacrh_24)
    object Profile : BottomNavScreens(Screen.Profile.route, "Профиль", R.drawable.profile_24)
}

@Composable
fun NavigationMenu(navController: NavController) {
    val items = listOf(
        BottomNavScreens.Stock,
        BottomNavScreens.CoffeeList,
        BottomNavScreens.Profile
    )

    NavigationBar(
        containerColor = Light,
        contentColor = Secondary
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        items.forEach { screen ->
            NavigationBarItem (
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Secondary,
                    selectedTextColor = Secondary,
                    indicatorColor = Main,
                    unselectedIconColor = Secondary,
                    unselectedTextColor = Secondary
                ),
                icon = { Icon(painter = painterResource(screen.icon), contentDescription = "navbar icon") },
                label = { Text(screen.title) },
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}