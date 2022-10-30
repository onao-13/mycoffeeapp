package com.example.mycoffee.screens.starter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
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
import com.example.mycoffee.components.MainFocusButton
import com.example.mycoffee.components.RegistrationForm
import com.example.mycoffee.components.SecondaryButton
import com.example.mycoffee.system.Screen
import com.example.mycoffee.ui.theme.Darkness
import com.example.mycoffee.ui.theme.Light
import com.example.mycoffee.ui.theme.MyCoffeeTheme

class RegistrationActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCoffeeTheme {
                val navController = rememberNavController()
                RegistrationScreen(navController)
            }
        }
    }
}

@Composable
fun RegistrationScreen(navController: NavController) {
    ConstraintLayout(
        Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(
                    R.drawable.bg_hello_screen
                ),
                colorFilter = ColorFilter.tint(
                    color = Darkness.copy(0.8f),
                    blendMode = BlendMode.SrcOver
                ),
                contentScale = ContentScale.Crop
            )
    ) {
        val (text, form, login, registration) = createRefs()

        RegistrationText(
            Modifier
                .fillMaxWidth()
                .wrapContentWidth(CenterHorizontally)
                .constrainAs(text) {
                    top.linkTo(parent.top, margin = 40.dp)
            }
        )
        RegistrationForm(
            Modifier
                .fillMaxWidth()
                .wrapContentWidth(CenterHorizontally)
                .constrainAs(form) {
                    top.linkTo(text.bottom, margin = 60.dp)
                }
        )
        MainFocusButton(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(CenterHorizontally)
                .constrainAs(login) {
                    bottom.linkTo(registration.top, margin = 20.dp)
                },
            onClick = { navController.navigate(Screen.Stock.route) },
            buttonTitle = "Зарегестрироваться"
        )
        SecondaryButton(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(CenterHorizontally)
                .constrainAs(registration) {
                    bottom.linkTo(parent.bottom, margin = 40.dp)
                },
            onClick = { navController.navigate(Screen.Login.toString()) },
            buttonTitle = "Войти"
        )
    }
}

@Composable
private fun RegistrationText(modifier: Modifier) {
    Text(
        modifier = modifier,
        text = "Регистрация \n в Cafemo",
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        color = Light,
        textAlign = TextAlign.Center,
        style = LocalTextStyle.current.merge(
            TextStyle(lineHeight = 1.5.em)
        )
    )
}

@Preview
@Composable
private fun Preview() {
    MyCoffeeTheme {
        val navController = rememberNavController()
        RegistrationScreen(navController)
    }
}