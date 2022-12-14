package com.example.mycoffee.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mycoffee.R
import com.example.mycoffee.model.Profile
import com.example.mycoffee.system.Screen
import com.example.mycoffee.ui.theme.Light
import com.example.mycoffee.ui.theme.Main
import com.example.mycoffee.viewmodel.ProfileViewModel

@Composable
fun ProfilePreview(name: String) {
    Column(modifier = Modifier.fillMaxSize()) {
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
                MediumRegularFont(name)
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
                text = "34" + "??",
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
fun Menu(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth(0.92f)
            .wrapContentWidth(CenterHorizontally)
            .background(Light, RoundedCornerShape(16.dp))
    ) {
        MenuButton(
            navController,
            Screen.ProfileDetail,
            "?????? ??????????????"
        )
        MenuDivider()
        MenuButton(
            navController,
            Screen.Basket,
            "??????????????"
        )
        MenuDivider()
        MenuButton(
            navController,
            Screen.Refunds,
            "????????????????"
        )
        MenuDivider()
        MenuButton(
            navController,
            Screen.Orders,
            "?????? ????????????"
        )
    }
}

@Composable
fun Settings(
    navController: NavController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(0.92f)
            .wrapContentWidth(CenterHorizontally),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Light)
    ) {
        MenuButton(
            navController,
            Screen.Settings,
            "??????????????????"
        )
    }
}

@Composable
fun Version() {
    Text(
        text = "CofemoApp, 0.4dev",
        fontSize = 14.sp,
        fontWeight = FontWeight.ExtraLight
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

/* TODO: ADD STATISTIC ICONS */
@Composable
fun ProfileStatistic(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(start = 14.dp),
        horizontalAlignment = Start,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        StatisticBlock(title = "??????????????", icon = painterResource(R.drawable.show_icon_18))
        StatisticBlock(title = "???????????????????? ??????????????", icon = painterResource(R.drawable.hide_icon_18))
    }
}

@Composable
private fun StatisticBlock(
    title: String,
    icon: Painter,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.height(30.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = icon,
            contentDescription = "statistic icon",
            modifier = Modifier.size(24.dp)
        )
        LittleBoldFont(title)
    }
}