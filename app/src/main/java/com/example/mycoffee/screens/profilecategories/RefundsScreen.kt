package com.example.mycoffee.screens.profilecategories

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mycoffee.components.RefundCard
import com.example.mycoffee.components.SecondaryTopBar
import com.example.mycoffee.ui.theme.BackgroundColor
import com.example.mycoffee.ui.theme.MyCoffeeTheme
import com.example.mycoffee.ui.theme.Secondary
import com.example.mycoffee.viewmodel.RefundViewModel

class RefundsActivity(): ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            RefundsScreen(navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RefundsScreen(
    navController: NavController,
    refundViewModel: RefundViewModel = viewModel()
) {
    val refundData = refundViewModel.refundList.collectAsState().value

    Scaffold(
        topBar = {
            SecondaryTopBar(
            "Возвраты",
                navController
            )
        },
        contentColor = Secondary,
        containerColor = BackgroundColor
    ) {
        LazyColumn(
            modifier = Modifier.padding(it),
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            items(refundData) { refund ->
                RefundCard(
                    refund.data,
                    refund.price
                )
            }
        }
    }
}