package com.example.mycoffee.screens.starter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
    Column(
        modifier = Modifier
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
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(Modifier.padding(top = 110.dp))
        RegistrationText()
        Spacer(Modifier.padding(top = 50.dp))
        RegistrationForm()
        Spacer(Modifier.padding(top = 60.dp))
        MainFocusButton(
            onClick = { /*TODO*/ },
            buttonTitle = "Зарегестрироваться"
        )
        Spacer(Modifier.padding(top = 20.dp))
        SecondaryButton(
            onClick = { navController.navigate(Screen.Login.toString()) },
            buttonTitle = "Войти"
        )
    }
}

@Composable
private fun RegistrationText() {
    Text(
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