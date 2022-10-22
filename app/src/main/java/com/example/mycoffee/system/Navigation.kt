package com.example.mycoffee.system

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mycoffee.screens.main.CoffeeListScreen
import com.example.mycoffee.screens.main.ProfileScreen
import com.example.mycoffee.screens.main.StockScreen
import com.example.mycoffee.screens.starter.HelloScreen
import com.example.mycoffee.screens.starter.LoginScreen
import com.example.mycoffee.screens.starter.RegistrationScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, Screen.Start.toString()) {
        composable(Screen.Start.toString()) { HelloScreen(navController) }
        composable(Screen.Registration.toString()) { RegistrationScreen(navController) }
        composable(Screen.Login.toString()) { LoginScreen(navController) }
        composable(Screen.Stock.toString()) { StockScreen(navController) }
        composable(Screen.CoffeeList.toString()) { CoffeeListScreen(navController) }
        composable(Screen.Profile.toString()) { ProfileScreen(navController) }
    }
}