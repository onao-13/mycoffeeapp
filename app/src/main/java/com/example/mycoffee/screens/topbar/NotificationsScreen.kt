package com.example.mycoffee.screens.topbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mycoffee.components.MainCard
import com.example.mycoffee.components.SecondaryBottomBar
import com.example.mycoffee.components.SecondaryTopBar
import com.example.mycoffee.ui.theme.BackgroundColor

class NotificationsActivity(): ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NotificationsScreen(navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationsScreen(navController: NavController) {
    Scaffold(
        topBar = { SecondaryTopBar("Уведомления", navController) },
        bottomBar = { SecondaryBottomBar("Пометить как прочитанное", navController) },
        containerColor = BackgroundColor
    ) {
        LazyColumn(
            modifier = Modifier.padding(it),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            items(8) {
                MainCard(Modifier.fillMaxWidth()) {
                    Text("Уведомление")
                }
            }
        }
    }
}