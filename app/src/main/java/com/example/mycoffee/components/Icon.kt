package com.example.mycoffee.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycoffee.ui.theme.MyCoffeeTheme
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mycoffee.R
import com.example.mycoffee.ui.theme.IconBackground


@Composable
fun CafemeIcon() {
    Card(
        modifier = Modifier
            .size(230.dp)
            .rotate(-17f)
            .alpha(0.9f),
        shape = CircleShape,
        colors = iconColor(),
    ) {
        Image(
            painter = painterResource(R.drawable.icon_cofemo),
            contentDescription = "icon",
            modifier = Modifier
                .align(CenterHorizontally)
                .fillMaxSize()
                .fillMaxHeight()
        )
    }
}

@Composable
private fun iconColor(): CardColors {
    return CardDefaults.cardColors(
        contentColor = IconBackground
    )
}


@Preview(widthDp = 500, heightDp = 500)
@Composable
private fun CofemeIconPreview() {
    MyCoffeeTheme {
        CafemeIcon()
    }
}