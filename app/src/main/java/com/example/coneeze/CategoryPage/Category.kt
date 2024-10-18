package com.example.coneeze.CategoryPage

import KeywordPrice
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coneeze.components.BottomIconRow
import com.example.coneeze.components.CustomTopBar
import com.example.coneeze.data.CategoryBeansName
import com.example.coneeze.data.CategoryGiftsName
import com.example.coneeze.data.CategoryGoodsName
import com.example.coneeze.data.CategoryProductsName
import com.example.coneeze.data.CategoryToolsName
import com.example.coneeze.data.TapNames1
import com.example.coneeze.data.beanskey
import com.example.coneeze.data.giftskey
import com.example.coneeze.data.goodskey
import com.example.coneeze.data.keyprices1
import com.example.coneeze.data.names2
import com.example.coneeze.data.productskey
import com.example.coneeze.data.toolskey
import com.example.coneeze.ui.theme.Gray10
import com.example.coneeze.ui.theme.GrayLine

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryScreen(navController: NavController) {
    // 선택된 인덱스를 상태로 관리
    var selectedIndex by remember { mutableStateOf(0) }

    // 선택된 인덱스에 따른 재구성 상태 관리 (예시로 간단하게 숫자 변경)
    var isRecomposed by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            CustomTopBar(
                title = "",
                showNavigationIcon = true,
                showActionIcon = false,
                onNavigationClick = { navController.navigate("홈") },
                onActionClick = { /* 액션 버튼 클릭 동작 */ }
            )
        },
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                item {
                    // TapMenu1에서 인덱스 클릭 시 상태 변경
                    TapMenu1(
                        datas = TapNames1,
                        onItemClick = { index ->
                            selectedIndex = index
                            isRecomposed = !isRecomposed  // 클릭할 때마다 재구성 트리거
                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }

                when (selectedIndex) {

                    1 -> { item { KeywordPrice(keyprices = beanskey)} }
                    2 -> { item { KeywordPrice(keyprices = productskey)} }
                    3 -> { item { KeywordPrice(keyprices = toolskey)} }
                    4-> { item { KeywordPrice(keyprices = goodskey)} }
                    5-> { item { KeywordPrice(keyprices = giftskey)} }
                }

                val itemCount = when (selectedIndex) {
                    1 -> CategoryBeansName.size
                    2 -> CategoryProductsName.size
                    3 -> CategoryToolsName.size
                    4 -> CategoryGoodsName.size
                    5 -> CategoryGiftsName.size
                    else -> 16
                }


                when (selectedIndex) {
                    0 -> { item { Section(text = "전체", number = "16") }}
                    else -> { item { Section(text = "전체", number = itemCount.toString()) }}

                }

                when (selectedIndex) {
                    0 -> { item { TenItems(navController = navController, names = CategoryBeansName) }}
                    1 -> { item { TenItems(navController = navController, names = CategoryBeansName) }}
                    2 -> { item {TenItems(navController = navController, names = CategoryProductsName)}}
                    3 -> { item { TenItems(navController = navController, names = CategoryToolsName)} }
                    4-> { item { TenItems(navController = navController, names = CategoryGoodsName)} }
                    5-> { item { TenItems(navController = navController, names = CategoryGiftsName)} }
                }

            }
        }

                // 재구성된 TenItems를 보여주기
                ,
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(Color.White)
            ) {
                Column {
                    Divider(
                        color = GrayLine,
                        thickness = 1.dp,
                        modifier = Modifier.fillMaxWidth()
                    )
                    BottomIconRow(
                        navController = navController,
                        selectedIndex = selectedIndex,
                        onItemSelected = { index ->
                            selectedIndex = index
                        }
                    )
                }
            }
        }
    )
}


@Preview
@Composable
fun CategoryScreenPreview() {
    val navController = rememberNavController()
    CategoryScreen(navController)
}
