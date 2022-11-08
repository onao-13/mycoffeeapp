package com.example.mycoffee.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.TopEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mycoffee.R
import com.example.mycoffee.system.Screen
import com.example.mycoffee.ui.theme.*

/* TODO: ADD BADGE */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBagNotificationTopBar(navController: NavController, productsCountInBasket: Int) {
    TopBarShape {
        Row {
            SearchField()
            IconButton(onClick = { navController.navigate(Screen.Basket.route) }) {
                Box(Modifier.fillMaxSize()) {
                    Icon(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .align(Center),
                        painter = painterResource(R.drawable.bag_24),
                        contentDescription = "bag icon"
                    )
                    if (productsCountInBasket < 1) {
                        Badge(
                            containerColor = Main,
                            contentColor = Secondary,
                            modifier = Modifier.padding(top = 4.dp).align(TopEnd)
                        ) {
                            Text("$productsCountInBasket")
                        }
                    }
                }
            }
            IconButton(onClick = { navController.navigate(Screen.Notifications.route) }) {
                Icon(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .align(CenterVertically),
                    painter = painterResource(R.drawable.notification_24),
                    contentDescription = "notification icon"
                )
            }
        }
    }
}

@Composable
private fun TopBarShape(content: @Composable () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        colors = CardDefaults.cardColors(
            containerColor = Light
        ),
        shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .height(80.dp)
                .fillMaxWidth(),
            contentAlignment = Center
        ) {
            content()
        }
    }
}

@Composable
fun SearchTopBar(modifier: Modifier = Modifier) {
    TopBarShape {
        SearchField(
            modifier = modifier,
            size = 0.9f
        )
    }
}