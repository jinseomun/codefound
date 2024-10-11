package com.example.coneeze.HomePage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coneeze.R


import com.example.coneeze.data.coffeeImages1
import com.example.coneeze.data.features1
import com.example.coneeze.data.names1
import com.example.coneeze.data.prices1

@Composable
fun RowScroll(
    navController: NavController,
    names: List<String>,
    features: List<String>,
    images: List<Int>,
    prices: List<String>
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, bottom =20.dp)
        ) {
            Column {
                LazyRow(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    itemsIndexed(names) { index, name ->
                        if (index < images.size && index < features.size && index < prices.size) {
                            RowItem(
                                navController = navController,
                                name = name,
                                image = images[index],
                                feature = features[index],
                                price = prices[index]
                            )
                        }
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun RowScrollPreview(){
    RowScroll(
        navController = rememberNavController(),  // 임시 NavController 사용
        names = names1,
        features = features1,
        images = coffeeImages1,
        prices = prices1
    )
}