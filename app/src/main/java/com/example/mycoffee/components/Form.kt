package com.example.mycoffee.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycoffee.ui.theme.*

@Composable
fun RegistrationForm(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .width(300.dp),
        shape = RoundedCornerShape(16.dp),
        colors = cardColors()
    ) {
        val name = remember { mutableStateOf("") }
        val number = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.padding(top = 20.dp))
            Column {
                Text(
                    text = "Имя",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                FormTextField(name)
            }
            Spacer(Modifier.padding(top = 20.dp))
            Column {
                Text(
                    text = "Номер",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                FormTextField(number)
            }
            Spacer(Modifier.padding(top = 20.dp))
            Column {
                Text(
                    text = "Пароль",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                FormTextField(password)
                Spacer(Modifier.padding(top = 20.dp))
                Column {
                    Valid(text = "Номер телефона", valid = true)
                    Spacer(Modifier.padding(top = 4.dp))
                    Valid(text = "Пароль", valid = false)
                }
            }
            Spacer(Modifier.padding(bottom = 20.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun FormTextField(
    inputText: MutableState<String>
) {
    TextField(
        value = inputText.value,
        onValueChange = { inputText.value = it },
        maxLines = 1,
        shape = RoundedCornerShape(0.dp),
        colors = formColors()
    )
}

@Composable
private fun Valid(
    text: String,
    valid: Boolean,
) {
    Text(
        text = text,
        color = if (valid) GreenValid else RedValid,
        fontSize = 10.sp
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun formColors(): TextFieldColors {
    return TextFieldDefaults.textFieldColors(
        textColor = Secondary,
        containerColor = Light
    )
}

@Composable
private fun cardColors(): CardColors {
    return CardDefaults.cardColors(
        containerColor = Light
    )
}

@Composable
fun LoginForm(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.width(300.dp),
        shape = RoundedCornerShape(16.dp),
        colors = cardColors()
    ) {
        val number = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.padding(top = 20.dp))
            Column {
                Text(
                    text = "Номер телефона",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                FormTextField(number)
            }
            Spacer(Modifier.padding(top = 20.dp))
            Column {
                Text(
                    text = "Пароль",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                FormTextField(password)
            }
            Spacer(Modifier.padding(bottom = 20.dp))
        }
    }
}

@Preview
@Composable
private fun LoginFormPreview() {
    MyCoffeeTheme {
        LoginForm()
    }
}