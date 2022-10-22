package com.example.mycoffee.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Title(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier.padding(
            start = 14.dp
        ),
        text = title,
        fontSize = 24.sp,
        fontWeight = FontWeight.SemiBold,
        textDecoration = TextDecoration.Underline
    )
}