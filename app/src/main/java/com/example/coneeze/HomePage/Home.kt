package com.example.coneeze.HomePage

import KeywordPrice
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coneeze.R
import com.example.coneeze.ui.theme.Main600
import com.example.coneeze.ui.theme.surround


import com.example.coneeze.data.coffeeImages1
import com.example.coneeze.data.features1
import com.example.coneeze.data.names1
import com.example.coneeze.data.prices1

import com.example.coneeze.data.coffeeImages2
import com.example.coneeze.data.features2
import com.example.coneeze.data.names2
import com.example.coneeze.data.prices2


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(start = 20.dp, end = 20.dp),
                navigationIcon = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.logo),
                            contentDescription = "커니즈 로고",
                            modifier = Modifier
                                .width(137.dp)
                                .height(24.dp)
                        )
                    }
                },
            )
        },
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                /*
                item { ExplainBanner() }

                item { ReserveTest() }

                item { Category() }

                item { GrayLine() }

                item { Header("홍길동 님의 취향에 맞는 커피예요") }

                item {
                    RowScroll(
                        names = names1,
                        features = features1,
                        images = coffeeImages1,
                        prices = prices1
                    )
                }

                item { GrayLine() }

                item { Header("이전 구매 상품과 유사한 상품") }

                item {
                    RowScroll(
                        names = names2,
                        features = features2,
                        images = coffeeImages2,
                        prices = prices2
                    )
                }

                item { ReviewBanner() }

                */


                item { Header("커니즈 추천 베스트 상품") }

                item { HorizontalScroll(3) }

                item { GrayLine() }

                item { Header("선물하기 좋은 상품") }

                item { KeywordPrice() }

                item { Spacer(modifier = Modifier.height(16.dp)) }

                item {
                    RowScroll(
                        names = names1,
                        features = features1,
                        images = coffeeImages1,
                        prices = prices1
                    )
                }

                item { OnedayBanner() }

                item { Header("특가/혜택 상품") }
            }
        },
        bottomBar = {
            BottomAppBar {
                IconButton(onClick = {}) {
                    // 버튼 1
                }
                IconButton(onClick = {}) {
                    // 버튼 2
                }
            }
        }
    )
}

@Composable
@Preview(showBackground = true, widthDp = 400, heightDp = 2000)
fun HomePreview() {
    HomeScreen()
}