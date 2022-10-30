package com.example.mycoffee.screens.starter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
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
    ConstraintLayout(
        Modifier
            .fillMaxSize()
            .paint(
                painterResource(R.drawable.bg_hello_screen),
                contentScale = ContentScale.Crop
            )
    ) {
        val (text, icon, button) = createRefs()

        HelloText(
            Modifier
                .fillMaxWidth()
                .wrapContentWidth(CenterHorizontally)
                .constrainAs(text) {
                    top.linkTo(parent.top, margin = 70.dp)
                }
        )
        CafemeIcon(
            Modifier
                .fillMaxWidth()
                .wrapContentHeight(CenterVertically)
                .wrapContentWidth(CenterHorizontally)
                .constrainAs(icon) {
                    top.linkTo(
                        text.bottom,
                        margin = 140.dp
                    )
                }
        )
        MainFocusButton(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(CenterHorizontally)
                .constrainAs(button) {
                    bottom.linkTo(parent.bottom, margin = 40.dp)
                },
            onClick = { navController.navigate(Screen.Registration.route) },
            buttonTitle = "Продолжить"
        )
    }
}

@Composable
private fun HelloText(modifier: Modifier) {
    Text(
        modifier = modifier,
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

@Preview
@Composable
private fun Preview() {
    MyCoffeeTheme {
        val navController = rememberNavController()
        HelloScreen(navController)
    }
}