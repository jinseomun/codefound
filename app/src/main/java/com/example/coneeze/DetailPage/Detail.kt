package com.example.coneeze.DetailPage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.coneeze.HomePage.GrayLine
import com.example.coneeze.components.CustomTopBar
import com.example.coneeze.components.NextButton
import com.example.coneeze.data.TapNames2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavController, image: Int, name: String, price: String) {
    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            Column {
                CustomTopBar(
                    title = "",
                    showNavigationIcon = true, // 네비게이션 아이콘을 보여줌
                    showActionIcon = false,    // 액션 아이콘을 숨김
                    onNavigationClick = { navController.popBackStack() },
                    onActionClick = { /* 액션 버튼 클릭 동작 */ }
                )
                TapMenu2(first = 0)
            }
            },


        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {

                item { DetailInfo(image, name, price) }

                item { GrayLine() }

                item { DetailExplain() }





            }
        },
        bottomBar = {
            NextButton(onClick = { /*TODO*/ }, text = "구매하기")

            //Buy_BottomButtonBar(image, name, price)
        }
    )

}


