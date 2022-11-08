package com.example.mycoffee.system

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.mycoffee.screens.buying.CoffeeDetailScreen
import com.example.mycoffee.screens.editing.EditNameScreen
import com.example.mycoffee.screens.editing.EditPasswordScreen
import com.example.mycoffee.screens.main.CoffeeListScreen
import com.example.mycoffee.screens.main.ProfileScreen
import com.example.mycoffee.screens.main.StockScreen
import com.example.mycoffee.screens.profilecategories.*
import com.example.mycoffee.screens.topbar.BasketScreen
import com.example.mycoffee.screens.topbar.NotificationsScreen
import com.example.mycoffee.screens.starter.HelloScreen
import com.example.mycoffee.screens.starter.LoginScreen
import com.example.mycoffee.screens.starter.RegistrationScreen
import com.example.mycoffee.viewmodel.*

@Composable
fun Navigation(
    startScreen: String,
    navController: NavHostController,
    productViewModel: ProductViewModel,
    orderViewModel: OrderViewModel,
    basketViewModel: BasketViewModel,
    refundViewModel: RefundViewModel,
    profileViewModel: ProfileViewModel
) {
    NavHost(navController, startScreen) {
        composable(Screen.Start.route) { HelloScreen(navController) }
        composable(Screen.Registration.route) { RegistrationScreen(navController, profileViewModel) }
        composable(Screen.Login.route) { LoginScreen(navController, profileViewModel) }
        composable(Screen.Stock.route) {
            StockScreen(
                navController,
                productViewModel,
                orderViewModel,
                basketViewModel
            )
        }
        composable(Screen.CoffeeList.route) { CoffeeListScreen(navController) }
        composable(Screen.Profile.route) { ProfileScreen(
            navController,
            profileViewModel,
            basketViewModel
        ) }
        composable(route = Screen.CoffeeDetail.route,
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) {
            CoffeeDetailScreen(
                navController,
                it.arguments?.getInt("id")!!.toInt(),
                basketViewModel,
                productViewModel
            )
        }
        composable(Screen.Basket.route) { BasketScreen(navController, basketViewModel) }
        composable(Screen.Notifications.route) { NotificationsScreen(navController) }
        composable(Screen.Refunds.route) { RefundsScreen(navController, refundViewModel) }
        composable(Screen.Orders.route) { OrdersScreen(navController, orderViewModel) }
        composable(Screen.Settings.route) { SettingsScreen(navController) }
        composable(Screen.ProfileDetail.route) { ProfileDetailScreen(navController, profileViewModel) }
        composable(Screen.EditingName.route) { EditNameScreen(navController, profileViewModel) }
        composable(Screen.EditingPassword.route) { EditPasswordScreen(navController, profileViewModel) }
    }
}