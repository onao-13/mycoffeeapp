package com.example.mycoffee.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.mycoffee.R
import com.example.mycoffee.model.Order
import com.example.mycoffee.model.Product
import com.example.mycoffee.system.Screen
import com.example.mycoffee.ui.theme.LightGray

@Composable
fun OrderCardRow(
    modifier: Modifier = Modifier,
    orders: List<Order>
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(orders) { order ->
            OrderCard(
                "Кофе",
                order
            )
        }
    }
}

@Composable
fun BannerRow(
    modifier: Modifier = Modifier,
    count: Int,
    navController: NavController
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        items(count) {
            BannerCard(
                image = painterResource(R.drawable.banner),
            ) {
                navController.navigate(Screen.CoffeeDetail.route)
            }
        }
    }
}

@Composable
fun BuyCoffeeRow(modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier
            .height(30.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(4) {
            Text(
                text = "Кофе",
                fontSize = 14.sp,
                fontWeight = FontWeight.Light,
                color = LightGray
            )
        }
    }
}