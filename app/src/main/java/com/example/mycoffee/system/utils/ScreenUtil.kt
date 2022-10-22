package com.example.mycoffee.system.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class ScreenUtil {
    private val config = LocalConfiguration

    @Composable
    fun getHeight(): Dp {
        return config.current.screenWidthDp.dp
    }

    @Composable
    fun getWidth(): Dp {
        return config.current.screenHeightDp.dp
    }
}