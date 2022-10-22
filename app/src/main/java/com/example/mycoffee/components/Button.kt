package com.example.mycoffee.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mycoffee.ui.theme.*

@Composable
fun MainFocusButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: ButtonColors = mainFocusButtonColors(),
    onClick: () -> Unit,
    buttonTitle: String
) {
    FilledTonalButton(
        modifier = modifier
            .fillMaxWidth(0.84f)
            .height(55.dp),
        enabled = enabled,
        shape = RoundedCornerShape(100.dp),
        colors = colors,
        onClick = onClick) {
        Text(buttonTitle)
    }
}

@Composable
fun SecondaryButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: ButtonColors = secondaryButtonColors(),
    onClick: () -> Unit,
    buttonTitle: String
) {
    FilledTonalButton(
        modifier = modifier
            .fillMaxWidth(0.84f)
            .height(55.dp),
        enabled = enabled,
        shape = RoundedCornerShape(100.dp),
        colors = colors,
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