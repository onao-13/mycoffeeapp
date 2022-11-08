package com.example.mycoffee

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.mycoffee.model.Profile
import com.example.mycoffee.system.Navigation
import com.example.mycoffee.system.Screen
import com.example.mycoffee.ui.theme.MyCoffeeTheme
import com.example.mycoffee.viewmodel.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCoffeeTheme {
                val navController = rememberNavController()
                val productViewModel = viewModel<ProductViewModel>()
                val orderViewModel = viewModel<OrderViewModel>()
                val basketViewModel = viewModel<BasketViewModel>()
                val refundViewModel = viewModel<RefundViewModel>()
                val profileViewModel = viewModel<ProfileViewModel>()

                val profile = profileViewModel.profile.collectAsState().value

                var startScreen = ""

                Log.d("Login", profile.number)

                startScreen = if (profile.number == "" && profile.password == "") {
                    Screen.Start.route
                } else {
                    Screen.Stock.route
                }

                Navigation(
                    startScreen,
                    navController,
                    productViewModel,
                    orderViewModel,
                    basketViewModel,
                    refundViewModel,
                    profileViewModel
                )
            }
        }
    }
}