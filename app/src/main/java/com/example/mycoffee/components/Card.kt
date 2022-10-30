package com.example.mycoffee.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.mycoffee.R
import com.example.mycoffee.system.Screen
import com.example.mycoffee.ui.theme.*

@Composable
fun MainCard(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = Light,
            contentColor = Secondary
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        content()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BannerCard(
    modifier: Modifier = Modifier,
    image: Painter,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .height(160.dp)
            .width(300.dp),
        shape = RoundedCornerShape(16.dp),
        onClick = onClick
    ) {
        Image(
            painter = image,
            contentDescription = "banner image",
            contentScale = ContentScale.Crop
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoffeeCard(
    modifier: Modifier = Modifier,
    openBuyingPanel: () -> Unit,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .width(300.dp)
            .height(280.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Main,
            contentColor = Secondary
        ),
        onClick = onClick
    ) {
        Column {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.banner),
                    contentDescription = "coffee image",
                    contentScale = ContentScale.Crop
                )
            }
            Row(
                Modifier
                    .padding(top = 10.dp, start = 10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(text = "Название кофе")
                    Text(text = "Описание", modifier = Modifier.padding(top = 10.dp))
                }
                FloatingActionButton(
                    onClick = openBuyingPanel,
                    containerColor = FabColor,
                    modifier = Modifier.padding(end = 10.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.bag_24),
                        contentDescription = "fab icon"
                    )
                }
            }
        }
    }
}

@Composable
private fun MiniCoffeeCard(
    modifier: Modifier = Modifier,
    icon: @Composable () -> Unit? = {  }
) {
    Card(
        modifier = modifier
            .width(180.dp)
            .height(130.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        icon()
    }
}

@Composable
private fun MiniCardWithButton(
    modifier: Modifier = Modifier,
    openBuyingPanel: () -> Unit,
    navController: NavController
) {
    MiniCoffeeCard(modifier) {
        Box(
            Modifier
                .fillMaxSize()
                .paint(
                    painter = painterResource(R.drawable.banner),
                    contentScale = ContentScale.Crop
                )
                .clickable {
                    navController.navigate(Screen.CoffeeDetail.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
        ) {
            SmallFloatingActionButton(
                onClick = openBuyingPanel,
                containerColor = FabColor,
                contentColor = Secondary,
                modifier = Modifier
                    .align(BottomEnd)
                    .padding(end = 4.dp, bottom = 4.dp)
            ) {
                Icon(
                    painterResource(R.drawable.bag_24),
                    contentDescription = "",
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}

@Composable
private fun MiniCoffeeCardType(modifier: Modifier = Modifier) {
    MiniCoffeeCard(modifier) {
        Box(
            Modifier
                .fillMaxSize()
                .paint(
                    painter = painterResource(R.drawable.banner),
                    contentScale = ContentScale.Crop
                )
        ) {
            Text(
                text = "Название",
                fontSize = 12.sp,
                fontWeight = FontWeight.Light
            )
        }
    }
}

@Composable
fun MiniCoffeeCardsColumn(
    navController: NavController,
    modifier: Modifier = Modifier,
    openBuyingPanel: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            MiniCardWithButton(
                Modifier.padding(start = 14.dp),
                openBuyingPanel,
                navController
            )
            MiniCardWithButton(
                Modifier.padding(end = 14.dp),
                openBuyingPanel,
                navController
            )
        }
    }
}

@Composable
private fun OrderPreview(modifier: Modifier) {
    Row(Modifier.padding(start = 16.dp, top = 16.dp)) {
        Card(
            modifier = modifier
                .size(70.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.banner),
                contentDescription = "order icon",
                contentScale = ContentScale.Crop
            )
        }
        Text(
            text = "Дата: " + "23.10.2022",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 14.dp)
                .align(CenterVertically)
        )
    }
}

@Composable
private fun OrderStatus() {
    Column(Modifier
        .padding(
            start = 16.dp,
            top = 10.dp
        )
    ) {
        Text(
            text = "Стоимость: " + "313",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.padding(top = 6.dp))
        Text(
            text = "Статус: " + "Готовится",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = LightGray
        )
    }
}

@Composable
fun CoffeeTypesColumn(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            MiniCoffeeCardType()
            MiniCoffeeCardType()
        }
    }
}

@Composable
fun RefundCard(
    date: String,
    price: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
        colors = CardDefaults.cardColors(
            containerColor = Light,
            contentColor = Secondary
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(start = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = date,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = price,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            BuyCoffeeRow(Modifier.fillMaxWidth().padding(start = 20.dp))
            RefundCardImage(Modifier.fillMaxWidth())
        }
    }
}

/* TODO: ADD REFUND BOTTOM IMAGE */
@Composable
private fun RefundCardImage(modifier: Modifier) {

}