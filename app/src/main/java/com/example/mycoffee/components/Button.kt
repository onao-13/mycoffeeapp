package com.example.mycoffee.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.mycoffee.system.Screen
import com.example.mycoffee.ui.theme.*

@Composable
fun MainFocusButton(
    buttonTitle: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    FilledTonalButton(
        modifier = modifier
            .fillMaxWidth(0.84f)
            .height(50.dp),
        enabled = true,
        shape = RoundedCornerShape(100.dp),
        colors = mainFocusButtonColors(),
        onClick = onClick) {
        Text(buttonTitle)
    }
}

@Composable
fun SecondaryButton(
    modifier: Modifier = Modifier,
    buttonTitle: String,
    onClick: () -> Unit
) {
    FilledTonalButton(
        modifier = modifier
            .fillMaxWidth(0.84f)
            .height(50.dp),
        enabled = true,
        shape = RoundedCornerShape(100.dp),
        colors = secondaryButtonColors(),
        onClick = onClick
    ) {
        Text(buttonTitle)
    }
}

@Composable
private fun mainFocusButtonColors(): ButtonColors {
    return ButtonDefaults.buttonColors(
        contentColor = Light,
        containerColor = RedFocus,
        disabledContainerColor = Disabled,
        disabledContentColor = DisabledFont
    )
}

@Composable
private fun secondaryButtonColors(): ButtonColors {
    return ButtonDefaults.buttonColors(
        contentColor = Secondary,
        containerColor = Main,
        disabledContentColor = Disabled,
        disabledContainerColor = DisabledFont
    )
}

@Composable
fun MenuButton(
    navController: NavController,
    screen: Screen,
    title: String,
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier.fillMaxWidth().padding(
            top = 2.dp,
            bottom = 2.dp
        ),
        onClick = {
            navController.navigate(screen.route)
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Light,
            contentColor = Secondary
        ),
        shape = RoundedCornerShape(4.dp)
    ) {
        Text(
            modifier = modifier
                .fillMaxWidth(),
            text = title,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Start
        )
    }
}