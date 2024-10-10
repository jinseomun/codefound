package com.example.coneeze.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.coneeze.ui.theme.Main600

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerWithDotsIndicator(
    pageCount: Int,
    pageContent: @Composable (page: Int) -> Unit
) {
    val pagerState = rememberPagerState(pageCount = { pageCount })

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFFF7F5F3))
    ) {
        Column {
            // 페이저
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxWidth()
            ) { page ->
                pageContent(page)
            }

            // 도트 인디케이터
            Row(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(pageCount) { iteration ->
                    val color =
                        if (pagerState.currentPage == iteration) Main600 else Color.LightGray
                    Box(
                        modifier = Modifier
                            .padding(3.dp)
                            .clip(CircleShape)
                            .background(color)
                            .size(4.dp)
                    )
                }
            }
        }
    }
}
