package com.example.mycoffee.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycoffee.model.Order
import com.example.mycoffee.model.OrderStatus
import com.example.mycoffee.ui.theme.Light
import com.example.mycoffee.ui.theme.Secondary

@Composable
fun OrderCard(
    title: String,
    order: Order
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
        colors = CardDefaults.cardColors(
            containerColor = Light,
            contentColor = Secondary
        )
    ) {
        Column(
            modifier = Modifier
                .padding(
                    start = 20.dp,
                    top = 10.dp
                )
                .fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(18.dp)
            ) {
                MediumSemiBoldFont(title)
                MediumSemiBoldFont(order.price.toString() + "₽")
            }
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(
                    text = "Заказ",
                    fontSize = 20.sp,
                    fontWeight = Medium
                )
                /* TODO: FIX COFFEES IN ORDER */
//                LazyRow(
//                    modifier = Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.spacedBy(10.dp)
//                ) {
//                    items(order) { product ->
//                        Text(
//                            text = product.name,
//                            fontSize = 14.sp,
//                            fontWeight = FontWeight.Light
//                        )
//                    }
//                }
            }
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(
                    text = "Статус",
                    fontSize = 20.sp,
                    fontWeight = Medium
                )
                StatusBar(order.status)
            }
        }
    }
}

@Composable
private fun StatusBar(status: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(42.dp)
        ) {
            StatusTitle(title = "Оплачено")
            StatusTitle(title = "Готовится", modifier = Modifier.padding(start = 10.dp))
            StatusTitle(title = "Приготовлено")
            StatusTitle(title = "Выдано", modifier = Modifier.padding(end = 8.dp))
        }
        Row(
            Modifier
                .fillMaxWidth()
                .height(30.dp)
                .padding(start = 16.dp)) {
            VisibilityBar(status)
        }
    }
}

@Composable
private fun VisibilityBar(status: String) {
    when(status) {
        OrderStatus.Paid.status -> PaidBar()
        OrderStatus.Cooking.status -> CookingBar()
        OrderStatus.Cooked.status -> CookedBar()
        else -> GivenBar()
    }
}

@Composable
private fun PaidBar() {
    Circle(color = StatusColor.Complete)
    Line(lineColor = StatusColor.NotStatus)
    Circle(color = StatusColor.NotStatus)
    Line(lineColor = StatusColor.NotStatus)
    Circle(color = StatusColor.NotStatus)
    Line(lineColor = StatusColor.NotStatus)
    Circle(color = StatusColor.NotStatus)
}

@Composable
private fun CookingBar() {
    Circle(color = StatusColor.Complete)
    Line(lineColor = StatusColor.Complete)
    Circle(color = StatusColor.InProgress)
    Line(lineColor = StatusColor.NotStatus)
    Circle(color = StatusColor.NotStatus)
    Line(lineColor = StatusColor.NotStatus)
    Circle(color = StatusColor.NotStatus)
}

@Composable
private fun CookedBar() {
    Circle(color = StatusColor.Complete)
    Line(lineColor = StatusColor.Complete)
    Circle(color = StatusColor.Complete)
    Line(lineColor = StatusColor.Complete)
    Circle(color = StatusColor.InProgress)
    Line(lineColor = StatusColor.NotStatus)
    Circle(color = StatusColor.NotStatus)
}

@Composable
private fun GivenBar() {
    Circle(color = StatusColor.Complete)
    Line(lineColor = StatusColor.Complete)
    Circle(color = StatusColor.Complete)
    Line(lineColor = StatusColor.Complete)
    Circle(color = StatusColor.Complete)
    Line(lineColor = StatusColor.Complete)
    Circle(color = StatusColor.Complete)
}

@Composable
private fun Circle(color: StatusColor) {
    Card(
        shape = CircleShape,
        modifier = Modifier.size(22.dp),
        colors = CardDefaults.cardColors(containerColor = color.color)
    ) {  }
}

@Composable
private fun Line(lineColor: StatusColor) {
    Divider(
        modifier = Modifier
            .width(80.dp)
            .padding(top = 8.dp),
        color = lineColor.color,
        thickness = 6.dp
    )
}

@Composable
private fun StatusTitle(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        fontSize = 10.sp,
        fontWeight = FontWeight.Light,
        modifier = modifier
        )
}

private sealed class StatusColor(val color: Color) {
    object Complete : StatusColor(Color(0xFF0BDA51))
    object InProgress : StatusColor(Color(0xFFE32636))
    object NotStatus : StatusColor(Color(0xFFFFFFFF))
}