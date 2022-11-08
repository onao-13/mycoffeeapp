package com.example.mycoffee.screens.profilecategories

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mycoffee.components.*
import com.example.mycoffee.model.Profile
import com.example.mycoffee.system.Screen
import com.example.mycoffee.ui.theme.BackgroundColor
import com.example.mycoffee.ui.theme.MyCoffeeTheme
import com.example.mycoffee.ui.theme.Secondary
import com.example.mycoffee.viewmodel.ProfileViewModel

class DetailProfileActivity(): ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            ProfileDetailScreen(navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileDetailScreen(
    navController: NavController,
    profileViewModel: ProfileViewModel = viewModel()
) {
    val profile = profileViewModel.profile.collectAsState().value

    Scaffold(
        topBar = { SecondaryTopBar("Мой профиль", navController) },
        containerColor = BackgroundColor,
        contentColor = Secondary
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .padding(top = 20.dp),
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            item {
                MainCard {
                    Column(
                        modifier = Modifier.padding(
                            top = 14.dp,
                            bottom = 14.dp
                        ),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Title("Информация обо мне")
                        MediumRegularFont("Номер: " + profile.number)
                        MediumRegularFont("Имя: " + profile.name)
                    }
                }
            }
            item {
                MainCard {
                    Column(
                        modifier = Modifier.padding(
                            top = 14.dp,
                            bottom = 14.dp
                        ),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Title("Статистика")
                        ProfileStatistic()
                    }
                }
            }
            item {
                MainCard {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                top = 14.dp,
                                bottom = 14.dp
                            ),
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                    ) {
                        Title("Сменить информацию о профиле")
                        MenuButton(
                            navController,
                            Screen.EditingName,
                            "Сменить имя",
                            Modifier.padding(start = 10.dp)
                        )
                        MenuButton(
                            navController,
                            Screen.EditingPassword,
                            "Сменить пароль",
                            Modifier.padding(start = 10.dp)
                        )
                    }
                }
            }
        }
    }
}