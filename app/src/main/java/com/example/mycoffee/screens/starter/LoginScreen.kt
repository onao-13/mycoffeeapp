package com.example.mycoffee.screens.starter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mycoffee.R
import com.example.mycoffee.components.LoginForm
import com.example.mycoffee.components.MainFocusButton
import com.example.mycoffee.components.SecondaryButton
import com.example.mycoffee.model.Profile
import com.example.mycoffee.system.Screen
import com.example.mycoffee.ui.theme.Darkness
import com.example.mycoffee.ui.theme.Light
import com.example.mycoffee.ui.theme.MyCoffeeTheme
import com.example.mycoffee.viewmodel.ProfileViewModel

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCoffeeTheme {
                val navController = rememberNavController()
                LoginScreen(navController)
            }
        }
    }
}

@Composable
fun LoginScreen(
    navController: NavController,
    profileViewModel: ProfileViewModel = viewModel()
) {
    val number = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    /* TODO: UPDATE CLASS PROFILE TO PROFILE_REQUEST */
    val profile = Profile(0, "", number.value, password.value)

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
        val (text, form, registration, login) = createRefs()

        LoginText(
            Modifier
                .fillMaxWidth()
                .wrapContentWidth(CenterHorizontally)
                .constrainAs(text) {
                    top.linkTo(parent.top, margin = 110.dp)
                }
        )
        LoginForm(
            Modifier
                .fillMaxWidth()
                .wrapContentWidth(CenterHorizontally)
                .constrainAs(form) {
                    top.linkTo(text.bottom, margin = 50.dp)
                },
            number, password
        )
        MainFocusButton(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(CenterHorizontally)
                .constrainAs(registration) {
                    bottom.linkTo(login.top, margin = 20.dp)
                },
            onClick = {
                profileViewModel.login(profile)
                navController.navigate(Screen.Stock.route)
            },
            buttonTitle = "Войти"
        )
        SecondaryButton(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(CenterHorizontally)
                .constrainAs(login) {
                    bottom.linkTo(parent.bottom, margin = 40.dp)
                },
            onClick = { navController.navigate(Screen.Registration.route) },
            buttonTitle = "Зарегестрироваться"
        )
    }
}

@Composable
private fun LoginText(modifier: Modifier) {
    Text(
        modifier = modifier,
        text = "Войти \n в Cafemo",
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        color = Light,
        textAlign = TextAlign.Center,
        style = LocalTextStyle.current.merge(
            TextStyle(lineHeight = 1.5.em)
        )
    )
}