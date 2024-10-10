package com.example.coneeze.HomePage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.coneeze.R

import com.example.coneeze.data.coffeeImages3
import com.example.coneeze.data.features3
import com.example.coneeze.data.names3
import com.example.coneeze.data.prices3

@Composable
fun twobytwo(
    navController: NavController,
    names: List<String>,
    features: List<String>,
    images: List<Int>,
    prices: List<String>
){
    val nameChunks = names.chunked(2)
    val featureChunks = features.chunked(2)
    val imageChunks = images.chunked(2)
    val priceChunks = prices.chunked(2)

    Column() {
        twobyone(
            navController = navController,
            names = nameChunks.getOrNull(0) ?: emptyList(),
            features = featureChunks.getOrNull(0) ?: emptyList(),
            images = imageChunks.getOrNull(0) ?: emptyList(),
            prices = priceChunks.getOrNull(0) ?: emptyList()
        )

        Spacer(modifier = Modifier.height(24.dp))

        twobyone(
            navController = navController,
            names = nameChunks.getOrNull(1) ?: emptyList(),
            features = featureChunks.getOrNull(1) ?: emptyList(),
            images = imageChunks.getOrNull(1) ?: emptyList(),
            prices = priceChunks.getOrNull(1) ?: emptyList()
        )
    }
}

