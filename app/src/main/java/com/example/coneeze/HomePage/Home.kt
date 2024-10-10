package com.example.coneeze.HomePage

import KeywordPrice
import androidx.compose.foundation.Image
import androidx.compose.foundation.border

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coneeze.components.PagerWithDotsIndicator
import com.example.coneeze.R
import com.example.coneeze.components.BottomIconRow
import com.example.coneeze.data.OriginPrices
import com.example.coneeze.data.Percents
import com.example.coneeze.data.SaleFeatures
import com.example.coneeze.data.SaleImages
import com.example.coneeze.data.SaleNames
import com.example.coneeze.data.SalePrices


import com.example.coneeze.data.coffeeImages1
import com.example.coneeze.data.coffeeImages2
import com.example.coneeze.data.coffeeImages3
import com.example.coneeze.data.features1
import com.example.coneeze.data.names1
import com.example.coneeze.data.prices1

import com.example.coneeze.data.features2
import com.example.coneeze.data.features3
import com.example.coneeze.data.names2
import com.example.coneeze.data.names3
import com.example.coneeze.data.prices2
import com.example.coneeze.data.prices3
import com.example.coneeze.data.tagbackgroundColors
import com.example.coneeze.data.tags
import com.example.coneeze.data.tagtextColors
import com.example.coneeze.ui.theme.Gray10


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
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

                item { ExplainBanner() }

                item { ReserveTest() }

                item { CategoryScroll() }

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




                item { Header("커니즈 추천 베스트 상품") }

                item { PagerWithDotsIndicator(
                    pageCount = 3,
                    pageContent = { page ->
                        twobytwo(
                            names = names3,
                            features = features3,
                            images = coffeeImages3,
                            prices = prices3
                        )
                    }
                ) }

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

                item{ PagerWithDotsIndicator(
                    pageCount = 3,
                    pageContent = { page ->
                        // 페이지 내용으로 SaleCategory를 전달
                        SaleCategory(
                            image = SaleImages,
                            name = SaleNames,
                            feature = SaleFeatures,
                            percent = Percents,
                            price = SalePrices,
                            origin_price = OriginPrices,
                            tagCategory = tags,
                            tagBackgroundColor = tagbackgroundColors,
                            tagTextColor = tagtextColors
                        )
                    }
                )
                }

                item { Footer()}
            }
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .height(80.dp) // 크기 설정
                    .border(2.dp, Gray10),
                containerColor = Color.White

                // 테두리 설정
            ) {
                BottomIconRow()
            }
        }
    )
}

@Composable
@Preview(showBackground = true)
fun HomePreview() {
    val navController = rememberNavController()
    HomeScreen(navController = navController)
}