package com.example.mycoffee.screens.editing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mycoffee.components.*
import com.example.mycoffee.system.Screen
import com.example.mycoffee.ui.theme.BackgroundColor
import com.example.mycoffee.ui.theme.MyCoffeeTheme
import com.example.mycoffee.ui.theme.Secondary
import com.example.mycoffee.viewmodel.ProfileViewModel

class EditPasswordActivity(): ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            EditPasswordScreen(navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditPasswordScreen(
    navController: NavController,
    profileViewModel: ProfileViewModel = viewModel()
) {

    val profile = profileViewModel.profile.collectAsState().value

    Scaffold(
        topBar = { SecondaryTopBar("Смена пароля", navController) },
        bottomBar = {
            SecondaryBottomBar("Сменить пароль", navController) {
                profileViewModel.updateProfile(profile)
            }
        },
        containerColor = BackgroundColor,
        contentColor = Secondary
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Title("Введите новый пароль:")
                MainTextField()
            }
        }
    }
}

@Preview(widthDp = 375, heightDp = 812)
@Composable
private fun Preview() {
    MyCoffeeTheme {
        val navController = rememberNavController()
        EditPasswordScreen(navController)
    }
}