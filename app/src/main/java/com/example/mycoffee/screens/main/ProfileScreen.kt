package com.example.mycoffee.screens.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mycoffee.components.*
import com.example.mycoffee.ui.theme.BackgroundColor
import com.example.mycoffee.ui.theme.MyCoffeeTheme
import com.example.mycoffee.viewmodel.BasketViewModel
import com.example.mycoffee.viewmodel.ProfileViewModel

class ProfileActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCoffeeTheme {
                val navController = rememberNavController()
                ProfileScreen(navController)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navController: NavController,
    profileViewModel: ProfileViewModel = viewModel(),
    basketViewModel: BasketViewModel = viewModel()
) {
    val profile = profileViewModel.profile.collectAsState().value

    //Basket count
    val count = basketViewModel.productsCountInBasket.collectAsState().value

    Scaffold(
        topBar = { SearchBagNotificationTopBar(navController, count) },
        containerColor = BackgroundColor,
        bottomBar = { NavigationMenu(navController) }
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                ProfilePreview(profile.name)
            }
            item {
                Menu(navController)
            }
            item {
                Divider(
                    modifier = Modifier.fillMaxWidth(0.4f),
                    thickness = 2.dp,
                    color = Color.Black
                )
            }
            item {
                Settings(navController)
            }
            item {
                MainFocusButton(
                    buttonTitle = "Выйти с аккаунта",
                    modifier = Modifier.fillMaxWidth(0.9f)
                ) {
                    profileViewModel.logout(profile)
                }
            }
            item {
                Version()
            }
            item {
                Spacer(Modifier.padding(top = 20.dp))
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    MyCoffeeTheme {
        val navController = rememberNavController()
        ProfileScreen(navController)
    }
}