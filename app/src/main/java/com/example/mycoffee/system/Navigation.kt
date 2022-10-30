package com.example.mycoffee.system

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mycoffee.screens.buying.CoffeeDetailScreen
import com.example.mycoffee.screens.editing.EditNameScreen
import com.example.mycoffee.screens.editing.EditPasswordScreen
import com.example.mycoffee.screens.main.CoffeeListScreen
import com.example.mycoffee.screens.main.ProfileScreen
import com.example.mycoffee.screens.main.StockScreen
import com.example.mycoffee.screens.profile_categories.*
import com.example.mycoffee.screens.topbar.BasketScreen
import com.example.mycoffee.screens.topbar.NotificationsScreen
import com.example.mycoffee.screens.starter.HelloScreen
import com.example.mycoffee.screens.starter.LoginScreen
import com.example.mycoffee.screens.starter.RegistrationScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, Screen.Stock.route) {
        composable(Screen.Start.route) { HelloScreen(navController) }
        composable(Screen.Registration.route) { RegistrationScreen(navController) }
        composable(Screen.Login.route) { LoginScreen(navController) }
        composable(Screen.Stock.route) { StockScreen(navController) }
        composable(Screen.CoffeeList.route) { CoffeeListScreen(navController) }
        composable(Screen.Profile.route) { ProfileScreen(navController) }
        composable(Screen.CoffeeDetail.route) { CoffeeDetailScreen(navController) }
        composable(Screen.Basket.route) { BasketScreen(navController) }
        composable(Screen.Notifications.route) { NotificationsScreen(navController) }
        composable(Screen.Refunds.route) { RefundsScreen(navController) }
        composable(Screen.Orders.route) { OrdersScreen(navController) }
        composable(Screen.Settings.route) { SettingsScreen(navController) }
        composable(Screen.Favorites.route) { FavoritesScreen(navController) }
        composable(Screen.ProfileDetail.route) { ProfileDetailScreen(navController) }
        composable(Screen.EditingName.route) { EditNameScreen(navController) }
        composable(Screen.EditingPassword.route) { EditPasswordScreen(navController) }
    }
}