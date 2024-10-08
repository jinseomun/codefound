package com.example.coneeze.HomePage

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coneeze.R
import com.example.coneeze.data.coffeeImages3
import com.example.coneeze.data.features3
import com.example.coneeze.data.names3
import com.example.coneeze.data.prices3

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalScroll(
    page: Int

) {
    // state 정의
    val state = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
       page // provide pageCount
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        HorizontalPager(
            state = state,  // 올바른 state 전달
            pageSpacing = 0.dp,
            userScrollEnabled = true,
            reverseLayout = false,
            contentPadding = PaddingValues(0.dp),
            beyondBoundsPageCount = 0,
            pageSize = PageSize.Fill,
            flingBehavior = PagerDefaults.flingBehavior(state = state),
            pageNestedScrollConnection = PagerDefaults.pageNestedScrollConnection(
                Orientation.Horizontal
            )
        ) { page ->
            twobytwo(
                names = names3,
                features = features3,
                images = coffeeImages3,
                prices = prices3
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center //내부 요소들을 중앙정렬
        ) {

                repeat(page) { index ->
                    val color = if (state.currentPage == index) Color.Black else Color.Gray
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 4.dp)  // 점 사이의 간격 추가
                            .size(4.dp)  // 점의 크기
                            .clip(RoundedCornerShape(50)) // 점을 동그랗게 만들기 위해 둥근 모서리 설정
                            .background(color)  // 각 점의 색상 설정
                    )
                }

        }
        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun HorizontalScrollPreview(){


    HorizontalScroll(3)
}