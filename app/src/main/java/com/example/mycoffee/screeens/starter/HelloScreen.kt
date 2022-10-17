package com.example.mycoffee.screeens.starter

import android.graphics.fonts.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mycoffee.R
import com.example.mycoffee.components.CafemeIcon
import com.example.mycoffee.components.MainFocusButton
import com.example.mycoffee.system.Screen
import com.example.mycoffee.ui.theme.MyCoffeeTheme

class HelloActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCoffeeTheme {
                val navController = rememberNavController()
                HelloScreen(navController)
            }
        }
    }
}

@Composable
fun HelloScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(R.drawable.bg_hello_screen),
                contentScale = ContentScale.Crop
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.padding(top = 70.dp))
        HelloText()
        Spacer(Modifier.padding(top = 150.dp))
        CafemeIcon()
        Spacer(Modifier.padding(top = 220.dp))
        MainFocusButton(
            onClick = { navController.navigate(Screen.Registration.toString()) },
            buttonTitle = "Продолжить"
        )
    }
}

@Composable
private fun HelloText() {
    Text(
        text = "Добро пожаловать в \n Cafemo",
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        style = LocalTextStyle.current.merge(
            TextStyle(
                lineHeight = 1.5.em
            )
        )
    )
}