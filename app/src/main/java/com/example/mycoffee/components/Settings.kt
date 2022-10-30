package com.example.mycoffee.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.mycoffee.ui.theme.Main
import com.example.mycoffee.ui.theme.MyCoffeeTheme

@Composable
fun ThemeSettings(modifier: Modifier = Modifier) {
    MainCard(
        modifier
            .fillMaxWidth()
            .height(160.dp)
    ) {
        val themeStyle = listOf(
            "Светлая",
            "Темная",
            "Как в системе"
        )
        val (active, inactive) = remember { mutableStateOf(themeStyle[0]) }

        Column(Modifier.padding(start = 10.dp)) {
            SettingTitle(
                title = "Цветовая тема",
                modifier = Modifier.padding(start = 14.dp, top = 10.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .selectableGroup(),
                verticalArrangement = Arrangement.Center
            ) {
                themeStyle.forEach { text ->
                    ThemeRadioButtonRow(text = text, active = (text == active)) {
                        inactive(text)
                    }
                }
            }
        }
    }
}

@Composable
private fun ThemeRadioButtonRow(
    text: String,
    active: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier.height(30.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = active,
            onClick = onClick,
            colors = RadioButtonDefaults.colors(
                selectedColor = Main,
                unselectedColor = Color(0xFFC79972)
            )
        )
        SettingText(text)
    }
}

@Composable
private fun SettingTitle(
    title: String,
    modifier: Modifier
) {
    Text(
        text = title,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        modifier = modifier
    )
}

@Composable
private fun SettingText(text: String) {
    Text(
        text = text,
        fontSize = 20.sp,
        fontWeight = FontWeight.Light
    )
}