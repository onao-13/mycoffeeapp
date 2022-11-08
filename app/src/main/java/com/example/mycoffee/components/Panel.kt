package com.example.mycoffee.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycoffee.model.BasketProduct
import com.example.mycoffee.model.Product
import com.example.mycoffee.ui.theme.*
import com.example.mycoffee.viewmodel.BasketViewModel

@Composable
fun BuyingPanel(
    scrollableState: ScrollableState,
    panelHeight: Float,
    product: Product,
    basketViewModel: BasketViewModel,
    onClick: () -> Unit
) {
    val sugarCount = remember { mutableStateOf(2) }
    val coffeeCount = remember { mutableStateOf(1) }

    val sugarCountPrice = 20 /* TODO: DELETE THIS!! */
    val totalSugarPrice = sugarCountPrice * sugarCount.value
    val totalPrice = (product.price * coffeeCount.value) + totalSugarPrice

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(panelHeight)
            .scrollable(
                orientation = Orientation.Vertical,
                state = scrollableState
            ),
        shape = RoundedCornerShape(
            topStart = 16.dp,
            topEnd = 16.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Light,
            contentColor = Secondary
        )
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(55.dp),
            horizontalAlignment = Alignment.Start
        ) {
            BuyingRowHeader(product.name)
            BuyingRow(
                left = { BuyingRowText("Кубиков кофе") },
                right = { SugarCounter(
                    addSugar = { if (sugarCount.value < 5) sugarCount.value++ },
                    subtractSugar = { if (sugarCount.value > 0) sugarCount.value-- },
                    sugarCount = sugarCount
                ) }
            )
            BuyingRow(
                left = { BuyingRowText("Количество") },
                right = { CoffeeCounter(
                    addCoffee = { coffeeCount.value++ },
                    subtractCoffee = { if (coffeeCount.value > 1) coffeeCount.value-- },
                    coffeeCount = coffeeCount
                ) }
            )
            BuyingRow(
                left = { 
                        Column {
                            BuyingRowText("Итоговая цена")
                            SecondaryText("Сахар")
                        }
                },
                right = {
                    Column {
                        PriceText(totalPrice)
                        SecondaryPrice(
                            sugarCount.value.toString() + "x " +
                                    sugarSum(sugarCount.value).toString() + "₽",
                            Modifier.padding(top = 10.dp)
                        )
                    }
                }
            )
            MainFocusButton(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .align(CenterHorizontally)
                    .padding(bottom = 8.dp),
                buttonTitle = "Добавить в корзину"
            ) {
                val basketProduct = BasketProduct(
                    product.id,
                    coffeeCount.value,
                    product.name,
                    totalPrice
                )

                basketViewModel.addToBasket(basketProduct)

                onClick()
            }
        }
    }
}

private fun sugarSum(sugarCount: Int): Int {
    return 20 * sugarCount
}

@Composable
private fun ControllerButton(
    imageVector: ImageVector,
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .background(Main, CircleShape)
            .size(24.dp),
        colors = IconButtonDefaults.iconButtonColors(
            contentColor = LightGray
        )
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = "add",
            modifier = Modifier
                .fillMaxSize(0.6f)
        )
    }
}

@Composable
private fun SugarCounter(
    addSugar: () -> Unit,
    subtractSugar: () -> Unit,
    sugarCount: MutableState<Int>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(end = 14.dp).width(180.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ControllerButton(Icons.Default.Remove) {
            subtractSugar()
        }
        SugarIndicator(sugarCount.value)
        ControllerButton(Icons.Default.Add) {
            addSugar()
        }
    }
}

@Composable
private fun SugarIndicator(sugar: Int = 2) {
    val sugarCount = 5

    LazyRow(
        userScrollEnabled = false,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(sugar) {
            Card(
                modifier = Modifier.size(8.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = RedFocus)
            ) {  }
        }

        items(sugarCount - sugar) {
            Card(
                modifier = Modifier.size(8.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {  }
        }
    }
}

@Composable
private fun CoffeeCounter(
    addCoffee: () -> Unit,
    subtractCoffee: () -> Unit,
    coffeeCount: MutableState<Int>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(end = 14.dp).width(180.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ControllerButton(Icons.Default.Remove) {
            subtractCoffee()
        }
        Text(
            text = coffeeCount.value.toString(),
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
        ControllerButton(Icons.Default.Add) {
            addCoffee()
        }
    }
}

@Composable
private fun BuyingRow(
    modifier: Modifier = Modifier,
    left: @Composable () -> Unit,
    right: @Composable () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 14.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        left()
        right()
    }
}

@Composable
private fun BuyingRowText(
    text: String
) {
    Text(
        text = text,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium
    )
}

@Composable
private fun BuyingRowHeader(coffeeName: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 6.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Divider(
            modifier = Modifier
                .fillMaxWidth(0.3f)
                .clip(RoundedCornerShape(16.dp))
                .align(CenterHorizontally),
            thickness = 6.dp,
            color = Color(0xFFF5F5F5)
        )
        Text(
            text = coffeeName,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(
                start = 14.dp,
                top = 20.dp
            )
        )
    }
}

@Composable
private fun PriceText(
    totalPrice: Int
) {
    Text(
        text = totalPrice.toString() + "₽",
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth(0.8f)
    )
}

@Composable
private fun SecondaryPrice(
    text: String,
    modifier: Modifier
) {
    Text(
        text = text,
        fontSize = 12.sp,
        fontWeight = FontWeight.Light,
        textAlign = TextAlign.Center,
        modifier = modifier.fillMaxWidth(0.8f),
        color = LightGray
    )
}

@Composable
private fun SecondaryText(text: String) {
    Text(
        text = text,
        fontSize = 12.sp,
        fontWeight = FontWeight.Light,
        color = LightGray,
        modifier = Modifier.padding(top = 10.dp)
    )
}