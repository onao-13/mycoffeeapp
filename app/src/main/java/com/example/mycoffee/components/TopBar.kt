package com.example.mycoffee.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycoffee.R
import com.example.mycoffee.ui.theme.*

@Composable
fun SearchBagNotificationTopBar() {
    TopBarShape {
        Row {
            SearchField()
            //                    Badge()
            Icon(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .align(CenterVertically),
                painter = painterResource(R.drawable.bag_24),
                contentDescription = "bag icon"
            )
            Icon(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .align(CenterVertically),
                painter = painterResource(R.drawable.notification_24),
                contentDescription = "notification icon"
            )
        }
    }
}

@Composable
private fun TopBarShape(content: @Composable () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        colors = topBarColors(),
        shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .height(80.dp)
                .fillMaxWidth(),
            contentAlignment = Center
        ) {
            content()
        }
    }
}

@Composable
private fun topBarColors(): CardColors {
    return CardDefaults.cardColors(
        containerColor = Light
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SearchField(
    modifier: Modifier = Modifier,
    size: Float = 0.74f
) {
    val searchRequest = remember { mutableStateOf("") }

    Card(
        modifier = modifier
            .fillMaxWidth(size)
            .height(50.dp),
        shape = RoundedCornerShape(30.dp),
        colors = CardDefaults.cardColors(containerColor = Main)

    ) {
        TextField(
            modifier = Modifier.align(CenterHorizontally),
            value = searchRequest.value,
            onValueChange =  { searchRequest.value = it},
            singleLine = true,
            leadingIcon = { Icon(
                painter = painterResource(R.drawable.seacrh_24),
                contentDescription = "seacrh icon",
                modifier = Modifier
            ) },
            placeholder = { Text(
                text =    "Найти твое любимое кофе",
                color = LightGrey
            ) },
            colors = fieldColors()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun fieldColors(): TextFieldColors {
    return TextFieldDefaults.textFieldColors(
        textColor = Secondary,
        containerColor = Main,
        cursorColor = Secondary
    )
}

@Composable
fun SearchTopBar(modifier: Modifier = Modifier) {
    TopBarShape {
        SearchField(
            modifier = modifier,
            size = 0.9f
        )
    }
}