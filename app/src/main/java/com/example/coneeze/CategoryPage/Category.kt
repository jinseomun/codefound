package com.example.coneeze.CategoryPage

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
import com.example.coneeze.data.TapNames1
import com.example.coneeze.ui.theme.Gray10
import com.example.coneeze.ui.theme.GrayLine


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            CustomTopBar(
                title = "",
                showNavigationIcon = true, // 네비게이션 아이콘을 보여줌
                showActionIcon = false,    // 액션 아이콘을 숨김
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

                item { TapMenu1(datas = TapNames1) }

                item { Section(
                    text = "전체",
                    number = "10"
                )}

                item {TenItems(navController)}




            }
        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp) // 높이 설정
                    .background(Color.White) // 배경색 설정
            ) {
                Column {
                    // 상단에 Gray 색상의 선을 추가
                    Divider(
                        color = GrayLine,
                        thickness = 1.dp,
                        modifier = Modifier.fillMaxWidth()
                    )
                    // 하단 아이콘들 배치
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
fun CategoryScreenPreview(){
    val navController = rememberNavController()
    CategoryScreen(navController)
}