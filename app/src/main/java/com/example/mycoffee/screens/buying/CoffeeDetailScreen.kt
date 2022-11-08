package com.example.mycoffee.screens.buying

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mycoffee.components.*
import com.example.mycoffee.model.Product
import com.example.mycoffee.ui.theme.BackgroundColor
import com.example.mycoffee.ui.theme.MyCoffeeTheme
import com.example.mycoffee.ui.theme.Secondary
import com.example.mycoffee.viewmodel.BasketViewModel
import com.example.mycoffee.viewmodel.ProductViewModel

class CoffeeDetailActivity(): ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            CoffeeDetailScreen(navController)
        }
    }
}

/* TODO: FIX THIS SCREEN */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoffeeDetailScreen(
    navController: NavController,
    id: Int = 0,
    basketViewModel: BasketViewModel = viewModel(),
    productViewModel: ProductViewModel = viewModel()
) {
    // Panel
    val showBuyingPanel = remember { mutableStateOf(false) }

    var panelHeight by remember { mutableStateOf(0.55f) }
    if (panelHeight >= 0.55f) panelHeight = 0.55f
    if (panelHeight <= 0.05f) showBuyingPanel.value = false
    val height = if (panelHeight <= 0.55f) panelHeight else 0.55f

    // Product data
    val coffee = productViewModel.productList.collectAsState().value[id]

    Scaffold(
        bottomBar =  {
            if (!showBuyingPanel.value) {
                BuyingBar(coffee.price) {
                    showBuyingPanel.value = true
                    panelHeight = 0.55f
                }
            } else {
                BuyingPanel(
                    rememberScrollableState { delta ->
                        panelHeight -= delta / 2000f
                        delta
                    },
                    height,
                    Product(0, "", 1, ""),
                    basketViewModel
                )  {
                    showBuyingPanel.value = false
                }
            }
        },
        containerColor = BackgroundColor,
        contentColor = Secondary
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            item {
                CoffeePreview(navController)
            }
            item {
                Title(coffee.name)
            }
            item {
                CoffeeDescription(coffee.description)
            }
        }
    }
}

@Preview(widthDp = 400, heightDp = 812, showBackground = true)
@Composable
private fun Preview() {
    MyCoffeeTheme {
        val navController = rememberNavController()
        CoffeeDetailScreen(navController)
    }
}