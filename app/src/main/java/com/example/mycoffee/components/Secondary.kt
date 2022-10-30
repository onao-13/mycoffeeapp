package com.example.mycoffee.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mycoffee.R
import com.example.mycoffee.ui.theme.BackgroundColor
import com.example.mycoffee.ui.theme.Secondary

@Composable
fun SecondaryTopBar(
    title: String,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        colors = CardDefaults.cardColors(
            containerColor = BackgroundColor,
            contentColor = Secondary
        )
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.back_icon_24),
                contentDescription = "back icon",
                modifier = Modifier
                    .padding(start = 10.dp)
                    .clickable {
                        navController.navigateUp()
                    }
            )
            Title(
                title,
                Modifier.fillMaxWidth(0.86f),
                TextAlign.Center,
            )
        }
    }
}

@Composable
fun SecondaryBottomBar(
    title: String,
    navController: NavController,
) {
    Box(Modifier.fillMaxWidth()) {
        MainFocusButton(
            buttonTitle = title,
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .align(Alignment.Center)
                .padding(bottom = 8.dp)
        ) {
            /* TODO: ADD NAVIGATION */
        }
    }
}

@Composable
fun Basket(modifier: Modifier = Modifier) {
    MainCard(modifier.fillMaxWidth(0.9f)) {
        Column(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(
                text = "Корзина",
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                color = Secondary,
                modifier = Modifier.padding(top = 20.dp)
            )
            Divider(Modifier.fillMaxWidth(), color = Color.Black)
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                userScrollEnabled = false,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(3) {
                    CoffeeBasketRow()
                }
            }
        }
    }
}

@Composable
private fun CoffeeBasketRow(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "1" + " Латте",
            fontWeight = FontWeight.Light,
            fontSize = 14.sp,
            color = Secondary
        )
        Text(
            text = "340" + "₽",
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = Secondary
        )
    }
}

@Composable
fun TotalPriceBar() {
    MainCard(
        Modifier
            .fillMaxWidth(0.9f)
            .height(60.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Итого:",
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )
            Text(
                text = "340" + "₽",
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )
        }
    }
}