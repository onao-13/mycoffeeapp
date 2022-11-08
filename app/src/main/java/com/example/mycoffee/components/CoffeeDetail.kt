package com.example.mycoffee.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mycoffee.R
import com.example.mycoffee.system.Screen
import com.example.mycoffee.ui.theme.Light
import com.example.mycoffee.ui.theme.LightGray
import com.example.mycoffee.ui.theme.Main
import com.example.mycoffee.ui.theme.Secondary

@Composable
fun CoffeePreview(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxSize()
            .fillMaxWidth()
            .height(260.dp),
        shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
    ) {
        Box {
            Image(
                painter = painterResource(R.drawable.banner),
                contentDescription = "coffee preview",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Icon(
                painter = painterResource(R.drawable.back_icon_24),
                contentDescription = "back icon",
                modifier = Modifier
                    .padding(start = 10.dp, top = 10.dp)
                    .clickable {
                        navController.navigate(Screen.Stock.route)
                    },
                tint = Secondary
            )
        }
    }
}

@Composable
fun CoffeeDescription(description: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.3f),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Light
        )
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Состав",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(
                    start = 10.dp,
                    top = 8.dp
                ),
                textAlign = TextAlign.Start
            )
            Text(
                text = description,
                modifier = Modifier.padding(start = 10.dp)
            )
        }
    }
}

@Composable
fun BuyingBar(price: Int, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        shape = RoundedCornerShape(
            topStart = 16.dp,
            topEnd = 16.dp
        ),
        colors = CardDefaults.cardColors(containerColor = Light)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PriceText(Modifier.padding(start = 18.dp), price)
            BuyButton(Modifier.padding(end = 18.dp)) {
                onClick()
            }
        }
    }
}

@Composable
private fun PriceText(
    modifier: Modifier = Modifier,
    price: Int
) {
    Text(
        text = "Цена: " + price + "₽",
        fontSize = 20.sp,
        fontWeight = FontWeight.Medium,
        modifier = modifier
    )
}

@Composable
private fun BuyButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    FilledTonalButton(
        modifier = modifier
            .fillMaxWidth(0.80f)
            .height(50.dp),
        onClick = onClick,
        shape = RoundedCornerShape(100.dp),
        colors = colors()
    ) {
        Text("Добавить в корзину")
    }
}

@Composable
private fun colors(): ButtonColors {
    return ButtonDefaults.buttonColors(
        contentColor = Color.Black,
        containerColor = Main
    )
}