package com.example.mycoffee.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycoffee.R
import com.example.mycoffee.ui.theme.Light
import com.example.mycoffee.ui.theme.Main
import com.example.mycoffee.ui.theme.MyCoffeeTheme

@Composable
fun ProfilePreview(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        Box {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(Main)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(0.92f)
                    .padding(top = 70.dp)
                    .align(Center),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                ProfileIcon()
                MyBonusPoints()
            }
        }
    }
}

@Composable
private fun ProfileIcon(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.profile_img),
        contentDescription = "profile icon",
        contentScale = ContentScale.Crop,
        modifier = modifier
            .size(100.dp)
            .clip(CircleShape)
            .border(1.dp, Color.White, CircleShape)

    )
}

@Composable
private fun MyBonusPoints(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .width(80.dp)
            .height(30.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Main)
    ) {
        Box(contentAlignment = Center) {
            Text(
                text = "34" + "Б",
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier
                    .fillMaxSize(),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun Menu(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth(0.92f)
            .wrapContentWidth(CenterHorizontally)
            .background(Light, RoundedCornerShape(16.dp)),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        MenuText("Мой профиль", Modifier.padding(top = 16.dp))
        MenuDivider()
        MenuText("Корзина")
        MenuDivider()
        MenuText("Возвраты")
        MenuDivider()
        MenuText("Мои заказы")
        MenuDivider()
        MenuText("Избранное", Modifier.padding(bottom = 16.dp))
    }
}

@Composable
fun Settings(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth(0.92f)
            .wrapContentWidth(CenterHorizontally),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Light)
    ) {
        MenuText("Настройки", modifier
            .fillMaxSize()
            .padding(top = 16.dp, bottom = 16.dp)
        )
    }
}

@Composable
fun Version() {
    Text(
        text = "CofemoApp, 0.2dev",
        fontSize = 14.sp,
        fontWeight = FontWeight.ExtraLight
    )
}

@Composable
private fun MenuText(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier
            .padding(start = 10.dp),
        text = title,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium
    )
}

@Composable
private fun MenuDivider(modifier: Modifier = Modifier) {
    Divider(
        modifier = modifier.fillMaxSize(),
        thickness = 1.dp,
        color = Color.Black
    )
}