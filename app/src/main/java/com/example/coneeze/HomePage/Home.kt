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
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = { // TopBar
            TopAppBar(
                title = { Text(text = "" )},
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
                            painter = painterResource(id = R.drawable.logo),  // 이미지 리소스 설정
                            contentDescription = "커니즈 로고",
                            modifier = Modifier
                                .width(137.dp)
                                .height(24.dp)
                        )
                    }
                }
                ,
            )
        },

        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .verticalScroll(scrollState)
            ) {


                ExplainBanner()


                ReserveTest()

                Category()

                GrayLine()

                Header("홍길동 님의 취향에 맞는 커피예요")

                RowScroll(
                    names = names1,
                    features = features1,
                    images = coffeeImages1,
                    prices = prices1
                )

                GrayLine()

                Header("이전 구매 상품과 유사한 상품")

                RowScroll(
                    names = names2,
                    features = features2,
                    images = coffeeImages2,
                    prices = prices2
                )

                ReviewBanner()

                Header("커니즈 추천 베스트 상품")

                HorizontalScroll()

                GrayLine()

                Header("선물하기 좋은 상품")

                KeywordPrice()

                Spacer(modifier = Modifier.height(16.dp))
                RowScroll(
                    names = names1,
                    features = features1,
                    images = coffeeImages1,
                    prices = prices1
                )

                OnedayBanner()

                Header("특가/혜택 상품")

            }
        },
        bottomBar = {
            BottomAppBar(
            ) {
                IconButton(onClick = {}) {

                }
                IconButton(onClick = {}) {

                }
            }
        }
    )

}

@Composable
@Preview(showBackground = true)
fun HomePreview() {

    HomeScreen()
}


