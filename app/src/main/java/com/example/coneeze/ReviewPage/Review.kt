package com.example.coneeze.ReviewPage

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coneeze.CategoryPage.Section
import com.example.coneeze.DetailPage.TapMenu2
import com.example.coneeze.HomePage.GrayLine
import com.example.coneeze.HomePage.ReviewBanner
import com.example.coneeze.components.CustomTopBar
import com.example.coneeze.components.NextButton
import com.example.coneeze.data.TapNames2
import com.example.coneeze.ui.theme.Gray10

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReviewScreen() {
    Scaffold(
        topBar = {
            CustomTopBar(
                title = "주문 상세",
                showNavigationIcon = true, // 네비게이션 아이콘을 보여줌
                showActionIcon = false,    // 액션 아이콘을 숨김
                onNavigationClick = { },
                onActionClick = { /* 액션 버튼 클릭 동작 */ }
            )
        },
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {

                item { TapMenu2(first = 1) }

                item { Section("별점", "") }

                item { Rating() }

                item { ReviewBanner() }

                item { GrayLine() }

                item { ReviewHeader() }

                item { CustomerReviews() }

                item { MoreReview() }


            }
        },
        bottomBar = {
            NextButton(onClick = { /*TODO*/ }, text = "구매하기")
        }
    )
}


@Preview
@Composable
fun ReviewScreenPreview() {
    ReviewScreen()
}