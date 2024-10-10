package com.example.coneeze.CategoryPage

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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coneeze.HomePage.BottomIconRow
import com.example.coneeze.HomePage.CategoryScroll
import com.example.coneeze.HomePage.ExplainBanner
import com.example.coneeze.HomePage.Footer
import com.example.coneeze.HomePage.GrayLine
import com.example.coneeze.HomePage.Header
import com.example.coneeze.HomePage.HorizontalScroll
import com.example.coneeze.HomePage.OnedayBanner
import com.example.coneeze.HomePage.ReserveTest
import com.example.coneeze.HomePage.ReviewBanner
import com.example.coneeze.HomePage.RowScroll
import com.example.coneeze.HomePage.SaleCategory
import com.example.coneeze.HomePage.twobyone
import com.example.coneeze.HomePage.twobytwo
import com.example.coneeze.R
import com.example.coneeze.data.OriginPrices
import com.example.coneeze.data.Percents
import com.example.coneeze.data.SaleFeatures
import com.example.coneeze.data.SaleImages
import com.example.coneeze.data.SaleNames
import com.example.coneeze.data.SalePrices
import com.example.coneeze.data.TapNames1
import com.example.coneeze.data.coffeImages4
import com.example.coneeze.data.coffeeImages1
import com.example.coneeze.data.coffeeImages2
import com.example.coneeze.data.coffeeImages3
import com.example.coneeze.data.features1
import com.example.coneeze.data.features2
import com.example.coneeze.data.features3
import com.example.coneeze.data.features4
import com.example.coneeze.data.names1
import com.example.coneeze.data.names2
import com.example.coneeze.data.names3
import com.example.coneeze.data.names4
import com.example.coneeze.data.prices1
import com.example.coneeze.data.prices2
import com.example.coneeze.data.prices3
import com.example.coneeze.data.prices4
import com.example.coneeze.data.tagbackgroundColors
import com.example.coneeze.data.tags
import com.example.coneeze.data.tagtextColors
import com.example.coneeze.ui.theme.Gray10


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                navigationIcon = {
                    BackTopBar()
                },
            )
        },
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {

                item { TapMenu1(datas = TapNames1) }

                item { Section(
                    text = "전체",
                    number = "10"
                )}

                item {TenItems()}




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



@Preview
@Composable
fun CategoryScreenPreview(){
    CategoryScreen()
}