package com.example.mycoffee.system

sealed class Screen(
    val route: String
) {
    object Start : Screen("Start")
    object Registration : Screen("Registration")
    object Login : Screen("Login")
    object Stock : Screen("Stock")
    object CoffeeList : Screen("Coffee List")
    object Profile : Screen("Profile")
    object CoffeeDetail : Screen("CoffeeDetail/{id}") {
        fun id(id: Int = 0): String {
            return this.route.replace("{id}", id.toString())
        }
    }
    object Basket : Screen("Basket")
    object Notifications : Screen("Notification")
    object Refunds : Screen("Refunds")
    object Orders : Screen("Orders")
    object Settings : Screen("Settings")
    object ProfileDetail : Screen("ProfileDetail")
    object EditingName : Screen("EditingName")
    object EditingPassword : Screen("EditingPassword")
}