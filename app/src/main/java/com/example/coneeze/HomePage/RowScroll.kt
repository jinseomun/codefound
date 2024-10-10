package com.example.coneeze.HomePage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coneeze.R


import com.example.coneeze.data.coffeeImages1
import com.example.coneeze.data.features1
import com.example.coneeze.data.names1
import com.example.coneeze.data.prices1


@Composable
fun RowScroll(
    names: List<String>,
    features: List<String>,
    images: List<Int>,
    prices: List<String>
) {
    Row(
        modifier = Modifier.fillMaxWidth()

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, bottom = 24.dp)
        ) {


            Column {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                    // LazyRow가 화면 가로로 꽉 차도록 설정
                ) {
                    itemsIndexed(names) { index, language ->
                        // 언어 리스트와 이미지 리스트를 매칭하여 RowItem에 전달
                        if (index < images.size && index < features.size && index < prices.size) {
                            RowItem(
                                name = language,
                                image = painterResource(id = images[index]),
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
        names = names1,
        features = features1,
        images = coffeeImages1,
        prices = prices1
    )
}