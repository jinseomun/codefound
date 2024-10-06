package com.example.coneez2.page


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coneez2.R
import com.example.coneez2.components.CustomTopBar
import com.example.coneez2.components.NextButton
import com.example.coneez2.components.TopLogo
import com.example.coneez2.ui.theme.Main600
/*
@Composable
fun ReservationScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column {
            // 상단바
            TopLogo()
            //이미지 슬라이드
            ImageSliderWithDotsIndicator()
        }
    }
}
*/
@OptIn(ExperimentalMaterial3Api::class)  // 실험적 API 사용을 명시적으로 허용
@Composable
fun ReservationScreen(modifier: Modifier = Modifier) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
                TopLogo()
        },
        content = { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                // 메인 콘텐츠
                ImageSliderWithDotsIndicator()
            }
        },
        bottomBar = {
            // 하단 바에 NextButton 추가
        }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageSliderWithDotsIndicator() {
    val pagerState = rememberPagerState(pageCount = { 4 }) // 페이지 개수를 4로 설정
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(680.dp)
            .background(color = Color(0xFFF7F5F3))
    ) {
        Column {
            // 이미지 슬라이더 부분
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxWidth() // 전체 크기 채우기
            ) { page ->
                when (page) {
                    0 -> Image(
                        painter = painterResource(id = R.drawable.reserv1), // 첫 번째 이미지 리소스
                        contentDescription = "Image 1",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxWidth()
                    )

                    1 -> Image(
                        painter = painterResource(id = R.drawable.reserv2), // 두 번째 이미지 리소스
                        contentDescription = "Image 2",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxWidth()
                    )

                    2 -> Image(
                        painter = painterResource(id = R.drawable.reserv3), // 세 번째 이미지 리소스
                        contentDescription = "Image 3",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxWidth()
                    )

                    3 -> Image(
                        painter = painterResource(id = R.drawable.reserv4), // 네 번째 이미지 리소스
                        contentDescription = "Image 4",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            // 동그라미 인디케이터 부분
            Row(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(pagerState.pageCount) { iteration ->
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

            //예약하기 버튼
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                contentAlignment = Alignment.Center
            ){
                ReservationButton(onClick = {})
            }
        }
    }
}


@Composable
fun ReservationButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,  // 클릭 시 동작할 함수
        modifier = Modifier
            .width(320.dp)  // 너비 설정
            .height(48.dp),  // 높이 설정
        shape = RoundedCornerShape(44.dp),  // 둥근 모서리 처리
        colors = ButtonDefaults.buttonColors(containerColor = Main600)  // 배경색 설정
    ) {
        Text(
            text = "예약하기",  // 버튼 텍스트
            style = TextStyle(
                color = Color.White,  // 텍스트 색상
                fontSize = 16.sp  // 텍스트 크기
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewReservation() {
    ReservationScreen()
}
