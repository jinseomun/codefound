package com.example.coneeze.HomePage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun twobyone(
    names: List<String>,
    images: List<Int>,
    features: List<String>,
    prices: List<String>
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        // 첫 번째 아이템
        if (names.isNotEmpty() && images.isNotEmpty() && features.isNotEmpty() && prices.isNotEmpty()) {
            HorizontalItem(
                name = names[0],
                feature = features[0],
                image = images[0],
                price = prices[0]
            )
        }

        Spacer(modifier = Modifier.width(24.dp)) //간격 분배

        // 두 번째 아이템
        if (names.size > 1 && images.size > 1 && features.size > 1 && prices.size > 1) {
            HorizontalItem(
                name = names[1],
                feature = features[1],
                image = images[1],
                price = prices[1]
            )
        }
    }
}
