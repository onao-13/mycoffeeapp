package com.example.mycoffee.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mycoffee.R
import com.example.mycoffee.ui.theme.LightGray
import com.example.mycoffee.ui.theme.Main
import com.example.mycoffee.ui.theme.Secondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchField(
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
            modifier = Modifier.align(Alignment.CenterHorizontally),
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
                color = LightGray
            ) },
            colors = TextFieldDefaults.textFieldColors(
                textColor = Secondary,
                containerColor = Main,
                cursorColor = Secondary,
                focusedLeadingIconColor = Secondary,
                unfocusedLeadingIconColor = Secondary,
                focusedLabelColor = Secondary,
                focusedIndicatorColor = Secondary,
                unfocusedIndicatorColor = Secondary,
                unfocusedLabelColor = Secondary
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTextField(modifier: Modifier = Modifier) {
    val textData = remember { mutableStateOf("") }

    TextField(
        value = textData.value,
        onValueChange = { textData.value = it },
        singleLine = true,
        shape = RoundedCornerShape(4.dp),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Secondary,
            containerColor = Main,
            cursorColor = Secondary,
            focusedLabelColor = Secondary,
            focusedIndicatorColor = Secondary,
            unfocusedIndicatorColor = Secondary,
            unfocusedLabelColor = Secondary
        ),
        modifier = modifier.fillMaxWidth(0.9f)
    )
}










